<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<%
	//cache기록을 지우는 코드.
	response.setHeader("Cache-Control","no-store");   
	response.setHeader("Pragma","no-cache");   
	response.setDateHeader("Expires",0);   
	if (request.getProtocol().equals("HTTP/1.1")){
		response.setHeader("Cache-Control", "no-cache");
	}
%> 
<SCRIPT language=javascript>

function checkValid() {
    var f = window.document.writeForm;
	if ( f.id.value == "") {
	    alert( "아이디를 입력해 주세요." );
	    f.id.focus();
		return false;
    }
	if ( f.pw.value == "" ) {
        alert( "비밀번호를 입력해 주세요" );
        f.pw.focus();
        return false;
    }
	if(f.id.value.length > 0)
	  {
	   var myregexp = new RegExp('^[A-Za-z]+[0-9]*$');
	   if(!myregexp.test(f.id.value))
	   {
	    alert("아이디는 영문과 숫자로만 입력이 가능합니다.");
	    return false;
	   }
	}
	if( document.getElementsByName("loginRadio")[0].checked ==false && 
		document.getElementsByName("loginRadio")[1].checked ==false	){
		alert("Teller인지 Admin인지 체크를 안하셨군요!!!");
		return false;
	}
	return true;
}

</SCRIPT>
<title>로그인</title>
</head>
	<h2>Teller인지 Admin인지 체크하시고 로그인하세요</h2>
	<hr>
	<body>
		<!-- client가 입력하는 입력하는 id/pw 폼
				전송 버튼 --> 
		 <form action="<%= request.getContextPath() %>/bank.do" method="post" name="writeForm" onsubmit='return checkValid()' >
			  <input type="hidden" name='command' value=''>
			  <table border="1">
			  	<tr>
			  	<td>ID</td><td><input type="text" name="id" size="10"/></td>
		 		<td>PW</td><td><input type="password" name="pw" size="10"/></td>
		 		<td><input type="submit" value="로그인" /></td>
		 		</tr>
		 		<tr>
		 		<td colspan=5 align="center">
		 		<input type="radio" name="loginRadio" value="teller">Teller | 
		 		<input type="radio" name="loginRadio" value="admin">Admin</td>
		 		</tr>
			  </table>
		 	
		 </form>
		 <br>
	</body>
</html>