<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<head>
	<script type="text/javascript" src="${ctxpath}/static/app/js/check.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>

<body class="pt-5">
	<div class="pt-5">
		<p class="text-center fs-2">기록을 입력하세요</p>
		<form name="dataScience" method="post" action="${ctxpath}/dataScience/dataScience.do" onSubmit="return Distance_Check()">
			<div class="container bg-light" style="width: 30%;">
				<div class="container-md p-3">
					<label for="exampleFormControlInput1" class="form-label">주행거리</label>
					<input type="text" class="form-control" id="distance" placeholder="km">
				</div>
				<div class="container-md p-3">
					<label for="exampleFormControlInput1" class="form-label">주행시간</label>
					<input type="email" class="form-control" id="time" placeholder="분">
				</div>
				<div class="container-md p-3">
					<label for="exampleFormControlInput1" class="form-label">주행시간</label>
					<input type="date" class="form-control" id="date">
				</div>
				<div class="d-grid gap-2 d-md-flex justify-content-md-end">
				<input class="btn btn-dark" type="submit" value="입력">
				<input class="btn btn-dark" type="reset" value="초기화">
				</div>
			</div>
		</form>
	</div>
</body>