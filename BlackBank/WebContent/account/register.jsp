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
			<h3>���µ��</h3>
			<br>
			<form action="<%= request.getContextPath() %>/bank.do" method="post" name="f">
				<table border="1" cellspacing="1" width="60%">
					<tr>
						<td width=30% align=center>���º�й�ȣ</td>
						<td width=70%><input type="password" name="accPw"></td>
					</tr>
					<tr>
						<td width=30% align=center>��ǰ�ڵ�</td>
						<td width=70%><select onchange="changeTable()" name="prdCode">
										<option selected>�ŷ��ڵ� ����</option>
										<option value="or" id="or" onclick="orCode()">���뿹��</option>
										<option value="sa" id="sa" onclick="saCode()">���࿹��</option>
										<option value="ti" id="ti" onclick="tiCode()">���⿹��</option>
										<option value="pe" id="pe" onclick="peCode()">��������</option>
									  </select>
						</td>
					</tr>
					<tr align="center" bgcolor="#dedede">
                     	<td colspan="2" width="50%" bgcolor="#dcdcdc"><font color="#696969"><p id="show"></td>
                 	</tr>
					<tr>
						<td width=30% align=center>���¸�������</td>
						<td width=70%><select name="expDay">
										<option selected>������ ����</option>
										<option>�ش���׾���</option>
										<option>1����</option>
										<option>3����</option>
										<option>10����</option>
									  </select>
						</td>
					</tr>
					<tr>
						<td width=30% align=center>���º�������</td>
						<td width=70%><select name="payDay">
										<option selected>���� ����
										<option>�ش���׾���</option>
										<option>�ſ�1��</option> <option>�ſ�2��</option> <option>�ſ�3��</option> <option>�ſ�4��</option> <option>�ſ�5��</option> <option>�ſ�6��</option>
										<option>�ſ�7��</option> <option>�ſ�8��</option> <option>�ſ�9��</option> <option>�ſ�10��</option> <option>�ſ�11��</option> <option>�ſ�12��</option>
										<option>�ſ�13��</option> <option>�ſ�14��</option> <option>�ſ�15��</option> <option>�ſ�16��</option> <option>�ſ�17��</option> <option>�ſ�18��</option>
										<option>�ſ�19��</option> <option>�ſ�20��</option> <option>�ſ�21��</option> <option>�ſ�22��</option> <option>�ſ�23��</option> <option>�ſ�24��</option>
										<option>�ſ�25��</option> <option>�ſ�26��</option> <option>�ſ�27��</option> <option>�ſ�28��</option> <option>�ſ�29��</option> <option>�ſ�30��</option>
										<option>�ſ�31��</option>
									  </select>
						</td>
					</tr>
				</table>
				<br>
				<input type="submit" value="���">&nbsp;
				<input type="hidden" name="command" value="AINSERT">
				<input type="reset" value="���">&nbsp;
			</form>
		</center>
</body>
</html>