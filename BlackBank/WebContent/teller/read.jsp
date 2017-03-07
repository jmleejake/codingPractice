<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
<HEAD>
<SCRIPT language=javascript>
	function sendDelete(){	
			var tlrPw = prompt("삭제할 텔러의 비밀번호를 입력해주세요");
			document.requestForm.command.value ="TDELETE";		
			document.requestForm.tlrPw.value = tlrPw;
			document.requestForm.submit();		
	}
</script>
<%
	//cache기록을 지우는 코드.
	response.setHeader("Cache-Control","no-store");   
	response.setHeader("Pragma","no-cache");   
	response.setDateHeader("Expires",0);   
	if (request.getProtocol().equals("HTTP/1.1")){
		response.setHeader("Cache-Control", "no-cache");
	}
%> 
</HEAD>
	<tr>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">텔러<br>번호</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">ID</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">비밀번호</span></b></font></p>
        </td>
    </tr>
		   <tr>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		          ${resultContent.tlrNum}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${resultContent.tlrId}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${resultContent.tlrPw}</span></p>
		        </td>
		    </tr>		 	    

        <form name="requestForm" method=post action="<%=request.getContextPath()%>/bank.do">        
	        <input type="button" value="수정" Onclick="location.href='<%=request.getContextPath()%>/bank.do?command=TUPFORM&tlrId=${resultContent.tlrId}'"> 
	        <input type=button value="삭제" onClick="sendDelete()">
	        <input type="hidden" name="command" value="" />
	        <input type="hidden" name="tlrPw" value="" />
		</form>
</table>	  
   

