<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajaxTest1.jsp</title>

<script src="resources/js/jquery-3.1.1.min.js"></script>
<script>
$(document).ready(function() {
	$("#btn1").on("click", btn1_click);
	$("#btn2").on("click", btn2_click);
});

function btn1_click() {
	alert("btn1 클릭");
	$.ajax({
		url:"at1_get"
		, type:"get"
		, success: output1
		, error: function(e) {
			alert(JSON.stringify(e));
		}
	});
}

function output1() {
	alert("success 응답 받았다요 - output1");
}

function btn2_click() {
	alert("btn2 클릭");
	$.ajax({
		url:"at1_post"
		, type:"post"
		, data:{str:"니홍고~!"} // 서버로 보내는 parameter
		, dataType:"text" // 서버에서 return 하는 data type
		, success: output2
		, error: function(e) {
			alert(JSON.stringify(e));
		}
	});
}

function output2(val) {
	//alert(val);
	$("p:eq(2)").html(val);
}
</script>
</head>
<body>
<h2>[Ajax 연습 1]</h2>

<p><input type="button" id="btn1" value="서버로 요청 보내기"></p>
<p><input type="button" id="btn2" value="문자열 보내기/받기"></p>
<p style="color: red;"></p>

</body>
</html>