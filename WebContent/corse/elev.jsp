<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "bike.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	BikeDAO corseDAO = BikeDAO.getDao();
	%>
	
<h2> 안녕 </h2>

<c:set var="list" value="<%=corseDAO.getCorseElev()%>"/>

<script>
	
var dto = '[[${list}]]'

var data=[];


</script>

<c:forEach var="dto" items="${list}">
	<script>
		data.push('${dto.elev}');
	</script>
</c:forEach>

<div style="width:800px">
    <canvas id="myChart"></canvas>
</div>

<script>
window.chartColors = {
		  red: 'rgb(255, 99, 132)',
		  orange: 'rgb(255, 159, 64)',
		  yellow: 'rgb(255, 205, 86)',
		  green: 'rgb(75, 192, 192)',
		  blue: 'rgb(54, 162, 235)',
		  purple: 'rgb(153, 102, 255)',
		  grey: 'rgb(231,233,237)'
		};


		var config = {
		  type: 'line',
		  data: {
		    labels: data,
		    datasets: [{
		      label: "고도",
		      backgroundColor: window.chartColors.red,
		      borderColor: window.chartColors.red,
		      data: data,
		      fill: false,
		    }]
		  },
		  options: {
		    responsive: true,
		    title:{
		      display:true,
		      text:'고도 그래프'
		    },
		    tooltips: {
		      mode: 'index',
		      intersect: false,
		    },
		    elements:{
		    	point:{radius:0.1}
		    },
		   hover: {
		      mode: 'X',
		      intersect: true
		    },
		    scales: {
		      xAxes: [{
		        display: false,
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