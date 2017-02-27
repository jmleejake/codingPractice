package global.sesoc.web5.board.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import global.sesoc.web5.board.dao.BoardDAO;
import global.sesoc.web5.board.vo.BoardVO;
import global.sesoc.web5.board.vo.ReplyVO;
import global.sesoc.web5.customer.vo.CustomerVO;
import global.sesoc.web5.util.FileService;
import global.sesoc.web5.util.PageNavigator;

/**
 * 게시판 콘트롤러
 * 글쓰기 읽기 목록 삭제 수정
 * @author kita
 */
@Controller
@RequestMapping("board")
public class BoardController {
	
	@Autowired
	BoardDAO dao;
	Logger log = LoggerFactory.getLogger(BoardController.class);
	
	// 게시판 관련 상수
	final int countPerPage = 10; // 페이지당 글 개수
	final int pagePerGroup= 5; // 페이지 이동그룹 당 표시 페이지수
	final String uploadPath = "/boardFile"; // 파일업로드 경로
	
	@RequestMapping("list")
	public String showList(
			Model model
			, @RequestParam(value="page", defaultValue="1") int page_no
			, @RequestParam(value="s_type", defaultValue="") String type
			, @RequestParam(value="s_text", defaultValue="") String keyword
			) {
		log.debug("showList :: GET");
		log.debug("current page :: {}", page_no);
		log.debug("search type :: {}", type);
		log.debug("search keyword :: {}", keyword);
		
		HashMap<String, Object> param = new HashMap<>();
		param.put("type", type);
		param.put("keyword", keyword);
		
		// 총 글개수
		int total_cnt = dao.selectBoardTotalCount(param);
//		int total_page = total_cnt % countPerPage == 0 ? 
//				total_cnt / countPerPage : total_cnt / countPerPage + 1;
		
		// 페이징 계산을 위한 객체 생성
		PageNavigator paging = new PageNavigator(countPerPage, pagePerGroup, page_no, total_cnt);
		
		model.addAttribute("contents"
				, dao.selectBoardList(
						paging.getStartRecord(), countPerPage, param));
		model.addAttribute("navi", paging);
		model.addAttribute("type", type);
		model.addAttribute("keyword", keyword);
		
		return "board/list";
	}
	
