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

}
