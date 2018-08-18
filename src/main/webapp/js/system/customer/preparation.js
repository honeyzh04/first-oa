
$(function() {
	$("form").validate({
		submitHandler : function(form) {// 必须写在验证前面，否则无法ajax提交
			ly.ajaxSubmit(form, {// 验证新增是否成功
				type : "post",
				dataType : "json",//ajaxSubmi带有文件上传的。不需要设置json
				success : function(data) {
					if (data == "success") {
						layer.confirm('报备成功!是否关闭窗口?', function(index) {
						/*	window.parent.location.reload();
							var index = parent.layer.getFrameIndex(window.name);*/
							/*parent.$("#datatable").dataTable().ajax.reload(null, false);*/
						parent.layer.close(parent.pageii);
						parent.myTable.draw(false);
						return false;
						});					
					} else {
						layer.msg('报备失败！',{
							  icon: 2,
							  time: 2000 //2秒关闭（如果不配置，默认是3秒）
							} );
					}
				}
			});
		},
	
	});
});
