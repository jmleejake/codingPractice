package global.sesoc.js;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	
	Logger log = LoggerFactory.getLogger(AjaxController.class);
	
	/**
	 * 테스트 페이지로 이동
	 * @return
	 */
	@RequestMapping("at1")
	public String ajaxTest1() {
		return "ajaxTest1";
	}
	
	/**
	 * 테스트 페이지에서 Ajax호출
	 * @return
	 */
	@ResponseBody
	@RequestMapping("at1_get")
	public void ajaxTest1_1() {
		log.debug("at1_get connected");
	}
	
	@ResponseBody
	@RequestMapping(value="at1_post", method=RequestMethod.POST, 
	produces="application/json;charset=utf-8")
	public String ajaxTest1_2(String str) {
		log.debug("at1_post str={}", str);
		return str + " はじめまして。";
	}
	
	@RequestMapping("at2")
	public String ajaxTest2() {
		return "ajaxTest2";
	}
	
	/**
	 * [Ajax parameter 받기1 ]서버로 각각의 parameter를 전달
	 * @param name
	 * @param age
	 * @param phone
	 */
	@ResponseBody
	@RequestMapping(value="at2_post_0", method=RequestMethod.POST)
	public void ajaxTest2_1(String name, int age, String phone) {
		log.debug("ajaxTest2_1");
		log.debug("name={}, age={}, phone={}", name, age, phone);
	}
	
	/**
	 * [Ajax parameter 받기2 ]서버의 VO객체로 전달
	 * @param vo
	 */
	@ResponseBody
	@RequestMapping(value="at2_post_1", method=RequestMethod.POST)
	public void ajaxTest2_2(PersonVO vo) {
		log.debug("ajaxTest2_2");
		log.debug("person={}", vo);
	}
	
	/**
	 * [Ajax parameter 받기3 ]서버의 VO객체로 전달
	 * @param vo
	 */
	@ResponseBody
	@RequestMapping(value="at2_post_2", method=RequestMethod.POST)
	public void ajaxTest2_3(PersonVO vo) {
		log.debug("ajaxTest2_3");
		log.debug("person={}", vo);
	}
	
	/**
	 * 객체를 리턴하는 메소드
	 * @return
	 */
	@ResponseBody
	@RequestMapping("returnTest")
	public PersonVO ajaxReturnTest() {
		PersonVO p = new PersonVO();
		p.setName("재미나이");
		p.setAge(31);
		p.setPhone("010-3460-1936");
		return p;
	}
}
