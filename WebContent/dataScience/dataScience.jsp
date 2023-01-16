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
<body class="pt-5">

	<h1 class="text text-center py-5">${dto.nickname}님의 주간기록</h1>
	
	<div style="width:80%;" class="container-md">
	<canvas id="distanceChart"></canvas>
	</div>
	

<script>
var distanceDateList = new Array();
var distancemyData = new Array();
var distanceAvgData = new Array();
var distanceRankData = new Array();

<c:forEach var="ridingmylist" items="${ridingmylist}">
	distanceDateList.push(${ridingmylist.riding_dt});
	distancemyData.push(${ridingmylist.distance});	
</c:forEach>

<c:forEach var="ridingAvglist" items="${ridingAvglist}">
	distanceAvgData.push(${ridingAvglist.distance});	
</c:forEach>

<c:forEach var="ridingRankinglist" items="${ridingRankinglist}">
	distanceRankData.push(${ridingRankinglist.distance});	
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
				data: distanceRankData,
				fill: false,
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

<script>
var kcalDateList = new Array();
var kcalmyData = new Array();


<c:forEach var="kcalmylist" items="${kcalmylist}">
	kcalDateList.push(${kcalmylist.riding_dt});
	kcalmyData.push(${kcalmylist.calorie});	
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
			labels: kcalDateList,
			datasets: [{
				label: "10% 그래프",
				backgroundColor: window.chartColors.green,
				borderColor: window.chartColors.green,
				data: [],
				fill: false,
			},
			{
				label: "평균 그래프",
				backgroundColor: window.chartColors.purple,
				borderColor: window.chartColors.purple,
				data: [],
				fill: false,
			},
			{
				label: "나의 그래프",
				backgroundColor: window.chartColors.red,
				borderColor: window.chartColors.red,
				data: kcalmyData,
				fill: false,
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
	var ctx = document.getElementById("kcalChart").getContext("2d");
	var myLine = new Chart(ctx, config);

</script>
</body>
</html>