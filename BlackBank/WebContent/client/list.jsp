<%@page import="bank.model.client.ClientDao,bank.model.client.ClientPaging,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<html>
<head>
<%
	//cache기록을 지우는 코드.
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	if (request.getProtocol().equals("HTTP/1.1")) {
		response.setHeader("Cache-Control", "no-cache");
	}
%> 

<style type="text/css"> 
	A:link {color:white; text-decoration:none} 
	A:visited {color:white; text-decoration:none} 
	A:active {color:white; text-decoration:none} 
	A:hover {color:white; text-decoration:none} 
</style>
</head>
<body bgcolor="black">
<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
	<form action="<%=request.getContextPath()%>/bank.do" method="post">
	<tr>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">고객 번호</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">고객 이름</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">주민등록번호</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">전화번호</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">핸드폰번호</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">주소</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:9pt;">이메일</span></b></font></p>
        </td>
    </tr>
    <%
    	String lPage = request.getParameter("page");
    	int iPage = 1;
    	if (lPage != null) {
    		iPage = Integer.parseInt(lPage);
    	}
    	List list = ClientDao.getPageClt(iPage);
    	request.setAttribute("list", list);
    %>
<c:choose>   
<c:when test="${list==null || fn:length(list) == 0 }">	
    </c:when>
    <c:otherwise>
    	<c:forEach items="${requestScope.list}" var="list">    	    
		   <tr>
		        <td>
		            <a align="center" href="<%=request.getContextPath()%>/bank.do?command=READ&cltRrn=${list.cltRrn}"><span style="font-size:9pt; color:#00ff00;">
             	   ${list.cltNum}</span></a>
		        </td>
		        <td>
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${list.cltName}</span></p>
		        </td>
		        <td>
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${list.cltRrn}</span></p>
		        </td>
		        <td>
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${list.cltTel}</span></p>
		        </td>
		        <td>
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${list.cltCel}</span></p>
		        </td>
		        <td>
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${list.cltAddr}</span></p>
		        </td>
		        <td>
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${list.cltEmail}</span></p>
		        </td>
		    </tr>		            		        
		    </c:forEach>
		  </c:otherwise>
	  </c:choose>
	   	
	<tr>
        <input type="text" name="cltRrn" value="주민등록번호 입력" onFocus="javascript:this.value=''">
        <input type="hidden" name="command" value="READ">
        <input type="submit"  value="고객조회">&nbsp;
        <input type="button" value="고객등록" Onclick="location.href='<%=request.getContextPath()%>/bank.do?command=INFORM'">
    </tr>
    </table>
    <center>
    <%--페이징처리해보기... --%>
    
    <%
        	if (ClientPaging.isPrevPage(iPage)) {
        %>
    <a href="<%=request.getContextPath()%>/bank.do?command=LIST&page=<%=iPage - 1%>">Prev</a>
    <%
    	} else {
    %>
    	Prev
   	<%
    	}
    %>
   	
    <%
   	    for (int pageNo = 1; pageNo <= ClientPaging.getPageCount(); pageNo++) {
   	    	if (iPage == pageNo) {
   	    		out.print("[" + pageNo + "]&nbsp;");
   	    	} else {
   	%>
    <a href="<%=request.getContextPath()%>/bank.do?command=LIST&page=<%=pageNo%>">[<%=pageNo%>]</a>&nbsp;
    <%
    		}
    	}
    %>
    
    <%
       	if (ClientPaging.isNextPage(iPage)) {
    %>
    <a href="<%=request.getContextPath()%>/bank.do?command=LIST&page=<%=iPage + 1%>">Next</a>
    <%
    	} else {
    %>
    	Next
    <%
    	}
    %>
    </center>
  </form>
 	<form action="<%=request.getContextPath()%>/bank.do?command=LIST" method="post">
 	<table align="right" border="0" width="100%">
 		<tr>
 			<td>
 				<input type="submit" value="고객리스트보기" />
 			</td>
 		</tr>		
 	</table>
	</form>
	</body>
</html>
   

