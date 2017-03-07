<%@ page contentType="text/html; charset=euc-kr" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
<%
	//cache기록을 지우는 코드.
	response.setHeader("Cache-Control","no-store");   
	response.setHeader("Pragma","no-cache");   
	response.setDateHeader("Expires",0);   
	if (request.getProtocol().equals("HTTP/1.1")){
		response.setHeader("Cache-Control", "no-cache");
	}
%> 
	<title><tiles:getAsString name="title" /></title>
</head>
<body bgcolor="black">
<center>
<table width="1100" border="1">
<tr>
	<td colspan="2" align="left"><tiles:insertAttribute name="header" /></td>
</tr>
<tr>
	<td width="55%" valign="top"><tiles:insertAttribute name="menu" /></td>
	<td width="45%" valign="top"><tiles:insertAttribute name="body" /></td>  
</tr>
</table>
</center>
</body>
</html>