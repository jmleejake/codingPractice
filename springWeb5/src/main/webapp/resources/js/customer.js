/**
 * 가입폼관련
 */

/*
 * 폼 onsubmit
 * */
function checkValue() {
	var id = document.getElementById("v_id").value;
	var pw1 = document.getElementById("pw1").value;
	var pw2 = document.getElementById("pw2").value;
	var name = document.getElementById("v_name").value;
	
	if(id == "") {
		alert("ID를 입력하세요!");
		return false;
	}
	
	if(pw1 == "") {
		alert("비밀번호를 입력하세요!");
		return false;
	}
	
	if(pw2 == "") {
		alert("비밀번호를 재입력하세요!");
		return false;
	} else {
		if(pw1 != pw2) {
			alert("같은 비밀번호가 아닙니다!");
			return false;
		}
	}
	
	if(name == "") {
		alert("이름을 입력하세요!");
		return false;
	}
	
	return true;
}

/*
 * 식별번호 (personal 주민번호 / company 사업자번호)
 * */
function setIdnoColumn() {
	var divisions = document.getElementsByName("division");
	
	for(var i=0, len=divisions.length; i<len; i++) {
		if(divisions[i].checked) {
			if(divisions[i].value == "company") {
				document.getElementById("td_idno").innerHTML = "사업자번호";
			} else if(divisions[i].value == "personal") {
				document.getElementById("td_idno").innerHTML = "주민번호";
			}
		}
	}
}

/*
 * 아이디 중복체크 팝업
 * */
function showPop() {
	window.open("idDup", "중뷁체크팝업", "top=200,left=400,width=400,height=250");
}

/*
 * 아이디 중복체크 실행
 * */
function idDupCheck() {
	var id = document.getElementById("custid").value;
	if(id == "") {
		alert("아이디를 입력하세요!");
		return false;
	}
	return true;
}

/*
 * 아이디 중복체크 후 해당 아이디 
 * 사용여부 출력 및 가입폼으로 되돌아가기
 * */
function idUse(id) {
	/*
	- 가입폼의 ID입력란에 전달받은 ID를 입력시킨다.
	- 현재창 닫기
	*/
	opener.document.getElementById("v_id").value = id;
	this.close();
}

/*
 * 수정/가입 처리
 * */
function submit(isUpdate) {
	var f = document.getElementById("f_join");
	if(isUpdate) {
		f.action = "update";
	} else {
		f.action = "join";
	}
	f.submit();
}