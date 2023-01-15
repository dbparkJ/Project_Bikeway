<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>

<meta charset="UTF-8">
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>

</head>
<body>

<c:forEach var="ridingmylist" begin = "0" end ="1" items="${ridingmylist}">					
<h2 align="center">${ridingmylist.id}님의 주간기록</h2>
</c:forEach>	
	<tr>
		<td>
			<div style="width:800px">
			<canvas id="myChart"></canvas>
			</div>
		</td>
	</tr>


<table width="800" height="300" align = "center">
	
	<tr>	
		<td>
			<font size = "+1" id="fontstyle">라이딩 주간 Kcal 분석</font>
		</td>
	</tr>
	
	<tr>
		<td>
			<img src = "" width="600" height="250">
		</td>
	</tr>

	<tr>
		<td align = "center">
			<c:set var = "total" value = "0"/>
			<c:forEach var="ridingmylist" items="${ridingmylist}">
				<c:set var = "total" value = "${total + ridingmylist.distance}"/>
			</c:forEach>					
				<font size = "+2" id = "fontstyle">일주일동안 5,632Kcal 소모하셨고 <c:out value = "${total}"/>Km 주행하셨습니다!</font>
		</td>
	</tr>
</table>

<script>
var distanceDateList = new Array();
var distancemyData = new Array();
var distanceAvgDate = new Array();

<c:forEach var="ridingmylist" items="${ridingmylist}">
	distanceDateList.push(${ridingmylist.riding_dt});
	distancemyData.push(${ridingmylist.distance});	
</c:forEach>

<c:forEach var="ridingAvglist" items="${ridingAvglist}">
	distanceAvgDate.push(${ridingAvglist.distance});	
</c:forEach>

// 우선 컨텍스트를 가져옵니다. 
	window.chartColors = {
		red: 'rgb(255, 99, 132)',
		orange: 'rgb(255, 159, 64)',
		yellow: 'rgb(255, 205, 86)',
		green: 'rgb(75, 192, 192)',
		blue: 'rgb(54, 162, 235)',
		purple: 'rgb(153, 102, 255)',
		grey: 'rgb(231,233,237)',
		mycolor : 'rgb(75, 192, 192)'
	};
	var config = {
		type: 'bar',
		data: {
			labels: distanceDateList,
			datasets: [{
				label: "10% 그래프",
				backgroundColor: window.chartColors.green,
				borderColor: window.chartColors.green,
				data: [5,8,1,12,24,51,10],
				fill: false,
			},
			{
				label: "평균 그래프",
				backgroundColor: window.chartColors.purple,
				borderColor: window.chartColors.purple,
				data: distanceAvgDate,
				fill: false,
			},
			{
				label: "나의 그래프",
				backgroundColor: window.chartColors.red,
				borderColor: window.chartColors.red,
				data: distancemyData,
				fill: false,
			}]
		},
		options: {
			responsive: true,
			title:{
				display:true,
				text:'일주일 라이딩 주행거리 분석 그래프'
			},
			tooltips: {
				mode: 'index',
				intersect: false,
			},
			elements:{
				point:{radius:1}
			},
			hover: {
				mode: 'X',
				intersect: true
			},
			scales: {
				xAxes: [{
					display: true,
					scaleLabel: {
						display: false,
						labelString: 'seq'
					}
				}],
				yAxes: [{
					display: true,
					scaleLabel: {
						display: true,
					},
				}]
				}
		}
	};
	var ctx = document.getElementById("myChart").getContext("2d");
	var myLine = new Chart(ctx, config);

</script>
</body>
</html>