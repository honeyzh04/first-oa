//自定义验证 ，单独验证某一个input  class="checkpass"
// 提交验证
$(function() {
	$("form").validate({
		submitHandler : function(form) {// 必须写在验证前面，否则无法ajax提交
			ly.ajaxSubmit(form, {// 验证新增是否成功
				type : "post",
				dataType : "json",
				success : function(data) {
					if (data == "success") {
						layer.confirm('添加成功!是否关闭窗口?', {
							icon : 6,
							title : '提示'
						}, function(index) {

                            parent.layer.close(parent.pageii);
                            parent.myTable.draw(false);
                            console.log("12")
							return false;
						});

					} else {
						layer.alert('添加失败！', 3);
					}
				}
			});
		},
		rules : {
			
			"teamAwardFormMap.customers":{
				required : true,
				number : true},


		},
		messages : {
			
			"teamAwardFormMap.customers" : {
				required : "请输入奖励客户组数",
                number : "请输入合法的数字",
				
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
