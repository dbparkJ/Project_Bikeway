<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="weather.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <c:set var="ctxpath" value="<%=request.getContextPath() %>"/>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table id="fontstyle" id="weather" height="30%" width="100%" cellpadding="2" align="center">
		<c:forEach var="rainvec" items="${rainvec}">
		<font>지역명 : ${rainvec.areaname}</font><br>
		<font>1일 오전 강수 확률 : ${rainvec.rain_1_am}</font><br>
		<font>1일 오전 날씨 상태 : ${rainvec.weather_1_am} </font><br>
		
		<th>
		<%-- 
		<c:choose>
		<c:when test="${weatherDTO.rain>0}">
		<a href="${ctxpath}/style/styleRain.do">
		<img src="${ctxpath}/imgs/weather/rain.PNG" width="70" height="70"><br>
		</a>
		</c:when>
		
		<c:when test="${weatherDTO.temp>10}">
		<a href="${ctxpath}/style/styleSunny.do">
		<img src="${ctxpath}/imgs/weather/sunny.PNG" width="70" height="70"><br>
		</a>
		</c:when>
		
		<c:otherwise>
		<a href="${ctxpath}/style/styleCloud.do">
		<img src="${ctxpath}/imgs/weather/cloud.PNG" width="70" height="70"><br>
		</a>
		</c:otherwise>
		</c:choose>
	
		<c:set var="day" value="${weatherRainDTO.updatetime}"/>
		<font size="-1"><fmt:formatDate value="${day}" pattern="MM-dd(E)"/></font><br> 날짜출력 --%>
		1일 오후 강수확률 : ${rainvec.rain_1_pm}<br>
		1일 오후 날씨상태 : ${rainvec.weather_1_pm}<br>안녕
		</th>
		
		</c:forEach>
	</table>
	
</body>
</html>