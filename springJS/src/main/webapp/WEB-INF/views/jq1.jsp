<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jq1.jsp</title>

<script src="resources/js/jquery-3.1.1.min.js"></script>
<script>
$(document).ready(function() {
	alert("Hello jQuery!");
	$("h2, h4").css("color", "red");
	$("input").css("background-color", "#d6e4fc")
	.css("color", "red")
	.val("1");
	$("p").css("color", "orange");
	$("#p1").css("color", "navy");
	$(".p2").css("color", "green");
	$("div").css("background-color", "yellow");
	
	$("div#d1").css({
		"border": "5px green solid"
		,"width": "300"
		,"height": "200"
		,"margin": "auto"
	});
	$("div#d1").on({
		mouseover : function() {$("div#d1").css("background-color", "red");}
		, mouseout : function() {$("div#d1").css("background-color", "yellow");}
	});
	
	$("div p").css("color", "#408080");
	$("div > p").css("color", "red");
	$("input[type='text']").css("color", "gray")
	.val("abcd");
	
	$("tr:odd").css("background-color", "#d3cdd2");
	$("tr:even").css("background-color", "#b6a9b4");
	$("tr:eq(0)").css("background", "black").css("color", "white");
	$("td:nth-child(2n+1)").css("color", "red");
	$("td:nth-child(2n+2)").css("color", "blue");
	$("th").css("width", "70").css("height", "60");
	
	$("body").css("text-align", "center");
	
	var arr = ["aaa", "bbb", "ccc", "ddd", "eee"];
	$.each(arr, function(i, item) {
		console.log(i + " : " + item);
	});
	
	$("p").each(function(i, item) {
		console.log(i + " : " + $(item).text());
		$(item).html("111");
		//$(item).text("2222");
	});
});

</script>
</head>
<body>
<h2>[jQuery 연습1]</h2>

<h3>123123</h3>
<h4>四 死 四 死 四 死 四 死 四 死</h4>
<img src="http://www.reactiongifs.com/r/hsk.gif" align="middle">
<div id="d1">DIV</div>
<div>DIV2</div>
<div>
<p>Paragraph5</p>
<ul>
	<li><p>Paragraph6</p></li>
</ul>
</div>
<p>Paragraph1</p>
<p id="p1">Paragraph2</p>
<p class="p2">Paragraph3</p>
<p class="p2">Paragraph4</p>
<p><a href="js1">Tagged Paragraph</a></p>

<form>
	<input type="text">
	<br>
	<input type="password">
	<br>
	<input name="r1" type="radio" checked="checked">1
	<input name="r1" type="radio">2
	<input name="r1" type="radio">3
	<br>
	<input type="checkbox">4
	<input type="checkbox">5
	<input type="checkbox">6
</form>

<div align="center">
<table>
	<tr>
		<th>이름</th>
		<th>나이</th>
		<th>전화번호</th>
	</tr>
	<tr>
		<td>aaa</td>
		<td>1</td>
		<td>1234</td>
	</tr>
	<tr>
		<td>bbb</td>
		<td>2</td>
		<td>3456</td>
	</tr>
	<tr>
		<td>ccc</td>
		<td>3</td>
		<td>2323</td>
	</tr>
	<tr>
		<td>ddd</td>
		<td>4</td>
		<td>3465</td>
	</tr>
	<tr>
		<td>eee</td>
		<td>5</td>
		<td>7654</td>
	</tr>
	<tr>
		<td>fff</td>
		<td>6</td>
		<td>8646</td>
	</tr>
</table>
</div>
</body>
</html>