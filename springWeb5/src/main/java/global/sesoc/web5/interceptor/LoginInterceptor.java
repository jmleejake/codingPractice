package global.sesoc.web5.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 사용자 로그인 확인 인터셉터
 * @author kita
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(
			HttpServletRequest request
			, HttpServletResponse response
			, Object handler)
			throws Exception {
		boolean ret = false;
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("cust") != null) {
			ret = true;
		} else {
			response.sendRedirect(request.getContextPath() + "/customer/login");
		}
		
		return ret;
	}
	
}
