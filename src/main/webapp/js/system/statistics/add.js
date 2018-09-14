	//单独验证某一个input  class="checkpass"

	 jQuery.validator.addMethod("roleKey", function(value, element) {
		 var chrnum = /^([a-zA-Z0-9]+)$/;
		  return this.optional(element) || (chrnum.test(value));
		  }, "只能输入数字和字母");
	 jQuery.validator.addMethod("roleCode", function(value, element) {
		 var chrnum = /^([0-9]+)$/;
		  return this.optional(element) || (chrnum.test(value));
		  }, "只能输入数字");
	 $(function() {
	 	$("form").validate({
	 		submitHandler : function(form) {//必须写在验证前面，否则无法ajax提交
	 			ly.ajaxSubmit(form,{//验证新增是否成功
	 				type : "post",
	 				dataType:"json",
	 				success : function(data) {
	 					if (data=="success") {
	 						layer.confirm('添加成功!是否关闭窗口?', function(index) {
	 							parent.layer.close(parent.pageii);
	 							parent.myTable.draw(false);
					        	return false;
	 						});
	 						
	 					} else {
	 						layer.msg('添加失败！');
	 					}
	 				}
	 			});
	 		},
	 		
	 			rules: {
	 				"statisticsFormMap.baidu_price":{ required:true,number : true},
	 				"statisticsFormMap.baidu_click":{ required:true ,number : true},
	 				"statisticsFormMap.sougou_price":{ required:true,number : true },
                    "statisticsFormMap.sougou_click":{ required:true ,number : true},
                    "statisticsFormMap.shenma_price":{ required:true ,number : true},
                    "statisticsFormMap.shenma_click":{ required:true,number : true },
	 			
	 			 },
	 			"roleName": {
	 				"statisticsFormMap.baidu_price":{ required:"请输入百度推广价格",number : "请输入合法的数字"},
	 				"statisticsFormMap.baidu_click":{ required:"请输入百度推广点击",number : "请输入合法的数字"},
	 				"statisticsFormMap.sougou_price":{ required:"请输入搜狗推广价格",number : "请输入合法的数字"},
                    "statisticsFormMap.sougou_click":{ required:"请输入搜狗推广点击",number : "请输入合法的数字"},
                    "statisticsFormMap.shenma_price":{ required:"请输入神马推广价格",number : "请输入合法的数字"},
                    "statisticsFormMap.shenma_click":{ required:"请输入神马推广点击",number : "请输入合法的数字"},
	 			
	 			 },
	 			
	 		errorPlacement : function(error, element) {//自定义提示错误位置
	 			$(".l_err").css('display','block');
	 			//element.css('border','3px solid #FFCCCC');
	 			$(".l_err").html(error.html());
	 		},
	 		success: function(label) {//验证通过后
	 			$(".l_err").css('display','none');
	 		}
	 	});
	 });

