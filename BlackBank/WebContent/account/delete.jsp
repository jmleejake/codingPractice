<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>삭제할 계좌번호와 계좌비밀번호를 입력해 주세요</h3>
	<form action="<%= request.getContextPath() %>/bank.do?command=ADELETE" method="post">
		<table border=1>
		<tr>
		<td>계좌번호: </td><td><input type="text" name="accNum" /></td>
		<td>계좌비밀번호: </td><td><input type="password" name="accPw" /></td>
		<td><input type="submit" value="계좌삭제" />
		</tr>
		</table>
	</form>
</body>
</html>