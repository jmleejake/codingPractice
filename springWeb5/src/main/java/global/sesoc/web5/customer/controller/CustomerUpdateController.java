package global.sesoc.web5.customer.controller;

import javax.servlet.http.HttpSession;

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
@SessionAttributes("custvo")
public class CustomerUpdateController {
	
	@Autowired
	CustomerDAO dao;
	Logger log = LoggerFactory.getLogger(CustomerUpdateController.class);
	
	/**
	 * 수정폼보기
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("update")
	public String customerUpdate(
			Model model
			, HttpSession session) {
		log.debug("customerUpdate :: GET");
		CustomerVO vo = dao.selectCustomer(((CustomerVO)session.getAttribute("cust")).getCustid());
		model.addAttribute("custvo", vo);
		model.addAttribute("update", true);
		return "customer/joinForm";
	}
	
	/**
	 * 수정처리
	 * @param vo
	 * @param model
	 * @return
	 */
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String customerUpdate(
			@ModelAttribute("custvo") CustomerVO vo
			, Model model) {
		log.debug("customerUpdate :: POST :: \n{}", vo);
		// 검증 & DB저장
		int ret = 0;
		try {
			ret = dao.updateCustomer(vo);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		if(ret > 0) {
			model.addAttribute("custvo", vo);
			return "redirect:updateComplete";
		} else {
			log.error("수정실패!!");
			model.addAttribute("errmsg", "수정실패");
			model.addAttribute("update", true);
			return "customer/joinForm";
		}
	}
	
	/**
	 * 수정완료
	 * @param vo
	 * @param model
	 * @param status
	 * @return
	 */
	@RequestMapping("updateComplete")
	public String customerUpdateComplete(
			@ModelAttribute("custvo") CustomerVO vo
			, Model model
			, SessionStatus status
			, HttpSession session) {
		model.addAttribute("custvo", vo);
		status.setComplete();
		session.setAttribute("cust", vo); // 이름이 고쳐졌을때 메인화면에서 고쳐져서 나오게할라고
		return "customer/updateComplete";
	}
}
