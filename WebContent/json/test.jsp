<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="bike.*"
    import="java.util.*"
    import="org.json.simple.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String corse_name = request.getParameter("keyword");
List<CorseDTO> rentBike = null;
BikeDAO dao = BikeDAO.getDao();
rentBike = dao.getRentBikeRecentInfo();
%>

<%=rentBike%>