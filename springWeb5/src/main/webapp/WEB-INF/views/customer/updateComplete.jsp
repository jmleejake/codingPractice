<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer updateComplete.jsp</title>

<!-- CSS파일 불러오기 -->
<link rel="stylesheet" href="../resources/css/customer.css">
</head>
<body>
<table>
	<tr>
		<th>ID</th>
		<td>${custvo.custid }</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>${custvo.password }</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${custvo.name }</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${custvo.email }</td>
	</tr>
	<tr>
		<th>고객구분</th>
		<td id="td_division"></td>
	</tr>
	<tr>
		<th id="td_idno"></th>
		<td>${custvo.idno }</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>${custvo.address }</td>
	</tr>
	<tr>
		<td id="btn_area" colspan="2">
			<input type="button" value="홈으로" onclick="location.href='../'">
		</td>
	</tr>
</table>

<script>
	var division = "${custvo.division}";
	if(division == "personal") {
		document.getElementById("td_division").innerHTML = "개인";
		document.getElementById("td_idno").innerHTML = "주민번호";
	} else if(division == "company") {
		document.getElementById("td_division").innerHTML = "기업";
		document.getElementById("td_idno").innerHTML = "사업자번호";
	}
</script>

</body>
</html>