<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<%
	//cache����� ����� �ڵ�.
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
	<h2>�ڷ�����Ȯ��â</h2>
	
	���̵�: ${check.tlrId}<br>
	��й�ȣ: ${check.tlrPw}<br>
	�̸�: ${check.tlrName}<br>
	�ֹε�Ϲ�ȣ: ${check.tlrRrn}<br>
	��ȭ��ȣ: ${check.tlrTel}<br>
	�ڵ���: ${check.tlrCel}<br>
	�ּ�: ${check.tlrAddr}<br>
	�̸���: ${check.tlrEmail}<br>
	<input type="button" value="�ڷ�����Ʈ��" onclick="location.href='<%= request.getContextPath() %>/bank.do?command=TLIST'" />
	
</body>
</html>