<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	
	function ddd()
	{
		var obj = document.getElementById("viewTable");
		
		if (obj.style.display == "none")
			obj.style.display = "inline";
		else
			obj.style.display = "none";
	}

</script>
</head>
<body>
	<table id="viewTable" style="display:none">
	<tr>
		<td>aaaaaaaa</td>
	</tr>
	</table>
	
	<table>
	<tr>
		<td><input type="button" value="OK" onclick="ddd();"></td>
	</tr>
	</table>
</body>
</html>