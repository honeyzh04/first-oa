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
                            parent.$("#loadhtml").load("/personal/list.shtml?id=23");
							return false;
						});

					} else {
						layer.alert('添加失败！', 3);
					}
				}
			});
		},
		rules : {
			
			"personalFormMap.add":{
				required : true,
				number : true},
            "personalFormMap.visit":{
                required : true,
                number : true},
            "personalFormMap.deal":{
                required : true,
                number : true},
			"personalFormMap.createDate" : {
				required : true,
				remote : { // 异步验证是否存在
					type : "POST",
					url : '../personal/deisExist.shtml',
					data : {
                        createDate: function() {
							return $("#createDate").val();
						},
                        type : function() {
                            return $("#type").val();
                        },
                        deId : function() {
                            return $("#deId").val();
                        },

					}
				}
			},

		},
		messages : {
			
			"personalFormMap.add" : {
				required : "请输入用计划新增",
                number : "请输入合法的数字",
				
			},
            "personalFormMap.visit" : {
                required : "请输入用计划新增",
                number : "请输入合法的数字",

            },
            "personalFormMap.deal" : {
                required : "请输入用计划佣金",
                number : "请输入合法的数字",

            },
			"personalFormMap.createDate" : {
				required : "请输入计划日期",
				remote : "该日期已经存在"
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
