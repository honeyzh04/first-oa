<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/common.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<html>
<head>
<script type="text/javascript" src="${ctx}/js/system/project/addProjectShops.js">
</script>
	<style>
		.wrap{
			width: 1000px;
			font-size: 14px;
		}
		.inpw100{
			width: 240px;
			height: 38px;
			line-height: 1.3;
			line-height: 38px;

			background: #fff;
			border-radius: 2px;
			margin-right: 3px;
			padding-left: 3px;
		}
		.labw130{
			float: left;
			display: block;
			padding: 9px 15px;
			width: 130px;
			margin-left: 10px;
			font-weight: 400;
			line-height: 20px;
			text-align: right;
		}
		.inpdiv190{
			float: left;
			width: 300px;
			margin-right: 50px;
		}
		.row{
			margin-bottom: 15px;
			margin-top: 20px;
			clear: both;
		}
		.inpw80{
			width: 112px;
		}
		.selw680{
			width: 580px;
		}
		.selw100{
			width: 240px;
		}
		.selw70{
			width: 78px;
			float: left;
		}
		option{
			height: 38px;
			line-height: 38px;
		}
		.rowbutton{
			padding-left: 130px;
		}
		.rowbutton button{
			width: 100px;
			height: 38px;
			line-height: 38px;
			margin: 0px 10px;
			border-radius:5px;
			border: 0px;
		}
		.sum{
			text-align: right;
			margin-right: 300px;
		}
	</style>

