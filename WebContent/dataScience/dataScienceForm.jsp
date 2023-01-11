<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    
    <script>
    //입력여부
    function Check(){
    	
    	 //주행거리입력여부
         if($('#distance').val()==''){
            alert("주행거리를 입력하세요");
            $('#distance').focus();
            return false;
         }
         
         //시간입력여부
         if($('#time').val()==''){
             alert("시간을 입력하세요");
             $('#time').focus();
             return false;
             
      } 
    		}//Check()-end
    </script>
    
<head>
<meta charset="EUC-KR">
<title>주행기록입력</title>
</head>

<body>
<div class="pt-5">
<h1 size = "+3" id = "title" align="center">기록을 입력하세요</h1>

<form name="dataScience" method="post" action="${ctxpath}/dataScience/dataScience.do" onSubmit="return Check()">
<table cellpadding = "10" align = "center" border = "1" width = "60%" height = "50%">
	<tr align = "center">
		<td colspan = "4">
			<font size = "+2">주행거리</font>
			<input type = "text" name = "distance" id = "distance" style="width:300px;height:50px;font-size:30px;">Km
		</td>
	</tr>
	
	<tr align = "center">
		<td colspan="4">
			<font size = "+2">주행시간</font>
			<input type = "text" name = "time" id ="time" placeholder = "(분)단위입력 " style="width:300px;height:50px;font-size:30px;">분
		</td>
	</tr>
	
	<tr align = "center">
			<td colspan="4" id="t1">
			<font size = "+2">날짜</font>
			<input type="date" name="date" id="date">
			</td>
	</tr>
	
	<tr>
		<td colspan = "4" align = "center">
		
		<input class="btn btn-dark" type="submit" value="입력">
		<input class="btn btn-dark" type="reset" value="초기화">
		</td>
	</tr>
</table>
</form>

</div>
</body>
</html>