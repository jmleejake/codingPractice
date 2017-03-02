<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jq2.jsp</title>

<style>
	.c1 {
		background-color: aqua;
		color: yellow;
		font-weight: bold;
	}
	
	.c2 {
		background-color: fuchsia;
		color: olive;
		font-weight: bold;
	}
</style>

<script src="resources/js/jquery-3.1.1.min.js"></script>

<script>
var cname = null;
$(document).ready(function() {
	$("#btn1").on("click", btn1_click);
	$("#btn2").on("click", btn2_click);
	$("#btn3").on("click", btn3_click);
	$("#btn4").on("click", btn4_click);
});

function btn1_click() {
	$("#p1").removeClass(cname);
	cname = "c1";
	$("#p1").addClass(cname);
}

function btn2_click() {
	$("#p1").removeClass(cname);
	cname = "c2";
	$("#p1").addClass(cname);
}

function btn3_click() {
	$("#p1").removeClass(cname);
}

function btn4_click() {
	var str = prompt("내용?!");
	$("#p1").text(str);
}
</script>
</head>
<body>
<h2>[jQuery 연습2]</h2>

<p id="p1">Paragraph</p>

<input type="button" id="btn1" value="클래스1 추가">
<input type="button" id="btn2" value="클래스2 추가">
<input type="button" id="btn3" value="클래스 삭제">
<input type="button" id="btn4" value="내용 변경">

</body>
</html>