<body>
<div class="l_err" style="width: 100%; margin-top: 2px;"></div>
<form class="" id="form" action="${ctx}/projectShops/addProjectShops.shtml" method="get">

	<div class="wrap" id="wrap">
        <input type="hidden" id="score"name="projectShopsFormMap.score" >
        <input type="hidden" id="sum"name="projectShopsFormMap.sum" >
		<div class="row">
			<label for="" class="labw130">项目名称 *</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="请输入项目名称" name="projectShopsFormMap.projectName"></div>
			<label for="" class="labw130">项目别名 *</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="请输入项目别名" name="projectShopsFormMap.Another_Name"></div>
		</div>
		<div class="row">

			<label for="" class="labw130">状态 *</label>
			<div class="inpdiv190">
				<select class="selw100 inpw100" name="projectShopsFormMap.state">
					<option value="">请选择</option>
					<option value="0">热销</option>
					<option value="1">待售</option>
					<option value="2">在售</option>
					<option value="3">认购</option>
					<option value="4">售罄</option>

				</select>
			</div>
			<label for="" class="labw130">排序权重 *</label>
			<div class="inpdiv190">
				<select class="selw100 inpw100" name="projectShopsFormMap.weight">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
			</div>
		</div>

		<div class="row">
			<label for="" class="labw130">项目位置 *</label>
			<div class="inpdiv190">
				<select class="form-control selw70 inpw100" id="cmbProvince" name="projectShopsFormMap.province"></select>
				<select class="form-control selw70 inpw100" id="cmbCity" name="projectShopsFormMap.city"></select>
				<select class="form-control selw70 inpw100" id="cmbArea" name="projectShopsFormMap.district" onchange="bao(this.options[this.options.selectedIndex].value)"></select>
			</div>
			<label for="" class="labw130">具体位置 *</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="请输入具体位置" name="projectShopsFormMap.projectPositions"    onchange="contactposition(this)"></div>
			<input type="hidden" name="projectShopsFormMap.projectPosition" id="cmbposition">
			<input type="hidden" class="inpw100" placeholder="默认" id="latitude" name="projectShopsFormMap.latitude" readonly="readonly">
		</div>
		<div class="row">

			<label for="" class="labw130">是否带租约 *</label>
			<div class="inpdiv190">
				<select class="selw100 inpw100" name="projectShopsFormMap.lease">
					<option value="">请选择</option>
					<option value="1">带租约</option>
					<option value="2">不带租约</option>
					<option value="3">部分带租约</option>
				</select>
			</div>
			<label for="" class="labw130">项目类型 *</label>
			<div class="inpdiv190">
				<select class="selw100 inpw100" name="projectShopsFormMap.projectType">
					<option value="">请选择</option>
					<option value="商业综合体">商业综合体</option>
					<option value="社区底商">社区底商</option>
				</select>
			</div>

		</div>

		<div class="row">
			<label for="" class="labw130">开发商</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="开发商" name="projectShopsFormMap.Developers"></div>
			<label for="" class="labw130">开建日期</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="开建日期"  id="StartDate" name="projectShopsFormMap.StartDate"></div>
		</div>

		<div class="row">
			<label for="" class="labw130">区域 *</label>
			<div class="inpdiv190"><select class="selw100 inpw100" name="projectShopsFormMap.region">
				<option value="">请选择</option>
				<option value="12">南区</option>
				<option value="13">北区</option>
				<option value="14">东区</option>
				<option value="15">西区</option>
			</select></div>
			<label for="" class="labw130">所属商圈 *</label>
            <select class="selectpicker projecBusiness " data-style="btn-danger" data-width="239px" id="projecBusiness"
                    name="projectShopsFormMap.business" data-live-search="true" title="选择项目"></select>

		</div>
		<div class="row">
			<label for="" class="labw130">面积区间 *</label>
			<div class="inpdiv190"><input type="text" class="inpw100 inpw80" placeholder="最小面积" name="projectShopsFormMap.areas">--
				<input type="text" class="inpw100 inpw80" placeholder="最大面积" name="projectShopsFormMap.areae">㎡</div>
			<label for="" class="labw130">单价区间 *</label>
			<div class="inpdiv190"><input type="text" class="inpw100 inpw80" placeholder="最低单价" name="projectShopsFormMap.prices">--
				<input type="text" class="inpw100 inpw80" placeholder="最高单价" name="projectShopsFormMap.pricee">元</div>
		</div>
		<div class="row">
			<label for="" class="labw130">总价区间 *</label>
			<div class="inpdiv190"><input type="text" class="inpw100 inpw80" placeholder="最低总价" name="projectShopsFormMap.pricess">--
				<input type="text" class="inpw100 inpw80" placeholder="最高总价" name="projectShopsFormMap.pricese">万元</div>
			<label for="" class="labw130">项目佣金 *</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="项目佣金" name="projectShopsFormMap.commission"></div>
		</div>
		<div class="row">
			<label for="" class="labw130">占地面积</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="占地面积" name="projectShopsFormMap.FloorArea">㎡</div>
			<label for="" class="labw130">建筑面积</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="建筑面积" name="projectShopsFormMap.CoveredArea">㎡</div>
		</div>
		<div class="row">
			<label for="" class="labw130">商业面积</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="商业面积" name="projectShopsFormMap.CommercialArea">㎡</div>
			<label for="" class="labw130">交付日期</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="交付日期" id="DeliveryDate" name="projectShopsFormMap.DeliveryDate"></div>
		</div>
		<div class="row">
			<label for="" class="labw130">绿化率</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="绿化率" name="projectShopsFormMap.GreeningRate">%</div>
			<label for="" class="labw130">容积率</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="容积率" name="projectShopsFormMap.PlotRatio">%</div>
		</div>
		<div class="row">
			<label for="" class="labw130">开盘时间 *</label>
            <div class="inpdiv190"><input type="text" class="inpw100" placeholder="开盘时间"  id="saleStartTime" name="projectShopsFormMap.saleStartTime"></div>

			<label for="" class="labw130">商铺数量</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="公司负责人姓名" name="projectShopsFormMap.ShopCount"></div>

		</div>
		<div class="row">
			<label for="" class="labw130">公司负责人 *</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="公司负责人姓名" name="projectShopsFormMap.firstPerson"></div>
			<label for="" class="labw130">联系电话 *</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="公司负责人联系电话号码" name="projectShopsFormMap.firstTelephone"></div>
		</div>
		<div class="row">
			<label for="" class="labw130">项目负责人 *</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="项目负责人姓名" name="projectShopsFormMap.projectPerson"></div>
			<label for="" class="labw130">联系电话 *</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="项目负责人联系电话" name="projectShopsFormMap.projectTelephone"></div>
		</div>
		<div class="row">
			<label for="" class="labw130">项目描述 *</label>
			<textarea name="projectShopsFormMap.description" id="" cols="80" rows="5" placeholder="请输入内容" onkeyup="wordStatic(this);"
					  maxlength="500"></textarea>
			<div class="sum">已输入<span id="num">0</span>/500</div>
		</div>
		<div class="row">
			<label for="" class="labw130">项目推荐 *</label>
			<textarea name="projectShopsFormMap.RecommendReason" id="" cols="80" rows="5" placeholder="请输入内容"></textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">项目特点&项目卖点 *</label>
            <select class="selectpicker  inpw100 selw680 dealUser " data-style="btn-info" data-width="581px"
                    id="feature" multiple data-live-search="true" title="请选择项目特点&项目卖点"></select>
               <input type="hidden" id="features"name="projectShopsFormMap.prFeature" >
				<option value=""></option>
			</select>
		</div>
		<div class="row">
			<label for="" class="labw130">项目说辞</label>
			<textarea name="projectShopsFormMap.rhetoric" id="" cols="80" rows="5" placeholder="请输入'项目说辞[先洗脑，后推荐；区域讲解由大到小，突出商务核心商业商圈未来规划]'"></textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">区域地段地表价值</label>
			<textarea name="projectShopsFormMap.oneA" id="" cols="80" rows="5" placeholder="请输入'区域地段地标价值[政府如何规划，地段战略位置]'"></textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">立体交通网络价值</label>
			<textarea name="projectShopsFormMap.oneB" id="" cols="80" rows="5" placeholder="请输入'立体交通网络价值[地铁、公交等各类配套设施]'"></textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">商圈价值&人力消费价值</label>
			<textarea name="projectShopsFormMap.oneC" id="" cols="80" rows="5" placeholder="请输入'商圈价值&人力消费价值[周围商圈、人流]'"></textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">商业规划价值</label>
			<textarea name="projectShopsFormMap.twoA" id="" cols="80" rows="5" placeholder="请输入'商业规划价值'"></textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">业态价值</label>
			<textarea name="projectShopsFormMap.twoB" id="" cols="80" rows="5" placeholder="请输入'业态价值'"></textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">自然资源价值</label>
			<textarea name="projectShopsFormMap.twoC" id="" cols="80" rows="5" placeholder="请输入'自然资源价值'"></textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">投资保障价值</label>
			<textarea name="projectShopsFormMap.twoE" id="" cols="80" rows="5" placeholder="请输入'投资保障价值'"></textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">噱头式的宣传</label>
			<textarea name="projectShopsFormMap.propaganda" id="" cols="80" rows="5" placeholder="请输入'噱头式的宣传'"></textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">项目优势</label>
			<textarea name="projectShopsFormMap.advantage" id="" cols="80" rows="5" placeholder="请输入'项目优势[从项目说辞归纳总结出项目卖点he优势]'"></textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">项目抗性&应对措施</label>
			<textarea name="projectShopsFormMap.resistanceAndMeasures" id="" cols="80" rows="5" placeholder="请输入'项目抗性&应对措施'"></textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">项目属性适合业态</label>
			<textarea name="projectShopsFormMap.attributeFormat" id="" cols="80" rows="5" placeholder="请输入'项目属性适合业态'"></textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">结果</label>
			<textarea name="projectShopsFormMap.result" id="" cols="80" rows="5" placeholder="请输入'结果'"></textarea>
		</div>
		<div class="row rowbutton"><button  type="button" id="btn-test" class="btn-info submitbtn">立即提交</button> <button onclick="reset()">重置</button></div>
	</div>
