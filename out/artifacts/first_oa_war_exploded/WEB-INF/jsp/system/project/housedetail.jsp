<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/common.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<html>
<head>
	<meta charset="UTF-8">
	<meta name="keywords" content="房发现，成都商铺，成都商铺出售，成都商铺投资，成都公寓，成都商铺出租，成都房产网" />
	<meta content="房发现AI找房好平台为您匹配性价比高、安全性好、回报率稳定的优质好房源，1000名置业专属经纪人为您免费服务，为您放心买房保驾护航！" name="description" />
	<meta content="房发现-开启精准智能找房时代" name="author" />
	<meta id="webAuthor" content="2018 &copy; 成都房发现 by FFX." name="author" />
	<title>房发现官方网站，商铺出售，商铺投资，商铺出租，公寓出售，找房放心好平台！</title>

	<meta name="viewport" content="width=1200, initial-scale=1">
	<meta name="viewport" content="width=1200, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta name="viewport" content="width=1200, initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
	<!--图标-->
	<!--<link rel="shortcut icon" type="image/x-icon" href="images/log.png" />-->
	<!--bootstrap-css-->
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<!-- Font Awesome -->
	<link href="http://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<!--公共样式-->
	<!--<link rel="stylesheet" type="text/css" href="css/common.css" />-->
	<!--自己的样式-->
	<!--<link rel="stylesheet" type="text/css" href="css/index.css" />

    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />-->
	<style>
		.mar30 {
			margin-left: 30px;
		}

		.mar10 {
			margin-right: 10px;
		}

		.mapOut {
			position: relative;
		}

		.mapBox {
			width: 380px;
			height: 400px;
			position: absolute;
			bottom: 0px;
			right: -10px;
			border: 1px solid #fff;
			background-color: rgba(255,255,255,0.8)
		}

		.mapBoxhide {
			width: 40px;
			height: 400px;
			position: absolute;
			bottom: 0px;
			right: -10px;
			border: 1px solid #fff;
			background-color: rgba(255,255,255,0.8)
		}

		.tab-title {
			font-size: 16px;
			line-height: 50px;
			text-align: center;
			padding-left: 0px;
			padding-right: 0px;
			border: 1px solid #eee;
		}

		.fz24 {
			font-size: 18px;
			font-weight: bold;
			text-align: center;
		}

		.borderAll li {
			border: 1px solid #ccc;
			line-height: 30px;
			font-size: 16px;
			text-align: center;
		}

		.scall {
			overflow-y: scroll;
			width: auto;
			height: 300px;
		}

		.scalls {
			overflow-y: scroll;
			width: auto;
			height: 378px;
		}

		.facilities {
			clear: both;
			margin: 15px 5px;
		}

		.facilities div {
			float: left;
			padding: 7px;
			font-size: 14px;
			border: 1px solid #ccc;
		}

		.padding-right40 {
			padding-right: 40px;
		}

		.maiginLeft5 {
			margin-left: 14px;
		}

		.scanBtn {
			width: 20px;
			height: 40px;
			line-height: 40px;
			background-color: #ccc;
			color: #fff;
			font-size: 20px;
			position: absolute;
			top: 160px;
			left: 0px;
		}

		.scanBtnhide {
			width: 20px;
			height: 40px;
			line-height: 40px;
			background-color: #ccc;
			position: absolute;
			top: 160px;
			left: 0px;
			color: #fff;
			font-size: 20px;
		}

		#submenuList {
			width: 357px !important;
		}

		#navbs-fixt-top {
			width: 1170px;
			height: auto;
			background-color: #fff;
		}

		.btn-border {
			border: 1px solid #ddd;
			background-color: #fff;
		}

		.fiex {
			position: fixed;
			top: 6%;
			z-index: 1031;
		}

		table th {
			text-align: center;
			font-size: 16px;
		}

		.text-color {
			color: #337ab7 !important;
		}

		.border {
			border-bottom: 1px solid #ccc;
		}

		hr {
			margin-top: 20px;
			margin-bottom: 10px;
			border: 0;
			border-top: 1px solid #eee;
		}

		.one-text {
			color: #c9302c;
		}

		.linH2 {
			line-height: 2;
			text-align: justify;
		}

		ul li {
			list-style: none;
		}
		.fz16{
			font-size:16px;
		}
		.fz18 {
			font-size: 16px;
		}
		.mar-b{
			margin-bottom:0px;
		}
		.bold{
			font-weight:bold;
		}
		.display{
			display:none;
		}
		.mt15{
			margin-top:15px;
		}
		.label {
			display: inline;
			padding: .6em .6em;
			font-size: 75%;
			font-weight: 700;
			line-height: 1;
			color: #fff;
			text-align: center;
			white-space: nowrap;
			vertical-align: baseline;
			border-radius: .25em;
		}
		.red{
			color:#f25252;
		}
		.cursor{
			cursor:pointer;
		}
	</style>
