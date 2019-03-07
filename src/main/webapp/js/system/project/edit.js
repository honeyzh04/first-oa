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

			"projectFormMap.projectName" : {
				required : true
			},
			"projectFormMap.Another_Name" : {

                required : true
			},
			"projectFormMap.lease" : {
				required : true
			},
			"projectFormMap.state": {
				required : true,
			},
			"projectFormMap.projectPosition" : {

				required : true,
			},
            "projectFormMap.type" : {
                required : true,
            },
            "projectFormMap.region" : {
                required : true,
            },
            "projectFormMap.saleStartTime" : {
                required : true,
            },
            "  projectFormMap.areas" : {
                required : true,
            },
            "  projectFormMap.areae" : {
                required : true,
            },
            " projectFormMap.areas" : {
                required : true,
            },
            " projectFormMap.areas" : {
                required : true,
            },
            "projectFormMap.prices" : {
                required : true,
            },
            "projectFormMap.pricee" : {
                required : true,
            },
            "projectFormMap.pricess" : {
                required : true,
            },
            "projectFormMap.pricese" : {
                required : true,
            },
            "projectFormMap.commission" : {
                required : true,
            },
            "projectFormMap.firstPerson" : {
                required : true,
            },
            "projectFormMap.firstTelephone" : {
                required : true,
            },
            "projectFormMap.projectPerson" : {
                required : true,
            },
            "projectFormMap.projectTelephone" : {
                required : true,
            },
            "projectFormMap.description" : {
                required : true,
            },
            "projectFormMap.RecommendReason" : {
                required : true,
            },
            "projectFormMap.prFeature" : {
                required : true,
            },




        },


		messages : {

			"projectFormMap.projectName" : {
				required : "请输入项目名"

			},

			"projectFormMap.Another_Name" : {
				required : "请输入项目昵称",

			},
			"projectFormMap.lease" : {
                required : "请选择是否带租约",

			},
			"projectFormMap.state" : {
				required : "请选择楼盘状态",
			},
			"cprojectFormMap.projectPosition" : {

				required : "请选择具体位置",
			},
            "projectFormMap.type" : {

                required : "请选择项目分类",
            },
            "projectFormMap.region" : {
                required : "请选择项目区域",
            },
            "projectFormMap.saleStartTime" : {
                required : "请选择开盘时间",
            },
            " projectFormMap.areas" : {
                required : "请选择最小面积",
            },
            " projectFormMap.areas" : {
                required : "请选择最大面积",
            },
            "projectFormMap.prices" : {
                required : "请选择最小单价",
            },
            "projectFormMap.pricee" : {
                required : "请选择最大单价",
            },
            "projectFormMap.pricess" : {
                required : "请选择最小总价",
            },
            "projectFormMap.pricese" : {
                required : "请选择最大总价",
            },
            "projectFormMap.commission" : {
                required : "请输入项目佣金",
            },
            "projectFormMap.firstPerson" : {
                required : "请输入公司负责人",
            },
            "projectFormMap.firstTelephone" : {
                required : "请输入公司负责人电话",
            },
            "projectFormMap.projectPerson" : {
                required : "请输入项目负责人",
            },
            "projectFormMap.projectTelephone" : {
                required : "请输入项目负责人电话",
            },
            "projectFormMap.description" : {
                required : "请输入项目描述",
            },
            "projectFormMap.RecommendReason" : {
                required : "请输入项目推荐",
            },
            "projectFormMap.prFeature" : {
                required : "请输入项目特点",
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

