<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/common.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<html>
<head>
<script type="text/javascript" src="${ctx}/js/system/project/editProjectShops.js">
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
<form class="" id="form" action="${ctx}/projectShops/editProjectShops.shtml" method="get">

	<div class="wrap" id="wrap">
        <input type="hidden" id="score"name="projectShopsFormMap.score" >
        <input type="hidden"  name="projectShopsFormMap.id" value="${projectShops.id}" />
        <input type="hidden" id="sum"name="projectShopsFormMap.sum" >
		<div class="row">
			<label for="" class="labw130">项目名称</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="请输入项目名称" name="projectShopsFormMap.projectName" value="${projectShops.projectName}"></div>
			<label for="" class="labw130">项目别名</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="请输入项目别名" name="projectShopsFormMap.Another_Name" value="${projectShops.Another_Name}"></div>
		</div>
		<div class="row">
			<label for="" class="labw130">状态</label>
			<input type="hidden" id="state" value="${projectShops.state}" />
			<div class="inpdiv190">
				<select class="selw100 inpw100"  id="selstate" name="projectShopsFormMap.state">
					<option value="">请选择</option>
					<option value="0">热销</option>
					<option value="1">待售</option>
					<option value="2">在售</option>
					<option value="3">认购</option>
					<option value="4">售罄</option>
				</select>
			</div>
			<label for="" class="labw130">排序权重</label>
			<input type="hidden" id="weight" value="${projectShops.weight}"/>
			<div class="inpdiv190">
				<select class="selw100 inpw100" id="selweight" name="projectShopsFormMap.weight">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>

				</select>
			</div>

		</div>

		<div class="row">
			<label for="" class="labw130">项目位置</label>
			<div class="inpdiv190">

				<input type="text" class="selw70 inpw100" name="projectShopsFormMap.province" id="province" value="${projectShops.province}" readonly="readonly">
				<input type="text" class="selw70 inpw100" name="projectShopsFormMap.city" id="city" value="${projectShops.city}" >
				<input type="text" class="selw70 inpw100" name="projectShopsFormMap.district" id="district" value="${projectShops.district}" >
			</div>
			<label for="" class="labw130">具体位置</label>
			<div class="inpdiv190"><input type="text" class="inpw100"   name="projectShopsFormMap.projectPosition"  value="${projectShops.projectPosition}" onchange="contactposition(this)" ></div>
			<input type="hidden"id="cmbposition">
			<input type="hidden" class="inpw100" placeholder="默认" id="latitude" name="projectShopsFormMap.latitude" readonly="readonly">
		</div>
		<div class="row">

				<label for="" class="labw130">是否带租约</label>
				<input type="hidden" id="lease" value="${projectShops.lease}"/>
				<div class="inpdiv190">
					<select class="selw100 inpw100" id="sellease" name="projectShopsFormMap.lease">
						<option value="">请选择</option>
						<option value="1">带租约</option>
						<option value="2">不带租约</option>
						<option value="3">部分带租约</option>
					</select>
				</div>
			<label for="" class="labw130">项目类型</label>
			<input type="hidden" id="projectType" value="${projectShops.projectType}"/>
<		<div class="inpdiv190">
				<select class="selw100 inpw100" id="selprojectType" name="projectShopsFormMap.projectType">
					<option value="">请选择</option>
					<option value="商业综合体">商业综合体</option>
					<option value="社区底商">社区底商</option>
				</select>
			</div>

		</div>
		<div class="row">
			<label for="" class="labw130">开发商</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="开发商"   value="${projectShops.Developers}" name="projectShopsFormMap.Developers"></div>
			<label for="" class="labw130">开建日期</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="开建日期"  value="${projectShops.StartDate}"  id="StartDate" name="projectShopsFormMap.StartDate"></div>
		</div>

		<div class="row">
			<label for="" class="labw130">区域</label>
			<input type="hidden" id="region" value="${projectShops.region}"/>
			<div class="inpdiv190"><select class="selw100 inpw100" id="selregion" name="projectShopsFormMap.region">
				<option value="">请选择</option>
				<option value="12">南区</option>
				<option value="13">北区</option>
				<option value="14">东区</option>
				<option value="15">西区</option>
			</select></div>
			<label for="" class="labw130">所属商圈</label>
			<input type="hidden" id="business" value="${projectShops.business}"/>
			<select class="selw100 inpw100"  id="projecBusiness"	name="projectShopsFormMap.business" >
			</select>
			<%--<select class="selectpicker projecBusiness " data-style="btn-danger" data-width="239px" id="projecBusiness"
					name="projectShopsFormMap.business" data-live-search="true" title="选择商圈"></select>
