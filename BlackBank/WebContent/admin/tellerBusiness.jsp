<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<%
	//cache����� ����� �ڵ�.
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	if (request.getProtocol().equals("HTTP/1.1")) {
		response.setHeader("Cache-Control", "no-cache");
	}
%>
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>
				<input type="button" value="�ڷ�����"
					   onClick="location.href='<%=request.getContextPath()%>/bank.do?command=TINFORM'">
				<input type="button" value="�ڷ�����Ʈ"
					   onClick="location.href='<%=request.getContextPath()%>/bank.do?command=TLIST'">
			</td>
		</tr>
	</table>

</body>
</html>