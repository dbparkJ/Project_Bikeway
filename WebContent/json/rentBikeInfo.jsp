<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="bike.*"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String rentBikeRecentInfo = request.getParameter("bikeInfo");
List<RentBikeInfoDTO> rentBikeRecentInfoList = null;
BikeDAO dao = BikeDAO.getDao();
rentBikeRecentInfoList = dao.getRentBikeRecentInfo();
%>
<%=rentBikeRecentInfoList %>