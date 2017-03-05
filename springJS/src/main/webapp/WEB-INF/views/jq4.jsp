<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jq4.jsp</title>

<style>
	input[type=text] {
		width: 300px;
		height: 40px;
	}
</style>

<script src="resources/js/jquery-3.1.1.min.js"></script>
<script>
$(document).ready(function() {
	$("#btn1").on("click", btn_click1);
	$("#s_id1").on("change", selectChange);
	$("#txt").on("input", textChange);
});

function btn_click1() {
	var selectedVal = $("#s_id1").val();
	console.log(selectedVal);
}

function selectChange() {
	var cate = $("#s_id1").val();
	var selBox = "<option value=''>소분류선택</option>";
	
	switch(cate) {
		case "food":
			selBox += "<option value='bread'>빵류</option>";
			selBox += "<option value='milk'>유제품</option>";
			selBox += "<option value='meat'>육류</option>";
			selBox += "<option value='snack'>스낵</option>";
			break;
			
		case "home_elec":
			selBox += "<option value='tv'>테레비</option>";
			selBox += "<option value='audio'>오디오</option>";
			selBox += "<option value='refridge'>냉장고</option>";
			selBox += "<option value='theater'>홈시어터</option>";
			break;
			
		case "fashion":
			selBox += "<option value='pants'>바지</option>";
			selBox += "<option value='gardigan'>가디건</option>";
			selBox += "<option value='hoodies'>후디</option>";
			selBox += "<option value='shirt'>티셔츠</option>";
			break;
	}
	$("#s_id2").html(selBox);
}

function textChange() {
	var howmany = $("#txt").val();
	
	$("label").html(50 - howmany.length);
}
</script>
</head>
<body>
<h2>[jQuery 연습4]</h2>

대분류
<select id="s_id1">
	<option value="">대분류 선택
	<option value="food">식품
	<option value="home_elec">가전
	<option value="fashion">패션
</select>

소분류
<select id="s_id2">
	<option value="">소분류 선택
</select>
<br><br>
<input type="text" id="txt" maxlength="50">&nbsp;&nbsp;글자수: <label></label><br>
<input type="button" id="btn1" value="셀렉트박스 접근">
</body>
</html>