<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>   
<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
<HEAD>
<SCRIPT language=javascript>
	function sendDelete(){	
		var cltRrn = prompt("������ ���� �ֹε�Ϲ�ȣ�� �Է����ּ���");
		document.requestForm.command.value = "DELETE";		
		document.requestForm.cltRrn.value = cltRrn;		
		document.requestForm.submit();		
	}	
</script>
<%
	//cache����� ����� �ڵ�.
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
            <font color="#696969"><b><span style="font-size:9pt;">�� ��ȣ</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">�� �̸�</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">�ֹε�Ϲ�ȣ</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">��ȭ��ȣ</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">�ڵ�����ȣ</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">�ּ�</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">�̸���</span></b></font></p>
        </td>
    </tr>  	    
		   <tr>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${resultContent.cltNum}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${resultContent.cltName}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${resultContent.cltRrn}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${resultContent.cltTel}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${resultContent.cltCel}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		          ${resultContent.cltAddr}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		          ${resultContent.cltEmail}</span></p>
		        </td>		        
		    </tr>		 	    

        <form name="requestForm" method="post" action="<%=request.getContextPath()%>/bank.do">        
	        <input type="button" value="����" 
	        	onclick="location.href='<%=request.getContextPath()%>/bank.do?command=UPFORM&cltRrn=${resultContent.cltRrn}'"/> 
	        <input type="submit" value="����" onclick="sendDelete()"/>
	        <input type="hidden" name="command" value=""/>
	        <input type="hidden" name="cltRrn" value=""/>
	        <input type="button" value="����ȸâ" onClick="location.href='<%=request.getContextPath()%>/bank.do?command=LIST'"/>
		</form>
</table>
<br><br>
<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
	<tr>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">���¹�ȣ</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">���º�й�ȣ</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">���°�������</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">���¸�����</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">���º�������</span></b></font></p>
        </td>       
    </tr>
	<c:choose>   
	<c:when test="${accountList==null || fn:length(accountList) == 0 }">	
    </c:when>
    	<c:otherwise>
    	<c:forEach items="${sessionScope.accountList}" var="accountList">
    		<c:if test="${accountList.cltNum == resultContent.cltNum }">
		   <tr>
		        <td bgcolor="">
		            <a align="center" href="<%=request.getContextPath()%>/bank.do?command=AREAD&accNum=${accountList.accNum}"><span style="font-size:9pt; color:#00ff00;">		            
		           ${accountList.accNum}</span></a>		            
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${accountList.accPw}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${accountList.crtDay}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${accountList.expDay}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${accountList.payDay}</span></p>
		        </td>		        
		    </tr>		            		        
    		</c:if>
		    </c:forEach>
		  </c:otherwise>
	  </c:choose>
	  <form action="<%=request.getContextPath()%>/bank.do?command=AREAD" method="post">
        <input type="text" name="accNum" value="���¹�ȣ �Է�" onFocus="javascript:this.value=''">
        <input type="submit"  value="������ȸ">&nbsp;&nbsp;&nbsp;
      	<input type="button" value="���»���" onClick='location.href="<%=request.getContextPath()%>/bank.do?command=AINFORM"'>
	   	<input type="button" value="���»���" onClick='location.href="<%=request.getContextPath()%>/bank.do?command=ADELFORM"' >
	  </form>
</table>  		  
   