</head>

<body>

<!--内容开始-->

<div class="container">
	<h3 class="projectName">项目名称</h3>
	<div class="">
		<button type="button" class="btn btn-danger state mar10 glyphicon glyphicon-chevron-right">${state}</button>
		<button type="button" class="btn btn-primary type mar10 glyphicon glyphicon-chevron-right"> </button>
		<button type="button" class="btn btn-info lease mar10 glyphicon glyphicon-chevron-right"> </button>
	</div>
	<div class="panel panel-default mt15">
		<div class="panel-body">
			<div class="row">
				<div class="col-lg-6">
					<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							<li data-target="#carousel-example-generic" data-slide-to="3"></li>
							<li data-target="#carousel-example-generic" data-slide-to="4"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox" id="detailPics">
							<div class="item active" id="detailActive">

								<!--<img class="img-responsive" src="images/gif.gif" />-->
							</div>

						</div>

						<!-- Controls -->
						<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
							<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a>
						<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
							<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
							<span class="sr-only">Next</span>
						</a>
					</div>
				</div>
				<div class="col-lg-5 mar30">
					<ul class="list-group">
						<li class="list-group-item">参考单价：<span class="fz18 red" id="price"></span></li>
						<li class="list-group-item">参考总价：<span class="fz18 red" id="prices"></span></li>
						<li class="list-group-item">面积区间：<span class="fz16 red" id="area"></span></li>
						<li class="list-group-item">项目状态：<span class="state red"></span></li>
						<li class="list-group-item">项目位置：<span id="projectPosition"></span></li>
					</ul>
					<div id="tese">
						<!--<span class="label label-danger state">在售</span>
                    <span class="label label-primary type">商铺</span>-->
					</div>
					<hr />
					<button type="button" class="btn btn-danger btn-lg"><i class="fa fa-volume-control-phone" aria-hidden="true"></i> 菲斯特负责人：<span class="firstPerson fz16"></span>  <span class="firstTelephone fz16"></span></button>

				</div>
			</div>
		</div>
	</div>
	<!-- 楼盘详情 -->
	<div>
		<div>
			<!-- 楼盘详情 -->
			<div class="panel panel-default">
				<div class="panel-heading"><p class="fz18 mar-b bold"><i class="fa fa-building red" aria-hidden="true"></i> 楼盘详情 </p></div>
				<div class="panel-body">
					<p class="description linH2 fz16"></p>
					<p class="linH2 fz16" id="propaganda"></p>
				</div>
			</div>
			<!-- 楼盘价值 -->
			<div class="panel panel-default">
				<div class="panel-heading"><p class="fz18 mar-b bold"><i class="fa fa-building red" aria-hidden="true"></i> 区域地段地标价值 </p></div>
				<div class="panel-body">
					<p class="linH2"><span class="oneA fz16"></span></p>
					<div>
						<div id="allmap" style="width: 100%; height: 395px; overflow: hidden; margin: 0; font-family: '微软雅黑';"></div>
						<div class="mapOut">
							<div class="mapBox ">
								<div class="btn-group maiginLeft5" role="group" aria-label="...">
									<button type="button" class="btn btn-default" id="traffMenu">交通</button>
									<button type="button" class="btn btn-default" id="storeMenu">商场</button>
									<button type="button" class="btn btn-default" id="apartMenu">小区</button>
									<button type="button" class="btn btn-default" id="hosptiolMenu">医院</button>
									<button type="button" class="btn btn-default" id="schoolMenu">学校</button>
									<button type="button" class="btn btn-default" id="sceneryMenu">景区</button>
								</div>
								<div class="submenu mt15 cursor maiginLeft5">
									<span class="label label-danger" id="traffMenubus">公交</span>
									<span class="label label-primary" id="traffMenusub">地铁</span>
									<span class="label label-success" id="traffMenucar">汽车</span>
									<span class="label label-info" id="traffMenutrainkeyun">火车客运站</span>
									<span class="label label-warning" id="traffMenutrainhuoyun">火车货运站</span>
								</div>
								<div class="submenus mt15 maiginLeft5 cursor">
									<span class="label label-danger" id="schoolMenuyou">幼儿园</span>
									<span class="label label-primary" id="schoolMenuxiao">小学</span>
									<span class="label label-success" id="schoolMenuzhong">中学</span>
									<span class="label label-info" id="schoolMenuda">大学</span>
								</div>
								<div class="mt15 clearfix">
									<div class="list-group scall pull-right" id="submenuList"></div>
								</div>
								<div class="scanBtn">
									<span class="glyphicon glyphicon-triangle-right" aria-hidden="true"></span>
								</div>
							</div>
							<div class="mapBoxhide display">
								<div class="scanBtnhide">
									<span class="glyphicon glyphicon-triangle-left" aria-hidden="true"></span>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading"><p class="fz18 mar-b bold"><i class="fa fa-building red" aria-hidden="true"></i> 立体交通网络价值 </p></div>
				<div class="panel-body">
					<p class="linH2 fz16"><span class="oneB fz16"></span></p>

				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading"><p class="fz18 mar-b bold"><i class="fa fa-building red" aria-hidden="true"></i> 商圈价值与人力消费价值 </p></div>
				<div class="panel-body">
					<p class="linH2 fz16"><span class="oneC fz16"></span></p>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading"><p class="fz18 mar-b bold"><i class="fa fa-building red" aria-hidden="true"></i> 商业规划价值 </p></div>
				<div class="panel-body">
					<p class="linH2 fz16"><span class="twoA fz16"></span></p>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading"><p class="fz18 mar-b bold"><i class="fa fa-building red" aria-hidden="true"></i> 业态价值 </p></div>
				<div class="panel-body">
					<p class="linH2 fz16"><span class="twoB fz16"></span></p>

				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading"><p class="fz18 mar-b bold"><i class="fa fa-building red" aria-hidden="true"></i> 自然资源价值 </p></div>
				<div class="panel-body">
					<p class="linH2 fz16"><span class="twoC fz16"></span></p>

				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading"><p class="fz18 mar-b bold"><i class="fa fa-building red" aria-hidden="true"></i> 投资保障价值 </p></div>
				<div class="panel-body">
					<p class="linH2 fz16"><span class="twoE fz16"></span></p>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading"><p class="fz18 mar-b bold"><i class="fa fa-building red" aria-hidden="true"></i> 项目抗性&应对措施 </p></div>
				<div class="panel-body">
					<p class="linH2 fz16"><span class="resistanceAndMeasures fz16"></span></p>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading"><p class="fz18 mar-b bold"><i class="fa fa-building red" aria-hidden="true"></i> 项目属性适合业态 </p></div>
				<div class="panel-body">
					<p class="linH2 fz16"><span class="attributeFormat fz16"></span></p>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading"><p class="fz18 mar-b bold"><i class="fa fa-building red" aria-hidden="true"></i> 项目特点 </p></div>
				<div class="panel-body">
					<p class="linH2 fz16"><span class="prFeature fz16"></span></p>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading"><p class="fz18 mar-b bold"><i class="fa fa-building red" aria-hidden="true"></i> 项目说辞 </p></div>
				<div class="panel-body">
					<p class="linH2 fz16"><span class="rhetoric fz16"></span></p>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading"><p class="fz18 mar-b bold"><i class="fa fa-building red" aria-hidden="true"></i> 项目优势 </p></div>
				<div class="panel-body">
					<p class="linH2 fz16"><span class="advantage fz16"></span></p>
				</div>
			</div>

			<!-- 户型介绍 -->
			<div class="panel panel-default">
				<div class="panel-heading"><p class="fz18 mar-b bold"><i class="fa fa-university red" aria-hidden="true"></i> 户型介绍 </p></div>
				<div class="panel-body">
					<p id="main"></p>
				</div>
			</div>
		</div>
	</div>
	<!-- 销控 -->
	<div id="saleFang">
		<div class="panel panel-default divfang1">
			<div class="panel-heading"><p class="fz18 mar-b bold"><i class="fa fa-home red" aria-hidden="true"></i> 在售房源 </p></div>
			<div class="panel-body2">
				<div class="row" style="margin-left:0px; margin-right:0px; text-align:center; text-align:center; font-size:16px; padding:10px 0;">
					<div class="col-lg-3 border">商铺名称</div>
					<div class="col-lg-3 border">商铺类型</div>
					<div class="col-lg-3 border">商铺简介</div>
					<div class="col-lg-3 border">商铺状态</div>
					<div style="width:100%;overflow-y:auto;height:200px; overflow-x:hidden; margin-top:15px;" id="contact">

					</div>
				</div>
			</div>
		</div>
	</div>
