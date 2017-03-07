<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<table align="center" border="0" cellpadding="5" cellspacing="2"
	width="100%" bordercolordark="white" bordercolorlight="black">
	<HEAD>
		<style type="text/css"> 
			A:link {color:white; text-decoration:none} 
			A:visited {color:white; text-decoration:none} 
			A:active {color:white; text-decoration:none} 
			A:hover {color:white; text-decoration:none} 
		</style>
	</HEAD>
	<body>

		<table align="center" border="0" cellpadding="5" cellspacing="2"
			width="100%" bordercolordark="white" bordercolorlight="black">
			<tr>
				<td bgcolor="#dcdcdc">
					<p align="center">
						<font color="#696969"><b><span style="font-size: 9pt;">상품코드</span></b></font>
					</p></td>
				<td bgcolor="#dcdcdc">
					<p align="center">
						<font color="#696969"><b><span style="font-size: 9pt;">상품명</span></b></font>
					</p></td>
				<td bgcolor="#dcdcdc">
					<p align="center">
						<font color="#696969"><b><span style="font-size: 9pt;">금리</span></b></font>
					</p></td>
			</tr>
			<c:choose>
				<c:when test="${allProduct==null || fn:length(allProduct) == 0 }">
				</c:when>
				<c:otherwise>
					<c:forEach items="${requestScope.allProduct}" var="allProduct">
						<tr>
							<td bgcolor="">
								<a align="center" href="<%=request.getContextPath()%>/bank.do?command=PRDREAD&prdCode=${allProduct.prdCode}"><span style="font-size:9pt; color:#00ff00;"> 
								${allProduct.prdCode}</span></a>
							</td>
							<td bgcolor="">
								<p align="center"><span style="font-size: 9pt; color:#fafad2;"> 
								${allProduct.prdName}</span></p>
							</td>
							<td bgcolor="">
								<p align="center"><span style="font-size: 9pt; color:#fafad2;"> 
								${allProduct.interest}</span></p>
							</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<form action="<%=request.getContextPath()%>/bank.do" method="post">
				<input type="text" name="prdCode" value="상품코드 입력" onFocus="javascript:this.value=''"> 
				<input type="hidden" name="command" value="PRDREAD"> 
				<input type="submit" value="상품조회"> 
				<input type="button" value="전체상품조회" onClick='location.href="<%= request.getContextPath() %>/bank.do?command=PRDLIST"'>&nbsp;&nbsp;&nbsp;
				<input type="button" value="상품생성" onClick='location.href="<%= request.getContextPath() %>/bank.do?command=PRDINFORM"'> 
			</form>
		</table>
	</body>
	</html>