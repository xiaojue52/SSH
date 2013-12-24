var Control = {};
Control.getTotalScore = function(){
	$.ajax({
		type:"post",
		url:"getTotalScore.action",
		data:"",
		dataType:"text",
		success:function(returnData){
			alert(returnData);
		},
		error:function(){
			
		}
	});
};
Control.getCustomizeHqlData = function(){
	$.ajax({
		type:"post",
		url:"getCostomizeHqlData.action",
		data:"",
		dataType:"text",
		success:function(returnData){
			alert(returnData);
		},
		error:function(){
			
		}
	});
};