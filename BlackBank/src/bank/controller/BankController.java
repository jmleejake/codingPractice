package bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BankController extends HttpServlet {
	
	Map<String, String> action_mapping = new HashMap<String, String>();
	Map<String, String> forward_mapping = new HashMap<String, String>();
	
	@Override
	public void init() throws ServletException {
		ResourceBundle rb = ResourceBundle.getBundle("bank.property.bank");
		Enumeration<String> e = rb.getKeys();
		
		while(e.hasMoreElements()){
			String key = e.nextElement();			
			String values = rb.getString(key);
			
			String v[] = values.split(":");
			action_mapping.put(key, v[0]);
			forward_mapping.put(key, v[1]);
		}
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String command = request.getParameter("command");
		
		if(command.equals("")){
			if (request.getParameter("loginRadio").equals("teller")) {
				command="TCHECKID";
			}else{
				command="ADCHECKID";
			}
		}		
		
		String forward = forward_mapping.get(command);
        String commandAction = action_mapping.get(command);
        
        if(!commandAction.equals("")){
			try {
				Class  c = Class.forName(commandAction); 
				Object o = c.newInstance();
				Method m = c.getDeclaredMethod("execute", HttpServletRequest.class, HttpServletResponse.class);
				m.invoke(o, request, response);
				
				if(request.getAttribute("error") != null){
					forward = "template/error.jsp";
				}
				
			} catch (ClassNotFoundException e) {			
				e.printStackTrace();
			} catch (IllegalArgumentException e) {				
				e.printStackTrace();
			} catch (SecurityException e) {				
				e.printStackTrace();
			} catch (NoSuchMethodException e) {				
				e.printStackTrace();
			} catch (IllegalAccessException e) {				
				e.printStackTrace();
			} catch (InvocationTargetException e) {				
				e.printStackTrace();
			} catch (InstantiationException e) {				
				e.printStackTrace();
			} catch (Exception e){
				e.printStackTrace();
			}
        }else{
        	request.setAttribute("error", "커맨드명령이 없습니다.");
        }
		request.getRequestDispatcher(forward).forward(request,response);
	}
	//quartz실행을 위한 static블록
	static{
		ScheduleManager obj = new ScheduleManager();
		obj.start();   
		obj.boundJobList();
	}
}