</div>



<!--内容结束-->
<!--聊天-->
<div id="chatBox"></div>

<!--页脚-->
<!--footer-->
<div id="footer"></div>
<!--footend-->
<!--jquery-->
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->








<!-- 模板 -->
<script src="../../../../js/system/project/art-template-web.js" type="text/javascript" charset="utf-8"></script>

<script type="text/html" id="mytemple2">
	{{if data}}{{each data value i}}
	<div class="row" style="margin-left:0px; text-align:center; margin-top:15px;">
		<div class="col-lg-3 border">{{data[i].trait}}{{data[i].shopNumber}}铺</div>
		{{if data[i].trait===""||data[i].trait===null}}
		<div class="col-lg-3 border">正在采集中...</div>
		{{else}}
		<div class="col-lg-3 border">{{data[i].trait}}</div>
		{{/if}}
		<div class="col-lg-3 border"><i class="fa fa-yen"></i>&nbsp;&nbsp;{{data[i].totalPrice}} 万&nbsp;&nbsp;<i class="fa fa-home"></i>&nbsp;&nbsp;{{data[i].forecastBuilding}} ㎡</div>
		<div class="col-lg-3 border">{{data[i].sell}}</div>
	</div>
	{{/each}}{{/if}}
</script>




<!-- 更多报表--区域医疗数据报告 -->
<script type="text/html" id="mytemple24">
	{{if ext}} {{each ext value i}}{{each ext[i].data value j}}
	<a class="list-group-item">
		<span class="badge">{{ext[i].data[j].distance}} m</span>
		{{ext[i].data[j].name}}
	</a>
	{{/each}}{{/each}} {{/if}}
