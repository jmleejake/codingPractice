<%@ page info="고객정보 수정하기" contentType="text/html;charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
</HEAD>
<%
	//cache기록을 지우는 코드.
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
			alert("전화번호칸이 비어있습니다!!");
			return false;
		}
		if(f.cltCel.value.length==0){
			alert("핸드폰칸이 비어있습니다!!");
			return false;
		}
		if(f.cltAddr.value==""){
			alert("주소칸이 비어있습니다!!");
			return false;
		}
		if(!/^[\w\.-]+@\w+(\.\w+)$/.test(f.cltEmail.value)){
		   	alert("이메일이 부정확합니다!!");
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
            ${resultContent.cltName} 고객님 수정하기</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">전화번호</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="cltTel" size="30"
		 value="${resultContent.cltTel}"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">핸드폰번호</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type=text name="cltCel" size="30"
		 value="${resultContent.cltCel}"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">주소</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="cltAddr" size="50"
		 value="${resultContent.cltAddr}"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">이메일</span></b></p>
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
		<input type="submit" value="수정하기"> <input type="reset" value="다시쓰기"></span></b></td>
    </tr>
</table>
</form>
<hr>
<div align=right><span style="font-size:9pt;">&lt;<a href="<%=request.getContextPath()%>/bank.do?command=LIST">고객리스트</a>&gt;</span></div>


</BODY>
</HTML>