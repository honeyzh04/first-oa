//自定义验证 ，单独验证某一个input  class="checkpass"
jQuery.validator.addMethod("checkacc", function(value, element) {
	
	var len = value.length;
	 var chrnum = /^([a-zA-Z0-9]+)$/;
    if(len<4){
        return false;
    }
    if(len>15){
        return false;
    }
    {if(!chrnum.exec(value)){return false;}};
    return true;
}, "账号由4至15位字母和数字组合构成");
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
						layer.confirm('添加成功!是否关闭窗口?', {
							icon : 6,
							title : '提示'
						}, function(index) {

							parent.layer.close(parent.pageii);
							parent.myTable.draw(false);
							return false;
						});
						$("#form")[0].reset();
					} else {
						layer.alert('添加失败！', 3);
					}
				}
			});
		},
		rules : {
			
			"userFormMap.userName":{required : true},
			"userFormMap.accountName" : {
				required : true,
				remote : { // 异步验证是否存在
					type : "POST",
					url : '../user/isExist.shtml',
					data : {
						name : function() {
							return $("#accountName").val();
						}
					}
				}
			},
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
			"userFormMap.accountName" : {
				required : "请输入账号",
				remote : "该账号已经存在"
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
