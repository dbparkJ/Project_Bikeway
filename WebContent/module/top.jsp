<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxpath" value="<%=request.getContextPath()%>" />

<div class="modal fade" id="exampleModal" tabindex="0" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered modal-dialog-scrollable pt-1">
		<div class="modal-content">
			<div class="modal-header bg-dark">
				<h1 class="modal-title text-white fs-5" id="exampleModalLabel">로그인</h1>
				<button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body bg-light pt-3">
				<div class="container w-90">
					<form method="post" action="${ctxpath}/member/loginPro.do">
						<div class="form-group pt-2">
							<label for="floatingInputInvalid">이메일 주소</label>
							<div class="form-floating mb-3">
								<input type="email" name="email" id="email" class="form-control" placeholder="name@example.com" required="required">
								<label for="floatingInputInvalid">name@example.com</label>
							</div>
						</div>
						<div class="form-group pt-2">
							<label for="inputPassword">비밀번호</label>
							<div class="form-floating mb-3">
								<input type="password" name="pw" id="pw" class="form-control" placeholder="Password" required="required">
								<label for="inputPassword">Password</label>
							</div>
						</div>
						<div class="d-grid gap-2 d-md-flex justify-content-md-end pt-3">
							<button class="btn btn-secondary" type="submit">로그인</button>
							<button type="button" class="btn btn-primary fs-6" onclick="location.href='${ctxpath}/member/inputForm.do'">회원가입</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
  <div class="container-fluid">
    <a class="navbar-brand fs-3 mx-5" href="${ctxpath}/main/viewMain.do">BIKEWAY</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDarkDropdown" aria-controls="navbarNavDarkDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
      <ul class="navbar-nav">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle mx-3" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            메뉴1
          </a>
          <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
            <li><a class="dropdown-item" href="${ctxpath}/corse/corse.do">추천코스</a></li>
            <li><a class="dropdown-item" href="${ctxpath}/member/inputForm.do">회원가입</a></li>
            <li><a class="dropdown-item" href="${ctxpath}/member/loginFrom.do">로그인</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle mx-3" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            메뉴2
          </a>
          <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
            <li><a class="dropdown-item" href="${ctxpath}/dataScience/dataScienceForm.do">데이터사이언스</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle mx-3" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            메뉴3
          </a>
          <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
      </ul>
    </div>
    <div>
	    <button type="button" class="btn btn-Dark mx-2" data-bs-toggle="modal" data-bs-target="#exampleModal">
	  	로그인
		</button>
    </div>
    <div>
	    <button type="button" class="btn btn-Dark mx-2">
	  	회원가입
		</button>
	</div>
  </div>
</nav>