</form>
</body>
<script src="${ctx}/js/system/project/isAddress.js"></script>
<script>

    $("#btn-test").click(function(){

        var o = document.getElementById("feature");//获取多选内容
        var str = [];
        for(var i=0;i<o.length;i++){
            if(o.options[i].selected){
                str.push(o.options[i].value);
            }
        }
        $("#features").val(str);

        $(this).attr("disabled","true"); //设置变灰按钮
        $("#form").submit();//提交表单
        setTimeout("$('#btn-test').removeAttr('disabled')",3000); //设置三秒后提交按钮 显示

    })
    layui.use('laydate', function() {
        var laydate = layui.laydate;

        //自定义格式
        laydate.render({
            elem: '#saleStartTime'
            , type: 'datetime'
        });
        //自定义格式
        laydate.render({
            elem: '#StartDate'
            , type: 'datetime'
        });
        //自定义格式
        laydate.render({
            elem: '#DeliveryDate'
            , type: 'datetime'
        });

    });
    function wordStatic(input) {
        // 获取要显示已经输入字数文本框对象
        var content = document.getElementById('num');
        if (content && input) {
            // 获取输入框输入内容长度并更新到界面
            var value = input.value;
            // 将换行符不计算为单词数
            value = value.replace(/\n|\r/gi, "");
            // 更新计数
            content.innerText = value.length;
        }
    }
    $(document).ready(function () {
        getFeature();
        addressInit('cmbProvince', 'cmbCity', 'cmbArea');

    });
    var Province = "";
    var city = "";
    var Area = "";
    var geo="";
    function contactposition(obj) {
        Province = $('#cmbProvince').val();
        city = $('#cmbCity').val()
        Area = $("#cmbArea").val();
        var p = $(obj).val();
        if (Area !== "" && p !== "") {
            $("#cmbposition").val( Area + p);
            var address = Province + city + Area + p
            $.ajax({
                url: "../project/getLatAndLng.shtml?address=" + address,
                type: 'get',
                dataType: 'json',
                success: function (res, error) {
                    geo=res.content
                    if (res.state == 1) {
                        $.ajax({
                            url: "http://fbd.fangqianli.com/FBD_FFX/Ffx_manage?method=add_geo&geo=" + res.content,
                            type: 'get',
                            dataType: 'json',
                            success: function (res, error) {
                                console.log(res)
                                if (res.state) {
                                    $.ajax({
                                        url: "http://fbd.fangqianli.com/FBD_FFX/FFX_Tools_Action?method=get_all_score&geo="+geo+"&data_type=2",
                                        type: 'get',
                                        dataType: 'json',
                                        success: function (res, error) {
                                            if (res.state){
                                                $("#score").val(JSON.stringify(res));
                                                $("#sum").val(res.ext.now_year.sum);

                                            }
                                            $("#latitude").val(geo)


                                        }
                                    })
                                }
                            }
                        })

                    }

                }
            })

        }

    }
    function getFeature() {
        $.ajax({
            "url": "../project/findFeature.shtml",
            "data": "",
            "type": "GET",
            "dataType": "json",
            "success": function (obj) {

                for (var i = 0; i < obj.length; i++) {
                    var str = "<option  value=" + obj[i].feature + ">" + obj[i].feature + "</option>";
                    $("#feature").append(str);
                    $('#feature').selectpicker('refresh');
                    $('#feature').selectpicker('render');

                }
            },
            error: function () {
                layer.alert("获取出错，请与管理员联系");
            }
        });
    }
    function getProjectBusiness(district) {

        $.ajax({
            "url": "../project/findProjectBusiness.shtml?district="+district,
            "data": "",
            "type": "POST",
            "dataType": "json",
            "success": function (obj) {

                for (var i = 0; i < obj.length; i++) {
                    var str = "<option value=" + obj[i].business + ">" + obj[i].business + "</option>";
                    $("#projecBusiness").append(str);


                }
                $("#projecBusiness").selectpicker('refresh');
                $("#projecBusiness").selectpicker('render');

            },
            error: function () {
                layer.alert("获取项目出错！请与管理员联系");
            }
        });
    }
    function bao(district) {
        $("#projecBusiness").html("");
        getProjectBusiness(district)

    }
    function reset(){
        $("#wrap input").val("");
    }



</script>

</html>