--%>
		</div>
		<div class="row">
			<label for="" class="labw130">面积区间</label>
			<div class="inpdiv190"><input type="text" class="inpw100 inpw80" placeholder="最小面积" name="projectShopsFormMap.areas" value="${projectShops.areas}">--
				<input type="text" class="inpw100 inpw80" placeholder="最大面积" name="projectShopsFormMap.areae" value="${projectShops.areae}">㎡</div>
			<label for="" class="labw130">单价区间</label>
			<div class="inpdiv190"><input type="text" class="inpw100 inpw80" placeholder="最低单价" name="projectShopsFormMap.prices" value="${projectShops.prices}">--
				<input type="text" class="inpw100 inpw80" placeholder="最高单价" name="projectShopsFormMap.pricee" value="${projectShops.pricee}">元</div>
		</div>
		<div class="row">
			<label for="" class="labw130">总价区间</label>
			<div class="inpdiv190"><input type="text" class="inpw100 inpw80" placeholder="最低总价" name="projectShopsFormMap.pricess" value="${projectShops .pricess}">--
				<input type="text" class="inpw100 inpw80" placeholder="最高总价" name="projectShopsFormMap.pricese" value="${projectShops.pricese}">万元</div>
			<label for="" class="labw130">项目佣金</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="项目佣金" name="projectShopsFormMap.commission" value="${projectShops.commission}"></div>
		</div>
		<div class="row">
			<label for="" class="labw130">占地面积</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="占地面积" name="projectShopsFormMap.FloorArea" value="${projectShops.FloorArea}">㎡</div>
			<label for="" class="labw130">建筑面积</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="建筑面积" name="projectShopsFormMap.CoveredArea" value="${projectShops.CoveredArea}"
			>㎡</div>
		</div>
		<div class="row">
			<label for="" class="labw130">商业面积</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="商业面积" name="projectShopsFormMap.CommercialArea" value="${projectShops.CommercialArea}">㎡</div>
			<label for="" class="labw130">交付日期</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="交付日期" id="DeliveryDate" name="projectShopsFormMap.DeliveryDate" value="${projectShops.DeliveryDate}"></div>
		</div>
		<div class="row">
			<label for="" class="labw130">绿化率</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="绿化率" name="projectShopsFormMap.GreeningRate" value="${projectShops.GreeningRate}">%</div>
			<label for="" class="labw130">容积率</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="容积率" name="projectShopsFormMap.PlotRatio" value="${projectShops.PlotRatio}"> %</div>
		</div>
		<div class="row">
			<label for="" class="labw130">开盘时间</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="开盘时间"  id="saleStartTime" value="${projectShops.saleStartTime}" name="projectShopsFormMap.saleStartTime"></div>
			<label for="" class="labw130">商铺数量</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="户数"  name="projectShopsFormMap.ShopCount" value="${projectShops.ShopCount}"></div>
		</div>

		<div class="row">
			<label for="" class="labw130">公司负责人</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="公司负责人姓名" name="projectShopsFormMap.firstPerson" value="${projectShops.firstPerson}"></div>
			<label for="" class="labw130">联系电话</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="公司负责人联系电话号码" name="projectShopsFormMap.firstTelephone" value="${projectShops.firstTelephone}"> </div>
		</div>
		<div class="row">
			<label for="" class="labw130">项目负责人</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="项目负责人姓名" name="projectShopsFormMap.projectShopsPerson" value="${projectShops.projectPerson}"></div>
			<label for="" class="labw130">联系电话</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="项目负责人联系电话" name="projectShopsFormMap.projectTelephone" value="${projectShops.projectTelephone}"></div>
		</div>
		<div class="row">
			<label for="" class="labw130">项目描述</label>
			<textarea name="projectShopsFormMap.description" id="" cols="80" rows="5" placeholder="请输入内容"	> ${projectShops.description}</textarea>

		</div>
		<div class="row">
			<label for="" class="labw130">项目推荐</label>
			<textarea name="projectShopsFormMap.RecommendReason" id="" cols="80" rows="5"  value="" placeholder="请输入内容" >${projectShops.RecommendReason}</textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">项目特点&项目卖点</label>
			<div class="inpdiv190"><input type="text" class="inpw100" style="width: 580px;"  id="features" name="projectShopsFormMap.prFeature" value="${projectShops.prFeature}"  ></div>
       <%--     <select class="selectpicker  inpw100 selw680 dealUser " data-style="btn-info" data-width="581px"
                    id="feature" multiple data-live-search="true" title="请选择项目特点&项目卖点"></select>
               <input type="hidden" id="features"name="projectShopsFormMap.prFeature" >
				<option value=""></option>
			</select>--%>
		</div>
		<div class="row">
			<label for="" class="labw130">项目说辞</label>
			<textarea name="projectShopsFormMap.rhetoric" id="" cols="80" rows="5"  value="" placeholder="请输入'项目说辞[先洗脑，后推荐；区域讲解由大到小，突出商务核心商业商圈未来规划]'">${projectShops.rhetoric}</textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">区域地段地表价值</label>
			<textarea name="projectShopsFormMap.oneA" id="" cols="80" rows="5"   value="" placeholder="请输入'区域地段地标价值[政府如何规划，地段战略位置]'">${projectShops.oneA}</textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">立体交通网络价值</label>
			<textarea name="projectShopsFormMap.oneB" id="" cols="80" rows="5"  value=""  placeholder="请输入'立体交通网络价值[地铁、公交等各类配套设施]'">${projectShops.oneB}</textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">商圈价值&人力消费价值</label>
			<textarea name="projectShopsFormMap.oneC" id="" cols="80" rows="5"  value="" placeholder="请输入'商圈价值&人力消费价值[周围商圈、人流]'">${projectShops.oneC}</textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">商业规划价值</label>
			<textarea name="projectShopsFormMap.twoA" id="" cols="80" rows="5"  value=""  placeholder="请输入'商业规划价值'">${projectShops.twoA}</textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">业态价值</label>
			<textarea name="projectShopsFormMap.twoB" id="" cols="80" rows="5"  value="" placeholder="请输入'业态价值'">${projectShops.twoB}</textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">自然资源价值</label>
			<textarea name="projectShopsFormMap.twoC" id="" cols="80" rows="5"  value="" placeholder="请输入'自然资源价值'">${projectShops.twoC}</textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">投资保障价值</label>
			<textarea name="projectShopsFormMap.twoE" id="" cols="80" rows="5"  value="" placeholder="请输入'投资保障价值'">${projectShops.twoE}</textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">噱头式的宣传</label>
			<textarea name="projectShopsFormMap.propaganda" id="" cols="80" rows="5"  value=""  placeholder="请输入'噱头式的宣传'">${projectShops.propaganda}</textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">项目优势</label>
			<textarea name="projectShopsFormMap.advantage" id="" cols="80" rows="5"  value="" placeholder="请输入'项目优势[从项目说辞归纳总结出项目卖点he优势]'">${projectShops.advantage}</textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">项目抗性&应对措施</label>
			<textarea name="projectShopsFormMap.resistanceAndMeasures" id="" cols="80" rows="5"  value=""  placeholder="请输入'项目抗性&应对措施'">${projectShops.resistanceAndMeasures}</textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">项目属性适合业态</label>
			<textarea name="projectShopsFormMap.attributeFormat" id="" cols="80" rows="5"  value="" placeholder="请输入'项目属性适合业态'">${projectShops.attributeFormat}</textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">结果</label>
			<textarea name="projectShopsFormMap.result" id="" cols="80" rows="5"   value="" placeholder="请输入'结果'">${projectShops.result}</textarea>
		</div>
		<div class="row rowbutton"><button  type="button" id="btn-test" class="btn-info submitbtn">立即提交</button> </div>
	</div>
