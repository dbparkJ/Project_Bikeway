<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "goods.*"
    import = "java.util.*"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
			GoodsDAO goodsDAO = GoodsDAO.getDao();
		%>
		
<c:set var = "list" value="<%=goodsDAO.usedgoods()%>"/>
	
	<c:forEach var = "dto" items ="${list}">
	<table class="table table-striped-columns" align ="center" width ="50%">
	
	<tr>
		<td align="center">
		<a href ="${dto.link}">
		<h3>${dto.title}</h3>
		</a>
		
		<img src = "${dto.img}" height = "280" width = "280">
		
		</td>		
	</tr>
	
	<tr>
		<td colspan="3" align="center">
		<font size ="+1">
		<b>${dto.price}원</b>
		</font>
		</td>
	</tr>

	</table>
	</c:forEach>
	
		
</body>
</html>