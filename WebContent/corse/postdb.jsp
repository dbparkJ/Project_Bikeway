<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="corse.*"
    import="java.util.*"
    import="org.json.simple.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
List<CorseDTO> corseList = null;
CorseDAO dao = CorseDAO.getDao();
corseList = dao.getAllCorseList();
%>
{"corseList" : <%=corseList %>,}