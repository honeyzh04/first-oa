//自定义验证 ，单独验证某一个input  
//手机号码验证
jQuery.validator
		.addMethod(
				"telephone",
				function(value, element) {
					var length = value.length;
					var mobile = /^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/
					return this.optional(element)
							|| (length == 11 && mobile.test(value));
				}, "手机号码格式错误");
jQuery.validator.addMethod(
		"content",
		function(value, element) {
			var length = value.length;
			
			return this.optional(element)
					|| (length >10);
		}, "跟进内容不得小于十个字");
$(function() {

	$("form").validate({
		submitHandler : function(form) {// 必须写在验证前面，否则无法ajax提交
			ly.ajaxSubmit(form, {// 验证新增是否成功
				type : "post",
				dataType : "json",// ajaxSubmi带有文件上传的。不需要设置json
				success : function(data) {
					/*if (!save()) {
						layer.msg('跟进内容不能少于十个字！', {
							icon : 2,
							time : 2000
						// 2秒关闭（如果不配置，默认是3秒）
						});
						return false;
					}else */	if (data == "success") {
						layer.confirm('添加成功!是否关闭窗口?', {
							icon : 6,
							title : '提示'
						}, function(index) {
							/*
							 * window.parent.location.reload(); var index =
							 * parent.layer.getFrameIndex(window.name);
							 */
							/*
							 * parent.$("#datatable").dataTable().ajax.reload(null,
							 * false);
							 */
							parent.layer.close(parent.pageii);
							parent.myTable.draw(false);
                            parent.matchproject();
							return false;
						});
						$("#form")[0].reset();
					} else {
						layer.msg('客户添加失败！', {
							icon : 2,
							time : 2000
						// 2秒关闭（如果不配置，默认是3秒）
						});
					}
				}
			});
		},
		rules : {

			"customerFormMap.customerName" : {
				required : true
			},
			"customerFormMap.totalPrice" : {
				
				number : true
			},
			"customerFormMap.telephone" : {
				telephone : true,
				required : true,
			},
			"customerFormMap.content": {
				content : true,
				required : true,
			},
			"customerFormMap.cusource" : {

				required : true,
			},
            "customerFormMap.ffxcusource" : {

                required : true,
            },
		},


		messages : {

			"customerFormMap.customerName" : {
				required : "请输入客户姓名"

			},

			"customerFormMap.telephone" : {
				required : "请输入客户电话号码",

			},
			"customerFormMap.totalPrice" : {
				
				number : "请输入合法的数字",

			},
			"customerFormMap.content" : {
				required : "请输入客户跟进内容",
			},
			"customerFormMap.cusource" : {

				required : "请选择客户来源",
			},
            "customerFormMap.ffxcusource" : {

                required : "请选择具体来源",
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

