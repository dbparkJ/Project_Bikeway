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
                dataType:"JSON",/*�����κ��� �޴� �ڷ���*/
                success: 
                function(data){
                	alert("���Ἲ��")
                	var json = JSON.parse(data.trim());
                	alert(json)
                }
             });//$.ajax()
		}
	
	</script>
	
	
	
	<body>
		<p id="demo"></p><br>
		<button onclick="a()">���ҷ�����</button>
		<table border="1">
	        <thead>
	            <tr>
	                <th>��ȣ</th>
	                <th>����</th>
	                <th>����</th>
	                <th>�ۼ���</th>
	            </tr>
	        </thead>
	        <tbody>
	        </tbody>
		</table>
		<div id="result"></div>
		<%-- <c:forEach var="allCorse" items="${allCorseList}">
			<span> �ڽ��̸� : ${allCorse.corse_name} </span>&nbsp;
			<span> ���� : ${allCorse.lat} </span>&nbsp;
			<span> �浵 : ${allCorse.lon} </span>&nbsp;
			<span> �� : ${allCorse.elev} </span>&nbsp; <br>
		</c:forEach> --%>
	</body>
</html>