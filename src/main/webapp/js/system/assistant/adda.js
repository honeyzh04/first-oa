
// 提交验证
$(function() {
	$("form").validate({
		submitHandler : function(form) {// 必须写在验证前面，否则无法ajax提交
			ly.ajaxSubmit(form, {// 验证新增是否成功
				type : "post",
				dataType : "json",
				success : function(data) {
					if (data == "success") {
						layer.confirm('完善成功!是否关闭窗口?', {
							icon : 6,
							title : '提示'
						}, function(index) {
							
							parent.layer.close(parent.pageii);
							parent.find();
							return false;
						});
						$("#form")[0].reset();
					} else {
						layer.alert('录入失败！', 3);
					}
				}
			});
		},
		rules : {
			
			"interlocutionFormMap.question":{required : true},

			"interlocutionFormMap.answer":{required : true},
			
		
		},
		messages : {
			
			"interlocutionFormMap.question" : {
				required : "请输入问题"
				
			},
			
			"interlocutionFormMap.answer" : {
				required : "请输入答案"
				
			},
			
		},
		errorPlacement : function(error, element) {// 自定义提示错误位置
			$(".l_err").css('display', 'block');
			// element.css('border','3px solid #FFCCCC');
			$(".l_err").html(error.html());
		},
		success : function(label) {// 验证通过后
			$(".l_err").css('display', 'none');
		}
	});
});
