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
	 				"roleFormMap.roleName":{ required:true},
	 				"roleFormMap.roleCode":{ required:true },
	 				"roleFormMap.roleKey":{ required:true, rangelength:[3,15] },
	 			
	 			 },
	 			"roleName": {
	 				"roleFormMap.roleName":{ required:"请输入职位名"},
	 				"roleFormMap.roleCode":{ required:"请输入职位编号"},
	 				"roleFormMap.roleKey":{ required:"请输入roleKey", rangelength:"roleKey长度在3-15位之间"},
	 			
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

