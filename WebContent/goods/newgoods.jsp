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

<div class="text-bg-dark p-3">	
<c:set var = "list" value="<%=goodsDAO.newgoods()%>"/>
	
	<c:forEach var = "dto" items ="${list}">
	<table align ="center" width ="50%">
	
	<tr>
		<td align="center">
		<a href ="${dto.link}">
		<h3>
		${dto.name}
		</h3>
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
</div>	
		
</body>
</html>