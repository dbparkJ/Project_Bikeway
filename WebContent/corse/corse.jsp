<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body class="bg-dark bg-gradient mx-5 pt-5">
		<div class="pt-4">
			<div class="btn-group">
				<button type="button" class="btn btn-danger dropdown-toggle me-3" data-bs-toggle="dropdown" aria-expanded="false">
					코스
				</button>
				<ul class="dropdown-menu dropdown-menu-dark">
					<li><a class="dropdown-item">서울근교</a></li>
					<li><hr class="dropdown-divider"></li>
					<li>
						<c:forEach var="singleCorse" items="${singleCorseList}">
							<div class="d-grid gap-2">
								<button class="btn btn-outline-white text-white" keyword = "${singleCorse.corse_name}" onclick="PaintingLine(this.getAttribute('keyword'))">${singleCorse.corse_name}</button>
							</div>	
						</c:forEach>
					</li>
				</ul>
				<button type="button" class="btn btn-danger" onclick="RentBikeRecentInfoList()"> 따릉이지도</button>
			</div>
      	<div id="map" style="width:40%;height:60%;"></div>
		</div>
	</body>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=17d6d1b98aeed31a6b874f4a6fd6d957"></script>    
	<script type="text/javascript" src="${ctxpath}/static/app/js/paintingMap.js"></script>
	
</html>