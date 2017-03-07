<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/board.do" method="post">
		<input type="submit" value="테스트"/>
		<input type="hidden" name="command" value="JOIN"/>
		<input type="hidden" name="MID" value="jmlee3"/>
		<input type="hidden" name="MPW" value="jmlee3"/>
		<input type="hidden" name="MNAME" value="재미니군"/>
		<input type="hidden" name="MTEL" value="1936"/>
		<input type="hidden" name="MJUSO" value="서울 용산구"/>
	</form>
</body>
</html>