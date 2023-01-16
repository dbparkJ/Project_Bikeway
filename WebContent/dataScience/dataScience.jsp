<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>

<meta charset="UTF-8">
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
	<%-- 시간 --%>
	<script src="https://cdn.jsdelivr.net/npm/chartjs-adapter-date-fns/dist/chartjs-adapter-date-fns.bundle.min.js"></script>

</head>
<body class="pt-5">

<h2 class="text text-center pt-5">${dto.nickname}님의 주간기록</h2>
<table width="800" height="300" align = "center">
	<tr>
		<td>
			<div style="width:800px">
			<canvas id="distanceChart"></canvas>
			</div>
		</td>
	</tr>

	<tr>
		<td>
			<div style="width:800px">
				<canvas id="kcalChart"></canvas>
			</div>
		</td>
	</tr>
</table>

<%-- 주행거리분석차트 --%>
<script>
var distanceDate = new Array();

var distancemyData = new Array();
var distanceAvgData = new Array();
var distanceRankData = new Array();

<c:forEach var="ridingmylist" items="${ridingmylist}">
	distanceDate.push(${ridingmylist.riding_dt});
	distancemyData.push(${ridingmylist.distance});	
</c:forEach>

<c:forEach var="ridingAvglist" items="${ridingAvglist}">
	distanceAvgData.push(${ridingAvglist.distance});	
</c:forEach>

<c:forEach var="ridingRankinglist" items="${ridingRankinglist}">
	distanceRankData.push(${ridingRankinglist.distance});	
</c:forEach>


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
			labels: ['월','화','수','목','금','토','일'],
			datasets: [{
				label: "10% 그래프",
				backgroundColor: window.chartColors.green,
				borderColor: window.chartColors.green,
				data: distanceRankData,
				fill: false,
				type:'line',
	            tension: 0.01,
			},
			{
				label: "평균 그래프",
				backgroundColor: window.chartColors.purple,
				borderColor: window.chartColors.purple,
				data: distanceAvgData,
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
	var ctx = document.getElementById("distanceChart").getContext("2d");
	var myLine = new Chart(ctx, config);

</script>


<%-- 칼로리분석차트 --%>
<script>
var kcalmyData = new Array();

<c:forEach var="caloriemylist" items="${caloriemylist}">
	kcalmyData.push(${caloriemylist.calorie});	
</c:forEach>

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
			labels: ['월','화','수','목','금','토','일'],
			datasets: [{
				label: "Kcal",
				backgroundColor: window.chartColors.green,
				borderColor: window.chartColors.green,
				data: kcalmyData,
				fill: false,
				type:'line',
	            tension: 0.01,
			}]
		},
		options: {
			responsive: true,
			title:{
				display:true,
				text:'일주일 라이딩 Kcal 분석 그래프'
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
						labelString: 'seq',
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
	var ctx = document.getElementById("kcalChart").getContext("2d");
	var myLine = new Chart(ctx, config);

</script>
</body>
</html>