var myTable = null;
var pageii = null;



function interlocutionaddLayer (_this){
	
	var id = $(_this).attr("value");
	
	//加载层
 	//var index = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
	//iframe层-禁滚动条
 	 pageii=layer.open({
		title : "完善问题库",
		type : 2,
		area : [ "600px", "430px" ],
		content : [ '../interlocution/addaUI.shtml?id=' + id]
	});
	//关闭加载效果
 	window.location.reload();
 	alert("dsaasd");

}


function interlocutioneditLayer (_this){
	var id = $(_this).attr("value");
	
	//加载层
 	var index = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
	//iframe层-禁滚动条
 	 pageii=layer.open({
		title : "修改答案",
		type : 2,
		area : [ "600px", "430px" ],
		content : [ '../interlocution/etidUI.shtml?aId=' + id]
	});
	//关闭加载效果
 	
	layer.close(index);
}
function interlocutiondeleLayer (_this){
	var id = $(_this).attr("value");
	
	layer.confirm('是否删除？', function(index) {

		$.ajax({
			"url" : '../interlocution/deleteEntity.shtml?aId=' + id,

			"type" : "GET",
			"datatype" : "json",
			"success" : function(s) {

				layer.msg('删除成功', {
					icon : 1,
					time : 1000
				// 2秒关闭（如果不配置，默认是3秒）
				});
				parent.find();
			},
			error : function(er) {
				layer.msg('删除失败');
			}

		});
		layer.close(index);
		
	});
	
	
}
