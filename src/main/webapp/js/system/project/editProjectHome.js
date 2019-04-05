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
						layer.confirm('编辑成功!是否关闭窗口?', {
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
							parent.layer.close(parent.paged);
							parent.myTabled.draw(false);
							return false;
						});
						$("#form")[0].reset();
					} else {
						layer.msg('项目编辑失败！', {
							icon : 2,
							time : 2000
						// 2秒关闭（如果不配置，默认是3秒）
						});
					}
				}
			});
		},
		rules : {

			"projectHomeFormMap.projectName" : {
				required : true
			},
			"projectHomeFormMap.Another_Name" : {

                required : true
			},
			"projectHomeFormMap.lease" : {
				required : true
			},
			"projectHomeFormMap.state": {
				required : true,
			},
			"projectHomeFormMap.projectPosition" : {

				required : true,
			},
            "projectHomeFormMap.type" : {
                required : true,
            },
            "projectHomeFormMap.region" : {
                required : true,
            },
            "projectHomeFormMap.saleStartTime" : {
                required : true,
            },
            "  projectHomeFormMap.areas" : {
                required : true,
            },
            "  projectHomeFormMap.areae" : {
                required : true,
            },
            " projectHomeFormMap.areas" : {
                required : true,
            },
            " projectHomeFormMap.areas" : {
                required : true,
            },
            "projectHomeFormMap.prices" : {
                required : true,
            },
            "projectHomeFormMap.pricee" : {
                required : true,
            },
            "projectHomeFormMap.pricess" : {
                required : true,
            },
            "projectHomeFormMap.pricese" : {
                required : true,
            },
            "projectHomeFormMap.commission" : {
                required : true,
            },
            "projectHomeFormMap.firstPerson" : {
                required : true,
            },
            "projectHomeFormMap.firstTelephone" : {
                required : true,
            },
            "projectHomeFormMap.projectPerson" : {
                required : true,
            },
            "projectHomeFormMap.projectTelephone" : {
                required : true,
            },
            "projectHomeFormMap.description" : {
                required : true,
            },
            "projectHomeFormMap.RecommendReason" : {
                required : true,
            },





        },


		messages : {

			"projectHomeFormMap.projectName" : {
				required : "请输入项目名"

			},

			"projectHomeFormMap.Another_Name" : {
				required : "请输入项目昵称",

			},
			"projectHomeFormMap.lease" : {
                required : "请选择是否带租约",

			},
			"projectHomeFormMap.state" : {
				required : "请选择楼盘状态",
			},
			"cprojectHomeFormMap.projectPosition" : {

				required : "请选择具体位置",
			},
            "projectHomeFormMap.type" : {

                required : "请选择项目分类",
            },
            "projectHomeFormMap.region" : {
                required : "请选择项目区域",
            },
            "projectHomeFormMap.saleStartTime" : {
                required : "请选择开盘时间",
            },
            " projectHomeFormMap.areas" : {
                required : "请选择最小面积",
            },
            " projectHomeFormMap.areas" : {
                required : "请选择最大面积",
            },
            "projectHomeFormMap.prices" : {
                required : "请选择最小单价",
            },
            "projectHomeFormMap.pricee" : {
                required : "请选择最大单价",
            },
            "projectHomeFormMap.pricess" : {
                required : "请选择最小总价",
            },
            "projectHomeFormMap.pricese" : {
                required : "请选择最大总价",
            },
            "projectHomeFormMap.commission" : {
                required : "请输入项目佣金",
            },
            "projectHomeFormMap.firstPerson" : {
                required : "请输入公司负责人",
            },
            "projectHomeFormMap.firstTelephone" : {
                required : "请输入公司负责人电话",
            },
            "projectHomeFormMap.projectPerson" : {
                required : "请输入项目负责人",
            },
            "projectHomeFormMap.projectTelephone" : {
                required : "请输入项目负责人电话",
            },
            "projectHomeFormMap.description" : {
                required : "请输入项目描述",
            },
            "projectHomeFormMap.RecommendReason" : {
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

