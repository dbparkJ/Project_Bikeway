/**
 * check function
 */

function Distance_Check(){
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
	 
	if($('#date').val()==''){
	alert("날짜를 선택하세요");
	$('#date').focus();
	return false;
	} 
}//Check()-end