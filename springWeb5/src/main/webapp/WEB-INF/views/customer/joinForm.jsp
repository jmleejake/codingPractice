<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer joinForm.jsp</title>

<!-- CSS파일 불러오기 -->
<link rel="stylesheet" href="../resources/css/customer.css">
<!-- JS파일 불러오기 -->
<script src="../resources/js/customer.js"></script>

</head>
<body>
<c:choose>
	<c:when test="${update }">
	<h1>[회원수정]</h1>
	</c:when>
	<c:otherwise>
	<h1>[회원가입]</h1>
	</c:otherwise>
</c:choose>

<c:if test="${errmsg != null }">
<div id="err">[${errmsg }]</div>
</c:if>
<form id="f_join" method="post" onsubmit="return checkValue();">
<table>
	<tr>
		<th>ID</th>
		<c:choose>
			<c:when test="${update }">
			<td><input type="text" id="v_id" 
			readonly="readonly" value="${custvo.custid }"></td>
			</c:when>
			<c:otherwise>
			<td>
				<input type="text" id="v_id" name="custid" readonly="readonly" 
				placeholder="ID중복확인을 이용">
				<input type="button" value="ID중복확인" onclick="showPop();">
			</td>
			</c:otherwise>
		</c:choose>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>
			<input type="password" id="pw1" name="password" placeholder="비밀번호 입력"><br>
			<input type="password" id="pw2" placeholder="비밀번호 다시 입력">
		</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>
			<input type="text" id="v_name" name="name" 
			placeholder="이름 입력" value="${custvo.name }">
		</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>
			<input type="text" name="email" 
			placeholder="이메일 입력" value="${custvo.email }">
		</td>
	</tr>
	<tr>
		<th>고객구분</th>
		<td>
			<input type="radio" id="r_per" name="division" value="personal" 
			checked="checked" onclick="setIdnoColumn();">개인
			<input type="radio" id="r_com" name="division" value="company"
			onclick="setIdnoColumn();">기업
		</td>
	</tr>
	<tr>
		<th id="td_idno">주민번호</th>
		<td>
			<input type="text" name="idno" 
			value="${custvo.idno }">
		</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>
			<input type="text" name="address" 
			placeholder="주소 입력" value="${custvo.address }">
		</td>
	</tr>
	<tr>
		<td id="btn_area" colspan="2">
			<c:choose>
				<c:when test="${update }">
				<input type="submit" value="수정" onclick="submit(${update });">
				</c:when>
				<c:otherwise>
				<input type="submit" value="가입" onclick="submit(${update });">
				</c:otherwise>
			</c:choose>
			
			<input type="reset" value="재입력">
			<input type="button" value="홈으로" onclick="location.href='../'">
		</td>
	</tr>
</table>
</form>

<script>
	var division = "${custvo.division}";
	if(division == "personal") {
		document.getElementById("r_per").checked = true;
		document.getElementById("td_idno").innerHTML = "주민번호";
	} else if(division == "company") {
		document.getElementById("r_com").checked = true;
		document.getElementById("td_idno").innerHTML = "사업자번호";
	}
</script>
</body>
</html>