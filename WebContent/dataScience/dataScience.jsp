<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import = "riding.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctxpath" value="<%=request.getContextPath() %>" />			

<html>
<head>
	<script>
	
	var tmpDate = new Date();
	 $("#distanceChart").attr("src", "${ctxpath}/img/chart.png?"+tmeDate.getTime());
	///img/shirt.jpg �ڿ� �ǹ̾��� ���ڰ� �ٰ� �Ǵµ�, �̹��� ���� �� �Ź� getTime( )�� �ٸ� ���ڰ� �ٰԵȴ�.
	//�̷��� �Ǹ� �������� ���ο� ���Ϸ� ����Ȱ����� �ν��Ͽ� �̹����� ����ȴ�.
	</script>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<%-- ��Ʈ��Ʈ�� --%>

	
	<style>
		<%--
		#title{
		font-family: ���� �߳�ü OTF;
		}
		#fontstyle{
		font-family: ���� �߳�ü OTF;
		}
		--%>
		
		#table1st
		border:2px solid #BDBDBD;
		}
	</style>

</head>
<body class="pt-5" >

	<tr>	
	<br>
	<%
	RidingDTO ridingDTO=new RidingDTO();
	RidingDAO ridingDAO=RidingDAO.getDao();
	%>
	
<h2 id = "title" align="center">'nickname'���� �ְ����</h2>

<table id = "table1style" cellpadding="20" width="800" height="300" align = "center">
	
		<td>
			<font size = "+1" id="fontstyle">���̵� �ְ� ����Ÿ� �м�</font>
		</td>
	</tr>
	
	<tr>
		<td> 
			<div id="image_container">
				<img id="distanceChart" src = "chart.png" width="600" height="250" alt="distance_chart"/>
			</div>
		</td>
	</tr>
	
</table>
<table></table>
<table id = "table1style" cellpadding="20" width="800" height="300" align = "center">
	
	<tr>	
		<td>
			<font size = "+1" id="fontstyle">���̵� �ְ� Kcal �м�</font>
		</td>
	</tr>
	
	<tr>
		<td>
			<div id="image_container">	
				<img src = "image_graph.png" width="600" height="250">
			</div>
		</td>
	</tr>

	<tr>
		<td align = "center">
			<font size = "+2" id = "fontstyle">�����ϵ��� 5,632Kcal �Ҹ��ϼ̰� 566Km �����ϼ̽��ϴ�!</font>
		</td>
	</tr>

</table>
</body>
</html>