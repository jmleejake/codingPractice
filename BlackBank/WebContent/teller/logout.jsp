
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�α׾ƿ�</title>
</head>
<body bgcolor="black">
<%session.invalidate();%>
<script type="text/javascript">
	alert("�α׾ƿ� �Ǿ����ϴ�.\n���� �Ϸ絵 �����ϼ̽��ϴ�");
	location.href='<%= request.getContextPath() %>/index.jsp';
</script>
</body>
</html>