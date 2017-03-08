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
