<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<c:forEach var="allCorse" items="${allCorseList}">
			<span> 코스이름 : ${allCorse.corse_name} </span>&nbsp;
			<span> 위도 : ${allCorse.lat} </span>&nbsp;
			<span> 경도 : ${allCorse.lon} </span>&nbsp;
			<span> 고도 : ${allCorse.elev} </span>&nbsp; <br>
		</c:forEach>
	</body>
</html>