<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>javascript 연습1</title>

<script>
// 숫자합
function sumtest() {
	var i,s,n,sum=0;
	s = prompt("숫자(정수)를 입력하시오!!");
	n = parseInt(s);
	for(i=1; i<=n; i++) {
		sum += i;
	}
	
// 	console.log("합계는 " + sum); // 개발자도구
// 	document.write("합계는 " + sum); // 새롭게 창을 만들어 결과값을 출력
// 	alert("합계는 " + sum); // 팝업
document.getElementById("ret1").innerHTML = "합계는 " + sum; 
}

//-----------------------
/*
 * setTimeout 내장함수를 이용하여 1초후에 어떤 동작이 일어나게 하는 연습
 */
function timer() {
	alert("타이머함수 실행")
}

function timerOut() {
	setTimeout(timer, 1000);
}
//-----------------------


//-----------------------
/*
 *setInterval 내장함수를 이용하여 1초마다 시계가 작동하는 듯한 동작이 일어나게 하는 연습
   (+) window.onload를 이용하여 웹페이지가 열리면 바로 동작할수있게 연습
   (+) clearInterval함수를 이용하여 해당 interval동작이 멈추게 연습
 */
var clock;
function clockStart() {
	clock = setInterval(clockGoes, 1000);
}

function clockGoes() {
	document.getElementById("showTime").innerHTML = new Date();
}

function clockStop() {
	clearInterval(clock);
}
//-----------------------


//-----------------------
/*
 * setInterval 내장함수를 이용하여 10초후에 다른 사이트로  이동하게 하는 연습
 */
var time = 10;
function goAnotherSite() {
	setInterval(showNum, 1000);
}

function showNum() {
	time--;
	console.log(time);
	if(time == 0) {
		location.href="http://www.naver.com";
	}
}
//-----------------------


//-----------------------
window.onload = function() {
	clockStart();
// 	goAnotherSite();
}
//-----------------------

function arrayTest() {
	var a1 = ['aa','bb','cc'];
	var a2 = [2,10,4,55];
	
	a1.sort();
	for(var i=0; i<a1.length; i++) {
		console.log(a1[i]);
	}
	
	console.log("reverse");
	a1.reverse();
	for(var i=0; i<a1.length; i++) {
		console.log(a1[i]);
	}
	
	var obj = {
		bno: 12,
		name: "Jaemin Lee",
		nickname: "Jake",
		title: "123123",
		content: "어쩌구 저쩌구 난리법석 우당탕탕"
	};
	
	var out = "";
	for(var key in obj) {
		out += key +" : " + obj[key] + "\n";
	}
	console.log(out);
}
</script>
</head>
<body>
<h1>[JavaScript 연습1]</h1>
<p><a href="javascript:sumtest();">1~입력받은 수 까지의 합계</a></p>
<p>결과: <div id="ret1"></div></p>입니다
<p><a href="javascript:timerOut();">setTimeout()</a></p>
<p>
	<input type="button" value="시계 시작" onclick="javascript:clockStart();">
	<input type="button" value="시계 중지" onclick="javascript:clockStop();">
</p>
<div id="showTime"></div>
<h3 style="color: red;">10초후에 다른세상에 간다요</h3>
<input type="button" value="배열연습" onclick="arrayTest();">
</body>
</html>