<%@page import="bank.model.trade.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<%
	//cache기록을 지우는 코드.
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	if (request.getProtocol().equals("HTTP/1.1")) {
		response.setHeader("Cache-Control", "no-cache");
	}
%> 
<script language="javascript">
	function sendDeposit(){	
		var trdMoney = prompt("입금할 금액");
		document.deposit.command.value="DEPOSIT";		
		document.deposit.trdMoney.value=trdMoney;		
		document.deposit.submit();		
	}
	
	function sendWithdraw(){	
		var trdMoney = prompt("출금할 금액");
		document.withdraw.command.value="WITHDRAW";		
		document.withdraw.trdMoney.value=trdMoney;		
		document.withdraw.submit();		
	}	
</script>

<style type="text/css"> 
	A:link {color:white; text-decoration:none} 
	A:visited {color:white; text-decoration:none} 
	A:active {color:white; text-decoration:none} 
	A:hover {color:white; text-decoration:none} 
</style>
</head>
<body bgcolor="black">
	
	&nbsp;<b>예금거래내역조회</b>
	<table border=1 width="500">
		<tr>
		<td><span style="font-size:10pt;">계좌번호</td><td><input type="text" size="20" value="${accountRead.accNum}"></td>
		<td><span style="font-size:10pt;">계좌개설일자</td><td><input type="text" size="20" value="${accountRead.crtDay}"></td>
		</tr>
		<tr>
		<td><span style="font-size:10pt;">계좌만기일자</td><td><input type="text" size="20" value="${accountRead.expDay}"></td>
		<td><span style="font-size:10pt;">계좌잔고</td><td><input type="text" size="20" value="${accountRead.balance}"></td>
		</tr>
		<tr>
		<td><span style="font-size:10pt;">계좌불입일자</td><td><input type="text" size="20" value="${accountRead.payDay}"></td>
		<td colspan="2"></td>
		</tr>
	</table>
	
	<form name="deposit" method=post action="<%=request.getContextPath()%>/bank.do">  
		 <input type="submit" value="입금" onclick="sendDeposit()">
	     <input type="hidden" name="command" value="" />		
	     <input type="hidden" name="trdMoney" value="" />	  
	     <input type="hidden" name="accNum" value="${accountRead.accNum}" />   
	     <input type="hidden" name="balance" value="${accountRead.balance}" />
	</form>
	
	<form name="withdraw" method=post action="<%=request.getContextPath()%>/bank.do">  
		 <input type="submit" value="출금" onclick="sendWithdraw()">
	     <input type="hidden" name="command" value="" />		
	     <input type="hidden" name="trdMoney" value="" />	  
	     <input type="hidden" name="accNum" value="${accountRead.accNum}" />   
	     <input type="hidden" name="balance" value="${accountRead.balance}" />
	</form>  
	<form name="transfer" method=post action="<%=request.getContextPath()%>/bank.do">
		 <input type="submit" value="이체"/>
		 <input type="text" name="trdNum" value="이체할 계좌번호" onFocus="javascript:this.value=''"/>&nbsp;
		 <input type="text" name="trdMoney" value="이체할 금액" onFocus="javascript:this.value=''"/>
		 <input type="hidden" name="command" value="TRANSFER"/>
		 <input type="hidden" name="accNum" value="${accountRead.accNum}" />   
	     <input type="hidden" name="balance" value="${accountRead.balance}" />		 
	</form>
	
	<br><br><br>
	<table width="500">
	<tr>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:10pt;">거래번호</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:10pt;">거래일시</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:10pt;">거래구분</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:10pt;">거래금액</span></b></font></p>
        </td>
        <td bgcolor="#dcdcdc">
            <p align="center">
            <font color="#696969"><b><span style="font-size:10pt;">거래후 잔액</span></b></font></p>
        </td>
    </tr>
  <%
  	String lPage = request.getParameter("page");
  	String accn = request.getParameter("accNum");
  	int iPage = 1;
  	if (lPage != null) {
  		iPage = Integer.parseInt(lPage);
  	}
  	TradeBean tb = new TradeBean(accn, iPage);
  	List list = TradeDao.getPageTrd(tb);
  	request.setAttribute("tradeList", list);
  %>
<c:choose>   
<c:when test="${tradeList==null || fn:length(tradeList) == 0 }">	
    </c:when>
    <c:otherwise>
    	<c:forEach items="${requestScope.tradeList}" var="tradeList">    	    
		   <tr>
		        <td>
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${tradeList.trdNum}</span></p>
		        </td>
		        <td>
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${tradeList.trdDate}</span></p>
		        </td>
		        <td>
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${tradeList.trdCode}</span></p>
		        </td>
		        <td>
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${tradeList.trdMoney}</span></p>
		        </td>
		        <td>
		            <p align="center"><span style="font-size:9pt; color:#fafad2;">
		           ${tradeList.trdBalance}</span></p>
		        </td>
		    </tr>		            		        
		    </c:forEach>
		  </c:otherwise>
	  </c:choose>
	</table>
	<center>
	<%--페이징처리해보기... --%>
    
    <%
        if (TradePaging.isPrevPage(iPage)) {
    %>
    <a href="<%=request.getContextPath()%>/bank.do?command=AREAD&page=<%=iPage - 1%>&accNum=${accountRead.accNum}">Prev</a>
    <%
    	} else {
    %>
    	Prev
   	<%
    	}
    %>
   	
    <%
   	    for (int pageNo = 1; pageNo <= TradePaging.getPageCount(); pageNo++) {
   	    	if (iPage == pageNo) {
   	    		out.print("[" + pageNo + "]&nbsp;");
   	    	} else {
   	%>
    <a href="<%=request.getContextPath()%>/bank.do?command=AREAD&page=<%=pageNo%>&accNum=${accountRead.accNum}">[<%=pageNo%>]</a>&nbsp;
    <%
    		}
    	}
    %>
    
    <%
        if (TradePaging.isNextPage(iPage)) {
    %>
    <a href="<%=request.getContextPath()%>/bank.do?command=AREAD&page=<%=iPage + 1%>&accNum=${accountRead.accNum}">Next</a>
    <%
    	} else {
    %>
    	Next
    <%
    	}
    %>
    </center>
    <br><br>
</body>
</html>