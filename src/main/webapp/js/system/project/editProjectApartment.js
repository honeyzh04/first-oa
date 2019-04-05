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
$(function() {

	$("form").validate({
		submitHandler : function(form) {// 必须写在验证前面，否则无法ajax提交
			ly.ajaxSubmit(form, {// 验证新增是否成功
				type : "post",
				dataType : "json",// ajaxSubmi带有文件上传的。不需要设置json
				success : function(data) {
						if (data == "success") {
						layer.confirm('修改成功!是否关闭窗口?', {
							icon : 6,
							title : '提示'
						}, function(index) {

							parent.layer.close(parent.pageb);
							parent.myTableb.draw(false);
							return false;
						});
						$("#form")[0].reset();
					} else {
						layer.msg('公寓添加失败！', {
							icon : 2,
							time : 2000
						// 2秒关闭（如果不配置，默认是3秒）
						});
					}
				}
			});
		},
		rules : {

			"projectApartmentFormMap.projectName" : {
				required : true
			},
			"projectApartmentFormMap.Another_Name" : {

                required : true
			},
			"projectApartmentFormMap.lease" : {
				required : true
			},
			"projectApartmentFormMap.state": {
				required : true,
			},
			"projectApartmentFormMap.projectPosition" : {

				required : true,
			},
            "projectApartmentFormMap.type" : {
                required : true,
            },
            "projectApartmentFormMap.region" : {
                required : true,
            },
            "projectApartmentFormMap.saleStartTime" : {
                required : true,
            },
            "  projectApartmentFormMap.areas" : {
                required : true,
            },
            "  projectApartmentFormMap.areae" : {
                required : true,
            },
            " projectApartmentFormMap.areas" : {
                required : true,
            },
            " projectApartmentFormMap.areas" : {
                required : true,
            },
            "projectApartmentFormMap.prices" : {
                required : true,
            },
            "projectApartmentFormMap.pricee" : {
                required : true,
            },
            "projectApartmentFormMap.pricess" : {
                required : true,
            },
            "projectApartmentFormMap.pricese" : {
                required : true,
            },
            "projectApartmentFormMap.commission" : {
                required : true,
            },
            "projectApartmentFormMap.firstPerson" : {
                required : true,
            },
            "projectApartmentFormMap.firstTelephone" : {
                required : true,
            },
            "projectApartmentFormMap.projectPerson" : {
                required : true,
            },
            "projectApartmentFormMap.projectTelephone" : {
                required : true,
            },
            "projectApartmentFormMap.description" : {
                required : true,
            },
            "projectApartmentFormMap.RecommendReason" : {
                required : true,
            },





        },


		messages : {

			"projectApartmentFormMap.projectName" : {
				required : "请输入项目名"

			},

			"projectApartmentFormMap.Another_Name" : {
				required : "请输入项目昵称",

			},
			"projectApartmentFormMap.lease" : {
                required : "请选择是否带租约",

			},
			"projectApartmentFormMap.state" : {
				required : "请选择楼盘状态",
			},
			"cprojectApartmentFormMap.projectPosition" : {

				required : "请选择具体位置",
			},
            "projectApartmentFormMap.type" : {

                required : "请选择项目分类",
            },
            "projectApartmentFormMap.region" : {
                required : "请选择项目区域",
            },
            "projectApartmentFormMap.saleStartTime" : {
                required : "请选择开盘时间",
            },
            " projectApartmentFormMap.areas" : {
                required : "请选择最小面积",
            },
            " projectApartmentFormMap.areas" : {
                required : "请选择最大面积",
            },
            "projectApartmentFormMap.prices" : {
                required : "请选择最小单价",
            },
            "projectApartmentFormMap.pricee" : {
                required : "请选择最大单价",
            },
            "projectApartmentFormMap.pricess" : {
                required : "请选择最小总价",
            },
            "projectApartmentFormMap.pricese" : {
                required : "请选择最大总价",
            },
            "projectApartmentFormMap.commission" : {
                required : "请输入项目佣金",
            },
            "projectApartmentFormMap.firstPerson" : {
                required : "请输入公司负责人",
            },
            "projectApartmentFormMap.firstTelephone" : {
                required : "请输入公司负责人电话",
            },
            "projectApartmentFormMap.projectPerson" : {
                required : "请输入项目负责人",
            },
            "projectApartmentFormMap.projectTelephone" : {
                required : "请输入项目负责人电话",
            },
            "projectApartmentFormMap.description" : {
                required : "请输入项目描述",
            },
            "projectApartmentFormMap.RecommendReason" : {
                required : "请输入项目推荐",
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

