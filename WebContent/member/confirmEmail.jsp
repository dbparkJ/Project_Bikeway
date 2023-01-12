<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.*"
    %>

<%--confirmEmail.jsp --%>

<%
String email=request.getParameter("email1");//ajax에서 넘겨준 email
MemberDAO dao=MemberDAO.getDao();
int x=dao.confirmEmail(email);//dao메서드 호출
%>
{
"x":<%=x%>
}
