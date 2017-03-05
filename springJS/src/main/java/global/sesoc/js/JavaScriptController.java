package global.sesoc.js;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JavaScriptController {

private static final Logger logger = LoggerFactory.getLogger(JavaScriptController.class);
	
	@RequestMapping(value = "js1", method = RequestMethod.GET)
	public String callJs1() {
		return "js1";
	}
	
	@RequestMapping(value = "js2", method = RequestMethod.GET)
	public String callJs2() {
		return "js-string";
	}
	
	@RequestMapping(value = "js3", method = RequestMethod.GET)
	public String callJs3() {
		return "js-browserobject";
	}
	
	@RequestMapping("jq1")
	public String callJQuery1() {
		return "jq1";
	}
	
	@RequestMapping("jq2")
	public String callJQuery2() {
		return "jq2";
	}
	
	@RequestMapping("jq3")
	public String callJQuery3() {
		return "jq3";
	}
	
	@RequestMapping("jq4")
	public String callJQuery4() {
		return "jq4";
	}

}
