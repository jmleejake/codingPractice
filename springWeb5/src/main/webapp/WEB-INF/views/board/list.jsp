<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board list.jsp</title>

<!-- CSS파일 불러오기 -->
<link rel="stylesheet" href="../resources/css/board.css">
<!-- JS파일 불러오기 -->
<script src="../resources/js/board.js"></script>
</head>
<body>
<h2>[게시판]</h2>
<p>
<c:if test="${cust.custid != null }">
<img class="img_list" src="../resources/img/write.png" onclick="location.href='add'" >
</c:if>
<img class="img_list" src="../resources/img/home.png" onclick="location.href='../'" >
</p>
	<!-- 게시판 글목록 -->
	<table id="tb_list">
		<tr>
		<td class="white" colspan="3" style="text-align: left;">전체 : ${navi.totalRecordsCount }</td>
		<td class="white" colspan="3" style="text-align: right;">${navi.currentPage }page / ${navi.totalPageCount }pages</td>
		</tr>
		<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>조회수</th>
		<th>작성일</th>
		<th>첨부파일</th>
		</tr>
		
		<c:forEach var="bor" items="${contents }">
		<tr>
		<td>${bor.bno }</td>
		<td>
		<label id="lb_title" onclick="showDetail(${bor.bno })"> ${bor.title }</label>
		<c:if test="${bor.is_new == 'T'}">
		<img src="../resources/img/new.png">
		</c:if>
		<c:if test="${bor.is_hot == 'T'}">
		<img src="../resources/img/hot.png">
		</c:if>
		</td>
		<td>${bor.custid }</td>
		<td>${bor.read_cnt }</td>
		<td>${bor.create_date }</td>
		<td>
		<c:if test="${bor.saved_file != null }">
		<img id="img_down_list" src="../resources/img/clip.png" 
		onclick="location.href='download?bno=${bor.bno}'">
		</c:if>
		</td>
		</tr>
		</c:forEach>
	</table>
	<!-- 페이징 영역 -->
	<br>
	<br>
	<div id="div_paging">
		<c:if test="${navi.currentPage - 5 > 0 }">
			<img src="../resources/img/minus5.png" 
			onclick="boardSearch(${navi.currentPage - 5});"
			style="cursor: pointer;" >
		</c:if>
		<c:if test="${navi.currentPage - 5 <= 0 }">
			<img src="../resources/img/minus5.png">
		</c:if>
		<c:if test="${navi.currentPage - 1 > 0 }">
			<img src="../resources/img/minus1.png" 
			onclick="boardSearch(${navi.currentPage - 1})"
			style="cursor: pointer;" >
		</c:if>
		<c:if test="${navi.currentPage - 1 <= 0 }">
			<img src="../resources/img/minus1.png">
		</c:if>
		<c:forEach var="page" begin="${navi.startPageGroup }" end="${navi.endPageGroup }">
			<a href="javascript:boardSearch(${page })">${page }</a>
		</c:forEach>
		<c:if test="${navi.currentPage + 1 <=  navi.totalPageCount }">
			<img src="../resources/img/plus1.png" 
			onclick="boardSearch(${navi.currentPage + 1})"
			style="cursor: pointer;" >
		</c:if>
		<c:if test="${navi.currentPage + 1 >  navi.totalPageCount }">
			<img src="../resources/img/plus1.png" >
		</c:if>
		<c:if test="${navi.currentPage + 5 <=  navi.totalPageCount }">
			<img src="../resources/img/plus5.png" 
			onclick="boardSearch(${navi.currentPage + 5})"
			style="cursor: pointer;" >
		</c:if>
		<c:if test="${navi.currentPage + 5 >  navi.totalPageCount }">
			<img src="../resources/img/plus5.png">
		</c:if>
	</div>
	<!-- 게시판 검색폼 영역 -->
	<br>
	<br>
	
	<div id="div_search">
	<form action="list">
	<input type="hidden" id="page" name="page" value="1">
	<input type="hidden" id="type" value="${type }">
	<select id="sel_search" name="s_type">
		<option value="title">제목</option>
		<option value="creator">작성자</option>
		<option value="content">내용</option>
	</select>
	<input type="text" id="v_search" name="s_text" value="${keyword }">
	<input type="submit" value="검색"">
	</form>
	</div>
</body>
</html>