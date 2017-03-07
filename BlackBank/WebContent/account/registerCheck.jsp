<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>계좌정보확인창</h2>
	계좌번호: ${check.accNum}<br>
	계좌비밀번호: ${check.accPw}<br>
	만기일자: ${check.expDay}<br>
	불입일자: ${check.payDay}<br>
	상품코드: ${check.prdCode}<br>
	잔액: ${check.balance}<br>
	<input type="button" value="리스트로이동" onclick="location.href='<%= request.getContextPath() %>/bank.do?command=AREAD&accNum=${check.accNum}'">
</body>
</html>