<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>������ ���¹�ȣ�� ���º�й�ȣ�� �Է��� �ּ���</h3>
	<form action="<%= request.getContextPath() %>/bank.do?command=ADELETE" method="post">
		<table border=1>
		<tr>
		<td>���¹�ȣ: </td><td><input type="text" name="accNum" /></td>
		<td>���º�й�ȣ: </td><td><input type="password" name="accPw" /></td>
		<td><input type="submit" value="���»���" />
		</tr>
		</table>
	</form>
</body>
</html>