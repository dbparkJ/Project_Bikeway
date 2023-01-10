<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/header/header.jsp"%>
<%-- template.jsp --%>
<html>
	<body>
		<div>
			<div>
				<!-- 상단바 -->	
				<jsp:include page="/module/top.jsp" flush="false"/>
				<!-- 메인이미지 -->	
				<jsp:include page="${CONTENT}" flush="false"/>
				<!-- 하단바 -->	
				<jsp:include page="/module/bottom.jsp" flush="false"/>
			</div>	
		</div>
	</body>
	
	
	
	<%-- 
	<script type="text/javascript" src="${ctxpath}/static/app/js/paging.js"></script>
	<script type="text/javascript" src="${ctxpath}/static/app/js/msg.js?ver=6"></script>
	<script type="text/javascript" src="${ctxpath}/static/app/js/address.js"></script>
	--%>
</html>
