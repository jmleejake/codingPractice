package global.sesoc.web5.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 웹 어플리케이션의 공통 예외처리 클래스
 * @author kita
 */
//@ControllerAdvice
public class ExceptionChecker {
	
	// exception의 종류마다 핸들러 처리를 할수있음
	@ExceptionHandler(Exception.class) 
	public String errorHandler() {
		return "/error/error";
	}
}
