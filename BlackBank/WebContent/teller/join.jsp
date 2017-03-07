<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="java.util.*, bank.model.teller.*" %>

<html>
<head>
	<script type='text/javascript' src='/BlackBank/dwr/interface/ReadTeller.js'></script>
	<script type='text/javascript' src='/BlackBank/dwr/engine.js'></script>
	<script type='text/javascript' src='/BlackBank/dwr/util.js'></script>

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
<title>Insert title here</title>

<script type="text/javascript">	
	
	function idChcek() {
		var id = document.getElementById('idCheck').value;
		ReadTeller.helloName(id, idInfo);	
	}

	function idInfo(data) {
		document.getElementById('idInfo').innerHTML = data;
	}

	function joinCheck(){
		var f = window.document.regiForm;
		
		if(f.tlrId.value==""){
			alert("아이디는 필수입니다!!");
			return false;
		}
		if(f.tlrPw.value==""){
			alert("비밀번호는 필수입니다!!");
			return false;
		}
		if(f.tlrName.value==""){
			alert("이름칸이 비어있습니다!!");
			return false;
		}
		if(f.tlrRrn.value==""){
			alert("주민번호가 비어있습니다!!");
			return false;
		}
		if(f.tlrTel.value.length==0){
			alert("전화번호칸이 비어있습니다!!");
			return false;
		}
		if(f.tlrCel.value.length==0){
			alert("핸드폰칸이 비어있습니다!!");
			return false;
		}
		if(f.tlrAddr.value==""){
			alert("주소칸이 비어있습니다!!");
			return false;
		}
		if(!/^[\w\.-]+@\w+(\.\w+)$/.test(f.tlrEmail.value)){
		   	alert("이메일이 부정확합니다!!");
		   	return false;
		}
		return true;
	}

</script>
</head>
<body>
	<center>
			<h3>텔러등록</h3>
			<br>
			<form action="<%= request.getContextPath() %>/bank.do" method="post" name="regiForm" onsubmit="return joinCheck()">
				<table border="1" cellspacing="1" width="400">
					<tr>
						<td width=35% align=center>I D </td>
						<td width=65% align=left><input type="text" id="idCheck" name="tlrId">
						<input type="button" value="중복확인" onClick="idChcek()">
						<font color="#ffff66"><div id="idInfo"></div></font></td>
					</tr>
					<tr>
						<td width=35% align=center>비밀번호</td>
						<td width=65% align=left><input type="password" name="tlrPw" size="20"></td>
					</tr>
					<tr>
						<td width=35% align=center>이름</td>
						<td width=65% align=left><input type="text" name="tlrName" size="20"></td>
					</tr>
					<tr>
						<td width=35% align=center>주민등록번호</td>
						<td width=65% align=left><input type="text" name="tlrRrn" size="20"></td>
					</tr>	
					<tr>
						<td width=35% align=center>전화번호</td>
						<td width=65% align=left><input type="text" name="tlrTel" size="20"></td>
					</tr>
					<tr>
						<td width=35% align=center>핸드폰번호</td>
						<td width=65% align=left><input type="text" name="tlrCel" size="20"></td>
					</tr>
					<tr>
						<td width=35% align=center>주소</td>
						<td width=65% align=left><input type="text" name="tlrAddr" size="20"></td>
					</tr>
					<tr>
						<td width=35% align=center>E-mail</td>
						<td width=65% align=left><input type="text" name="tlrEmail" size="20"></td>
					</tr>
				</table>
				<br>
				<input type="submit" value="등록">&nbsp;
				<input type="hidden" name="command" value="TINSERT">
				<input type="reset" value="취소">&nbsp;
				<input type="button" value="목록" Onclick="location.href='<%= request.getContextPath() %>/bank.do?command=TLIST'">
				
				<br><br>
			</form>
		</center>
</body>
</html>