<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import = "java.util.*"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
	<script type="text/javascript" src="${ctxpath}/static/app/js/check.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<c:choose>
	<%-- �α��λ��°� �ƴҶ�  sdsdsdsdsd--%>
	<c:when test= "${empty dto.id}" >
			<script>
		 	alert("�α��� �� �̿� �����մϴ�");
			</script>
			<meta http-equiv="Refresh" content="0;url=${ctxpath}/member/loginForm.do">
	</c:when>
	
<%-- �α��λ����϶� --%>dd
	<c:otherwise>	
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
									<label for="exampleFormControlInput1" class="form-label">����Ÿ�</label>
									<div class="form-floating">
										<input type="text" id="distance" class="form-control" placeholder="km" required="required">
										<label for="floatingInputInvalid">km</label>
									</div>
								</div>
								<div class="container-md p-3">
									<label for="exampleFormControlInput1" class="form-label">����ð�</label>
									<div class="form-floating">
										<input type="text" id="distance" class="form-control" placeholder="��" required="required">
										<label for="floatingInputInvalid">��</label>
									</div>
								</div>
								
								<div class="container-md p-3">
									<label for="exampleFormControlInput1" class="form-label">��������</label>
									<input type="date" class="form-control" id="date" required="required">
								</div>
								
								<div class="d-grid gap-2 d-md-flex justify-content-md-end">
									<input class="btn btn-dark" type="submit" value="�Է�">
									<input class="btn btn-dark" type="reset" value="�ʱ�ȭ">
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
	</c:otherwise>
</c:choose>