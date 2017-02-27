package global.sesoc.web5.customer.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.web5.customer.dao.CustomerDAO;
import global.sesoc.web5.customer.vo.CustomerVO;

@Controller
@RequestMapping("customer")
public class CustomerLogInController {
	
	@Autowired
	CustomerDAO dao;
	Logger log = LoggerFactory.getLogger(CustomerLogInController.class);
	
	@RequestMapping("login")
	public String customerLogin() {
		log.debug("customerLogin :: GET");
		return "customer/login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String customerLogin(
			HttpSession session
			, CustomerVO vo
			, Model model) {
		log.debug("customerLogin :: POST :: \n{}", vo);
		CustomerVO ret = dao.selectCustomer(vo.getCustid());
		log.debug("결과값 :: \n{}", ret);
		if(ret != null) {
			if(!ret.getPassword().equals(vo.getPassword())) {
				model.addAttribute("id", vo.getCustid());
				model.addAttribute("msg", "비밀번호를 확인해주세요!!");
				return "customer/login";
			} else {
				log.debug("password check");
				session.setAttribute("cust", ret);
				return "redirect:../";
			}
		} else {
			model.addAttribute("id", vo.getCustid());
			model.addAttribute("msg", "존재하지 않는 아이디입니다!!");
			return "customer/login";
		}
	}
	
	@RequestMapping("logout")
	public String cutomerLogout(HttpSession session) {
		session.removeAttribute("cust");
		return "redirect:../";
	}
}
