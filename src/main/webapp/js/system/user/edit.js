//手机号码验证
jQuery.validator.addMethod("telephone", function(value, element) {
	 var length = value.length;
	 var mobile = /^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/
	 return this.optional(element) || (length == 11 && mobile.test(value));
	 }, "手机号码格式错误");
// 提交验证
$(function() {
	$("form").validate({
		submitHandler : function(form) {// 必须写在验证前面，否则无法ajax提交
			ly.ajaxSubmit(form, {// 验证新增是否成功
				type : "post",
				dataType : "json",
				success : function(data) {
					if (data == "success") {
						layer.confirm('更新成功!是否关闭窗口?', {
							icon : 6,
							title : '提示'
						}, function(index) {

							parent.layer.close(parent.pageii);
							parent.myTable.draw(false);
							return false;
						});
						$("#form")[0].reset();
					} else {
						layer.alert('更新失敗！', 3);
					}
				}
			});
		},
		rules : {
			
			"userFormMap.userName":{required : true},
			
			"userFormMap.email": {
				email:true,
				rangelength:[8,15]
			},
			"userFormMap.telephone": {
				telephone: true,
				required : true,
			}
		},
		messages : {
			
			"userFormMap.userName" : {
				required : "请输入用户姓名"
				
			},
			
			"userFormMap.email": {
				 email:"请输入正确的email地址",
				 rangelength:" email长度在8-15位之间"
			},
			"userFormMap.telephone": {
				required : "请输入客户电话号码",
				
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
