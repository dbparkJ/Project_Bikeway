<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<head>
<meta charset="UTF-8">
<title>데모 그래프</title>
</head>
<body>
<div style="width:800px">
    <canvas id="myChart"></canvas>
</div>

<script>
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
			labels: ['월','화','수','목','금','토','일'],
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
				data: [10,0,12,0,0,5,1],
				fill: false,
			},
			{
				label: "나의 그래프",
				backgroundColor: window.chartColors.red,
				borderColor: window.chartColors.red,
				data: [5,6,12,2,34,5,1],
				fill: false,
			}]
		},
		options: {
			responsive: true,
			title:{
				display:true,
				text:'demo 그래프'
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
/*
- Chart를 생성하면서, 
- ctx를 첫번째 argument로 넘겨주고, 
- 두번째 argument로 그림을 그릴때 필요한 요소들을 모두 넘겨줍니다. 
*/

</script>
</body>
</html>