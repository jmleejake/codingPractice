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
	function updateCheck(){
		var f = window.document.updateForm;
		
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

<form name=updateForm method=post action="<%=request.getContextPath()%>/bank.do" onsubmit="return updateCheck()">
    <input type="hidden" name="command" value="TUPDATE">
    <input type='hidden' name='tlrId' value="${resultContent.tlrId}">
    <input type='hidden' name='tlrPw' value="${resultContent.tlrPw}">    
	<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#dcdcdc">
            <p align="center"><font color="#696969" size="3"><b>
            ${resultContent.tlrName} �ڷ� �����ϱ�</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt; color:#ffffff;">��ȭ��ȣ</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="tlrTel" size="30"
		 value="${resultContent.tlrTel}"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt; color:#ffffff;">�ڵ�����ȣ</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type=text name="tlrCel" size="30"
		 value="${resultContent.tlrCel}"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt; color:#ffffff;">�ּ�</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="tlrAddr" size="50"
		 value="${resultContent.tlrAddr}"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt; color:#ffffff;">�̸���</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="tlrEmail" size="50"
		 value="${resultContent.tlrEmail}"></span></b></td>
    </tr>    
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">&nbsp;</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type="submit" value="�����ϱ�"> <input type="reset" value="�ٽþ���"></span></b></td>
    </tr>
</table>
</form>

</body>
</html>