</script>
<script type="text/html" id="mytemple25">
	{{if ext}} {{each ext value i}}
	<a class="list-group-item">
		<span class="badge">{{ext[i].distance}} m</span>
		{{ext[i].name}}
	</a>
	{{/each}} {{/if}}
</script>

<!--地图-->
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=x0baOoLE2m6N9QKwHcZv8e53"></script>



<script type="text/javascript">

    var _IDs =${IDs};
    console.log(_IDs)
    _http = "http://fbd.fangqianli.com/FBD_FFX/";
    //经纬度
    var latitude = ""; //维度
    var longitude = ""; //经度
    var adurl = "http://bd.fangfaxian.com/PrDC/FFXGetPrIdInfoList/";
    $.ajax({
        type: "GET",
        url: adurl,
        data: {
            id: _IDs
        },
        async: true,
        dataType: "json",
        success: function (datas) {
            // console.log(datas);

            if (datas.state === true) {
                var latitudes = datas.data[0].latitude;
                //console.log(latitudes);
                //经纬度
                longitude = (latitudes.split(","))[0];//纬度
                latitude = (latitudes.split(","))[1];//经度
                //console.log(latitude);
                //console.log(longitude);
                var projectName = datas.data[0].projectName;//获取项目别名
                $(".projectName").html(projectName);

                var type = datas.data[0].type;//项目类型
                $(".type").html(type);

                var state = datas.data[0].state;//项目状态
                $(".state").html(state);

                var lease = datas.data[0].lease;//带租约
                $(".lease").html(lease);

                var prices = datas.data[0].prices;//最低单价
                var pricee = datas.data[0].pricee;//最高单价
                $("#price").html(prices + "元/㎡--" + pricee + "元/㎡");

                var pricess = datas.data[0].pricess;//最低总价
                var pricese = datas.data[0].pricese;//最高总价
                $("#prices").html(pricess + "万--" + pricese + "万");

                var areas = datas.data[0].areas;//最低面积
                var areae = datas.data[0].areae;//最高面积
                $("#area").html(areas + "㎡--" + areae + "㎡");

                var projectPosition = datas.data[0].projectPosition;//项目位置
                $("#projectPosition").html(projectPosition);

                var description = datas.data[0].description;//项目描述
                $(".description").html(description);



                //楼盘价值
                var oneA = datas.data[0].oneA;//区域地段地标价值
                var oneB = datas.data[0].oneB;//立体交通网络价值
                var oneC = datas.data[0].oneC;//商圈价值与人力消费价值
                var twoA = datas.data[0].twoA;//商业规划价值
                var twoB = datas.data[0].twoB;//业态价值
                var twoC = datas.data[0].twoC;//自然资源价值
                var twoD = datas.data[0].twoD;//商铺价值
                var twoE = datas.data[0].twoE;//投资保障价值
                if (oneA === "" || oneA === null) {
                    $(".oneA").html("资料整理中...");
                } else {
                    $(".oneA").html(oneA);
                }
                if (oneB === "" || oneB === null) {
                    $(".oneB").html("资料整理中...");
                } else {
                    $(".oneB").html(oneB);
                }
                if (oneC === "" || oneC === null) {
                    $(".oneC").html("资料整理中...");
                } else {
                    $(".oneC").html(oneC);
                }
                if (twoA === "" || twoA === null) {
                    $(".twoA").html("资料整理中...");
                } else {
                    $(".twoA").html(twoA);
                }
                if (twoB === "" || twoB === null) {
                    $(".twoB").html("资料整理中...");
                } else {
                    $(".twoB").html(twoB);
                }
                if (twoC === "" || twoC === null) {
                    $(".twoC").html("资料整理中...");
                } else {
                    $(".twoC").html(twoC);
                }
                if (twoD === "" || twoD === null) {
                    $(".twoD").html("资料整理中...");
                } else {
                    $(".twoD").html(twoD);
                }
                if (twoE === "" || twoE === null) {
                    $(".twoE").html("资料整理中...");
                } else {
                    $(".twoE").html(twoE);
                }

                //项目抗性&应对措施
                var resistanceAndMeasures = datas.data[0].resistanceAndMeasures;
                if (resistanceAndMeasures === "" || resistanceAndMeasures === null) {
                    $(".resistanceAndMeasures").html("资料整理中...");
                } else {
                    $(".resistanceAndMeasures").html(resistanceAndMeasures);
                }
                //项目属性适合业态
                var attributeFormat = datas.data[0].attributeFormat;
                if (attributeFormat === "" || attributeFormat === null) {
                    $(".attributeFormat").html("资料整理中...");
                } else {
                    $(".attributeFormat").html(attributeFormat);
                }

                //项目特点
                var prFeature = datas.data[0].prFeature;//项目特点
                // $("#prFeature").html(prFeature);
                var arrprFeature = prFeature.split(",");
                //console.log(arrprFeature);
                for (var i = 0; i < arrprFeature.length && i < 3; i++) {
                    //console.log(arrprFeature[i]);
                    $("#tese").append("<span class='label label-danger state'style='margin-right:10px; padding:8px 10px; font-size:16px;'>" + arrprFeature[i] + "</span>");
                }

                if (prFeature === "" || prFeature === null) {
                    $(".prFeature").html("资料整理中...");
                } else {
                    $(".prFeature").html(prFeature);
                }
                //项目说辞rhetoric
                var rhetoric = datas.data[0].rhetoric;

                if (rhetoric === "" || rhetoric === null) {
                    $(".rhetoric").html("资料整理中...");
                } else {
                    $(".rhetoric").html(rhetoric);
                }
                //项目优势
                var advantage = datas.data[0].advantage;

                if (advantage === "" || advantage === null) {
                    $(".advantage").html("资料整理中...");
                } else {
                    $(".advantage").html(advantage);
                }
                //噱头式的宣传
                var propaganda = datas.data[0].propaganda;
                $("#propaganda").html(propaganda);



                var imgPathHss = datas.data[0].imgPathH;//户型图
                var imgPathP = datas.data[0].imgPathP;//配套图
                var imgPathS = datas.data[0].imgPathS;//实景图
                var imgPathX = datas.data[0].imgPathX;//效果图
                //console.log(imgPathHss.length);

                //合并数组
                var imgArr = [];
                //先判断
                if (imgPathHss.length === 0) {
                    imgArr = imgPathX.concat(imgPathP, imgPathS);
                } else if (imgPathP.length === 0) {
                    imgArr = imgPathX.concat(imgPathHss, imgPathS);
                } else if (imgPathS === 0) {
                    imgArr = imgPathX.concat(imgPathHss, imgPathP);
                } else if (imgPathX === 0) {
                    imgArr = imgPathS.concat(imgPathHss, imgPathP);
                } else {
                    imgArr = imgPathX.concat(imgPathP, imgPathS, imgPathHss);
                }
                //console.log(imgArr);

                $("#detailActive").html("<img src='http://bd.fangfaxian.com" + imgArr[2] + "' alt='房发现'>"); //封面图
                for (var d = 0; d < imgArr.length; d++) {
                    //console.log(imgPathX[d]);
                    var imgArrContent = "<div class='item'><img src='http://bd.fangfaxian.com" + imgArr[d] + "'alt='成都房发现'></div>";
                    $("#detailPics").append(imgArrContent);

                }


                var imgPathH = datas.data[0].imgPathH[0];//户型图
                var imgPathHs = datas.data[0].imgPathH;//户型图
                //if (imgPathHs.length === 0) {
                //    $("#pro").addClass("display");
                //} else {
                //    $("#pro").removeClass("display");
                //    $("#main").html("<p><a href='http://bd.fangfaxian.com" + imgPathH + "' rel='lightbox' title='Double click for full size'><img style='width: 100%; ' src='http://bd.fangfaxian.com" + imgPathH + "' /></a> </p>");
                //}
                if (imgPathHs.length === 0) {
                    $("#main").html("资料整理中... ");
                } else {

                    $("#main").html("<img class='img-responsive' src='http://bd.fangfaxian.com" + imgPathH + "' />");
                }



                firstPerson = datas.data[0].firstPerson;//项目负责人
                $(".firstPerson").html(firstPerson);

                var firstTelephone = datas.data[0].firstTelephone;//项目负责人电话
                $(".firstTelephone").html(firstTelephone);

                map();



                //商铺list销控
                $.ajax({
                    type: "GET",
                    url: "http://bd.fangfaxian.com/ShopDC/FFXGetShopPrIdInfoList/",
                    async: true,
                    data: {
                        "id": _IDs//项目id
                    },
                    dataType: "json",
                    success: function (datas) {
                        //console.log(datas);

                        if (datas.state === true) {
                            if (datas.data.length === 0) {
                                $("#saleFang").addClass("display");
                            } else {
                                var html2 = template('mytemple2', datas);
                                $("#contact").append(html2);
                            }
                        } else {
                            $(".divfang1").addClass("display");
                        }


                    }, error: function (err) {
                        //console.log(err);
                    }
                });




            } else {
                console.log(message);
            }


        }, error: function (err) {
            //console.log(err);
        }
    });



    $(".scanBtn").click(function () {
        //alert("000");
        $(".mapBox").hide();
        $(".mapBoxhide").show();
    });
    $(".mapBoxhide").click(function () {
        //alert("000");
        $(".mapBox").show();
        $(".mapBoxhide").hide();
    });

    function map() {
        //console.log(latitude);
        //console.log(longitude);
        _urls = _http + "";
        _method = "";
        _parent = "";
        _dis = "";

        //地图
        $(".submenus").hide();
        var allurl = _http + "Traffic";
        var allmethod = "get_traffic_info";
        var allicon = "../img/project/bus.png";
        var alltype = "1";
        allMap(allurl, allmethod, alltype, allicon);

        //点击交通
        $("#traffMenu").click(function () {
            $(".submenus").hide();
            $(".submenu").show();
            var allurl = _http + "Traffic";
            var allmethod = "get_traffic_info";
            var allicon = "../img/project/bus.png";
            var alltype = "1";
            allMap(allurl, allmethod, alltype, allicon);
        });
        //点击交通-公交
        $("#traffMenubus").click(function () {
            var allurl = _http + "Traffic";
            var allmethod = "get_traffic_info";
            var allicon = "../img/project/bus.png";
            var alltype = "1";
            allMap(allurl, allmethod, alltype, allicon);
        });
        //点击交通-地铁
        $("#traffMenusub").click(function () {
            var allurl = _http + "Traffic";
            var allmethod = "get_traffic_info";
            var allicon = "../../../../img/project/sub.png";
            var alltype = "2";
            allMap(allurl, allmethod, alltype, allicon);
        });
        //点击交通-汽车
        $("#traffMenucar").click(function () {
            var allurl = _http + "Traffic";
            var allmethod = "get_traffic_info";
            var allicon = "../../../../img/projet/sub.png";
            var alltype = "4";
            allMap(allurl, allmethod, alltype, allicon);
        });
        //点击交通-火车客运
        $("#traffMenutrainkeyun").click(function () {
            var allurl = _http + "Traffic";
            var allmethod = "get_traffic_info";
            var allicon = "../../../../img/projet/train.png";
            var alltype = "5";
            allMap(allurl, allmethod, alltype, allicon);
        });
        //点击交通-火车客运
        $("#traffMenutrainhuoyun").click(function () {
            var allurl = _http + "Traffic";
            var allmethod = "get_traffic_info";
            var allicon = "../../../../img/projet/train.png";
            var alltype = "6";
            allMap(allurl, allmethod, alltype, allicon);
        });

        //点击商场
        $("#storeMenu").click(function () {
            $(".submenu").hide();
            $(".submenus").hide();
            var allurl1 = _http + "Agent";
            var allmethod1 = "get_inner_info";
            var allicon1 = "../img/project/shop.png";
            var allid = "17";
            allMap2(allurl1, allmethod1, allid, allicon1);
        });
        //点击小区
        $("#apartMenu").click(function () {
            $(".submenu").hide();
            $(".submenus").hide();
            var allurl1 = _http + "Neighbourhood";
            var allmethod1 = "get_all_info";
            var allicon1 = "../img/project/xiaoqu.png";
            var allid = "17";
            allMap2(allurl1, allmethod1, allid, allicon1);
        });
        //点击医院
        $("#hosptiolMenu").click(function () {
            $(".submenu").hide();
            $(".submenus").hide();
            var allurl1 = _http + "Agent";
            var allmethod1 = "get_inner_info";
            var allicon1 = "../img/project/yiyuan.png";
            var allid = "5";
            allMap2(allurl1, allmethod1, allid, allicon1);
        });
        //点击学校
        $("#schoolMenu").click(function () {
            $(".submenu").hide();
            $(".submenus").show();
            var allurl1 = _http + "Agent";
            var allmethod1 = "get_inner_info";
            var allicon1 = "../img/project/youeryuan.png";
            var allid = "7";
            allMap2(allurl1, allmethod1, allid, allicon1);
        });
        //点击学校-幼儿园
        $("#schoolMenuyou").click(function () {
            $(".submenu").hide();
            $(".submenus").show();
            var allurl1 = _http + "Agent";
            var allmethod1 = "get_inner_info";
            var allicon1 = "../img/project/youeryuan.png";
            var allid = "7";
            allMap2(allurl1, allmethod1, allid, allicon1);
        });
        //点击学校-小学
        $("#schoolMenuxiao").click(function () {
            $(".submenu").hide();
            $(".submenus").show();
            var allurl1 = _http + "Agent";
            var allmethod1 = "get_inner_info";
            var allicon1 = "../img/project/xiaoxue.png";
            var allid = "7";
            allMap2(allurl1, allmethod1, allid, allicon1);
        });
        //点击学校-中学
        $("#schoolMenuzhong").click(function () {
            $(".submenu").hide();
            $(".submenus").show();
            var allurl1 = _http + "Agent";
            var allmethod1 = "get_inner_info";
            var allicon1 = "../img/project/zhongxue.png";
            var allid = "7";
            allMap2(allurl1, allmethod1, allid, allicon1);
        });
        //点击学校-大学
        $("#schoolMenuda").click(function () {
            $(".submenu").hide();
            $(".submenus").show();
            var allurl1 = _http + "Agent";
            var allmethod1 = "get_inner_info";
            var allicon1 = "../img/project/daxue.png";
            var allid = "7";
            allMap2(allurl1, allmethod1, allid, allicon1);
        });

        //点击景区
        $("#sceneryMenu").click(function () {
            $(".submenu").hide();
            $(".submenus").hide();
            var allurl1 = _http + "Agent";
            var allmethod1 = "get_inner_info";
            var allicon1 = "../img/project/jingqu.png";
            var allid = "9";
            allMap2(allurl1, allmethod1, allid, allicon1);
        });

        //交通
        function allMap(_urls, _method, _type, _icon) {
            var map = new BMap.Map("allmap");
            map.centerAndZoom(new BMap.Point(longitude, latitude), 14);  // 初始化地图,设置中心点坐标和地图级别
            //map.enableScrollWheelZoom(false); // 开启鼠标滚轮缩放
            map.addControl(new BMap.NavigationControl());
            map.addControl(new BMap.NavigationControl());
            map.addControl(new BMap.OverviewMapControl());
            map.addControl(new BMap.ScaleControl);
            map.setCurrentCity("成都");
            var new_points = new BMap.Point(longitude, latitude);
            var markers = new BMap.Marker(new_points);  // 创建标注
            map.addOverlay(markers);              // 将标注添加到地图中
            map.panTo(new_points);

            $.ajax({
                type: "get",
                url: _urls,
                data: {
                    method: _method,
                    geo: longitude + "," + latitude,
                    dis: "1000",
                    type: _type
                },
                //返回数据的格式
                datatype: "json",
                //成功返回之后调用的函数
                success: function (data) {
                    //console.log(data);

                    if (data.state === true) {

                        var html24 = template('mytemple24', data);
                        $("#submenuList").html(html24);
                        /*===============3==*/
                        var myIcons = new BMap.Icon(_icon, new BMap.Size(40, 45)),
                            opts = {
                                width: 250,     // 信息窗口宽度
                                height: 80,     // 信息窗口高度
                                title: "地点:", // 信息窗口标题
                                //                          distance:'距离:',
                                enableMessage: true//设置允许信息窗发送短息
                            };

                        if (data.ext.length !== 0) {
                            for (var x = 0; x < data.ext[0].data.length; x++) {
                                var lng = data.ext[0].data[x].lat;
                                var lat = data.ext[0].data[x].lon;
                                var marker = new BMap.Marker(new BMap.Point(lat, lng), { icon: myIcons });  // 创建标注
                                var content = data.ext[0].data[x].name;
                                map.addOverlay(marker);// 将标注添加到地图中
                                addClickHandler(content, marker);

                                function addClickHandler(content, marker) {
                                    marker.addEventListener("mouseover", function (e) {
                                        openInfo(content, e);
                                    });
                                }

                                function openInfo(content, e) {
                                    var p = e.target;
                                    var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
                                    var infoWindow = new BMap.InfoWindow(content, opts);  // 创建信息窗口对象
                                    map.openInfoWindow(infoWindow, point); //开启信息窗口
                                }
                            }
                        }




                        /*================12=*/
                    }
                    else {
                        console.log(data.message);
                    }
                },
                error: function () {
                    //            console.log(data.message)
                }
            });
        }
        //其他
        function allMap2(_urls, _method, _id, _icon) {
            var map = new BMap.Map("allmap");
            map.centerAndZoom(new BMap.Point(longitude, latitude), 14);  // 初始化地图,设置中心点坐标和地图级别
            // map.enableScrollWheelZoom(false); // 开启鼠标滚轮缩放
            map.addControl(new BMap.NavigationControl());
            map.addControl(new BMap.NavigationControl());
            map.addControl(new BMap.OverviewMapControl());
            map.addControl(new BMap.ScaleControl);
            map.setCurrentCity("成都");
            var new_points = new BMap.Point(longitude, latitude);
            var markers = new BMap.Marker(new_points);  // 创建标注
            map.addOverlay(markers);              // 将标注添加到地图中
            map.panTo(new_points);

            $.ajax({
                type: "get",
                url: _urls,
                data: {
                    method: _method,
                    geo: longitude + "," + latitude,
                    dis: "1000",
                    password: '123',
                    parent_id: _id
                },
                //返回数据的格式
                datatype: "json",
                //成功返回之后调用的函数
                success: function (data) {
                    //console.log(data);

                    if (data.state === true) {
                        var html25 = template('mytemple25', data);
                        $("#submenuList").html(html25);
                        /*===============3==*/
                        var myIcons = new BMap.Icon(_icon, new BMap.Size(40, 45)),
                            opts = {
                                width: 250,     // 信息窗口宽度
                                height: 80,     // 信息窗口高度
                                title: "地点:", // 信息窗口标题
                                //                          distance:'距离:',
                                enableMessage: true//设置允许信息窗发送短息
                            };
                        // console.log(data.ext);
                        for (var x = 0; x < data.ext.length; x++) {

                            var lng = data.ext[x].lat;
                            var lat = data.ext[x].lon;
                            //console.log(lng);
                            // console.log(lat);
                            var marker = new BMap.Marker(new BMap.Point(lat, lng), { icon: myIcons });  // 创建标注
                            var content = data.ext[x].name;
                            map.addOverlay(marker);// 将标注添加到地图中
                            addClickHandler(content, marker);

                            function addClickHandler(content, marker) {
                                marker.addEventListener("mouseover", function (e) {
                                        openInfo(content, e);
                                    }
                                );
                            }

                            function openInfo(content, e) {
                                var p = e.target;
                                var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
                                var infoWindow = new BMap.InfoWindow(content, opts);  // 创建信息窗口对象
                                map.openInfoWindow(infoWindow, point); //开启信息窗口
                            }
                        }



                        /*================12=*/
                    }
                    else {
                        // alert(data.message);
                    }
                },
                error: function () {
                    //            console.log(data.message)
                }
            });
        }
    }
</script>


</body>

</html>