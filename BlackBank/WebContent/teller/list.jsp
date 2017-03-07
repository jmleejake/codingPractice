<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<HEAD>
<%
	//cache����� ����� �ڵ�.
	response.setHeader("Cache-Control","no-store");   
	response.setHeader("Pragma","no-cache");   
	response.setDateHeader("Expires",0);   
	if (request.getProtocol().equals("HTTP/1.1")){
		response.setHeader("Cache-Control", "no-cache");
	}
%>

<style type="text/css"> 
	A:link {color:white; text-decoration:none} 
	A:visited {color:white; text-decoration:none} 
	A:active {color:white; text-decoration:none} 
	A:hover {color:white; text-decoration:none} 
</style> 
</HEAD>

<table align="center" border="0" cellpadding="5" cellspacing="2" bordercolordark="white" bordercolorlight="black">
	<form action="<%=request.getContextPath()%>/bank.do" method="post">
	<tr>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">�ڷ�<br>��ȣ</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">���̵�</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">�̸�</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">��ȭ��ȣ</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">�ڵ���</span></b></font></p>
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
    
<c:choose>   
<c:when test="${list==null || fn:length(list) == 0 }">
    </c:when>
    <c:otherwise>
    	<c:forEach items="${sessionScope.list}" var="list">    	    
		   <tr>
		        <td>
		            <a align="center" href="<%=request.getContextPath()%>/bank.do?command=TREAD&tlrId=${list.tlrId}"><span style="font-size:9pt; color:#00ff00;">
		           ${list.tlrNum}</span></a>
		        </td>
		        <td>
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${list.tlrId}</span></p>
		        </td>
		        <td>
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${list.tlrName}</span></p>
		        </td>
		        <td>
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${list.tlrTel}</span></p>
		        </td>
		        <td>
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${list.tlrCel}</span></p>
		        </td>
		        <td>
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${list.tlrAddr}</span></p>
		        </td>
		        <td>
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${list.tlrEmail}</span></p>
		        </td>
		    </tr>		            		        
		    </c:forEach>
		  </c:otherwise>
	  </c:choose>
	<input type="text" name="tlrId" value="ID�� �Է��ϼ���" onFocus="javascript:this.value=''"/>
	<input type="hidden" name="command" value="TREAD" />
	<input type="submit" value="�ڷ���ȸ" />&nbsp;&nbsp;&nbsp;
	<input type="button" value="�ڷ�����" onclick="location.href='<%= request.getContextPath() %>/bank.do?command=TINFORM'">
	<input type="button" value="�ڷ�����Ʈ" onclick="location.href='<%= request.getContextPath() %>/bank.do?command=TLIST'">
    </table>
  </form>
   

