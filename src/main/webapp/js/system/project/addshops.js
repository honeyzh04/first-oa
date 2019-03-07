jQuery.validator.addMethod(
    "content",
    function (value, element) {
        var length = value.length;

        return this.optional(element)
            || (length > 10);
    }, "内容不能为空");
$(function () {
    $("form").validate({
        submitHandler: function (form) {// 必须写在验证前面，否则无法ajax提交
            ly.ajaxSubmit(form, {// 验证新增是否成功
                type: "post",
                dataType: "json",// ajaxSubmi带有文件上传的。不需要设置json
                success: function (data) {
                    if (data == "success") {
                        layer.confirm('添加成功!是否关闭窗口?', {
                            icon: 6,
                            title: '提示'
                        }, function (index) {
                            parent.layer.close(parent.pageii);
                            parent.myTable.draw(false);
                            return false;
                        });
                        $("#form")[0].reset();
                    } else {
                        layer.msg('商铺销控添加失败！', {
                            icon: 2,
                            time: 2000
                            // 2秒关闭（如果不配置，默认是3秒）
                        });
                    }
                }
            });
        },
        rules: {

            "projectFormMap.proId": {
                required: true
            },
            "projectFormMap.shopNumber": {

                required: true
            },
            "projectFormMap.forecastBuilding": {
                required: true
            },
            "projectFormMap.acreate": {
                required: true,
            },
            "projectFormMap.forecastPublicApportionment": {

                required: true,
            },
            "projectFormMap.forecastSet": {
                required: true,
            },
            "projectFormMap.totalPrice": {
                required: true,
            },
            "projectFormMap.price": {
                required: true,
            },
            "projectFormMap.height": {
                required: true,
            },
            "projectFormMap.opening": {
                required: true,
            },
            "projectFormMap.sell": {
                required: true,
            },
            "projectFormMap.store_status": {
                required: true,
            },
            "projectFormMap.flue": {
                required: true,
            },
            "projectFormMap.Rent": {
                required: true,
            },
            "projectFormMap.port": {
                required: true,
            },
            "projectFormMap.intro": {
                required: true,
            },
            "projectFormMap.RecommendReason": {
                required: true,
            },


        },


        messages: {

            "projectFormMap.proId": {
                required: "请选择项目"

            },
            "projectFormMap.shopNumber": {
                required: "请输入商铺编号",
            },
            "projectFormMap.forecastBuilding": {
                required: "请输入预测建筑面积",
            },
            "projectFormMap.acreate": {
                required: "请输入商铺面积",
            },
            "projectFormMap.forecastPublicApportionment": {
                required: "请输入预测公摊",
            },
            "projectFormMap.forecastSet": {
                required: "请输入预测套内",
            },
            "projectFormMap.totalPrice": {
                required: "请输入商铺总价",
            },
            "projectFormMap.price": {
                required: "请输入商铺单价",
            },
            "projectFormMap.height": {
                required: "请输入层高",
            },
            "projectFormMap.opening": {
                required: "请输入开间",
            },
            "projectFormMap.sell": {
                required: "请选择出售状态",
            },
            "projectFormMap.store_status": {
                required: "请选择经营状态",
            },
            "projectFormMap.flue": {
                required: "请选择是否有烟道",
            },
            "projectFormMap.Rent": {
                required: "请输入租金",
            },
            "projectFormMap.port": {
                required: "请输入项目佣金",
            },
            "projectFormMap.intro": {
                required: "请输入公司负责人",
            },
            "projectFormMap.RecommendReason": {
                required: "请输入公司负责人电话",
            },


        },

        errorPlacement: function (error, element) {// 自定义提示错误位置
            $(".l_err").css('display', 'block');
            // element.css('border','3px solid #FFCCCC');
            $(".l_err").html(error.html());
        },
        success: function (label) {// 验证通过后
            $(".l_err").css('display', 'none');
        }
    });
});

