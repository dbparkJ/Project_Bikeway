<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<html>
	<head>
		<meta charset="EUC-KR">
	</head>
	<body class="bg-dark bg-gradient mx-5 pt-5">
	
		<nav class="navbar bg-light">
			<div class="pt-3">
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
		</nav>
		
		<div class="pt-4">
		
			<div class="btn-group">
				<button type="button" class="btn btn-danger dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
					코스
				</button>
				<ul class="dropdown-menu dropdown-menu-dark">
					<li><a class="dropdown-item">서울근교</a></li>
					<li><hr class="dropdown-divider"></li>
					<li>
						<c:forEach var="singleCorse" items="${singleCorseList}">
							<div class="d-grid gap-2">
								<button class="btn btn-outline-white text-white" keyword = "${singleCorse.corse_name}" onclick="PaintingLine(this.getAttribute('keyword'))" value="${singleCorse.corse_name}">${singleCorse.corse_name}</button>
							</div>	
						</c:forEach>
					</li>

				</ul>
			</div>
		
		
		
		<%-- <c:forEach var="singleCorse" items="${singleCorseList}">
			<button class="btn-primary" onclick="PaintingLine()" value="${singleCorse.corse_name}">${singleCorse.corse_name}</button>
		</c:forEach> --%>
      	<div id="map" style="width:40%;height:60%;"></div>
		</div>
	</body>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=17d6d1b98aeed31a6b874f4a6fd6d957"></script>    
	<script type="text/javascript" src="${ctxpath}/static/app/js/PaintingLine.js"></script>
	
</html>