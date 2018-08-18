//自定义验证 ，单独验证某一个input  class="checkpass"
jQuery.validator.addMethod("content", function(value, element) {
	var length = value.length;

	return this.optional(element) || (length > 10);
}, "跟进内容不得小于十个字");

// 手机号码验证
jQuery.validator
		.addMethod(
				"telephone",
				function(value, element) {
					var length = value.length;
					var mobile = /^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/
					return this.optional(element)
							|| (length == 11 && mobile.test(value));
				}, "手机号码格式错误");
$(function() {

	$("form").validate({
		submitHandler : function(form) {// 必须写在验证前面，否则无法ajax提交
			ly.ajaxSubmit(form, {// 验证新增是否成功
				type : "post",
				dataType : "json",// ajaxSubmi带有文件上传的。不需要设置json
				success : function(data) {
					if (!save()) {
						layer.msg('跟进内容不能少于十个字！', {
							icon : 2,
							time : 2000
						// 2秒关闭（如果不配置，默认是3秒）
						});
						return false;
					}
					;
					if (data == "success") {
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
			"customerFormMap.content" : {
				content : true,
				required : true,
			},
			"customerFormMap.dealarea" : {
				number : true,

			},
			"customerFormMap.dealprice" : {
				number : true,

			},
			"customerFormMap.dealprojectId" : {

				required : true,
			},
			"customerFormMap.visitprojectId" : {

				required : true,
			},
			"customerFormMap.visitdate" : {

				required : true,
			},

			"customerFormMap.dealdate" : {

				required : true,
			},
			"customerFormMap.commission" : {

				required : true,
			},
			"customerFormMap.dealprice" : {

				required : true,
			},
			"customerFormMap.dealarea" : {

				required : true,
			},
			"customerFormMap.cusource" : {

				required : true,
			},

		},

		messages : {

			"customerFormMap.customerName" : {
				required : "请输入客户姓名"

			},
			"customerFormMap.totalPrice" : {

				number : "请输入合法的数字",

			},
			"customerFormMap.telephone" : {
				required : "请输入客户电话号码",

			},
			"customerFormMap.totalPrice" : {
				required : "请输入客户电话号码",

			},
			"customerFormMap.content" : {
				required : "请输入客户跟进内容",
			},
			"customerFormMap.dealarea" : {
				number : "请输入合法的数字",

			},
			"customerFormMap.dealprice" : {
				number : "请输入合法的数字",

			},
			"customerFormMap.dealprojectId" : {

				required : "请输入成交项目",
			},
			"customerFormMap.visitprojectId" : {

				required : "请输入到访项目",
			},
			"customerFormMap.visitdate" : {

				required : "请输入到访时间",
			},
			"customerFormMap.dealdate" : {

				required : "请输入成交时间",
			},
			"customerFormMap.commission" : {

				required : "请输入成交佣金",
			},
			"customerFormMap.dealprice" : {

				required : "请输入成交总价",
			},
			"customerFormMap.dealarea" : {

				required : "请输入成交面积",
			},
			"customerFormMap.cusource" : {

				required : "请选择客户来源",
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
function save() {
	// alert("111")
	var a = $.trim($("#contenta").val());
	// console.log(a)
	if (a == "" || a.length <= 10 || a == null) {

		return false;
	} else {
		return true;
	}

}
