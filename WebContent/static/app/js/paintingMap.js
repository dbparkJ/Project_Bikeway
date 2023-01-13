/*
 *    지도,그래프를 그리기
 */

var mapContainer = document.getElementById('map'), 
mapOption = { 
	        center: new kakao.maps.LatLng(37.57593830595383, 126.81177519319424), // 지도의 중심좌표
	        level: 9 // 지도의 확대 레벨
	    };  
	    
var map = new kakao.maps.Map(mapContainer, mapOption);

var polyline = null;
var path = []; /*위경도를 그리기위한 전역변수*/
var elevList = []; /*고도 그래프를 그리기위한 전역변수*/
var points = [];
var bounds = new kakao.maps.LatLngBounds();


/**
 *  따릉이 API 최신정보
 */
function RentBikeRecentInfoList(){
	$.ajax({
		type : "GET",
		url : "../json/rentBikeInfo_json.jsp",
		dataType : "JSON",
		success : function(data){
			for(var i=0; i<data.length; i++){
			console.log(data[i])
			}
		}
	})
}// function-end

function PaintingLine(keyword){
		$.ajax({
		type : "GET",
        url:"../json/corseDatabase_json.jsp?keyword="+keyword,
        dataType:"JSON",
        success: function(data){
					removemap(polyline);
					removegraph(elevList);
		        	drawingLine(data);
					var marker;
					for (i = 0; i < points.length; i++) {
						// 배열의 좌표들이 잘 보이게 마커를 지도에 추가합니다
						marker =     new kakao.maps.Marker({ position : path[i] });
						marker.setMap(map);
						
						// LatLngBounds 객체에 좌표를 추가합니다
						bounds.extend(path[i]);
					}
					
					polyline.setMap(map);
					creatgraph(data);
	        		}
     	});//$.ajax()
}

function setBounds() {
	// LatLngBounds 객체에 추가된 좌표들을 기준으로 지도의 범위를 재설정합니다
	// 이때 지도의 중심좌표와 레벨이 변경될 수 있습니다
	map.setBounds(bounds);
}

function drawingLine(data){
	for(var i=0; i<data.length; i++){
    		path.push(new kakao.maps.LatLng(data[i].lat,data[i].lon))
	}
	polyline = 	new kakao.maps.Polyline({
				    path: path, // 선을 구성하는 좌표배열 입니다
				    strokeWeight: 5, // 선의 두께 입니다
				    strokeColor: 'red', // 선의 색깔입니다
				    strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
				    strokeStyle: 'solid', // 선의 스타일입니다
				    endArrow : true
				});
}

let myLine;//전역변수로 선언
function creatgraph(data){
	elevList=[];
	if (myLine != undefined){//이미 있으면 myLine 삭제
		myLine.destroy();
	}
	for(var i=0; i<data.length; i++){
		elevList.push(data[i].elev)
	}
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
		type: 'line',
		data: {
			labels: elevList,
			datasets: [{
				label: "고도",
				backgroundColor: window.chartColors.red,
				borderColor: window.chartColors.red,
				data: elevList,
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
				point:{radius:1}
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
}

function removemap(polyline){
	if(polyline != null){
		polyline.setMap(null);
		polyline=null;
		path = [];
	}
}

function removegraph(elevList){
	if(elevList != null){
		elevList =[];
			}
}