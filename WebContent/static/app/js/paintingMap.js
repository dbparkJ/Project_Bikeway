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
var lating =[]; /* 마커의 위경도*/
var title =[]; /*마커의 이름*/
var markers = [];
/*마커 이미지주소*/
var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 

/**
 *  따릉이 API 최신정보
 */
function RentBikeRecentInfoList(){
	$.ajax({
		type : "GET",
		url : "../json/rentBikeInfo_json.jsp",
		dataType : "JSON",
		success : function(data){
			drwaingMarker(data)
		}
	})
}// function-end


function drwaingMarker(data){
	var lating=[];

	for(var i=0; i<data.length; i++){
			lating.push(new kakao.maps.LatLng(data[i].latlonList.lat,data[i].latlonList.lon))
	}
			
	for (var i = 0; i < data.length; i ++) {
    
    // 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(24, 35); 
    
    // 마커 이미지를 생성합니다    
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
    
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: lating[i], // 마커를 표시할 위치
        title : data[i].stationName, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image : markerImage // 마커 이미지 
    	});
    
    markers.push(marker)
	}
}

function PaintingLine(keyword){
		$.ajax({
		type : "GET",
        url:"../json/corseDatabase_json.jsp?keyword="+keyword,
        dataType:"JSON",
        success: function(data){
					removemap(polyline);
					removegraph(elevList);
		        	drawingLine(data);
					polyline.setMap(map);
					creatgraph(data);
	        		}
     	});//$.ajax()
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

function infoWindow(){
var iwContent = '<div style="padding:5px;">Hello World!</div>'; // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
var iwPosition = new kakao.maps.LatLng(33.450701, 126.570667); //인포윈도우 표시 위치입니다
var iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다
}








function corseInfowindow(){
	kakao.maps.event.addListener(polyline, 'click', function(mouseEvent) {  
    var latlng = mouseEvent.latLng;
    console.log(latlng.toString());         
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