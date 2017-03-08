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
<script src="../resources/js/jquery-3.1.1.min.js"></script>

<script>
$(document).ready(function() {
	$("#rep_submit").on("click", replyCheck);
	$(".img_rep").on("click", replyAction);
});


function replyCheck() {
	var text = document.getElementById("v_text");
	
	if(text.value == "") {
		alert("댓글 내용이 없다데쓰!!!!");
		text.focus();
		return;
	}
	
	$.ajax({
		url:"rep_add"
		, type:"post"
		, data:$("#add_frm").serialize()
		, dataType:"json"
		, success: function(list) {
			//$("#v_text").val("");
			text.value = "";
			showList(list);
		}
		, error: function(e) {
			alert(JSON.stringify(e));
		}
	});
}

function showList(repList) {
	var login_id = $("#login_id").val();
	$("#rep_list").html("");
	var txt = "<table> ";
	$.each(repList, function(i, rep) {
		txt += "<tr>";
		txt += "<th>" + rep.creator_name;
		txt += "<input type='hidden' id='login_id' value='" + login_id + "''>";
		txt += "</th>";
		txt += "<td>" + rep.create_date + "</td>";
		txt += "<td>" + rep.text + "</td>";
 		txt += "<td>";
 		if(login_id == rep.custid) {
 			txt += "<img src='../resources/img/modify.png' class='img_rep' act='mod' repno='" + rep.repno + "' bno='" + rep.bno + "' custid='" + rep.custid + "' txt='" + rep.text + "' >";
 		}
 		txt += "</td>";
 		txt += "<td>";
 		if(login_id == rep.custid) {
 			txt += "<img src='../resources/img/delete.png' class='img_rep' act='del' repno='" + rep.repno + "' bno='" + rep.bno + "' custid='" + rep.custid + "' >";
 		}
 		txt += "</td>";
		txt += "</tr>";
	});
	txt += "</table>";
	$("#rep_list").html(txt);
	$(".img_rep").on("click", replyAction);
}

function replyAction() {
	var repno = $(this).attr("repno");
	var action = $(this).attr("act");
	var bno = $(this).attr("bno");
	var custid = $(this).attr("custid");
	
	$("#repno").val(repno);
	$("#bno").val(bno);
	$("#custid").val(custid);
	
	if(action == 'del') {
		var delConfirm = confirm("정말 삭제합니까?");
		if(delConfirm) {
			$.ajax({
				url:"rep_del"
				, type:"post"
				, data:$("#rep_frm").serialize()
				, dataType:"json"
				, success: function(list) {
					showList(list);
				}
				, error: function(e) {
					alert(JSON.stringify(e));
				} 
			});
		}
	} else if (action == 'mod') {
		var modConfirm = confirm("정말 수정합니까?");
		if(modConfirm) {
			var modFrm = "<input type='text' id='v_modt' name='text' >";
			modFrm += "<input type='button' id='mod_submit' value='수정'>";
			$("#mod_frm").html(modFrm);
			$("#v_modt").val($(this).attr("txt"));
			$("#mod_submit").on("click", mod_submit);
		}
	}
	
}

function mod_submit() {
	$.ajax({
		url:"rep_mod"
		, type:"post"
		, data:$("#rep_frm").serialize()
		, dataType:"json"
		, success: function(list) {
			showList(list);
			$("#v_modt").val("");
			$("#mod_frm").html("");
		}
		, error: function(e) {
			alert(JSON.stringify(e));
		} 
	});
}
</script>
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
<form id="add_frm">
댓글
<input type="hidden" name="bno" value="${borvo.bno}">

<input type="text" id="v_text" name="text">
<input type="button" id="rep_submit" value="등록">
</form>
</c:if>

<form id="rep_frm" method="post">
	<input type="hidden" id="repno" name="repno" >
	<input type="hidden" id="bno" name="bno" >
	<input type="hidden" id="custid" name="custid" >
	<div id="mod_frm"></div>
</form>

<div id="rep_list">
<table>
	<c:forEach var="repvo" items="${reps }">
	<tr>
		<th>
		<input type="hidden" id="login_id" value="${cust.custid }">
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
		<img src='../resources/img/modify.png' class='img_rep' act='mod' repno='${repvo.repno }' 
		bno='${repvo.bno }' custid='${repvo.custid }' txt='${repvo.text }'>
		</c:if>
		</td>
		<td>
		<c:if test="${cust.custid ==  repvo.custid}">
		<img src='../resources/img/delete.png' class='img_rep' act='del' repno='${repvo.repno }' 
		bno='${repvo.bno }' custid='${repvo.custid }'>
		</c:if>
		</td>
	</tr>
	</c:forEach>
</table>
</div>
</div>
</body>
</html>