<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
       
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<%-- ��Ʈ��Ʈ�� --%>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>

	
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
<body>
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