</form>
</body>
<script src="${ctx}/js/system/project/isAddress.js"></script>
<script>

    $("#btn-test").click(function(){

       /* var o = document.getElementById("feature");//获取多选内容
        var str = [];
        for(var i=0;i<o.length;i++){
            if(o.options[i].selected){
                str.push(o.options[i].value);
            }
        }
        $("#features").val(str);*/

        $(this).attr("disabled","true"); //设置变灰按钮
        $("#form").submit();//提交表单
        setTimeout("$('#btn-test').removeAttr('disabled')",3000); //设置三秒后提交按钮 显示

    })
    layui.use('laydate', function() {
        var laydate = layui.laydate;

        //自定义格式
        laydate.render({
            elem: '#saleStartTime'
            ,format: 'yyyy年MM月dd日'
        });
        //自定义格式
        laydate.render({
            elem: '#StartDate'
            ,format: 'yyyy年MM月dd日'
        });
        //自定义格式
        laydate.render({
            elem: '#DeliveryDate'
            ,format: 'yyyy年MM月dd日'
        });

    });

    $(document).ready(function () {
       // getFeature();

        getProjectBusiness()
       var lease = $("#lease").val();
        var state = $("#state").val();
        var weight = $("#weight").val();
        var projectType = $("#projectType").val();
        var region = $("#region").val();


        //根据值让option选中

        $("#sellease option[value='" + lease + "']").attr("selected", "selected");
        $("#selstate option[value='" + state + "']").attr("selected", "selected");
        $("#selweight option[value='" + weight + "']").attr("selected", "selected");
        $("#selprojectType option[value='" + projectType + "']").attr("selected", "selected");
        $("#selregion option[value='" + region + "']").attr("selected", "selected");


    });
    var Province = "";
    var city = "";
    var Area = "";
    var geo="";
    function contactposition(obj) {
        Province = $('#province').val();
        city = $('#city').val()
        Area = $("#district").val();
        var p = $(obj).val();
        if (Area !== "" && p !== "") {
            $("#cmbposition").val(Area + p);
            var address = Province + city + Area + p
            console.log(address)
            $.ajax({
                url: "../project/getLatAndLng.shtml?address=" + address,
                type: 'get',
                dataType: 'json',
                success: function (res, error) {
                    console.log(res)
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
                                            console.log("yaya"+res)
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
    function getProjectBusiness() {
        $.ajax({
            "url": "../project/findProjectBusiness.shtml",
            "data": "",
            "type": "GET",
            "dataType": "json",
            "success": function (obj) {
                $("#projecBusiness").html("<option value=0> - - - -选择商圈- - - - </option>");
                for (var i = 0; i < obj.length; i++) {
                    var str = "<option value=" + obj[i].business + ">" + obj[i].business + "</option>";
                    $("#projecBusiness").append(str);

                }
                // $('.projectBusiness').selectpicker('refresh');
                // $('.projectBusiness').selectpicker('render');
                console.log("Dada223")
                let business = $("#business").val();
                $("#projecBusiness option[value='" +  business + "']").attr("selected",  "selected");
            },
            error: function () {
                layer.alert("获取项目出错！请与管理员联系");
            }
        });

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
                layer.alert("获取项目特点，请与管理员联系");
            }
        });
    }

</script>

</html>