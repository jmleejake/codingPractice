<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajaxTest2.jsp</title>

<script src="resources/js/jquery-3.1.1.min.js"></script>
<script>
$(document).ready(function() {
	$("div:first").html("4 값받기");
	$("div:eq(1)").html("5 값받기");
	
	$("#btn1").on("click", returnTest1);
	$("#btn2").on("click", returnTest2);
});

function goServer(type) {
	var name = $("#name" + type).val();
	var age = $("#age" + type).val();
	var tel = $("#phone" + type).val();
	
	if(name == "") {
		alert("이름 입력하라우");
		return;
	}
	
	if(age == "") {
		alert("나이 입력하라우");
		return;
	} else {
		if(isNaN(age)) {
			alert("나이는 숫자로...");
			return;
		}
	}
	
	if(tel == "") {
		alert("전번 입력하라우");
		return;
	}
	
	switch(type) {
		case 0:
		case 1:
			$.ajax({
				url:"at2_post_" + type
				, type:"post"
				, data:{
					name: name
					, age: age
					, phone: tel
				}
				, success: function() {
					alert("ㅇㅋ");
				}
				, error: function() {
					alert("ㄴㄴ");
				}
			});
			break;
			
		case 2:
			$.ajax({
				url:"at2_post_" + type
				, type:"post"
				, data:$("#frm").serialize() // form내의 name값으로 서버로 전달
				, success: function() {
					alert("ㅇㅋ");
				}
				, error: function() {
					alert("ㄴㄴ");
				}
			});
			break;
	}
	
}

function returnTest1() {
	$.ajax({
		url:"returnTest"
		, type:"get"
		, dataType: "text"
		, success: function(person) {
			//alert(person);
			$("div:first").html(person);
		}
		, error: function(e) {
			alert(JSON.stringify(e));
		}
	});
}

function returnTest2() {
	$.ajax({
		url:"returnTest"
		, type:"get"
		, dataType: "json"
		, success: function(person) {
			alert(person.name);
			$("div:eq(1)").html("나마에와 [" + person.name + "]데쓰. <br>[" + person.age + "]사이데, 뎅와방고와 [" + person.phone + "] 데쓰");
		}
		, error: function(e) {
			alert(JSON.stringify(e));
		}
	});
}
</script>
</head>
<body>
<h2>[Ajax 연습2]</h2>

<p>1. 서버로 각각의 parameter를 전달</p>
<table>
	<tr>
		<td>이름</td>
		<td><input type="text" id="name0"></td>
	</tr>
	<tr>
		<td>나이</td>
		<td><input type="text" id="age0"></td>
	</tr>
	<tr>
		<td>전화</td>
		<td><input type="text" id="phone0"></td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="button" id="btn_save" 
		value="저장" onclick="goServer(0)">
		</td>
	</tr>
</table>

<p>2. 서버의 VO객체로 전달</p>
<table>
	<tr>
		<td>이름</td>
		<td><input type="text" id="name1"></td>
	</tr>
	<tr>
		<td>나이</td>
		<td><input type="text" id="age1"></td>
	</tr>
	<tr>
		<td>전화</td>
		<td><input type="text" id="phone1"></td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="button" id="btn_save1" 
		value="저장" onclick="goServer(1)">
		</td>
	</tr>
</table>

<p>3. 서버의 VO객체로 전달 (form전송)</p>
<form id="frm">
	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" id="name2" name="name"></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><input type="text" id="age2" name="age"></td>
		</tr>
		<tr>
			<td>전화</td>
			<td><input type="text" id="phone2" name="phone"></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="button" id="btn_save2" 
			value="저장" onclick="goServer(2)">
			</td>
		</tr>
	</table>
</form>

<p>4. 서버에서 객체를 String으로 받기</p>
<p><input type="button" id="btn1" value="객체받기"></p>
<div></div>

<p>5. 서버에서 객체를 JSON으로 받기</p>
<p><input type="button" id="btn2" value="객체받기"></p>
<div></div>

</body>
</html>