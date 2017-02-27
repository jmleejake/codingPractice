<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board read.jsp</title>

<!-- CSS파일 불러오기 -->
<link rel="stylesheet" href="../resources/css/board.css">
<!-- JS파일 불러오기 -->
<script src="../resources/js/board.js"></script>
</head>
<body>
<h2>[게시판 글읽기]</h2>
<table>
	<tr>
		<th>작성자</th>
		<td>${borvo.creator_name } (${borvo.custid })</td>
	</tr>
	<tr>
		<th>작성일시</th>
		<td>${borvo.create_date }</td>
	</tr>
	<tr>
		<th>조회수</th>
		<td>${borvo.read_cnt }</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${borvo.title }</td>
	</tr>
	<tr>
		<th>내용</th>
		<td id="td_content">${borvo.content }</td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td>
		<c:if test="${borvo.saved_file != null }">
		${borvo.original_file }
		<img id="img_down" src="../resources/img/save.png" 
		onclick="location.href='download?bno=${borvo.bno}'">
		</c:if>
		</td>
	</tr>
</table>
<br>
<br>
<div id="div_btn">
<c:if test="${cust.custid ==  borvo.custid}">
<img class="img_list" src="../resources/img/delete.png" 
onclick="deleteCheck(${borvo.bno})">
<img class="img_list" src="../resources/img/modify.png" 
onclick="updateCheck(${borvo.bno})">
</c:if>
<img class="img_list" src="../resources/img/list.png" onclick="location.href='list'">
</div>
<br>
<br>
<div id="div_rep">
<c:if test="${cust.custid !=  null}">
<form id="add_frm" action="rep_add" method="post" onsubmit="return replyCheck();">
댓글
<input type="hidden" name="bno" value="${borvo.bno}">
<c:if test="isUpdateStatus()">
<input type="hidden" id="mod_repno" name="repno" >
<input type="hidden" id="mod_custid" name="custid" >
</c:if>

<input type="text" id="v_text" name="text">
<input type="submit" id="rep_submit" value="등록">
</form>
</c:if>


<table>
	<c:forEach var="repvo" items="${reps }">
	<tr>
		<th>
		${repvo.creator_name } (${repvo.custid })
		</th>
		<td>
		${repvo.create_date }
		</td>
		<td>
		${repvo.text }
		</td>
		<td>
		<c:if test="${cust.custid ==  repvo.custid}">
		<input type="hidden" id="repno${repvo.repno }" value="${repvo.repno }">
		<input type="hidden" id="bno${repvo.repno }" value="${repvo.bno }">
		<input type="hidden" id="custid${repvo.repno }" value="${repvo.custid }">
		<input type="hidden" id="text${repvo.repno }" value="${repvo.text }">
		<img src="../resources/img/modify.png"
		onclick="replyAction(${repvo.repno}, 'mod');" >
		</c:if>
		</td>
		<td>
		<c:if test="${cust.custid ==  repvo.custid}">
		<img src="../resources/img/delete.png"
		onclick="replyAction(${repvo.repno}, 'del');" >
		</c:if>
		</td>
	</tr>
	</c:forEach>
</table>
<form id="rep_frm" method="post">
	<input type="hidden" id="repno" name="repno" >
	<input type="hidden" id="bno" name="bno" >
	<input type="hidden" id="custid" name="custid" >
</form>
</div>
</body>
</html>