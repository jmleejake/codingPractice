<%@ page info="������ �����ϱ�" contentType="text/html;charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
</HEAD>
<%
	//cache����� ����� �ڵ�.
	response.setHeader("Cache-Control","no-store");   
	response.setHeader("Pragma","no-cache");   
	response.setDateHeader("Expires",0);   
	if (request.getProtocol().equals("HTTP/1.1")){
		response.setHeader("Cache-Control", "no-cache");
	}
%> 
<BODY>

<script type="text/javascript">
	function updateCheck(){
		var f = window.document.updateForm;
		
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

<form name=updateForm method=post action="<%=request.getContextPath()%>/bank.do" onsubmit="return updateCheck()">
    <input type="hidden" name="command" value="UPDATE">
    <input type='hidden' name='cltRrn' value="${resultContent.cltRrn}">    
	<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
    <tr>
        <td width="1220" colspan="2" bgcolor="#dcdcdc">
            <p align="center"><font color="#696969" size="3"><b>
            ${resultContent.cltName} ���� �����ϱ�</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">��ȭ��ȣ</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="cltTel" size="30"
		 value="${resultContent.cltTel}"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">�ڵ�����ȣ</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type=text name="cltCel" size="30"
		 value="${resultContent.cltCel}"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">�ּ�</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="cltAddr" size="50"
		 value="${resultContent.cltAddr}"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">�̸���</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="cltEmail" size="50"
		 value="${resultContent.cltEmail}"></span></b></td>
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
<hr>
<div align=right><span style="font-size:9pt;">&lt;<a href="<%=request.getContextPath()%>/bank.do?command=LIST">������Ʈ</a>&gt;</span></div>


</BODY>
</HTML>