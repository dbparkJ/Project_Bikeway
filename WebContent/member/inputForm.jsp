<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxpath" value="<%=request.getContextPath() %>" />   

<html>
	<body class="pt-5">
		<div class="pt-3">
		<h2>회원가입</h2>
		</div>
		<form name="inputForm" method="post" action="${ctxpath}/member/inputPro.do" onsubmit="return check2()" >
				<table border="1" align="center">
					<tr>
						<td>이메일</td>
						<td>
							<input type="email" name="email" id="email" size="30" placeholder="이메일입력" required="required">
							<input class="btn btn-outline-dark" type="button" value="email중복체크" onClick="emailCheck()">                
							<input type="hidden" name="emailck" id="emailck" value="false">                
						</td>
					</tr>
					<tr>
						<td>PW</td>
						<td>
							<input type="password" name="password" id="password" size="12" required="required">
						</td>
					</tr>
					<tr>
						<td>PW확인</td>
						<td>
							<input type="password" name="password2" id="password2" size="12" required="required">
						</td>
					</tr>
					<tr>
						<td>이름</td>
						<td>
							<input type="text" name="name" id="name" size="30" placeholder="이름입력" required="required">
						</td>
					</tr>
					<tr>
						<td>닉네임</td>
						<td>
							<input type="text" name="nickname" id="nickname" size="12" required="required">
							<input type="hidden" name="nicknameck" id="nicknameck" value="false" >
						</td>
					</tr>
					<tr>
						<td>우편번호</td>
						<td>
							<input type="text" name="zipcode" id="zipcode" size="7">
							<input class="btn btn-outline-dark" type="button" value="주소찾기" onClick="findAddr()">
						</td>
					</tr>
					<tr>
						<td>주소</td>
						<td><input type="text" name="address" id="address" size="50" required="required"></td>
					</tr>  
					<tr>
						<td>몸무게</td>
						<td><input type="text" name="weight" id="weight" size="7" required="required"></td>
					</tr>               
					<tr>
						<td colspan="2" align="center">
							<input class="btn btn-outline-dark" type="submit" value="회원가입" >
							<input class="btn btn-outline-dark" type="reset" value="다시입력">
							<input class="btn btn-outline-dark" type="button" value="취소" onClick="location='${ctxpath}/main/viewMain.do'">
						</td>
					</tr>
				</table>
		</form>
	</body>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript" src="${ctxpath}/static/app/js/check.js"></script>
</html>