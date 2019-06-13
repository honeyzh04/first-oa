
	 $(function() {
	 	$("form").validate({
	 		submitHandler : function(form) {//必须写在验证前面，否则无法ajax提交
	 			ly.ajaxSubmit(form,{//验证新增是否成功
	 				type : "post",
	 				dataType:"json",
	 				success : function(data) {
	 					if (data=="success") {
	 						layer.confirm('充值成功!是否关闭窗口?', function(index) {
	 							parent.layer.close(parent.pageii);
	 							parent.myTable.draw(false);
					        	return false;
	 						});
	 						
	 					} else {
	 						layer.msg('充值失败！');
	 					}
	 				}
	 			});
	 		},
	 			rules: {
	 				"creditFormMap.department":{ required:true},
	 				"creditFormMap.userId":{ required:true },
	 				"creditFormMap.credit":{ required:true,  },
	 			
	 			 },
	 			"roleName": {
	 				"creditFormMap.department":{ required:"不能为空号"},
	 				"creditFormMap.userId":{ required:"不能为空号"},
	 				"creditFormMap.credit":{ required:"不能为空号"},
	 			
	 			 },
	 			
	 		errorPlacement : function(error, element) {//自定义提示错误位置
	 			$(".l_err").css('display','block');
	 			$(".l_err").html(error.html());
	 		},
	 		success: function(label) {//验证通过后
	 			$(".l_err").css('display','none');
	 		}
	 	});
	 });

