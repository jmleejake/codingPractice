package global.sesoc.web5.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import global.sesoc.web5.customer.dao.CustomerDAO;
import global.sesoc.web5.customer.vo.CustomerVO;

@Controller
@RequestMapping("customer")
/*
 * @Controller안에서 정의 되어있는 메소드 내의 model에 
 * @SessionAttributes안에 들어가는 이름의 객체가 담기는 동시에 
 * session에 탑재
 * */
@SessionAttributes("custvo")
public class CustomerJoinController {
	
	@Autowired
	CustomerDAO dao;
	Logger log = LoggerFactory.getLogger(CustomerJoinController.class);
	
	/**
	 * 가입폼보기
	 * @return
	 */
	@RequestMapping("join")
	public String customerJoin(Model model) {
		log.debug("customerJoin :: GET");
		CustomerVO vo = new CustomerVO();
		model.addAttribute("custvo", vo);
		return "customer/joinForm";
	}
	
	/**
	 * 아이디 중복체크 폼보기
	 * @return
	 */
	@RequestMapping("idDup")
	public String idDuplicateCheck() {
		log.debug("idDuplicateCheck :: GET");
		return "customer/idCheck";
	}
	
	/**
	 * 아이디 중복체크 처리
	 * @param custid
	 * @return
	 */
	@RequestMapping(value="idDup", method=RequestMethod.POST)
	public String idDuplicateCheck(String custid, Model model) {
		log.debug("idDuplicateCheck :: POST :: {}", custid);
		CustomerVO ret = dao.selectCustomer(custid);
		log.debug("결과값?! :: {}", ret);
		model.addAttribute("execute", true);
		model.addAttribute("ret", ret);
		model.addAttribute("curr_id", custid);
		
		return "customer/idCheck";
	}
	
	/**
	 * 가입처리
	 * @param vo 화면단에서 넘어온 고객정보
	 * @return
	 */
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String customerJoin(
			@ModelAttribute("custvo") CustomerVO vo
			, Model model) {
		log.debug("customerJoin :: POST \n:: {}", vo);
		// 검증 & DB저장
		int ret = 0;
		try {
			ret = dao.insertCustomer(vo);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		if(ret > 0) {
			model.addAttribute("custvo", vo);
			return "redirect:joinComplete";
		} else {
			log.error("가입실패!!");
			model.addAttribute("errmsg", "가입실패");
			return "customer/joinForm";
		}
	}
	
	/**
	 * 가입완료
	 * @param vo
	 * @param model
	 * @param status
	 * @return
	 */
	@RequestMapping("joinComplete")
	public String customerJoinComplete(
			@ModelAttribute("custvo") CustomerVO vo
			, Model model
			, SessionStatus status) {
		log.debug("customerJoinComplete :: GET \n:: {}", vo);
		model.addAttribute("custvo", vo);
		status.setComplete();
		return "customer/joinComplete";
	}
}
