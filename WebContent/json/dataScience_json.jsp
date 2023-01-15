<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="riding.*"
    import="java.util.*"
    import="org.json.simple.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
List<RidingDTO> ridinglist = null;
RidingDAO dao = RidingDAO.getDao();

String riding_dt = request.getParameter("riding_dt");

ridinglist =dao.getRidingList(riding_dt);
%>

<%= ridinglist%>