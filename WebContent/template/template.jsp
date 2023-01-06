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
				<a href="${ctxpath}/corse/corse.do">상단메뉴바</a>	 
			</div>
			<div>
				<img src="${ctxpath}/template/bike2.jpg" style="max-width: 100%; height:auto;"/>
			</div>
			<div>
				<div>
					<div style="">네이버
						<nav>
							<ul>
								<li><a href="">첫번째리스트</a></li>
								<li><a href="">첫번째리스트</a></li>
								<li><a href="">첫번째리스트</a></li>
								<li><a href="">첫번째리스트</a></li>
								<li><a href="">첫번째리스트</a></li>
							</ul>
						</nav>
					</div>
				</div>
			
				<div class="container-md">
					<%-- <jsp:include page="/module/top.jsp" flush="false"/>--%>
					<!-- content -->	
					<div class="container-md">
						<jsp:include page="${CONTENT}" flush="false"/>
					</div>
					<!-- content end-->
					<jsp:include page="/module/bottom.jsp"/>
				</div>
			</div>	
		</div>
	</body>
	<%-- 
	<script type="text/javascript" src="${ctxpath}/static/app/js/paging.js"></script>
	<script type="text/javascript" src="${ctxpath}/static/app/js/msg.js?ver=6"></script>
	<script type="text/javascript" src="${ctxpath}/static/app/js/address.js"></script>
	--%>
</html>
