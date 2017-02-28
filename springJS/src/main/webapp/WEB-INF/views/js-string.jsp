<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>js-string.jsp</title>

<script>
function stringTest() {
	
	
	/*
	1. 14가 아니면 오류 length
	2. 성별이 9,0,1,2,3,4가 아니면 오류 charAt
	3. 월이 1~12가 아니면 오류 slice / substring
	4. 일이 1~31이 아니면 오류 slice / substring
	5. 7번째글자가 '-' 이 아니면 오류 slice / substring
	6. 정상입력이면 "1990년 1월 1일생 27세다 남자다요" date
	*/
	var n = null;
	while(true) {
		n = prompt("주민등록번호 입력하라우 (900101-1111111의 형식)");
		
		console.log("성별: " + n.charAt(7));
		console.log("월: " + n.slice(2,4));
		console.log("일: " + n.slice(4,6));
		console.log("7번글자: " + n.charAt(6));
		console.log("년도: " + n.slice(0,2));
		
		var year_front = null;
		var year_back = n.slice(0,2);
		var thisYear = new Date().getFullYear();
		
		var sex = parseInt(n.charAt(7));
		var month = parseInt(n.slice(2,4));
		var day = parseInt(n.slice(4,6));
		var dash = n.charAt(6);
		
		
		if(n.length > 14 || n.length < 14) {
			alert("형식이 안맞다요!! (길이)");
			continue;
		}
		
		console.log(sex);
		if(sex != 9 && sex != 0 && sex != 1 &&
				sex != 2 && sex != 3 && sex != 4) {
			alert("형식이 안맞다요!! (성별)");
			continue;
		} else {
			switch(sex) {
				case 9: case 0: year_front="18"; break;
				case 1: case 2: year_front="19"; break;
				case 3: case 4: year_front="20"; break;
			}
		}
		var birth_year = year_front + year_back;
		var age = thisYear - parseInt(year_front + year_back);
		var nam_yeo = sex%2 ==0 ? "여자":"남자";
		
		console.log(birth_year + "년생")
		console.log(nam_yeo + "다요");
		console.log(age + "살");
		
		var m_ok = false;
		console.log(month);
		console.log("---m---");
		for(var i=1; i <=12; i++) {
			if(month == i) {
				m_ok = true;
			}
		}
		if(!m_ok) {
			alert("월이 아닌데?!!");
			continue;
		}
		
		var d_ok = false;
		console.log(day);
		console.log("---d---");
		for(var i=1; i <=31; i++) {
			if(day == i) {
				d_ok = true;
			}
		}
		if(!d_ok) {
			alert("일이 아닌데?!!");
			continue;
		}
		
		if(dash != "-") {
			alert("형식이 안맞다요!!! (dash)");
			continue;
		}
		
		alert("이 친구는 " + birth_year + "년 " + month + " 월 " + day + " 일에 태어난 " + nam_yeo + " 입니다.");
		break;
	}
	
}
</script>
</head>
<body>
<h2>[String 객체]</h2>

<input type="button" value="민증" onclick="javascript:stringTest();">
</body>
</html>