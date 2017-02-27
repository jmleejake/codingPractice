<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board write.jsp</title>

<!-- CSS파일 불러오기 -->
<link rel="stylesheet" href="../resources/css/board.css">
<!-- JS파일 불러오기 -->
<script src="../resources/js/board.js"></script>
</head>
<body onload="checkState(${update})">
<h2 id="title">[게시글 등록]</h2>
<form id="frm" action="add" method="post" enctype="multipart/form-data" onsubmit="return boardValueCheck();">
<c:if test="${update}">
<input type="hidden" name="custid" value="${borvo.custid }">
<input type="hidden" name="bno" value="${borvo.bno }">
</c:if>
<table>
	<tr>
		<th>제목</th>
		<td><input type="text" id="v_title" name="title" value="${borvo.title }"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea id="ta_content" name="content" rows="7" cols="50">${borvo.content }</textarea></td>
	</tr>
	<tr>
		<th>파일첨부</th>
		<td>
		<input type="file" name="upload" multiple="multiple">
		<c:if test="${update }">
			<br>
			${borvo.original_file }
		</c:if>
		</td>
	</tr>
	<tr>
		<td id="btn_area" colspan="2">
		<input id="btn_submit" type="submit" value="등록">
		<input type="button" value="게시판 메인으로" onclick="location.href='list'">
		</td>
	</tr>
</table>
</form>
</body>
</html>