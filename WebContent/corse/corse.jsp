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
			<span> �ڽ��̸� : ${allCorse.corse_name} </span>&nbsp;
			<span> ���� : ${allCorse.lat} </span>&nbsp;
			<span> �浵 : ${allCorse.lon} </span>&nbsp;
			<span> �� : ${allCorse.elev} </span>&nbsp; <br>
		</c:forEach>
	</body>
</html>