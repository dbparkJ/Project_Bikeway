<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.*"%>


<body class="mx-5 pt-5">
	<div class="container overflow-hidden pt-5">
		<div class="row gx-5">
			<div class="col">
				<div class="p-3 border bg-light">Custom column padding</div>
			</div>
			<div class="col">
				<div class="bg-light border" style="width: 500px;">
					<form name="dataScience" method="post" action="${ctxpath}/dataScience/dataScience.do">
						<div class="container-md p-3">
							<label for="exampleFormControlInput1" class="form-label">주행거리</label>
							<div class="form-floating">
								<input type="text" id="distance" class="form-control" placeholder="km" required="required">
								<label for="floatingInputInvalid">km</label>
							</div>
						</div>
						<div class="container-md p-3">
							<label for="exampleFormControlInput1" class="form-label">주행시간</label>
							<div class="form-floating">
								<input type="text" id="distance" class="form-control" placeholder="분" required="required">
								<label for="floatingInputInvalid">분</label>
							</div>
						</div>
						
						<div class="container-md p-3">
							<label for="exampleFormControlInput1" class="form-label">주행일자</label>
							<input type="date" class="form-control" id="date" required="required">
						</div>
						
						<div class="d-grid gap-2 d-md-flex justify-content-md-end">
							<input class="btn btn-dark" type="submit" value="입력">
							<input class="btn btn-dark" type="reset" value="초기화">
						</div>
					</form>
				</div>
			</div>
			<div class="col">
				<div class="p-3 border bg-light">Custom column padding</div>
			</div>
		</div>
	</div>
</body>