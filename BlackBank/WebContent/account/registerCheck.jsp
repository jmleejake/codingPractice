<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>��������Ȯ��â</h2>
	���¹�ȣ: ${check.accNum}<br>
	���º�й�ȣ: ${check.accPw}<br>
	��������: ${check.expDay}<br>
	��������: ${check.payDay}<br>
	��ǰ�ڵ�: ${check.prdCode}<br>
	�ܾ�: ${check.balance}<br>
	<input type="button" value="����Ʈ���̵�" onclick="location.href='<%= request.getContextPath() %>/bank.do?command=AREAD&accNum=${check.accNum}'">
</body>
</html>