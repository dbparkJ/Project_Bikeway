<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="bike.*"
    import="java.util.*"
    import="org.json.simple.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String corse_name = request.getParameter("keyword");
List<CorseDTO> corseList = null;
BikeDAO dao = BikeDAO.getDao();
corseList = dao.getCorseLatLon(corse_name);
%>
<%=corseList%>