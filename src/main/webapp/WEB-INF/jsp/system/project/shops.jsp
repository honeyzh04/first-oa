<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/common.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<html>
<style>
	.wrap {
		width: 1000px;
		font-size: 14px;
	}

	.inpw100 {
		width: 170px;
		height: 38px;
		line-height: 38px;
		border: 1px solid #cac5c5;
		background: #fff;
		border-radius: 2px;
		margin-right: 3px;
		padding-left: 3px;
		display: inline-block;
	}

	.labw130 {
		float: left;
		display: block;
		padding: 9px 15px;
		width: 130px;
		margin-left: 10px;
		font-weight: 400;
		line-height: 20px;
		text-align: right;
	}

	.inpdiv190 {
		float: left;
		width: 230px;
		margin-right: 50px;
	}

	.row {
		width: 100%;
		margin-bottom: 15px;
		margin-top: 20px;
		clear: both;
	}


	.selw100 {
		width: 170px;
	}


	option {
		height: 38px;
		line-height: 38px;
	}

	.rowbutton button {
		width: 100px;
		height: 38px;
		line-height: 38px;
		margin: 0px 10px;
		border-radius: 5px;
		border: 0px;
	}



	.imageDiv {
		display: inline-block;
		width: 160px;
		height: 120px;
		-webkit-box-sizing: border-box;
		-moz-box-sizing: border-box;
		box-sizing: border-box;
		border: 1px dashed darkgray;
		background: #f8f8f8;
		position: relative;
		overflow: hidden;
		margin: 10px
	}


	.cover .delbtn {
		color: red;
		font-size: 20px;
		z-index: 999;

	}

	.imageDiv:hover .cover {
		display: block;
	}

	.more {
		width: 592px;
		height: auto;
	}
</style>

<body>
<div class="wrap" id="wrap">
	<input type="hidden" name="shopsId" value="${shopsId}" id="shopsId" class="shopsId">
	<div class="row">
		<label for="" class="labw130">项目名称</label>
		<div class="inpdiv190">
			<div class="inpw100 prId"></div>
		</div>
		<label for="" class="labw130">商铺编号</label>
		<div class="inpdiv190">
			<div class="inpw100 shopNumber"></div>
		</div>
	</div>

	<div class="row">

		<label for="" class="labw130">预测建筑</label>
		<div class="inpdiv190">
			<div class="inpw100 forecastBuilding"></div>m²
		</div>
		<label for="" class="labw130">商铺面积</label>
		<div class="inpdiv190">
			<div class="inpw100 acreate"></div>m²
		</div>
	</div>
	<div class="row">
		<label for="" class="labw130">预测公摊</label>
		<div class="inpdiv190">
			<div class="inpw100 forecastPublicApportionment"></div>m²
		</div>
		<label for="" class="labw130">预测套内</label>
		<div class="inpdiv190">
			<div class="inpw100 forecastSet"></div>m²
		</div>

	</div>
	<div class="row">
		<label for="" class="labw130">商铺总价</label>
		<div class="inpdiv190">
			<div class="inpw100 totalPrice"></div>万
		</div>
		<label for="" class="labw130">商铺单价</label>
		<div class="inpdiv190">
			<div class="inpw100 price"></div>万
		</div>

	</div>
	<div class="row">
		<label for="" class="labw130">层高</label>
		<div class="inpdiv190">
			<div class="inpw100 height"></div>m
		</div>
		<label for="" class="labw130">开间</label>
		<div class="inpdiv190">
			<div class="inpw100 opening"></div>m
		</div>
	</div>

	<div class="row">
		<label for="" class="labw130">出售</label>
		<div class="inpdiv190">
			<div class="selw100 inpw100 sell"></div>
		</div>
		<label for="" class="labw130">经营状态</label>
		<div class="inpdiv190">
			<div class="selw100 inpw100 store_status">
			</div>
		</div>
	</div>


	<div class="row">
		<label for="" class="labw130">是否有烟道</label>
		<div class="inpdiv190">
			<div class="selw100 inpw100 flue">
			</div>
		</div>
		<label for="" class="labw130">项目特点</label>
		<div class="inpdiv190">
			<div class="selw100 inpw100 trait">

			</div>
		</div>
	</div>
	<div class="row">
		<label for="" class="labw130">租金</label>
		<div class="inpdiv190">
			<div class="selw100 inpw100 Rent">

			</div>元/月m²
		</div>
		<label for="" class="labw130">租约时间</label>
		<div class="inpdiv190">
			<div class="selw100 inpw100 leaseTime">

			</div>
		</div>
	</div>

	<div class="row">
		<label for="" class="labw130">口岸</label>
		<div class="inpw100 more port"></div>

	</div>
	<div class="row">
		<label for="" class="labw130">描述</label>
		<div class="inpw100 more intro"></div>
	</div>
	<div class="row">
		<label for="" class="labw130">项目推荐</label>
		<div class="inpw100 more RecommendReason"></div>
	</div>
