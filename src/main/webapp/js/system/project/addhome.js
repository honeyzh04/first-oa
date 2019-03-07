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
            "projectFormMap.building": {

                required: true
            },
            "projectFormMap.floor": {
                required: true
            },
            "projectFormMap.roomNo": {
                required: true,
            },
            "projectFormMap.area": {

                required: true,
            },
            "projectFormMap.sell": {
                required: true,
            },
            "projectFormMap.price": {
                required: true,
            },



        },


        messages: {

            "projectFormMap.proId": {
                required: "请选择项目"

            },
            "projectFormMap.building": {
                required: "请输入楼栋单元",
            },
            "projectFormMap.floor": {
                required: "请输入楼层",
            },
            "projectFormMap.roomNo": {
                required: "请输入房号",
            },
            "projectFormMap.area": {
                required: "请输入建面",
            },
            "projectFormMap.sell": {
                required: "请选择销售状态",
            },
            "  projectFormMap.price": {
                required: "请输入住宅价格",
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

