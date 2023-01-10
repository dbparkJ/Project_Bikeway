/**
 * 자전거 코스를 그림
 */

 // 지도를 표시할 div 
var mapContainer = document.getElementById('map'), 
mapOption = { 
	        center: new kakao.maps.LatLng(37.57593830595383, 126.81177519319424), // 지도의 중심좌표
	        level: 9 // 지도의 확대 레벨
	    };  
	    
// 지도를 생성합니다

var polyline = null;
var path = [];
var map = new kakao.maps.Map(mapContainer, mapOption);
function PaintingLine(keyword){
		$.ajax({
		type : "GET",
        url:"../json/corseDatabase_json.jsp?keyword="+keyword,
        dataType:"JSON",/*서버로부터 받는 자료형*/
        success: function(data){
			removemap(polyline);
        	for(var i=0; i<data.length; i++){
        		path.push(new kakao.maps.LatLng(data[i].lat,data[i].lon))
        	}
			// 지도에 표시할 선을 생성합니다
			polyline = 		new kakao.maps.Polyline({
							    path: path, // 선을 구성하는 좌표배열 입니다
							    strokeWeight: 5, // 선의 두께 입니다
							    strokeColor: 'red', // 선의 색깔입니다
							    strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
							    strokeStyle: 'solid', // 선의 스타일입니다
							    endArrow : true
							});

			// 지도에 선을 표시합니다 
			polyline.setMap(map);
        }
     });//$.ajax()
}

function removemap(polyline){
	if(polyline !=null){
		
	polyline.setMap(null);
	polyline=null;
	path = [];
	
	
	}
}