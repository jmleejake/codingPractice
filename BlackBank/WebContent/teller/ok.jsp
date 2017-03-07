<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<%
	//cache기록을 지우는 코드.
	response.setHeader("Cache-Control","no-store");   
	response.setHeader("Pragma","no-cache");   
	response.setDateHeader("Expires",0);   
	if (request.getProtocol().equals("HTTP/1.1")){
		response.setHeader("Cache-Control", "no-cache");
	}
%> 
<title>Insert title here</title>
</head>
<body>
	&nbsp;&nbsp;<b>${sessionScope.tellerMember}</b> 텔러님 접속에 성공하셨습니다.<br>
	&nbsp;&nbsp;오늘하루도 수고하세요!!&nbsp;&nbsp;
	<input type="button" value="로그아웃" onclick="location.href='<%= request.getContextPath() %>/teller/logout.jsp'">
</body>
</html>