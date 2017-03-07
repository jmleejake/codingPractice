<%@ page info="상품정보 수정하기" contentType="text/html; charset=euc-kr"  pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD></HEAD>

<BODY>


<form name=prdModify method=post action="<%=request.getContextPath()%>/bank.do">
	<input type="hidden" name="command" value="PRDUPDATE" />
	<input type="hidden" name="prdCode" value="${resultContent.prdCode}" />
	<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#dcdcdc">
            <p align="center"><font color="#696969" size="3"><b>
            상품코드 ${resultContent.prdCode} 수정하기</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt; color:#ffffff; ">상품명</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="prdName" size="30" value="${resultContent.prdName}"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt; color:#ffffff; ">금리</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type=text name="interest" size="30" value="${resultContent.interest}"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">&nbsp;</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type="submit" value="수정하기"> <input type="reset" value="다시쓰기"></span></b></td>
    </tr>
</table>
</form>
<hr>
<div align=right><span style="font-size:9pt;">&lt;<a href="<%=request.getContextPath()%>/bank.do?command=PRDLIST">상품리스트</a>&gt;</span></div>


</BODY>
</HTML>