	@RequestMapping("add")
	public String addBoard() {
		log.debug("addBoard :: GET");
		return "board/write";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String addBoard(
			BoardVO vo
			, MultipartFile upload
			, HttpSession session) {
		log.debug("addBoard :: POST");
		log.debug("contentType: {}", upload.getContentType());
		log.debug("name: {}", upload.getName());
		log.debug("original name: {}", upload.getOriginalFilename());
		log.debug("size: {}", upload.getSize());
		
		// 첨부파일이 있다면 서버의 하드디스크에 파일을 생성하여 복사
		if(!upload.isEmpty()) {
			log.debug("::::::: file upload start :::::::");
			/*
			try {
				upload.transferTo(new File(uploadPath + "/" + UUID.randomUUID().toString()));
			} catch (IllegalStateException e) {
				log.error(e.getMessage());
			} catch (IOException e) {
				log.error(e.getMessage());
			}
			*/
			String uploadFileName = FileService.saveFile(upload, uploadPath);
			vo.setOriginal_file(upload.getOriginalFilename());
			vo.setSaved_file(uploadFileName);
			/*
			byte[] buf = new byte[1024];
			BufferedInputStream in = null;
			FileOutputStream out = null;
			try {
				in = new BufferedInputStream(upload.getInputStream());
				out = new FileOutputStream(uploadPath + "/" + UUID.randomUUID().toString());
				int i;
				
				while((i=in.read(buf)) != -1) {
					out.write(buf, 0, i);
				}
			} catch (IOException e) {
				log.error(e.getMessage());
			} finally {
				try {
					if(in != null) in.close();
					if(out != null) out.close();
				} catch (IOException e) {
				}
			}
			*/
		}
		
		String id = ((CustomerVO) session.getAttribute("cust")).getCustid();
		vo.setCustid(id);
		log.debug("사용자 아이디 세팅 :: {}", vo);
		dao.insertBoard(vo);
		return "redirect:list";
	}
	
	@RequestMapping("read")
	public String readBoard(int bno, Model model) {
		log.debug("readBoard :: GET :: bno= {}", bno);
		BoardVO ret = dao.selectBoard(bno);
		model.addAttribute("borvo", ret);
		
		ArrayList<ReplyVO> replist = dao.selectReply(bno);
		model.addAttribute("reps", replist);
		
		return "board/read";
	}
	
	@RequestMapping("download")
	public String downloadAttachFile(
			int bno
			, HttpServletResponse resp) {
		log.debug("downloadAttachFile :: GET :: bno= {}", bno);
		
		/*
		 * 1. 전달된 글번호로 글정보 검색
		 * 2. 원래의 파일명을 보여줄 준비
		 * 3. 서버에 저장된 파일을 읽어
		 *   클라이언트로 전달할 출력스트림으로 복사
		 * */
		
		// 1
		BoardVO ret = dao.selectBoard(bno);
		// 2
		try {
			resp.setHeader("Content-Disposition", 
					"attachment;filename=" 
					+ URLEncoder.encode(ret.getOriginal_file(), "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			log.error(e1.getMessage());
		}
		
		// 3
		String saved_full_path = uploadPath + "/" + ret.getSaved_file();
		log.debug("첨부파일이 저장되있는 경로 :: {}", saved_full_path);
		
		FileInputStream in = null;
		ServletOutputStream out = null;
		try {
			in = new FileInputStream(saved_full_path);
			out = resp.getOutputStream();
			
			FileCopyUtils.copy(in, out);
			/*
			byte[] buf = new byte[1024];
			int i;
			
			while((i = in.read(buf)) != -1) {
				out.write(buf, 0, i);
			}
			*/
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		} finally {
			try {
				if(in != null) in.close();
				if(out != null) out.close();
			} catch (IOException e) {
				log.error(e.getMessage());
			}
		}
		return null;
	}
	
	@RequestMapping("delete")
	public String deleteBoard(
			int bno
			, HttpSession session) {
		log.debug("deleteBoard :: GET :: bno = {}", bno);
		/*
		 * 1. 세션에서 사용자 아이디 읽기
		 * 2. 해당글에 첨부된 파일이 있으면 삭제
		 * 3. 글번호와 로그인 아이디를 전달하여 DB에서 글 삭제
		 * 4. 글목록으로 redirect
		 * */
		
		BoardVO vo = dao.selectBoard(bno);
		// 1
		String session_id = ((CustomerVO)session.getAttribute("cust")).getCustid();
		
		if(session_id.equals(vo.getCustid())) {
			// 2
			if(vo.getSaved_file() != null && vo.getOriginal_file() != null) {
				if(FileService.deleteFile(uploadPath + "/" + vo.getSaved_file())) {
					log.debug("첨부파일 삭제완료");
				}
			}
			
			// 3
			HashMap<String, Object> param = new HashMap<>();
			param.put("id", session_id);
			param.put("bno", bno);
			dao.deleteBoard(param);
		}
		
		return "redirect:list";
	}
	
	@RequestMapping("update")
	public String updateBoard(
			int bno
			, Model model
			, HttpSession session) {
		log.debug("updateBoard :: GET :: bno= {}", bno);
		
		BoardVO vo = dao.selectBoard(bno);
		
		String session_id = ((CustomerVO)session.getAttribute("cust")).getCustid();
		
		if(session_id.equals(vo.getCustid())) {
			model.addAttribute("update", true);
			model.addAttribute("borvo", vo);
			return "board/write";
		} else {
			return "redirect:list";
		}
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String updateBoard(
			BoardVO vo
			, Model model
			, MultipartFile upload
			, HttpSession session) {
		log.debug("updateBoard :: POST \n:: {}", vo);
		log.debug("contentType: {}", upload.getContentType());
		log.debug("name: {}", upload.getName());
		log.debug("original name: {}", upload.getOriginalFilename());
		log.debug("size: {}", upload.getSize());
		
		BoardVO original_vo = dao.selectBoard(vo.getBno());
		
		// 첨부파일이 있다면 서버의 하드디스크에 파일을 생성하여 복사
		if(!upload.isEmpty()) {
			log.debug("::::::: file upload start :::::::");
			
			boolean del_ret = FileService.deleteFile(uploadPath + "/" + original_vo.getSaved_file());
			if(del_ret) log.debug("::::::: file deleted :::::::");
			
			String uploadFileName = FileService.saveFile(upload, uploadPath);
			vo.setOriginal_file(upload.getOriginalFilename());
			vo.setSaved_file(uploadFileName);
		}
		
		String id = ((CustomerVO) session.getAttribute("cust")).getCustid();
		vo.setCustid(id);
		log.debug("사용자 아이디 세팅 & 파일첨부 :: {}", vo);
		dao.updateBoard(vo);
		
		return "redirect:read?bno=" + vo.getBno();
	}
	
	@RequestMapping(value="rep_add", method=RequestMethod.POST)
	public String addReply(
			ReplyVO vo
			, Model model
			, HttpSession session) {
		log.debug("addReply :: POST :: \n{}");
		
		String id = ((CustomerVO) session.getAttribute("cust")).getCustid();
		vo.setCustid(id);
		
		dao.insertReply(vo);
		
		return "redirect:read?bno=" + vo.getBno();
	}
	
	@RequestMapping(value="rep_del", method=RequestMethod.POST)
	public String deleteReply(
			ReplyVO vo
			, HttpSession session) {
		log.debug("deleteReply :: POST :: \n{}", vo);
		
		String id = ((CustomerVO) session.getAttribute("cust")).getCustid();
		if(id.equals(vo.getCustid())) {
			dao.deleteReply(vo);
		}
		return "redirect:read?bno=" + vo.getBno();
	}
	
	
	@RequestMapping(value="rep_mod", method=RequestMethod.POST)
	public String updateReply(
			ReplyVO vo
			, HttpSession session) {
		log.debug("updateReply :: POST :: \n{}", vo);
		
		String id = ((CustomerVO) session.getAttribute("cust")).getCustid();
		if(id.equals(vo.getCustid())) {
			dao.updateReply(vo);
		}
		return "redirect:read?bno=" + vo.getBno();
	}
}
