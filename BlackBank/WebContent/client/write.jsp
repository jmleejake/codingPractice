<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
</head>
<body>

<script type="text/javascript">
	function joinCheck(){
		var f = window.document.writeForm;
		
		if(f.cltName.value==""){
			alert("�̸�ĭ�� ����ֽ��ϴ�!!");
			return false;
		}
		if(f.cltRrn.value==""){
			alert("�ֹι�ȣ�� ����ֽ��ϴ�!!");
			return false;
		}
		if(f.cltTel.value.length==0){
			alert("��ȭ��ȣĭ�� ����ֽ��ϴ�!!");
			return false;
		}
		if(f.cltCel.value.length==0){
			alert("�ڵ���ĭ�� ����ֽ��ϴ�!!");
			return false;
		}
		if(f.cltAddr.value==""){
			alert("�ּ�ĭ�� ����ֽ��ϴ�!!");
			return false;
		}
		if(!/^[\w\.-]+@\w+(\.\w+)$/.test(f.cltEmail.value)){
		   	alert("�̸����� ����Ȯ�մϴ�!!");
		   	return false;
		}
		return true;
	}

</script>

	<center>
			<h3>�����</h3>
			<br>
			<form action="<%=request.getContextPath()%>/bank.do" method="post"
			name="writeForm" onsubmit="return joinCheck()">
				<table border="1" cellspacing="1" width="60%">
					<tr>
						<td width=30% align=center>���̸�</td>
						<td width=70%><input type="text" name="cltName"></td>
					</tr>
					<tr>
						<td width=30% align=center>�ֹε�Ϲ�ȣ</td>
						<td width=70%><input type="text" name="cltRrn"></td>
						</td>
					</tr>	
					<tr>
						<td width=30% align=center>��ȭ��ȣ</td>
						<td width=70%><input type="text" name="cltTel"></td>
					</tr>
					<tr>
						<td width=30% align=center>�ڵ�����ȣ</td>
						<td width=70%><input type="text" name="cltCel"></td>
						</td>
					</tr>
					<tr>
						<td width=30% align=center>�ּ�</td>
						<td width=70%><input type="text" name="cltAddr"></td>
						</td>
					</tr>
					<tr>
						<td width=30% align=center>�̸���</td>
						<td width=70%><input type="text" name="cltEmail"></td>
						</td>
					</tr>
				</table>
				<br>
				<input type="submit" value="���">&nbsp;
				<input type="hidden" name="command" value="INSERT">
				<input type="reset" value="���">&nbsp;
				<input type="button" value="�����" Onclick="location.href='<%=request.getContextPath()%>/bank.do?command=LIST'">
				
			</form>
		</center>
</body>
</html>