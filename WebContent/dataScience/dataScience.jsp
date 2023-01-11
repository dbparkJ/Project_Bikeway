<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import = "riding.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctxpath" value="<%=request.getContextPath() %>" />			


<html>
<head>

<meta charset="EUC-KR">
<title>Insert title here</title>

	<%-- 부트스트랩 --%>


	<script src="https:ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			var vahnge=setInterval2(gogo,5000);//5�� ������� gogo()ȣ��
		})	
		
		function gogo(){
			$("#imgId").attr("src","${ctxpath}/template/chart.png")
		}
	</script>
	<style>
		<%--
		#title{
		font-family: 여기어때 잘난체 OTF;
		}
		#fontstyle{
		font-family: 여기어때 잘난체 OTF;
		}
		--%>
		
		#table1st{
		border:2px solid #BDBDBD;
		}
		
	</style>

</head>

<body class="pt-5" >

	<tr>	
	<br>
	<%
	RidingDTO ridingDTO=new RidingDTO();
	RidingDAO ridingDAO=RidingDAO.getDao();
	%>
	

	
<h2 id = "title" align="center">'nickname'님의 주간기록</h2>


<table id = "table1style" cellpadding="20" width="800" height="300" align = "center">
	
		<td>
			<font size = "+1" id="fontstyle">라이딩 주간 주행거리 분석</font>
		</td>
	</tr>
	
	<tr>
		<td> 
			<div id="image_container">
				<img id="distanceChart" src = "chart.png" width="600" height="250" alt="distance_chart"/>
			</div>
		</td>
	</tr>
	
</table>
<table></table>
<table id = "table1style" cellpadding="20" width="800" height="300" align = "center">
	
	<tr>	
		<td>
			<font size = "+1" id="fontstyle">라이딩 주간 Kcal 분석</font>
		</td>
	</tr>
	
	<tr>
		<td>
			<div id="image_container">	
				<img src = "image_graph.png" width="600" height="250">
			</div>
		</td>
	</tr>

	<tr>
		<td align = "center">
			<font size = "+2" id = "fontstyle">일주일동안 5,632Kcal 소모하셨고 566Km 주행하셨습니다!</font>
		</td>
	</tr>

</table>
</body>
</html>