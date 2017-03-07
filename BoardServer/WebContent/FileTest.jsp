<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>eXrep 파일업로드테스트페이지</h1>
	
	<form action="<%= request.getContextPath() %>/board.do" method="post">
		<input type = "file"  id="testFile" />
		<input type = "submit"   value="업로드" />
		<input type= "hidden" name="command" value="FILEUPLOAD" />
	</form>
</body>
</html>