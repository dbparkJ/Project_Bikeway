<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
       
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- �̰��� �׽�Ʈ �ؽ�Ʈ �Դϴ� -->
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
<body class="pt-5">
<div class="text-bg-dark p-3">
<h2 id = "title" align="center">'nickname'���� �ְ����</h2>

<table id = "table1style" cellpadding="20" width="800" height="300" align = "center">
	<tr>	
		<td>
			<font size = "+1" id="fontstyle">���̵� �ְ� ����Ÿ� �м�</font>
		</td>
	</tr>
	
	<tr>
		<td>
			<img src = "${ctxpath}/dataScience/chart.png" width="800" height="250">
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
			<img src = "${ctxpath}/dataScience/chart.png" width="800" height="250">
		</td>
	</tr>
	
	<tr>
		<td align = "center">
			<font size = "+2" id = "fontstyle">�����ϵ��� 5,632Kcal �Ҹ��ϼ̰� 566Km �����ϼ̽��ϴ�!</font>
		</td>
	</tr>

</table>
</div>
</body>
</html>