
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "riding.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctxpath"  value="<%=request.getContextPath() %>" />	

<html>
<head>

<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<title>Insert title here</title>
	<%-- 부트스트랩 --%>

	<style>
		<%--
		#title{
		font-family: 여기어때 잘난체 OTF;
		}
		#fontstyle{
		font-family: 여기어때 잘난체 OTF;
		}
		--%>
		
		#table1st
		border:2px solid #BDBDBD;
		}
	</style>

</head>
<body class="pt-5" >
	<tr>	
	<%
	RidingDTO ridingDTO=new RidingDTO();
	RidingDAO ridingDAO=RidingDAO.getDao();
	%>
<table>
테스트
<script>
	var disList=[]
	var dateList=[]
</script>
<c:set var = "list" value = "<%=ridingDAO.getRidingList() %>"/>
 
	<c:forEach var="rdto" items="${list}">
		<script>
			disList.push(${rdto.distance});
			dateList.push(${rdto.riding_dt})
		</script>
	</c:forEach>
</table>
<script>
	console.log(dateList);
</script>	

<h2 id = "title" align="center">'nickname'님의 주간기록</h2>

<table id = "table1style" cellpadding="20" width="800" height="300" align = "center">
	
		<td>
			<font size = "+1" id="fontstyle">라이딩 주간 주행거리 분석</font>
		</td>
	</tr>
	
	<tr>
		<td> 
			<div id="image_container">
				<canvas id="myRidingChart"></canvas>
			</div>
		</td>
	</tr>
	
</table>

<table id = "table1style" cellpadding="20" width="800" height="300" align = "center">
	
	<tr>	
		<td>
			<font size = "+1" id="fontstyle">라이딩 주간 Kcal 분석</font>
		</td>
	</tr>
	
	<tr>
		<td>
			<div id="image_container2">	
				<img src = "${ctxpath}/template/bike2.jpg" width="600" height="250">
			</div>
		</td>
	</tr>

	<tr>
		<td align = "center">
			<font size = "+2" id = "fontstyle">일주일동안 5,632Kcal 소모하셨고 566Km 주행하셨습니다!</font>
		</td>
	</tr>

</table>
	
   <script>
    var img = $('#imgId');

    function changeImg() {
    	var tmpDate = new Date();
        img.attr('src', "/test/a.png?ver=" + tmpDate.getTime())
    }

    setInterval(()=> changeImg(), 500);
   </script>
</body>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=17d6d1b98aeed31a6b874f4a6fd6d957"></script>    
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
	<script type="text/javascript" src="${ctxpath}/static/app/js/paintingMap.js"></script>
</html>