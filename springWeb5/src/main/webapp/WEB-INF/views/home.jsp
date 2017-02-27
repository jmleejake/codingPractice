<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  [Web5]
</h1>
<c:if test="${cust != null }">
	[${cust.name }(${cust.custid })]님 로그인중
</c:if>
<ul type="square">
	<c:if test="${cust == null }">
	<li><a href="customer/join">회원가입</a></li>
	<li><a href="customer/login">로그인</a></li>
	</c:if>
	<c:if test="${cust != null }">
	<li><a href="customer/logout">로그아웃</a></li>
	<li><a href="customer/update">개인정보수정</a></li>
	</c:if>
	<li><a href="board/list">게시판</a></li>
</ul>
</body>
</html>
