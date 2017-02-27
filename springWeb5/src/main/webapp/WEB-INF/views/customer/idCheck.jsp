<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>customer idCheck.jsp</title>

<!-- CSS파일 불러오기 -->
<link rel="stylesheet" href="../resources/css/customer.css">
<!-- JS파일 불러오기 -->
<script src="../resources/js/customer.js"></script>
</head>
<body>
<h1>[ID 중복 확인]</h1>
<!-- 검색폼 -->
<form action="idDup" method="post" onsubmit="return idDupCheck();">
	<table>
		<tr>
			<td><input type="text" id="custid" name="custid" 
					placeholder="아이디 입력" value="${curr_id }"></td>
			<td><input type="submit" value="검색"></td>
		</tr>
	</table>
</form>
<!-- 검색결과 -->
<c:if test="${execute }">
	<c:if test="${ret == null }">
		<p id="possible">[${curr_id }]는(은) 사용가능한 아이디 입니다.
		<input type="button" value="사용하기" onclick="idUse('${curr_id }')"></p>
	</c:if>
	<c:if test="${ret != null }">
		<p id="impossible">[${curr_id }]는 이미 사용중인 아이디 입니다.</p>
	</c:if>
</c:if>
</body>
</html>