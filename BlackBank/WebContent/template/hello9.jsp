<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="utf-8" />
<%
	//cache기록을 지우는 코드.
	response.setHeader("Cache-Control","no-store");   
	response.setHeader("Pragma","no-cache");   
	response.setDateHeader("Expires",0);   
	if (request.getProtocol().equals("HTTP/1.1")){
		response.setHeader("Cache-Control", "no-cache");
	}
%> 

<title>은행 수신 업무 시스템 by C eight</title>
<script type="text/javascript" src="jquery.js"></script>
<style type="text/css">
@import url(css.css);
</style>
<script type="text/javascript" src="js.js"></script>
</head>
<body>
	<font color="white">
		<div id="wrapper">
			<h1>C eight</h1>
			<div id="content">
				<p>
					<tiles:insertDefinition name="bank8" />
				</p>
			</div>
			<div id="foot">Hight 전틀러!</div>
		</div>
	</font>
</body>
</html>
