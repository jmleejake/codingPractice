/**
 * 
 */

function boardValueCheck() {
	var title = document.getElementById("v_title").value;
	var content = document.getElementById("ta_content").value;
	
	if(title == "") {
		alert("제목을 입력하세요!");
		return false;
	} else {
		if(title.includes("<") || title.includes(">")) {
			alert("다메!!");
			return false;
		}
	}
	
	if(content == "") {
		alert("내용을 입력하세요!");
		return false;
	} else {
		if(content.includes("<") || content.includes(">")) {
			alert("다메!!");
			return false;
		}
	}
	
	return true;
}

function showDetail(bno) {
	location.href='read?bno=' + bno;
}

function boardSearch(page) {
	var type = document.getElementById("type").value;
	var search = type != "" ? type : document.getElementById("sel_search").value;
	var keyword = document.getElementById("v_search").value;
	
	location.href='list?page=' + page + '&s_type=' + search + '&s_text=' + keyword;
}

function deleteCheck(bno) {
	var delConfirm = confirm("정말 삭제합니까?");
	if(delConfirm) {
		location.href='delete?bno=' + bno;
	}
}

function checkState(update) {
	var f = document.getElementById("frm");
	var btn = document.getElementById("btn_submit");
	var title = document.getElementById("title");
	
	if(update) {
		title.innerHTML = "[게시글 수정]";
		btn.value = "수정";
		f.action = "update";
	} else {
		console.log("1111");
		title.innerHTML = "[게시글 등록]";
		btn.value = "등록"
		f.action = "add";
	}
}

function updateCheck(bno) {
	var modConfirm = confirm("정말 수정합니까?");
	if(modConfirm) {
		location.href='update?bno=' + bno;
	}
}

function replyAction(repno, action) {
	var f = document.getElementById("rep_frm");
	var v_repno = document.getElementById("repno" + repno).value;
	var v_bno = document.getElementById("bno" + repno).value;
	var v_custid = document.getElementById("custid" + repno).value;
	var v_text = document.getElementById("text" + repno).value;
	
	var repno = document.getElementById("repno");
	var bno = document.getElementById("bno");
	var custid = document.getElementById("custid");
	
	if(action == 'del') {
		var delConfirm = confirm("정말 삭제합니까?");
		if(delConfirm) {
			f.action = "rep_del";
			repno.value = v_repno;
			bno.value = v_bno;
			custid.value = v_custid;
			f.submit();
		}
	} else if (action == 'mod') {
		var modConfirm = confirm("정말 수정합니까?");
		if(modConfirm) {
			document.getElementById("add_frm").action = "rep_mod";
			
			document.getElementById("mod_repno").value = v_repno;
			document.getElementById("mod_custid").value = v_custid;
			document.getElementById("v_text").value = v_text;
			
			document.getElementById("rep_submit").value ="수정";
		}
	}
	
}

function replyCheck() {
	var text = document.getElementById("v_text");
	
	if(text.value == "") {
		alert("댓글 내용이 없다데쓰!!!!");
		text.focus();
		return false;
	} else {
		if(text.includes("<") || text.includes(">")) {
			alert("다메!!");
			return false;
		}
	}
	
	return true;
}