<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
 <center>
   <h3>��ǰ���</h3>
   <br>
   <form action="<%= request.getContextPath() %>/bank.do" method="post">
    <table border="1" cellspacing="1" width="60%">
     <tr>
      <td width=30% align=center>��ǰ�ڵ�</td>
      <td width=70%><input type="text" name="prdCode"></td>
     </tr>
    <table border="1" cellspacing="1" width="60%">
     <tr>
      <td width=30% align=center>��ǰ�̸�</td>
      <td width=70%><input type="text" name="prdName"></td>
     </tr>
     <tr>
      <td width=30% align=center>��ǰ�ݸ�</td>
      <td width=70%><input type="text" name="interest"></td>
     </tr>
     <tr>
      <td width=30% align=center>�����ں�й�ȣ</td>
      <td width=70%><input type="text" name="adminPw"></td>
     </tr>
    </table>
    <br>
    <input type="submit" value="���">&nbsp;
    <input type="hidden" name="command" value="PRDINSERT">
    <input type="reset" value="���">&nbsp;
   </form>
  </center>
</body>
</html>