<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
</head>
<body>
	<div>
		<c:foreach var="tempvec" items="${tempvec}">
			<c:foreach var="rainlist" items="${rainlist}">
				<!-- 1일차 -->
				<c:set var="day" value="<%=new Date(new Date().getTime() + 60*60*24*1000*1)%>"/>
				<fmt:formatDate value="${day}" pattern="yyyy-MM-dd(E)"/>
				<div>
					<c:if test="${rainlist.weather_1_am eq '흐림'}">
						<img src="../weather/snowrain.jpg">
					</c:if>
					<c:if test="${rainlist.weather_1_am eq '흐리고 비/눈'}">
						<img src="../weather/cloudy.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_1_am eq '구름많음'}">
						<img src="../weather/sunny.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_1_am eq '맑음'}">
						<img src="../weather/rain.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_1_am eq '흐리고 비'}">
						<img src="../weather/cloudy.jpg">				
					</c:if>
				</div>
				<div>
					<c:if test="${rainlist.weather_1_pm eq '흐림'}">
						<img src="../weather/snowrain.jpg">
					</c:if>
					<c:if test="${rainlist.weather_1_pm eq '흐리고 비/눈'}">
						<img src="../weather/cloudy.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_1_pm eq '구름많음'}">
						<img src="../weather/sunny.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_1_pm eq '맑음'}">
						<img src="../weather/rain.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_1_pm eq '흐리고 비'}">
						<img src="../weather/cloudy.jpg">				
					</c:if>
				</div>
				<div>
					<p>${rainlist.weather_1_am}</p>
					<p>${rainlist.weather_1_pm}</p>
					<p>최저기온 : ${tempvec.lowtemp_1}℃ / 최고기온 : ${tempvec.hightemp_1}℃ </p>
					<p>강수확률 : ${rainlist.rain_1_am}% / ${rainlist.rain_1_pm}%</p>
				</div>
				
				<c:set var="day" value="<%=new Date(new Date().getTime() + 60*60*24*1000*1)%>"/>
				<fmt:formatDate value="${day}" pattern="yyyy-MM-dd(E)"/>
				<div>
					<c:if test="${rainlist.weather_2_am eq '흐림'}">
						<img src="../weather/snowrain.jpg">
					</c:if>
					<c:if test="${rainlist.weather_2_am eq '흐리고 비/눈'}">
						<img src="../weather/cloudy.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_2_am eq '구름많음'}">
						<img src="../weather/sunny.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_2_am eq '맑음'}">
						<img src="../weather/rain.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_2_am eq '흐리고 비'}">
						<img src="../weather/cloudy.jpg">				
					</c:if>
				</div>
				<div>
					<c:if test="${rainlist.weather_2_pm eq '흐림'}">
						<img src="../weather/snowrain.jpg">
					</c:if>
					<c:if test="${rainlist.weather_2_pm eq '흐리고 비/눈'}">
						<img src="../weather/cloudy.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_2_pm eq '구름많음'}">
						<img src="../weather/sunny.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_2_pm eq '맑음'}">
						<img src="../weather/rain.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_2_pm eq '흐리고 비'}">
						<img src="../weather/cloudy.jpg">				
					</c:if>
				</div>
				<div>
					<p>${rainlist.weather_2_am}</p>
					<p>${rainlist.weather_2_pm}</p>
					<p>최저기온 : ${tempvec.lowtemp_2}℃ / 최고기온 : ${tempvec.hightemp_2}℃ </p>
					<p>강수확률 : ${rainlist.rain_2_am}% / ${rainlist.rain_2_pm}%</p>
				</div>
			
				<c:set var="day" value="<%=new Date(new Date().getTime() + 60*60*24*1000*1)%>"/>
				<fmt:formatDate value="${day}" pattern="yyyy-MM-dd(E)"/>
				<div>
					<c:if test="${rainlist.weather_3_am eq '흐림'}">
						<img src="../weather/snowrain.jpg">
					</c:if>
					<c:if test="${rainlist.weather_3_am eq '흐리고 비/눈'}">
						<img src="../weather/cloudy.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_3_am eq '구름많음'}">
						<img src="../weather/sunny.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_3_am eq '맑음'}">
						<img src="../weather/rain.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_3_am eq '흐리고 비'}">
						<img src="../weather/cloudy.jpg">				
					</c:if>
				</div>
				<div>
					<c:if test="${rainlist.weather_3_pm eq '흐림'}">
						<img src="../weather/snowrain.jpg">
					</c:if>
					<c:if test="${rainlist.weather_3_pm eq '흐리고 비/눈'}">
						<img src="../weather/cloudy.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_3_pm eq '구름많음'}">
						<img src="../weather/sunny.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_3_pm eq '맑음'}">
						<img src="../weather/rain.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_3_pm eq '흐리고 비'}">
						<img src="../weather/cloudy.jpg">				
					</c:if>
				</div>
				<div>
					<p>${rainlist.weather_3_am}</p>
					<p>${rainlist.weather_3_pm}</p>
					<p>최저기온 : ${tempvec.lowtemp_3}℃ / 최고기온 : ${tempvec.hightemp_3}℃ </p>
					<p>강수확률 : ${rainlist.rain_3_am}% / ${rainlist.rain_3_pm}%</p>
				</div>
				
				<c:set var="day" value="<%=new Date(new Date().getTime() + 60*60*24*1000*1)%>"/>
				<fmt:formatDate value="${day}" pattern="yyyy-MM-dd(E)"/>
				<div>
					<c:if test="${rainlist.weather_4_am eq '흐림'}">
						<img src="../weather/snowrain.jpg">
					</c:if>
					<c:if test="${rainlist.weather_4_am eq '흐리고 비/눈'}">
						<img src="../weather/cloudy.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_4_am eq '구름많음'}">
						<img src="../weather/sunny.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_4_am eq '맑음'}">
						<img src="../weather/rain.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_4_am eq '흐리고 비'}">
						<img src="../weather/cloudy.jpg">				
					</c:if>
				</div>
				<div>
					<c:if test="${rainlist.weather_4_pm eq '흐림'}">
						<img src="../weather/snowrain.jpg">
					</c:if>
					<c:if test="${rainlist.weather_4_pm eq '흐리고 비/눈'}">
						<img src="../weather/cloudy.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_4_pm eq '구름많음'}">
						<img src="../weather/sunny.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_4_pm eq '맑음'}">
						<img src="../weather/rain.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_4_pm eq '흐리고 비'}">
						<img src="../weather/cloudy.jpg">				
					</c:if>
				</div>
				<div>
					<p>${rainlist.weather_4_am}</p>
					<p>${rainlist.weather_4_pm}</p>
					<p>최저기온 : ${tempvec.lowtemp_4}℃ / 최고기온 : ${tempvec.hightemp_4}℃ </p>
					<p>강수확률 : ${rainlist.rain_4_am}% / ${rainlist.rain_4_pm}%</p>
				</div>
				
				<c:set var="day" value="<%=new Date(new Date().getTime() + 60*60*24*1000*1)%>"/>
				<fmt:formatDate value="${day}" pattern="yyyy-MM-dd(E)"/>
				<div>
					<c:if test="${rainlist.weather_5_am eq '흐림'}">
						<img src="../weather/snowrain.jpg">
					</c:if>
					<c:if test="${rainlist.weather_5_am eq '흐리고 비/눈'}">
						<img src="../weather/cloudy.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_5_am eq '구름많음'}">
						<img src="../weather/sunny.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_5_am eq '맑음'}">
						<img src="../weather/rain.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_5_am eq '흐리고 비'}">
						<img src="../weather/cloudy.jpg">				
					</c:if>
				</div>
				<div>
					<c:if test="${rainlist.weather_5_pm eq '흐림'}">
						<img src="../weather/snowrain.jpg">
					</c:if>
					<c:if test="${rainlist.weather_5_pm eq '흐리고 비/눈'}">
						<img src="../weather/cloudy.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_5_pm eq '구름많음'}">
						<img src="../weather/sunny.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_5_pm eq '맑음'}">
						<img src="../weather/rain.jpg">				
					</c:if>
					<c:if test="${rainlist.weather_5_pm eq '흐리고 비'}">
						<img src="../weather/cloudy.jpg">				
					</c:if>
				</div>
				<div>
					<p>${rainlist.weather_5_am}</p>
					<p>${rainlist.weather_5_pm}</p>
					<p>최저기온 : ${tempvec.lowtemp_5}℃ / 최고기온 : ${tempvec.hightemp_5}℃ </p>
					<p>강수확률 : ${rainlist.rain_5_am}% / ${rainlist.rain_5_pm}%</p>
				</div>

			</c:foreach>
		</c:foreach>
	</div>		
		
</body>
</html>