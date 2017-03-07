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
	<h2>텔러정보확인창</h2>
	
	아이디: ${check.tlrId}<br>
	비밀번호: ${check.tlrPw}<br>
	이름: ${check.tlrName}<br>
	주민등록번호: ${check.tlrRrn}<br>
	전화번호: ${check.tlrTel}<br>
	핸드폰: ${check.tlrCel}<br>
	주소: ${check.tlrAddr}<br>
	이메일: ${check.tlrEmail}<br>
	<input type="button" value="텔러리스트로" onclick="location.href='<%= request.getContextPath() %>/bank.do?command=TLIST'" />
	
</body>
</html>