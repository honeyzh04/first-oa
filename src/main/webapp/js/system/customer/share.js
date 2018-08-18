
$(function() {

	
	$("form").validate({
		submitHandler : function(form) {// 必须写在验证前面，否则无法ajax提交
			ly.ajaxSubmit(form, {// 验证新增是否成功
				type : "post",
				dataType : "json",//ajaxSubmi带有文件上传的。不需要设置json
				success : function(data) {
					if (data == "success") {
						layer.confirm('共享成功!是否关闭窗口?', function(index) {
						/*	window.parent.location.reload();
							var index = parent.layer.getFrameIndex(window.name);*/
							/*parent.$("#datatable").dataTable().ajax.reload(null, false);*/
						parent.layer.close(parent.pageii);
						parent.myTable.draw(false);
						return false;
						});					
					} else {
						layer.msg('客户共享失败！',{
							  icon: 2,
							  time: 2000 //2秒关闭（如果不配置，默认是3秒）
							} );
					}
				}
			});
		},
		rules : {

			"customerFormMap.user" : {
				required : true
			}
		},

		messages : {

			"customerFormMap.user" : {
				required : "请选择共享经纪人"

			}
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
