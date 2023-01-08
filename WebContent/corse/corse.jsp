<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
	</head>
	<script>
		function a(){
			$.ajax({
				type : "get",
                url:"postdb.jsp",
                dataType:"JSON",/*서버로부터 받는 자료형*/
                success: 
                function(data){
                	alert("연결성공")
                	var json = JSON.parse(data.trim());
                	alert(json)
                }
             });//$.ajax()
		}
	
	</script>
	
	
	
	<body>
		<p id="demo"></p><br>
		<button onclick="a()">디비불러오기</button>
		<table border="1">
	        <thead>
	            <tr>
	                <th>번호</th>
	                <th>제목</th>
	                <th>내용</th>
	                <th>작성자</th>
	            </tr>
	        </thead>
	        <tbody>
	        </tbody>
		</table>
		<div id="result"></div>
		<%-- <c:forEach var="allCorse" items="${allCorseList}">
			<span> 코스이름 : ${allCorse.corse_name} </span>&nbsp;
			<span> 위도 : ${allCorse.lat} </span>&nbsp;
			<span> 경도 : ${allCorse.lon} </span>&nbsp;
			<span> 고도 : ${allCorse.elev} </span>&nbsp; <br>
		</c:forEach> --%>
	</body>
</html>