<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/common.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<html>
<head>
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

		.inpw80 {
			width: 80px;
		}

		.selw680 {
			width: 593px;
		}

		.selw100 {
			width: 170px;
		}

		.selw70 {
			width: 70px;
			float: left;
		}

		option {
			height: 38px;
			line-height: 38px;
		}

		.rowbutton {
			padding-left: 130px;
		}

		.rowbutton button {
			width: 100px;
			height: 38px;
			line-height: 38px;
			margin: 0px 10px;
			border-radius: 5px;
			border: 0px;
		}

		.sum {
			text-align: right;
			margin-right: 300px;
		}

		.upfile {
			display: inline-block !important;
			opacity: 0;
			position: absolute;
			left: 0
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

		.cover {
			position: absolute;
			z-index: 3;
			top: 0;
			left: 0;
			width: 160px;
			height: 130px;
			background-color: rgba(0, 0, 0, .3);
			display: none;
			line-height: 125px;
			text-align: center;
			cursor: pointer;
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
	<input type="hidden" name="apartmentId" value="${apartmentId}" id="apartmentId" class="apartmentId">
	<div class="row">
		<label for="" class="labw130">项目名称</label>
		<div class="inpdiv190">
			<div class="selw100 inpw100 prId">
			</div>
		</div>
		<label for="" class="labw130">房间编号</label>
		<div class="inpdiv190">
			<div class="inpw100 roomNo"></div>
		</div>
	</div>
	<div class="row">
		<label for="" class="labw130">性质</label>
		<div class="inpdiv190">
			<div class="selw100 inpw100 nature">

			</div>
		</div>
		<label for="" class="labw130">出售</label>
		<div class="selw100 inpw100 sell">

		</div>

	</div>
	<div class="row">
		<label for="" class="labw130">建面</label>
		<div class="inpdiv190">
			<div class="inpw100 noodles"></div>m²
		</div>
		<label for="" class="labw130">惊爆折扣</label>
		<div class="inpdiv190">
			<div class="inpw100 shockDiscount"></div>
		</div>

	</div>
	<div class="row">
		<label for="" class="labw130">原总价</label>
		<div class="inpdiv190">
			<div class="inpw100 originalPrice"></div>万
		</div>
		<label for="" class="labw130">原单价</label>
		<div class="inpdiv190">
			<div class="inpw100 originalUnitPrice"></div>万
		</div>
	</div>

	<div class="row">
		<label for="" class="labw130">现总价</label>
		<div class="inpdiv190">
			<div class="inpw100 currentPrice"></div>万
		</div>
		<label for="" class="labw130">现单价</label>
		<div class="inpdiv190">
			<div class="inpw100 currentUnitPrice"></div>万
		</div>
	</div>

	<div class="row">
		<label for="" class="labw130">折扣低价</label>
		<div class="inpdiv190">
			<div class="inpw100 discountLowPrice"></div>万
		</div>
		<label for="" class="labw130">折扣单价</label>
		<div class="inpdiv190">
			<div class="inpw100 discountUnitPrice"></div>万
		</div>
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
	var apartmentId=$("#apartmentId").val();
    $.ajax({
        url: "../project/findApartment.shtml?id="+apartmentId,
        type: 'get',
        dataType: 'json',
        success: function (res, error) {
            console.log(res)
            $(".prId").text(res.content.apartment.prId);
            $(".building").text(res.content.apartment.building);
            $(".floor").text(res.content.apartment.floor);
            $(".roomNo").text(res.content.apartment.roomNo);

            if (res.content.apartment.nature == "1") {
                $(".nature").text('商用')              //经营状态
            } else if (res.content.apartment.nature == "2") {
                $(".nature").text('自用')
            } else {
                $(".nature").text(res.content.apartment.nature);
            }
            //出售
            if (res.content.apartment.sell == "1") {
                $(".sell").text("待售")              //出售 1(待售) 2(在售) 3(认购) 4(已售)
            } else if (res.content.apartment.sell == "2") {
                $(".sell").text("在售")
            } else if (res.content.apartment.sell == "3") {
                $(".sell").text("认购")
            } else if (res.content.apartment.sell == "4") {
                $(".sell").text("已售")
            } else {
                $(".sell").text(res.content.apartment.sell)
            }
            $(".noodles").text(res.content.apartment.noodles);
            $(".shockDiscount").text(res.content.apartment.shockDiscount);
            $(".originalPrice").text(res.content.apartment.originalPrice);
            $(".originalUnitPrice").text(res.content.apartment.originalUnitPrice);
            $(".currentPrice").text(res.content.apartment.currentPrice);
            $(".currentUnitPrice").text(res.content.apartment.currentUnitPrice);
            $(".discountLowPrice").text(res.content.apartment.discountLowPrice);
            $(".discountUnitPrice").text(res.content.apartment.discountUnitPrice);
            var apartmentsarr = res.content.apartmentImg;
            var imghtml = "";
            for (var i = 0; i < apartmentsarr.length; i++) {
                imghtml += '<tr class="imgtr"><td class="wid30"><div class="imageDiv"><img src="../img/pro_apartment/' +apartmentId + '/'  + apartmentsarr[i].img + '"/></div> </td>' +
                    '<td> ' + apartmentsarr[i].img + '</td>' +
                    '</tr>'
            }
            $("#box1").html(imghtml)
        }

    })
</script>

</html>