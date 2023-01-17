<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxpath" value="<%=request.getContextPath()%>" />

<body class="mx-5 py-5">
	<div class="text display-4 text-center pt-5">${dto.nickname} 님의</div>
	<h1 class="text text-center pb-5"> 라이딩 기록을 입력해주세요</h1>
			<div class="container-md bg-light border pt-5" style="width: 50%;">
				<form name="dataScience" method="post" action="${ctxpath}/dataScience/dataScience.do">
					<div class="container-md p-3">
						<label for="exampleFormControlInput1" class="form-label">주행거리</label>
						<div class="form-floating">
							<input type="text" name="distance" id="distance" class="form-control" placeholder="km" required="required">
							<label for="floatingInputInvalid">Km</label>
						</div>
					</div>
					<div class="container-md p-3">
						<label for="exampleFormControlInput1" class="form-label">주행시간</label>
						<div class="form-floating">
							<input type="text" name="riding_time" id="riding_time" class="form-control" placeholder="분" required="required">
							<label for="floatingInputInvalid">분</label>
						</div>
					</div>
					
					<div class="container-md p-3">
						<label for="exampleFormControlInput1" class="form-label">주행일자</label>
						<input type="date" name="riding_dt" class="form-control" id="riding_dt" required="required">
					</div>
					
					<div class="d-grid gap-2 d-md-flex justify-content-md-end">
						<input class="btn btn-dark" type="submit" value="입력">
						<input class="btn btn-dark" type="reset" value="초기화">
					</div>
				</form>
			</div>
</body>