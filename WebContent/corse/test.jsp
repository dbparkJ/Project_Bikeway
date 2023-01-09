<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
	<head>
	    <meta charset="utf-8">
	    <title>Drawing Library���� ������ ���</title>
	    <style>
			.map_wrap {width: 100%;position: relative;}
			.modes {position: absolute;top: 10px;left: 10px;z-index: 1;}
			.getdata{position: absolute;top: 370px;left: 10px;z-index: 1;}
			#drawingMap, #map {width: 100%;height: 350px;}
			#map {margin-top: 10px;}
		</style>
	</head>
	<body>
	<div class="map_wrap">
	    <div id="drawingMap"></div>
	    <div id="map"></div> 
	    <p class="modes">
		    <button onclick="selectOverlay('MARKER')">��Ŀ</button>
		    <button onclick="selectOverlay('POLYLINE')">��</button>
		    <button onclick="selectOverlay('CIRCLE')">��</button>
		    <button onclick="selectOverlay('RECTANGLE')">�簢��</button>
		    <button onclick="selectOverlay('POLYGON')">�ٰ���</button>
		</p>
	    <p class="getdata">
	        <button onclick="getDataFromDrawingMap()">��������</button>
	    </p>
	</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=17d6d1b98aeed31a6b874f4a6fd6d957&libraries=drawing"></script>
	<script>
		// Drawing Manager�� ������ �׸� ���� div
		var drawingMapContainer = document.getElementById('drawingMap'),
	 	   drawingMap = { 
	   	     center: new kakao.maps.LatLng(33.450701, 126.570667), // ������ �߽���ǥ
	  	      level: 3 // ������ Ȯ�� ����
	 	   };
	
		// ������ ǥ���� div��  ���� �ɼ�����  ������ �����մϴ�
	var drawingMap = new kakao.maps.Map(drawingMapContainer, drawingMap); 
	
	var options = { // Drawing Manager�� ������ �� ����� �ɼ��Դϴ�
	    map: drawingMap, // Drawing Manager�� �׸��� ��Ҹ� �׸� map ��ü�Դϴ�
	    drawingMode: [ // Drawing Manager�� ������ �׸��� ��� ����Դϴ�
	        kakao.maps.drawing.OverlayType.MARKER,
	        kakao.maps.drawing.OverlayType.POLYLINE,
	        kakao.maps.drawing.OverlayType.RECTANGLE,
	        kakao.maps.drawing.OverlayType.CIRCLE,
	        kakao.maps.drawing.OverlayType.POLYGON
	    ],
	    // ����ڿ��� ������ �׸��� ���̵� �����Դϴ�
	    // ����ڿ��� ������ �׸���, �巡���Ҷ�, �����Ҷ� ���̵� ������ ǥ���ϵ��� �����մϴ�
	    guideTooltip: ['draw', 'drag', 'edit'], 
	    markerOptions: { // ��Ŀ �ɼ��Դϴ� 
	        draggable: true, // ��Ŀ�� �׸��� ���� �巡�� �����ϰ� �մϴ� 
	        removable: true // ��Ŀ�� ���� �� �� �ֵ��� x ��ư�� ǥ�õ˴ϴ�  
	    },
	    polylineOptions: { // �� �ɼ��Դϴ�
	        draggable: true, // �׸� �� �巡�װ� �����ϵ��� �����մϴ�
	        removable: true, // �׸� �� ���� �� �� �ֵ��� x ��ư�� ǥ�õ˴ϴ�
	        editable: true, // �׸� �� ������ �� �ֵ��� �����մϴ� 
	        strokeColor: '#39f', // �� ��
	        hintStrokeStyle: 'dash', // �׸��� ���콺�� ����ٴϴ� �������� �� ��Ÿ��
	        hintStrokeOpacity: 0.5  // �׸��� ���콺�� ����ٴϴ� �������� ����
	    },
	    rectangleOptions: {
	        draggable: true,
	        removable: true,
	        editable: true,
	        strokeColor: '#39f', // �ܰ��� ��
	        fillColor: '#39f', // ä��� ��
	        fillOpacity: 0.5 // ä���� ����
	    },
	    circleOptions: {
	        draggable: true,
	        removable: true,
	        editable: true,
	        strokeColor: '#39f',
	        fillColor: '#39f',
	        fillOpacity: 0.5
	    },
	    polygonOptions: {
	        draggable: true,
	        removable: true,
	        editable: true,
	        strokeColor: '#39f',
	        fillColor: '#39f',
	        fillOpacity: 0.5,
	        hintStrokeStyle: 'dash',
	        hintStrokeOpacity: 0.5
	    }
	};
	
	// ���� �ۼ��� �ɼ����� Drawing Manager�� �����մϴ�
	var manager = new kakao.maps.drawing.DrawingManager(options);
	
	// ��ư Ŭ�� �� ȣ��Ǵ� �ڵ鷯 �Դϴ�
	function selectOverlay(type) {
	    // �׸��� ���̸� �׸��⸦ ����մϴ�
	    manager.cancel();
	
	    // Ŭ���� �׸��� ��� Ÿ���� �����մϴ�
	    manager.select(kakao.maps.drawing.OverlayType[type]);
	}
	
	// Drawing Manager���� �����͸� ������ ������ ǥ���� �Ʒ��� ���� div
	var mapContainer = document.getElementById('map'),
	    mapOptions = { 
	        center: new kakao.maps.LatLng(33.450701, 126.570667), // ������ �߽���ǥ
	        level: 3 // ������ Ȯ�� ����
	    };
	
	// ���� div�� ���� �ɼ����� ������ �����մϴ�
	var map = new kakao.maps.Map(mapContainer, mapOptions),
	    overlays = []; // ������ �׷��� ������ ���� �迭
	
	// �������� ��ư�� Ŭ���ϸ� ȣ��Ǵ� �ڵ鷯 �Լ��Դϴ�
	// Drawing Manager�� �׷��� ��ü �����͸� ������ �Ʒ� ������ ǥ���մϴ�
	function getDataFromDrawingMap() {
	    // Drawing Manager���� �׷��� ������ ������ �����ɴϴ� 
	    var data = manager.getData();
	
	    // �Ʒ� ������ �׷��� ������ �ִٸ� ��� ����ϴ�
	    removeOverlays();
	
	    // ������ ������ �����ͷ� �������� �׸��ϴ�
	    drawMarker(data[kakao.maps.drawing.OverlayType.MARKER]);
	    drawPolyline(data[kakao.maps.drawing.OverlayType.POLYLINE]);
	    drawRectangle(data[kakao.maps.drawing.OverlayType.RECTANGLE]);
	    drawCircle(data[kakao.maps.drawing.OverlayType.CIRCLE]);
	    drawPolygon(data[kakao.maps.drawing.OverlayType.POLYGON]);
	}
	
	// �Ʒ� ������ �׷��� ������ �ִٸ� ��� ����ϴ�
	function removeOverlays() {
	    var len = overlays.length, i = 0;
	
	    for (; i < len; i++) {
	        overlays[i].setMap(null);
	    }
	
	    overlays = [];
	}
	
	// Drawing Manager���� ������ ������ �� ��Ŀ�� �Ʒ� ������ ǥ���ϴ� �Լ��Դϴ�
	function drawMarker(markers) {
	    var len = markers.length, i = 0;
	
	    for (; i < len; i++) {
	        var marker = new kakao.maps.Marker({
	            map: map, 
	            position: new kakao.maps.LatLng(markers[i].y, markers[i].x), 
	            zIndex: markers[i].zIndex
	        });
	
	        overlays.push(marker);
	    }
	}
	
	// Drawing Manager���� ������ ������ �� ���� �Ʒ� ������ ǥ���ϴ� �Լ��Դϴ�
	function drawPolyline(lines) {
	    var len = lines.length, i = 0;
	
	    for (; i < len; i++) {
	        var path = pointsToPath(lines[i].points);
	        var style = lines[i].options;
	        var polyline = new kakao.maps.Polyline({
	            map: map,
	            path: path,
	            strokeColor: style.strokeColor,
	            strokeOpacity: style.strokeOpacity,
	            strokeStyle: style.strokeStyle,
	            strokeWeight: style.strokeWeight
	        });
	
	        overlays.push(polyline);
	    }
	}
	
	// Drawing Manager���� ������ ������ �� �簢���� �Ʒ� ������ ǥ���ϴ� �Լ��Դϴ�
	function drawRectangle(rects) {
	    var len = rects.length, i = 0;
	
	    for (; i < len; i++) {
	        var style = rects[i].options;
	        var rect = new kakao.maps.Rectangle({
	            map: map, 
	            bounds: new kakao.maps.LatLngBounds(
	                new kakao.maps.LatLng(rects[i].sPoint.y, rects[i].sPoint.x),
	                new kakao.maps.LatLng(rects[i].ePoint.y, rects[i].ePoint.x)
	            ), 
	            strokeColor: style.strokeColor,
	            strokeOpacity: style.strokeOpacity,
	            strokeStyle: style.strokeStyle,
	            strokeWeight: style.strokeWeight,
	            fillColor: style.fillColor,
	            fillOpacity: style.fillOpacity
	        });
	
	        overlays.push(rect);
	    }
	}
	
	// Drawing Manager���� ������ ������ �� ���� �Ʒ� ������ ǥ���ϴ� �Լ��Դϴ�
	function drawCircle(circles) {
	    var len = circles.length, i = 0;
	
	    for (; i < len; i++) {
	        var style = circles[i].options;
	        var circle = new kakao.maps.Circle({
	            map: map, 
	            center: new kakao.maps.LatLng(circles[i].center.y, circles[i].center.x), 
	            radius: circles[i].radius,
	            strokeColor: style.strokeColor,
	            strokeOpacity: style.strokeOpacity,
	            strokeStyle: style.strokeStyle,
	            strokeWeight: style.strokeWeight,
	            fillColor: style.fillColor,
	            fillOpacity: style.fillOpacity
	        });
	
	        overlays.push(circle);
	    }
	}
	
	// Drawing Manager���� ������ ������ �� �ٰ����� �Ʒ� ������ ǥ���ϴ� �Լ��Դϴ�
	function drawPolygon(polygons) {
	    var len = polygons.length, i = 0;
	
	    for (; i < len; i++) {
	        var path = pointsToPath(polygons[i].points);
	        var style = polygons[i].options;
	        var polygon = new kakao.maps.Polygon({
	            map: map,
	            path: path,
	            strokeColor: style.strokeColor,
	            strokeOpacity: style.strokeOpacity,
	            strokeStyle: style.strokeStyle,
	            strokeWeight: style.strokeWeight,
	            fillColor: style.fillColor,
	            fillOpacity: style.fillOpacity
	        });
	
	        overlays.push(polygon);
	    }
	}
	
	// Drawing Manager���� ������ ������ �� 
	// ���� �ٰ����� ������ ������ kakao.maps.LatLng��ü�� �����ϰ� �迭�� ��ȯ�ϴ� �Լ��Դϴ� 
	function pointsToPath(points) {
	    var len = points.length, 
	        path = [], 
	        i = 0;
	
	    for (; i < len; i++) { 
	        var latlng = new kakao.maps.LatLng(points[i].y, points[i].x);
	        path.push(latlng); 
	    }
	
	    return path;
	}
	</script>
	</body>
</html>