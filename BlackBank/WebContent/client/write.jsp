<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<%
	//cache기록을 지우는 코드.
	response.setHeader("Cache-Control","no-store");   
	response.setHeader("Pragma","no-cache");   
	response.setDateHeader("Expires",0);   
	if (request.getProtocol().equals("HTTP/1.1")){
		response.setHeader("Cache-Control", "no-cache");
	}
%> 
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">
	function joinCheck(){
		var f = window.document.writeForm;
		
		if(f.cltName.value==""){
			alert("이름칸이 비어있습니다!!");
			return false;
		}
		if(f.cltRrn.value==""){
			alert("주민번호가 비어있습니다!!");
			return false;
		}
		if(f.cltTel.value.length==0){
			alert("전화번호칸이 비어있습니다!!");
			return false;
		}
		if(f.cltCel.value.length==0){
			alert("핸드폰칸이 비어있습니다!!");
			return false;
		}
		if(f.cltAddr.value==""){
			alert("주소칸이 비어있습니다!!");
			return false;
		}
		if(!/^[\w\.-]+@\w+(\.\w+)$/.test(f.cltEmail.value)){
		   	alert("이메일이 부정확합니다!!");
		   	return false;
		}
		return true;
	}

</script>

	<center>
			<h3>고객등록</h3>
			<br>
			<form action="<%=request.getContextPath()%>/bank.do" method="post"
			name="writeForm" onsubmit="return joinCheck()">
				<table border="1" cellspacing="1" width="60%">
					<tr>
						<td width=30% align=center>고객이름</td>
						<td width=70%><input type="text" name="cltName"></td>
					</tr>
					<tr>
						<td width=30% align=center>주민등록번호</td>
						<td width=70%><input type="text" name="cltRrn"></td>
						</td>
					</tr>	
					<tr>
						<td width=30% align=center>전화번호</td>
						<td width=70%><input type="text" name="cltTel"></td>
					</tr>
					<tr>
						<td width=30% align=center>핸드폰번호</td>
						<td width=70%><input type="text" name="cltCel"></td>
						</td>
					</tr>
					<tr>
						<td width=30% align=center>주소</td>
						<td width=70%><input type="text" name="cltAddr"></td>
						</td>
					</tr>
					<tr>
						<td width=30% align=center>이메일</td>
						<td width=70%><input type="text" name="cltEmail"></td>
						</td>
					</tr>
				</table>
				<br>
				<input type="submit" value="등록">&nbsp;
				<input type="hidden" name="command" value="INSERT">
				<input type="reset" value="취소">&nbsp;
				<input type="button" value="고객목록" Onclick="location.href='<%=request.getContextPath()%>/bank.do?command=LIST'">
				
			</form>
		</center>
</body>
</html>