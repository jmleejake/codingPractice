<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>   
<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
<HEAD>

</HEAD>
	<body>
		<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
			<tr>
		        <td bgcolor="#dcdcdc">
		            <p align="center">
		            <font color="#696969"><b><span style="font-size:9pt;">상품 코드</span></b></font></p>
		        </td>
		        <td bgcolor="#dcdcdc">
		            <p align="center">
		            <font color="#696969"><b><span style="font-size:9pt;">상품명</span></b></font></p>
		        </td>
		        <td bgcolor="#dcdcdc">
		            <p align="center">
		            <font color="#696969"><b><span style="font-size:9pt;">금리</span></b></font></p>
		        </td>  
		    </tr>
				   <tr>
				        <td bgcolor="">
				            <p align="center"><span style="font-size:9pt; color:#fafad2;">		            
				           ${productContent.prdCode}</span></p>		            
				        </td>
				        <td bgcolor="">
				            <p align="center"><span style="font-size:9pt; color:#fafad2;">
				           ${productContent.prdName}</span></p>
				        </td>
				        <td bgcolor="">
				            <p align="center"><span style="font-size:9pt; color:#fafad2;">
				           ${productContent.interest}</span></p>
				        </td>    
				    </tr>		            		        
		</table>
		<input type="button" value="상품수정" onClick='location.href="<%= request.getContextPath() %>/bank.do?command=PRDUPFORM&prdCode=${productContent.prdCode}"'> 
		<input type="button" value="상품삭제" onClick='location.href="<%= request.getContextPath() %>/bank.do?command=PRDDELFORM&prdCode=${productContent.prdCode}"'>  	
	</body>
</html>