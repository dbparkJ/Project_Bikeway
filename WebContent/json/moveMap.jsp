<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="bike.*"
    import="java.util.*"
    import="org.json.simple.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String mapName = request.getParameter("keyword");
List<Corse_MAX_MIN_DTO> corseMaxMinList = null;
BikeDAO dao = BikeDAO.getDao();
corseMaxMinList = dao.getCorse_max_minLatLon(mapName);
%>

<%=corseMaxMinList%>