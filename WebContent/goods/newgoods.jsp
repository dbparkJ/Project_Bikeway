<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
</head>
<body class="mx-5 pt-5">
	<div class="pb-5">
		<div class="container-md pt-5">
			<div class="pb-5">
				<div class="text-center py-3">
					<h1 class="dispaly-4"><신규 자전거 리스트></h1>
				</div>
				<div class="row row-cols-1 row-cols-md-4 g-5 bg-light">
				
					<c:forEach var="goods" items="${goodslist}">
						<div class="col">
							<div class="card h-100">
								<img src="${goods.img}" class="card-img border" alt="...">
								<div class="card-body">
									<p class="card-title fs-4">${goods.name}</p>
								</div>
								<div class="text-end ">
									<p class="card-text fs-5">${goods.price}원</p>
								</div>
								<div class="card-footer text-end">
									<a class="text-muted fs-6" href="${goods.link}">구매하러 가기</a>
								</div>
							</div>
						</div>
					</c:forEach>
					
					
					
				</div>
			</div>
		</div>
	</div>

		
</body>
</html>