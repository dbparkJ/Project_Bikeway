<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/header/header.jsp"%>
<%-- template.jsp --%>
<html>
<body>
Hello

<div id="map" style="width:500px;height:400px;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=17d6d1b98aeed31a6b874f4a6fd6d957"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(33.450701, 126.570667),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
	</script>

		<div class="container-md">
		<%-- <jsp:include page="/module/top.jsp" flush="false"/>--%>
		<!-- content -->	
		<div class="container-md">
			<%--<jsp:include page="${CONTENT}" flush="false"/> --%>
		</div>
		<!-- content end-->
		<jsp:include page="/module/bottom.jsp"/>
		</div>
	
</body>
<%-- 
<script type="text/javascript" src="${ctxpath}/static/app/js/paging.js"></script>
<script type="text/javascript" src="${ctxpath}/static/app/js/msg.js?ver=6"></script>
<script type="text/javascript" src="${ctxpath}/static/app/js/address.js"></script>
--%>
</html>