</div>
<table class="table table-bordered">
	<thead>
	<tr class="bgf2">
		<th class="wid30">预览</th>
		<th>文件名</th>
	</tr>
	</thead>
	<tbody class="tbody" id="box1">
	</tbody>
</table>
</body>
<script>
    var shopsId=$("#shopsId").val();
    $.ajax({
        url: "../projectShops/findShops.shtml?id="+shopsId,
        type: 'get',
        dataType: 'json',
        success: function (res, error) {
            console.log(res)
            if(res.state=='1'){
                $(".prId").text(res.content.shops.prId)              //项目名称
                $(".shopNumber").text(res.content.shops.shopNumber)              //商铺编号
                $(".forecastBuilding").text(res.content.shops.forecastBuilding)              //预测建筑
                $(".acreate").text(res.content.shops.acreate)              //商铺面积
                $(".forecastPublicApportionment").text(res.content.shops.forecastPublicApportionment)              //预测公摊
                $(".forecastSet").text(res.content.shops.forecastSet)              //预测套内
                $(".totalPrice").text(res.content.shops.totalPrice)              //商铺总价
                $(".price").text(res.content.shops.price)              //商铺单价
                $(".height").text(res.content.shops.height)              //层高
                $(".opening").text(res.content.shops.opening)              //开间
                //出售
                if (res.content.shops.sell == "1") {
                    $(".sell").text("待售")              //出售 1(待售) 2(在售) 3(认购) 4(已售)
                } else if (res.content.shops.sell == "2") {
                    $(".sell").text("在售")
                } else if (res.content.shops.sell == "3") {
                    $(".sell").text("认购")
                } else if (res.content.shops.sell == "4") {
                    $(".sell").text("已售")
                } else {
                    $(".sell").text(res.content.shops.sell)
                }
                if (res.content.shops.store_status == "1") {
                    $(".store_status").text('经营中')              //经营状态
                } else if (res.content.shops.store_status == "2") {
                    $(".store_status").text('空铺')
                } else {
                    $(".store_status").text(res.content.shops.store_status)
                }
                if (res.content.shops.flue == "1") {
                    $(".flue").text("有烟道")              //是否有烟道
                }
                else if (res.content.shops.flue == "2") {
                    $(".flue").text("无烟道")              //是否有烟道
                }
                $(".trait").text(res.content.shops.trait)              //项目特点
                $(".Rent").text(res.content.shops.Rent)              //租金
                $(".leaseTime").text(res.content.shops.leaseTime)              //租约时间
                $(".port").text(res.content.shops.port)              //口岸
                $(".intro").text(res.content.shops.intro)              //描述
                $(".RecommendReason").text(res.content.shops.RecommendReason)              //项目推荐


                var shopsarr = res.content.shopsImg;
                var imghtml = "";
                for (var i = 0; i < shopsarr.length; i++) {
                    imghtml += '<tr class="imgtr"><td class="wid30"><div class="imageDiv"><img src="../img/pro_shops/' + shopsId + '/'  + shopsarr[i].img + '"  width="160px" height="120px"/></div> </td>' +
                        '<td> ' + shopsarr[i].img + '</td>' +
                        '</tr>'
                }
                $("#box1").html(imghtml)
            }
        }

    })
</script>

</html>