<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer login.jsp</title>

<!-- CSS파일 불러오기 -->
<link rel="stylesheet" href="../resources/css/customer.css">
</head>
<body>
<h2>[로그인]</h2>
<p id="err">${msg }</p>
<form action="login" method="post">
<table>
	<tr>
		<td>ID</td>
		<td><input type="text" name="custid" value="${id }"></td>
	</tr>
	<tr>
		<td>PW</td>
		<td><input type="password" name="password"></td>
	</tr>
	<tr>
		<td colspan="2" id="btn_area">
			<input type="submit" value="로그인">
			<input type="button" value="홈으로" onclick="location.href='../'">
		</td>
	</tr>
</table>
</form>
</body>
</html>