<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="bike.*"
    import="java.util.*"
    import="org.json.simple.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String corse_name = request.getParameter("keyword");
List<Corse_MAX_MIN_DTO> corseList = null;
BikeDAO dao = BikeDAO.getDao();
corseList = dao.getCorse_max_minLatLon(corse_name);
%>

<%=corseList%>