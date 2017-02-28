<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 뷰포트(media-query를 사용하기위해 추가)  -->
<meta name="viewport" content="width=device-width, 
initial-scale=1.0, maximum-scale=1.0, user-scalable=no, 
target-densitydpi=medium-dpi">
<title>js-object.jsp</title>

<!-- media query -->
<!-- 최소 너비가 100px인 화면에서 적용되는 css -->
<link rel="stylesheet" href="resources/css/mobile1.css" media="(min-width:100px)">
<!-- 최대 너비가 50px이고 세로화면 화면에서 적용되는 css -->
<link rel="stylesheet" href="resources/css/mobile2.css" media="(max-width:500px) and (orientation:portrait)">
<!-- 인쇄시 적용되는 css -->
<link rel="stylesheet" href="resources/css/mobile3.css" media="print">
<script>
function windowObj() {
// 	window.open("http://www.naver.com", "naver_child", "width=300, height=300, location=no, status=no");
var child = window.open("js2", "naver_child", "width=300, height=300, location=no, status=no");
child.moveTo(300, 300);

setInterval(
	function() {
		child.moveBy(10,10);
	}, 1000
);
}

function screenObj() {
	console.log("화면너비 " + screen.width);
	console.log("화면높이 " + screen.height);
	console.log("사용가능화면너비 " + screen.availWidth);
	console.log("사용가능화면높이 " + screen.availHeight);
	
	var w, h, l, t;
	w = screen.width/2;
	h = screen.height/2;
	l = screen.width/4;
	t = screen.height/4;
	
	window.open("http://www.naver.com", "naver_child", "width="+w+" , height="+h+" , left="+l+", top="+t+", location=no, status=no");
}

function navigatorObj() {
// 	alert(navigator.userAgent);
	var check_pc = ["Windows", "Chrome"];
	var check_phone = ["iPhone", "Mobile"];
	console.log(navigator.userAgent);
	var user = navigator.userAgent;
	for(var i=0; i<check_pc.length; i++) {
		console.log(check_pc[i]);
		var check_ret = user.indexOf(check_pc[i], 0);
		if(check_ret > 0) {
			alert("윈도우로다가 접속했구마!!!!");
			return;
		}
	}
	
	for(var i=0; i<check_phone.length; i++) {
		console.log(check_phone[i]);
		var check_ret = user.indexOf(check_phone[i], 0);
		if(check_ret > 0) {
			alert("모바일이다요!!!! 딴세상으로 이도오~~~!!!!");
			location.href = "js1";
			return;
		}
	}
	console.log(navigator.userAgent)
	console.log(navigator.appCodeName);
	console.log(navigator.appName);
	console.log(navigator.appVersion);
	console.log(navigator.platform);
}

function addTextBox() {
	var div = document.getElementById("textDiv");
	div.innerHTML += "<br><input type='text' name='txt'>";
}
</script>
</head>
<body>
<h2>[브라우저 객체 모델 연습]</h2>

<ul>
	<li>
	<input type="button" value="window객체" onclick="javascript:windowObj();">
	</li>
	<li>
	<input type="button" value="screen객체" onclick="javascript:screenObj();">
	</li>
	<li>
	<input type="button" value="navigator객체" onclick="javascript:navigatorObj();">
	</li>
	<li>
	<input type="button" value="location객체" onclick="javascript:locationObj();">
	</li>
	<li>
	<input type="button" value="screen객체" onclick="javascript:screenObj();">
	</li>
</ul>

<form>
	<input type="button" onclick="addTextBox();" value="입력란 추가">
	<div id="textDiv">
		<input type="text" name="txt">
	</div>
</form>
</body>
</html>