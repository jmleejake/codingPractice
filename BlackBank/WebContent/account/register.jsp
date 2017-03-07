<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="bank.model.account.action.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<script type='text/javascript' src='/BlackBank/dwr/interface/CodeCheck.js'></script>
<script type='text/javascript' src='/BlackBank/dwr/engine.js'></script>
<script type='text/javascript' src='/BlackBank/dwr/util.js'></script>

<script type="text/javascript">

	function orCode() {
		var code = document.getElementById('or').value;		
		CodeCheck.prdCode(code, prdInfo);
	}
	
	function saCode() {
		var code = document.getElementById('sa').value;		
		CodeCheck.prdCode(code, prdInfo);
	}
	
	function tiCode() {
		var code = document.getElementById('ti').value;		
		CodeCheck.prdCode(code, prdInfo);
	}
	
	function peCode() {
		var code = document.getElementById('pe').value;		
		CodeCheck.prdCode(code, prdInfo);
	}

	function prdInfo(data) {		
		document.getElementById('show').innerHTML = data;
	}
	
</script>

</head>
<body>
	<center>
			<h3>계좌등록</h3>
			<br>
			<form action="<%= request.getContextPath() %>/bank.do" method="post" name="f">
				<table border="1" cellspacing="1" width="60%">
					<tr>
						<td width=30% align=center>계좌비밀번호</td>
						<td width=70%><input type="password" name="accPw"></td>
					</tr>
					<tr>
						<td width=30% align=center>상품코드</td>
						<td width=70%><select onchange="changeTable()" name="prdCode">
										<option selected>거래코드 선택</option>
										<option value="or" id="or" onclick="orCode()">보통예금</option>
										<option value="sa" id="sa" onclick="saCode()">저축예금</option>
										<option value="ti" id="ti" onclick="tiCode()">정기예금</option>
										<option value="pe" id="pe" onclick="peCode()">정기적금</option>
									  </select>
						</td>
					</tr>
					<tr align="center" bgcolor="#dedede">
                     	<td colspan="2" width="50%" bgcolor="#dcdcdc"><font color="#696969"><p id="show"></td>
                 	</tr>
					<tr>
						<td width=30% align=center>계좌만기일자</td>
						<td width=70%><select name="expDay">
										<option selected>만기일 선택</option>
										<option>해당사항없음</option>
										<option>1년후</option>
										<option>3년후</option>
										<option>10년후</option>
									  </select>
						</td>
					</tr>
					<tr>
						<td width=30% align=center>계좌불입일자</td>
						<td width=70%><select name="payDay">
										<option selected>일자 선택
										<option>해당사항없음</option>
										<option>매월1일</option> <option>매월2일</option> <option>매월3일</option> <option>매월4일</option> <option>매월5일</option> <option>매월6일</option>
										<option>매월7일</option> <option>매월8일</option> <option>매월9일</option> <option>매월10일</option> <option>매월11일</option> <option>매월12일</option>
										<option>매월13일</option> <option>매월14일</option> <option>매월15일</option> <option>매월16일</option> <option>매월17일</option> <option>매월18일</option>
										<option>매월19일</option> <option>매월20일</option> <option>매월21일</option> <option>매월22일</option> <option>매월23일</option> <option>매월24일</option>
										<option>매월25일</option> <option>매월26일</option> <option>매월27일</option> <option>매월28일</option> <option>매월29일</option> <option>매월30일</option>
										<option>매월31일</option>
									  </select>
						</td>
					</tr>
				</table>
				<br>
				<input type="submit" value="등록">&nbsp;
				<input type="hidden" name="command" value="AINSERT">
				<input type="reset" value="취소">&nbsp;
			</form>
		</center>
</body>
</html>