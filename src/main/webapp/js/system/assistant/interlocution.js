
function interlocutionLayer(){
	
	//加载层
 	var index = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
	//iframe层-禁滚动条
	layer.open({
	    type: 2,
	    title:'销售百问',
	    area: ['700px', '600px'],
	    skin: 'layui-layer-rim', //加上边框
	    content: ['./interlocution/list.shtml']
	});
	//关闭加载效果
	layer.close(index);
}



