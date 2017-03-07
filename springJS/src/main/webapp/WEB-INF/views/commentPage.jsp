<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>commentPage.jsp</title>
<!-- 
	Comment VO 정의
	Form에 입력한 데이터를 읽어 서버로 전송
	Controller에서는 값을 받아 DAO에 전달
	MyBatis를 이용한 DB insert
	javascript 함수로 돌아와 alert 출력 (멘트=저장되었습니다.)
 -->
<script src="resources/js/jquery-3.1.1.min.js"></script>
<script>
$(document).ready(function() {
	$.ajax({
		url:"showList"
		, type:"get"
		, dataType:"json"
		, success: function(list) {
			showList(list);
		}
		, error: function() {
			alert("불러오기실패");
		}
		
	});
	
	$("#btn_save").on("click", addComment);
});

function addComment() {
	var name = $("#n").val();
	var txt = $("#txt").val();
	
	if(name == "") {
		alert("이름을 입력하라우!!");
		return;
	}
	if(txt == "") {
		alert("내용을 입력하라우!!");
		return;
	}
	
	$.ajax({
		url:"addComm"
		, type:"post"
		, data:$("#frm").serialize()
		, success: function(list) {
			$("#n").val("");
			$("#txt").val("");
			alert("저장성공");
			
			showList(list);
		}
		, error: function() {
			alert("저장실패");
		}
		
	});
}

function showList(commlist) {
	var txts = "<table id='tbl_comm'>";
	/*
	for(var i=0; i<commlist.length; i++) {
		txts += "<tr>";
		txts += "<td style='color:red;'>" + commlist[i].repno + "</td>";
		txts += "<td>" + commlist[i].create_date + "</td>"; 
		txts += "</tr>";
		txts += "<tr>";
		txts += "<td style='color:blue;'>" + commlist[i].name + "</td>";
		txts += "<td>" + commlist[i].text + "</td>"; 
		txts += "</tr>";
	}
	*/
	$.each(commlist, function(i, comm) {
		txts += "<tr>";
		txts += "<td style='color:red;'>" + comm.repno + "</td>";
		txts += "<td>" + comm.create_date + "&nbsp;&nbsp;<input type='button' class='btn_del' value='삭제' repno='" + comm.repno + "'></td>"; 
		txts += "</tr>";
		txts += "<tr>";
		txts += "<td style='color:blue;'>" + comm.name + "</td>";
		txts += "<td>" + comm.text + "</td>"; 
		txts += "</tr>";
	});
	txts += "</table>";
	$("div").html(txts);
	$(".btn_del").on("click", commDel);
}

function commDel() {
	if(!confirm("삭제한다요?!")) {
		return;
	}
	$.ajax({
		url:"delComm"
		, type:"post"
		, data: {repno:$(this).attr("repno")}
		, success: function(list) {
			alert("삭제성공");
			
			showList(list);
		}
		, error: function() {
			alert("삭제실패");
		}
		
	});
}
</script>

<style>
#tbl_comm tr:nth-child(2n+1) {
	background-color: #cccbbb;
}
</style>
</head>
<body>
<h2>[댓글화면 연습]</h2>
<!-- 댓글작성 -->
<form id="frm">
<table>
	<tr>
		<td>이름</td>
		<td><input type="text" id="n" name="name" style="width: 120px;"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><input type="text" id="txt" name="text" style="width: 400px;">&nbsp;&nbsp;<input type="button" id="btn_save" value="저장"></td>
	</tr>
</table>
</form>

<!-- 댓글목록출력 -->
<div></div>
</body>
</html>