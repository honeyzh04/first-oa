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
							parent.layer.close(parent.pagec);
							parent.myTablec.draw(false);
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

			"projectOfficeFormMap.projectName" : {
				required : true
			},
			"projectOfficeFormMap.Another_Name" : {

                required : true
			},
			"projectOfficeFormMap.lease" : {
				required : true
			},
			"projectOfficeFormMap.state": {
				required : true,
			},
            "projectOfficeFormMap.city" : {
                required : true,
            },

            "projectOfficeFormMap.projectPosition" : {

				required : true,
			},
            "projectOfficeFormMap.type" : {
                required : true,
            },
            "projectOfficeFormMap.region" : {
                required : true,
            },
            "projectOfficeFormMap.saleStartTime" : {
                required : true,
            },
            "projectOfficeFormMap.areas" : {
                required : true,
            },
            "projectOfficeFormMap.areae" : {
                required : true,
            },
            "projectOfficeFormMap.areas" : {
                required : true,
            },
            "projectOfficeFormMap.areas" : {
                required : true,
            },
            "projectOfficeFormMap.prices" : {
                required : true,
            },
            "projectOfficeFormMap.pricee" : {
                required : true,
            },
            "projectOfficeFormMap.pricess" : {
                required : true,
            },
            "projectOfficeFormMap.pricese" : {
                required : true,
            },
            "projectOfficeFormMap.commission" : {
                required : true,
            },
            "projectOfficeFormMap.firstPerson" : {
                required : true,
            },
            "projectOfficeFormMap.firstTelephone" : {
                required : true,
            },
            "projectOfficeFormMap.projectPerson" : {
                required : true,
            },
            "projectOfficeFormMap.projectTelephone" : {
                required : true,
            },
            "projectOfficeFormMap.description" : {
                required : true,
            },
            "projectOfficeFormMap.RecommendReason" : {
                required : true,
            },
            "projectOfficeFormMap.prFeature" : {
                required : true,
            },
            "projectOfficeFormMap.projectPositions" : {
                required : true,
            },




        },


		messages : {

			"projectOfficeFormMap.projectName" : {
				required : "请输入项目名"

			},

			"projectOfficeFormMap.Another_Name" : {
				required : "请输入项目昵称",

			},
			"projectOfficeFormMap.lease" : {
                required : "请选择是否带租约",

			},
			"projectOfficeFormMap.state" : {
				required : "请选择楼盘状态",
			},
            "projectOfficeFormMap.city" : {
                required : "请选择楼盘位置",
            },

			"cprojectOfficeFormMap.projectPosition" : {

				required : "请选择具体位置",
			},
            "projectOfficeFormMap.type" : {

                required : "请选择项目分类",
            },
            "projectOfficeFormMap.region" : {
                required : "请选择项目区域",
            },
            "projectOfficeFormMap.saleStartTime" : {
                required : "请选择开盘时间",
            },
            " projectOfficeFormMap.areas" : {
                required : "请选择最小面积",
            },
            " projectOfficeFormMap.areas" : {
                required : "请选择最大面积",
            },
            "projectOfficeFormMap.prices" : {
                required : "请选择最小单价",
            },
            "projectOfficeFormMap.pricee" : {
                required : "请选择最大单价",
            },
            "projectOfficeFormMap.pricess" : {
                required : "请选择最小总价",
            },
            "projectOfficeFormMap.pricese" : {
                required : "请选择最大总价",
            },
            "projectOfficeFormMap.commission" : {
                required : "请输入项目佣金",
            },
            "projectOfficeFormMap.firstPerson" : {
                required : "请输入公司负责人",
            },
            "projectOfficeFormMap.firstTelephone" : {
                required : "请输入公司负责人电话",
            },
            "projectOfficeFormMap.projectPerson" : {
                required : "请输入项目负责人",
            },
            "projectOfficeFormMap.projectTelephone" : {
                required : "请输入项目负责人电话",
            },
            "projectOfficeFormMap.description" : {
                required : "请输入项目描述",
            },
            "projectOfficeFormMap.RecommendReason" : {
                required : "请输入项目推荐",
            },
            "projectOfficeFormMap.prFeature" : {
                required : "请输入项目特点",
            },
            "projectOfficeFormMap.projectPositions" : {
                required : "请输入项目具体位置",
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

