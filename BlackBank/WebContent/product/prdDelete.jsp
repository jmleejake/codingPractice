<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
 <p>삭제할 상품코드와 관리자 비밀번호를 입력해 주세요</p>
 <form action="<%= request.getContextPath() %>/bank.do?command=PRDELETE" method="post">
  <table border=1>
  <tr>
  <td>상품<br>코드: </td><td><input type="text" name="prdCode" value=<%=request.getParameter("prdCode") %>></td>
  <td>관리자<br>비밀번호: </td><td><input type="password" name="adminPw" /></td>
  <td><input type="submit" value="상품삭제" />
  </tr>
  </table>
 </form>
</body>
</html>