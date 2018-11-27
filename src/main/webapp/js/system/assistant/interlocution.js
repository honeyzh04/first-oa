
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

function ordered(){

    //加载层
    var index = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
    //iframe层-禁滚动条
    layer.open({
        title : "预约客户",
        resize : false,
        type : 2,
        area : ["60%","70%"],
        content: ['./customer/orderedCustomer.shtml']
    });
    //关闭加载效果
    layer.close(index);
}
function awardCustomer(){

    //加载层
    var index = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
    //iframe层-禁滚动条
    layer.open({
        title : "奖励客户",
        resize : false,
        type : 2,
        area : ["60%","70%"],
        content: ['./temaaward/awardCustomer.shtml']
    });
    //关闭加载效果
    layer.close(index);
}


