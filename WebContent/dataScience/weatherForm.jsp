<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header/header.jsp" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
	<style type="text/css">
		#tb1{
			border-top-style: double;
			padding: 20px 0px;
			font-size: 13pt;
			font-family: 나눔고딕OTF;
		}
		
		h2{
			margin: 20px 0px;
			text-align: center;
			font-size: 20pt;
			font-family: 나눔고딕OTF;
			font-color: #5D5D5D;
		}
		
		input{
			padding: 5px;
		}
		
		#bu1{
			width: 100px;
			height: 30px;
			font-size: 13pt;
			font-weight: bold;
			color: white;
			background-color: #5D5D5D;
			border: none;
			cursor: hand;
		}
		
		#t1{
			width: 80px;
			font-weight: bold;
			background-color: #5D5D5D;
			color: white;
			text-align: center;
		}
		
		#t2{
			width: 150px;
			font-size: 13pt;
		}
	</style>
</head>
<body>
	<h2>날씨 정보 등록</h2>
	
<form name="weatherForm" method="post" action="weatherPro.jsp">
	<table id="tb1" align="center">
		<tr>
			<td id="t1">날짜 </td>
			<td id="t2">
				<input type="date" name="date" id="date">
			</td>
		</tr>
		<tr>
			<td id="t1">기온</td>
			<td id="t2">
				<input type="text" name="temp" id="temp" size="6">°C
			</td>
		</tr>
		<tr>
			<td id="t1">강수량</td>
			<td id="t2">
				<input type="text" name="rain" id="rain" size="6">ml
			</td>
		</tr>
		<tr>
			<td id="t1">풍속</td>
			<td id="t2">
				<input type="text" name="wind" id="wind" size="6">m/sec
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><br>
			<input id="bu1" type="submit" value="전송">
			<input id="bu1" type="reset" value="초기화">
			</td>
		</tr>
	</table>
</form>
</body>
</html>