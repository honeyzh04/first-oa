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
					/*if (!save()) {
						layer.msg('跟进内容不能少于十个字！', {
							icon : 2,
							time : 2000
						// 2秒关闭（如果不配置，默认是3秒）
						});
						return false;
					}else */	if (data == "success") {
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
							parent.layer.close(parent.pagea);
							parent.myTablea.draw(false);
							return false;
						});
						$("#form")[0].reset();
					} else {
						layer.msg('商铺编辑失败！', {
							icon : 2,
							time : 2000
						// 2秒关闭（如果不配置，默认是3秒）
						});
					}
				}
			});
		},
		rules : {

			"projectShopsFormMap.projectName" : {
				required : true
			},
			"projectShopsFormMap.Another_Name" : {

                required : true
			},
			"projectShopsFormMap.lease" : {
				required : true
			},
			"projectShopsFormMap.state": {
				required : true,
			},
			"projectShopsFormMap.projectPosition" : {

				required : true,
			},
            "projectShopsFormMap.type" : {
                required : true,
            },
            "projectShopsFormMap.region" : {
                required : true,
            },
            "projectShopsFormMap.saleStartTime" : {
                required : true,
            },
            "  projectShopsFormMap.areas" : {
                required : true,
            },
            "  projectShopsFormMap.areae" : {
                required : true,
            },
            " projectShopsFormMap.areas" : {
                required : true,
            },
            " projectShopsFormMap.areas" : {
                required : true,
            },
            "projectShopsFormMap.prices" : {
                required : true,
            },
            "projectShopsFormMap.pricee" : {
                required : true,
            },
            "projectShopsFormMap.pricess" : {
                required : true,
            },
            "projectShopsFormMap.pricese" : {
                required : true,
            },
            "projectShopsFormMap.commission" : {
                required : true,
            },
            "projectShopsFormMap.firstPerson" : {
                required : true,
            },
            "projectShopsFormMap.firstTelephone" : {
                required : true,
            },
            "projectShopsFormMap.projectPerson" : {
                required : true,
            },
            "projectShopsFormMap.projectTelephone" : {
                required : true,
            },
            "projectShopsFormMap.description" : {
                required : true,
            },
            "projectShopsFormMap.RecommendReason" : {
                required : true,
            },





        },


		messages : {

			"projectShopsFormMap.projectName" : {
				required : "请输入项目名"

			},

			"projectShopsFormMap.Another_Name" : {
				required : "请输入项目昵称",

			},
			"projectShopsFormMap.lease" : {
                required : "请选择是否带租约",

			},
			"projectShopsFormMap.state" : {
				required : "请选择楼盘状态",
			},
			"cprojectShopsFormMap.projectPosition" : {

				required : "请选择具体位置",
			},
            "projectShopsFormMap.type" : {

                required : "请选择项目分类",
            },
            "projectShopsFormMap.region" : {
                required : "请选择项目区域",
            },
            "projectShopsFormMap.saleStartTime" : {
                required : "请选择开盘时间",
            },
            " projectShopsFormMap.areas" : {
                required : "请选择最小面积",
            },
            " projectShopsFormMap.areas" : {
                required : "请选择最大面积",
            },
            "projectShopsFormMap.prices" : {
                required : "请选择最小单价",
            },
            "projectShopsFormMap.pricee" : {
                required : "请选择最大单价",
            },
            "projectShopsFormMap.pricess" : {
                required : "请选择最小总价",
            },
            "projectShopsFormMap.pricese" : {
                required : "请选择最大总价",
            },
            "projectShopsFormMap.commission" : {
                required : "请输入项目佣金",
            },
            "projectShopsFormMap.firstPerson" : {
                required : "请输入公司负责人",
            },
            "projectShopsFormMap.firstTelephone" : {
                required : "请输入公司负责人电话",
            },
            "projectShopsFormMap.projectPerson" : {
                required : "请输入项目负责人",
            },
            "projectShopsFormMap.projectTelephone" : {
                required : "请输入项目负责人电话",
            },
            "projectShopsFormMap.description" : {
                required : "请输入项目描述",
            },
            "projectShopsFormMap.RecommendReason" : {
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

