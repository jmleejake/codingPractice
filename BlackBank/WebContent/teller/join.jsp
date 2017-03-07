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
	//cache����� ����� �ڵ�.
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
			alert("���̵�� �ʼ��Դϴ�!!");
			return false;
		}
		if(f.tlrPw.value==""){
			alert("��й�ȣ�� �ʼ��Դϴ�!!");
			return false;
		}
		if(f.tlrName.value==""){
			alert("�̸�ĭ�� ����ֽ��ϴ�!!");
			return false;
		}
		if(f.tlrRrn.value==""){
			alert("�ֹι�ȣ�� ����ֽ��ϴ�!!");
			return false;
		}
		if(f.tlrTel.value.length==0){
			alert("��ȭ��ȣĭ�� ����ֽ��ϴ�!!");
			return false;
		}
		if(f.tlrCel.value.length==0){
			alert("�ڵ���ĭ�� ����ֽ��ϴ�!!");
			return false;
		}
		if(f.tlrAddr.value==""){
			alert("�ּ�ĭ�� ����ֽ��ϴ�!!");
			return false;
		}
		if(!/^[\w\.-]+@\w+(\.\w+)$/.test(f.tlrEmail.value)){
		   	alert("�̸����� ����Ȯ�մϴ�!!");
		   	return false;
		}
		return true;
	}

</script>
</head>
<body>
	<center>
			<h3>�ڷ����</h3>
			<br>
			<form action="<%= request.getContextPath() %>/bank.do" method="post" name="regiForm" onsubmit="return joinCheck()">
				<table border="1" cellspacing="1" width="400">
					<tr>
						<td width=35% align=center>I D </td>
						<td width=65% align=left><input type="text" id="idCheck" name="tlrId">
						<input type="button" value="�ߺ�Ȯ��" onClick="idChcek()">
						<font color="#ffff66"><div id="idInfo"></div></font></td>
					</tr>
					<tr>
						<td width=35% align=center>��й�ȣ</td>
						<td width=65% align=left><input type="password" name="tlrPw" size="20"></td>
					</tr>
					<tr>
						<td width=35% align=center>�̸�</td>
						<td width=65% align=left><input type="text" name="tlrName" size="20"></td>
					</tr>
					<tr>
						<td width=35% align=center>�ֹε�Ϲ�ȣ</td>
						<td width=65% align=left><input type="text" name="tlrRrn" size="20"></td>
					</tr>	
					<tr>
						<td width=35% align=center>��ȭ��ȣ</td>
						<td width=65% align=left><input type="text" name="tlrTel" size="20"></td>
					</tr>
					<tr>
						<td width=35% align=center>�ڵ�����ȣ</td>
						<td width=65% align=left><input type="text" name="tlrCel" size="20"></td>
					</tr>
					<tr>
						<td width=35% align=center>�ּ�</td>
						<td width=65% align=left><input type="text" name="tlrAddr" size="20"></td>
					</tr>
					<tr>
						<td width=35% align=center>E-mail</td>
						<td width=65% align=left><input type="text" name="tlrEmail" size="20"></td>
					</tr>
				</table>
				<br>
				<input type="submit" value="���">&nbsp;
				<input type="hidden" name="command" value="TINSERT">
				<input type="reset" value="���">&nbsp;
				<input type="button" value="���" Onclick="location.href='<%= request.getContextPath() %>/bank.do?command=TLIST'">
				
				<br><br>
			</form>
		</center>
</body>
</html>