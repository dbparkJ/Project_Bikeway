<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    
    <script>
    //�Է¿���
    function Check(){
    	
    	 //����Ÿ��Է¿���
         if($('#distance').val()==''){
            alert("����Ÿ��� �Է��ϼ���");
            $('#distance').focus();
            return false;
         }
         
         //�ð��Է¿���
         if($('#time').val()==''){
             alert("�ð��� �Է��ϼ���");
             $('#time').focus();
             return false;
             
      } 
    		}//Check()-end
    </script>
    
<head>
<meta charset="EUC-KR">
<title>�������Է�</title>
</head>

<body>
<div class="pt-5">
<h1 size = "+3" id = "title" align="center">����� �Է��ϼ���</h1>

<form name="dataScience" method="post" action="${ctxpath}/dataScience/dataScience.do" onSubmit="return Check()">
<table cellpadding = "10" align = "center" border = "1" width = "60%" height = "50%">
	<tr align = "center">
		<td colspan = "4">
			<font size = "+2">����Ÿ�</font>
			<input type = "text" name = "distance" id = "distance" style="width:300px;height:50px;font-size:30px;">Km
		</td>
	</tr>
	
	<tr align = "center">
		<td colspan="4">
			<font size = "+2">����ð�</font>
			<input type = "text" name = "time" id ="time" placeholder = "(��)�����Է� " style="width:300px;height:50px;font-size:30px;">��
		</td>
	</tr>
	
	<tr align = "center">
			<td colspan="4" id="t1">
			<font size = "+2">��¥</font>
			<input type="date" name="date" id="date">
			</td>
	</tr>
	
	<tr>
		<td colspan = "4" align = "center">
		
		<input class="btn btn-dark" type="submit" value="�Է�">
		<input class="btn btn-dark" type="reset" value="�ʱ�ȭ">
		</td>
	</tr>
</table>
</form>

</div>
</body>
</html>