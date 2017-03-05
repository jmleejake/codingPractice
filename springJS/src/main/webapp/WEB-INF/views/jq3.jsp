<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jq3.jsp</title>

<style>
	.st_h2 {
		font-family: 궁서;
		font-size: 30px;
	}
	
	img {
		width: 160px;
		height: 160px;
	}
	
	.img_big {
		width: 600px;
		height: 600px;
	}
	
	table {
		margin: auto;
	}
</style>

<script src="resources/js/jquery-3.1.1.min.js"></script>
<script>
$(document).ready(function() {
	$("body").css({
		"margin": "auto"
		,"text-align": "center"
	});
	
	$("#btn1").on("click", changeTitle);
	$("#btn2").on("click", btn2_click);
	
	var img = $("img:first").attr("src");
	$("img:first").on({
		mouseover: function() {
			var random_no = Math.floor(Math.random() * 5) + 1;
			var change_img = img.substring(0,img.length-5) + random_no + ".png";
			$("img:first").attr("src", change_img);
			$("img:first").addClass("img_big");
		}
		, mouseout: function() {
			$("img:first").attr("src", "resources/img/ch1.png");
			$("img:first").removeClass("img_big");
		}
	});
	
	for(var i=1; i<=4; i++) {
		var rno = Math.floor(Math.random() * 5) + 1;
		console.log(rno);
		var imgs = img.substring(0,img.length-5) + rno + ".png";
		console.log(imgs);
		$("#img"+ i).attr("src", imgs);
	}
	
	$(".cbtn").on("click", function(event) {
		var btn_data = $("#" + event.target.id).attr("data");
		$("input[type=text]").val(btn_data);
	});

// 	$(".cbtn").on("click", addText);

	$(".timg").on({
		mouseover: function(event) {
			$("#" + event.target.id).addClass("img_big");
		}
		, mouseout: function() {
			$("#" + event.target.id).removeClass("img_big");
		}
	});
	
	$("#btn5").on("click", function() {
		var cnt = 0;
		var numbers = "";
		$("input[type=text]").val("");
// 		$("input[type=checkbox]").each(function(i, item) {
// 			if($(item).prop("checked")) {
// 				numbers += $(item).val() + " ";
// 				cnt++;
// 			}
// 		})
		
		$("input[type=checkbox]:checked").each(function(i, item) {
			numbers += $(item).val() + " ";
			cnt = i+1;
		})
		
		if(cnt >= 3) {
			$("input[type=text]").val(numbers);
		} else {
			alert("체크박스에서 세개 이상 고르셈요");
		}
	});
	
});

function changeTitle() {
	$("h2:eq(1)").text("진지 돋는 궁서체 인거임.");
	$("h2:eq(1)").addClass("st_h2");
}

function btn2_click() {
	var img = $("img").attr("src");
	console.log(img);
	var random_no = Math.floor(Math.random() * 5) + 1;
	console.log(random_no);
	var change_img = img.substring(0,img.length-5) + random_no + ".png";
	$("img").attr("src", change_img);
}

function addText() {
	var btn_data = $(this).attr("data");
	$("input[type=text]").val(btn_data);
}

</script>
</head>
<body>
<h2>[jQuery 연습3]</h2>
<h2>[jQuery 연습3]-</h2>

<img src="resources/img/ch1.png">
<br>
<input type="checkbox" value="111">첫번째
<input type="checkbox" value="222">두번째
<input type="checkbox" value="333">세번째
<input type="checkbox" value="444">네번째
<input type="checkbox" value="555">오번째
<br><br>
<input type="text">
<br><br>
<input type="button" id="btn1" value="제목 서식 변경하기">
<input type="button" id="btn2" value="속성 사용하기">
<input type="button" id="btn3" class="cbtn" value="사용자 정의 속성1" data="abc">
<input type="button" id="btn4" class="cbtn" value="사용자 정의 속성2" data="xyz">
<input type="button" id="btn5" value="체크박스 속성">
<br><br>
<table>
	<tr>
		<td><img class="timg" id="img1"></td>
		<td><img class="timg" id="img2"></td>
	</tr>
	<tr>
		<td><img class="timg" id="img3"></td>
		<td><img class="timg" id="img4"></td>
	</tr>
</table>
</body>
</html>