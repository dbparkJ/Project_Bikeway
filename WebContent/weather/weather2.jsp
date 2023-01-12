<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "weather.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
	WeatherRainDTO weatherRainDTO=new WeatherRainDTO();
	WeatherRainDAO weatherRainDAO=WeatherRainDAO.getDao();
	
	WeatherTempDTO weatherTempDTO=new WeatherTempDTO();
	WeatherTempDAO weatherTempDAO=WeatherTempDAO.getDao();
	%>
	
	<table id="fontstyle" id="weather" height="30%" width="100%" cellpadding="2" align="center" border = "1">
		<th>
		<h3>월</h3>
		<a href="${ctxpath}/style/styleCloud.do">
		<img src="sunny.jpg" width="70" height="70"><br>
		</a>
		<font size="-1">2℃ / 5℃ </font><br>
		<font size="-1">강수 : 10% / 50%</font><br>
		</th>
		
		<th>
		<h3>화</h3>
		<a href="${ctxpath}/style/styleCloud.do">
		<img src="rain.jpg" width="70" height="70"><br>
		</a>
		<font size="-1">2℃ / 5℃ </font><br>
		<font size="-1">강수 : 10% / 50%</font><br>
		</th>
		
		<th>
		<h3>수</h3>
		<a href="${ctxpath}/style/styleCloud.do">
		<img src="rain.jpg" width="70" height="70"><br>
		</a>
		<font size="-1">2℃ / 5℃ </font><br>
		<font size="-1">강수 : 10% / 50%</font><br>
		</th>
		
		<th>
		<h3>목</h3>
		<a href="${ctxpath}/style/styleCloud.do">
		<img src="cloudy.jpg" width="70" height="70"><br>
		</a>
		<font size="-1">2℃ / 5℃ </font><br>
		<font size="-1">강수 : 10% / 50%</font><br>
		</th>
		
		<th>
		<h3>금</h3>
		<a href="${ctxpath}/style/styleCloud.do">
		<img src="cloudy.jpg" width="70" height="70"><br>
		</a>
		<font size="-1">2℃ / 5℃ </font><br>
		<font size="-1">강수 : 10% / 50%</font><br>
		</th>
	</table>
	
</body>
</html>