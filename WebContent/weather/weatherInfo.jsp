<%@page import="weather.WeatherDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "weather.*"
    import = "java.util.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
</head>
<body>
		<%
			WeatherDAO weatherRainDAO = WeatherDAO.getDao();
			WeatherDAO weatherTempDAO = WeatherDAO.getDao();
		%>
		
		<c:set var = "list" value="<%=weatherRainDAO.rainInfo()%>"/>
		<c:set var = "vector" value = "<%=weatherTempDAO.tempInfo()%>"/>
		<table id="fontstyle" id="weather" height="30%" width="90%" cellpadding="2" align="center">
		<c:forEach var="wdto" items="${list}">
		<c:forEach var="rdto" items="${vector}">
		
		<%-- 1일 
		날씨상태 : 흐림, 흐리고 비/눈, 구름많음, 맑음, 구름많고 비/눈--%>
		<th>
		<c:set var="day" value="<%=new Date(new Date().getTime() + 60*60*24*1000*1)%>"/>
		<h3><font><fmt:formatDate value="${day}" pattern="yyyy-MM-dd(E)"/></font><br> <%-- 1일후 날짜 --%></h3>
   		
   		<%-- 오전 날씨 상태 --%>
   		<c:if test="${wdto.weather_1_am eq '흐림'}">
   		<img src="cloudy.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_1_am eq '흐리고 비/눈'}">
   		<img src="snowrain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_1_am eq '구름많고 비/눈'}">
   		<img src="snowrain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_1_am eq '구름많음'}">
   		<img src="cloudy.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_1_am eq '맑음'}">
   		<img src="sunny.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_1_am eq '흐리고 비'}">
   		<img src="rain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<%-- 오후 날씨 상태 --%>
   		<c:if test="${wdto.weather_1_pm eq '흐림'}">
   		<img src="cloudy.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_1_pm eq '흐리고 비/눈'}">
   		<img src="snowrain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_1_pm eq '구름많고 비/눈'}">
   		<img src="snowrain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_1_pm eq '구름많음'}">
   		<img src="cloudy.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_1_pm eq '맑음'}">
   		<img src="sunny.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_1_pm eq '흐리고 비'}">
   		<img src="rain.jpg" width="90" height="90"><br>
   		</c:if>
   	 	
   	 	<font size="-1">${wdto.weather_1_am}</font><br>  <%-- 오전 날씨상태 --%>	
		<font size="-1">${wdto.weather_1_pm}</font><br>  <%-- 오후 날씨상태 --%>
		<font size="-1">${rdto.lowtemp_1}℃ / ${rdto.hightemp_1}℃ </font><br> <%-- 최저/최고기온 --%>
		<font size="-1">강수 : ${wdto.rain_1_am}% / ${wdto.rain_1_pm}%</font><br> <%--오전 강수확률 / 오후 강수확률 --%>
		</th>
		
		<%-- 2일 --%>
		<th>
		<c:set var="day" value="<%=new Date(new Date().getTime() + 60*60*24*1000*2)%>"/>
		<h3><font><fmt:formatDate value="${day}" pattern="yyyy-MM-dd(E)"/></font><br></h3>
		
		<%-- 오전 --%>
		<c:if test="${wdto.weather_2_am eq '흐림'}">
   		<img src="cloudy.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_2_am eq '흐리고 비/눈'}">
   		<img src="snowrain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_2_am eq '구름많고 비/눈'}">
   		<img src="snowrain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_2_am eq '구름많음'}">
   		<img src="cloudy.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_2_am eq '맑음'}">
   		<img src="sunny.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_2_am eq '흐리고 비'}">
   		<img src="rain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<%-- 오후 --%>
		<c:if test="${wdto.weather_2_pm eq '흐림'}">
   		<img src="cloudy.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_2_pm eq '흐리고 비/눈'}">
   		<img src="snowrain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_2_pm eq '구름많고 비/눈'}">
   		<img src="snowrain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_2_pm eq '구름많음'}">
   		<img src="cloudy.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_2_pm eq '맑음'}">
   		<img src="sunny.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_2_pm eq '흐리고 비'}">
   		<img src="rain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<font size="-1">${wdto.weather_2_am}</font><br>  <%-- 오전 날씨상태 --%>
		<font size="-1">${wdto.weather_2_pm}</font><br>  <%-- 오후 날씨상태 --%>
		<font size="-1">${rdto.lowtemp_2}℃ / ${rdto.hightemp_2}℃ </font><br>
		<font size="-1">강수 : ${wdto.rain_2_am}% / ${wdto.rain_2_pm}%</font><br>
		</th>
		
		<%-- 3일 --%>
		<th>
		<c:set var="day" value="<%=new Date(new Date().getTime() + 60*60*24*1000*3)%>"/>
		<h3><font><fmt:formatDate value="${day}" pattern="yyyy-MM-dd(E)"/></font><br></h3>
		
		<%-- 오전 --%>
		<c:if test="${wdto.weather_3_am eq '흐림'}">
   		<img src="cloudy.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_3_am eq '흐리고 비/눈'}">
   		<img src="snowrain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_3_am eq '구름많고 비/눈'}">
   		<img src="snowrain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_3_am eq '구름많음'}">
   		<img src="cloudy.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_3_am eq '맑음'}">
   		<img src="sunny.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_3_am eq '흐리고 비'}">
   		<img src="rain.jpg" width="90" height="90"><br>
   		</c:if>
		
		<%-- 오후 --%>
		<c:if test="${wdto.weather_3_pm eq '흐림'}">
   		<img src="cloudy.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_3_pm eq '흐리고 비/눈'}">
   		<img src="snowrain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_3_pm eq '구름많고 비/눈'}">
   		<img src="snowrain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_3_pm eq '구름많음'}">
   		<img src="cloudy.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_3_pm eq '맑음'}">
   		<img src="sunny.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_3_pm eq '흐리고 비'}">
   		<img src="rain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<font size="-1">${wdto.weather_3_am}</font><br> <%-- 오전 --%>
		<font size="-1">${wdto.weather_3_pm}</font><br> <%-- 오후 --%>
		<font size="-1">${rdto.lowtemp_3}℃ / ${rdto.hightemp_3}℃ </font><br>
		<font size="-1">강수 : ${wdto.rain_3_am}% / ${wdto.rain_3_pm}%</font><br>
		</th>
		
		<%-- 4일 --%>
		<th>
		<c:set var="day" value="<%=new Date(new Date().getTime() + 60*60*24*1000*4)%>"/>
		<h3><font><fmt:formatDate value="${day}" pattern="yyyy-MM-dd(E)"/></font><br></h3>
		
		<%-- 오전 --%>
		<c:if test="${wdto.weather_4_am eq '흐림'}">
   		<img src="cloudy.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_4_am eq '흐리고 비/눈'}">
   		<img src="snowrain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_4_am eq '구름많고 비/눈'}">
   		<img src="snowrain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_4_am eq '구름많음'}">
   		<img src="cloudy.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_4_am eq '맑음'}">
   		<img src="sunny.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_4_am eq '흐리고 비'}">
   		<img src="rain.jpg" width="90" height="90"><br>
   		</c:if>
		
		<%-- 오후 --%>
		<c:if test="${wdto.weather_4_pm eq '흐림'}">
   		<img src="cloudy.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_4_pm eq '흐리고 비/눈'}">
   		<img src="snowrain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_4_pm eq '구름많고 비/눈'}">
   		<img src="snowrain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_4_pm eq '구름많음'}">
   		<img src="cloudy.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_4_pm eq '맑음'}">
   		<img src="sunny.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_4_pm eq '흐리고 비'}">
   		<img src="rain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<font size="-1">${wdto.weather_4_am}</font><br>
		<font size="-1">${wdto.weather_4_pm}</font><br>
		<font size="-1">${rdto.lowtemp_4}℃ / ${rdto.hightemp_4}℃ </font><br>
		<font size="-1">강수 : ${wdto.rain_4_am}% / ${wdto.rain_4_pm}%</font><br>
		</th>
		
		<%-- 5일 --%>
		<th>
		<c:set var="day" value="<%=new Date(new Date().getTime() + 60*60*24*1000*5)%>"/>
		<h3><font><fmt:formatDate value="${day}" pattern="yyyy-MM-dd(E)"/></font><br></h3>
		
		<%-- 오전 --%>
		<c:if test="${wdto.weather_5_am eq '흐림'}">
   		<img src="cloudy.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_5_am eq '흐리고 비/눈'}">
   		<img src="snowrain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_5_am eq '구름많고 비/눈'}">
   		<img src="snowrain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_5_am eq '구름많음'}">
   		<img src="cloudy.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_5_am eq '맑음'}">
   		<img src="sunny.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_5_am eq '흐리고 비'}">
   		<img src="rain.jpg" width="90" height="90"><br>
   		</c:if>
		
		<%-- 오후 --%>
		<c:if test="${wdto.weather_5_pm eq '흐림'}">
   		<img src="cloudy.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_5_pm eq '흐리고 비/눈'}">
   		<img src="snowrain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_5_pm eq '구름많고 비/눈'}">
   		<img src="snowrain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_5_pm eq '구름많음'}">
   		<img src="cloudy.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_5_pm eq '맑음'}">
   		<img src="sunny.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<c:if test="${wdto.weather_5_pm eq '흐리고 비'}">
   		<img src="rain.jpg" width="90" height="90"><br>
   		</c:if>
   		
   		<font size="-1">${wdto.weather_5_am}</font><br> <%-- 오전 --%>
		<font size="-1">${wdto.weather_5_pm}</font><br> <%-- 오후 --%>
		<font size="-1">${rdto.lowtemp_5}℃ / ${rdto.hightemp_5}℃ </font><br>
		<font size="-1">강수 : ${wdto.rain_5_am}% / ${wdto.rain_5_pm}%</font><br>
		</th>		
		</c:forEach>
		</c:forEach>
	</table>
	
</body>
</html>