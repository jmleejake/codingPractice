<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
 <p>������ ��ǰ�ڵ�� ������ ��й�ȣ�� �Է��� �ּ���</p>
 <form action="<%= request.getContextPath() %>/bank.do?command=PRDELETE" method="post">
  <table border=1>
  <tr>
  <td>��ǰ<br>�ڵ�: </td><td><input type="text" name="prdCode" value=<%=request.getParameter("prdCode") %>></td>
  <td>������<br>��й�ȣ: </td><td><input type="password" name="adminPw" /></td>
  <td><input type="submit" value="��ǰ����" />
  </tr>
  </table>
 </form>
</body>
</html>