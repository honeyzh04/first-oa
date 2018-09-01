<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/common.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
   <style type="text/css">


       /*左侧内容*/
       .main-left{width: 880px; float: left; overflow: hidden;}
       .main-item{width: 848px; padding: 0 15px 20px 15px; border: 1px solid #e6e6e6; font-size: 14px; margin-bottom: 10px;}
       .main-item h3{font-size: 20px; color: #333; text-indent: 11px; height: 25px; line-height: 25px; padding-top: 20px; font-weight: 400;}
       .main-info{width: 848px; height: 20px; line-height: 20px; border-bottom: 1px dashed #e6e6e6; padding-bottom: 20px; margin-top: 30px;}
       .main-info-price,.main-info-comment{padding-left: 10px; width: 414px; float: left; font-size: 14px;}
       .main-info .tit{font-size: 14px; padding-right: 2px; text-align: left;}
       .main-info-price em{font-size: 16px; color: #cc0000;}
       .main-info-comment .star{margin-right: 6px;}
       .main-info-comment .star i{display: inline-block; width: 16px; height: 16px; background: url(http://img1.soufun.com/house/images/detail_dianpingstar.png) no-repeat; margin: 0 2px 0 0; vertical-align: middle;}
       .main-info-comment .star .half-star{background-position: 0 -16px;}
       .main-info-comment .star .gray-star{background-position: 0 -32px;}
       .main-info-comment .comment{color: #c00; font-size: 12px; text-decoration: none;}
       .main-item .list{padding-top: 18px; font-size: 14px;}
       .list li{float: left; padding: 0 10px; width: 404px; overflow: hidden;}
       .list .list-right-floor{float: left; width: 748px; line-height: 32px; overflow: hidden;}
       .list .list-text{padding: 0 10px; width: 828px; float: none;}
       .list .list-left,.list .list-right,.list .list-right-text{float: left; line-height: 32px;}
       .list .list-left{ padding-right: 3px; width: 73px;}
       .list .list-left.w84{width: 84px;}
       .list-right{width: 328px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;}
       .list  .list-right-text{width: 748px;overflow: hidden; white-space: nowrap; text-overflow: ellipsis; }
       .list  .list-right-text.w730{width: 730px;}
       .list-right .tag{display: block; float: left; border: 1px solid #ccc; height: 24px; line-height: 23px; text-align: center; padding: 0 10px; margin: 4px 6px 0 0; }
       .list-right .bulid-type{margin-right: 4px;}
       .list-right.c00{color: #c00;}
       .list .item-a{font-size: 12px; color: #c00; margin-left: 12px; line-height: 28px;}

       /*交通配套*/
       .
       {line-height: 30px; font-size: 14px; color: #333; padding: 0 0 22px 10px; margin-top: 20px;}
       .set.bd-1{border-bottom: 1px dashed #e6e6e6 }
       .set h3{font-size: 14px; color: #333; margin-bottom: 20px; padding-top: 0;text-indent:0;}

       /*价格信息*/
       a.price-trend{float: right; font-size: 14px; color: #c00;margin-right:10px;}
       .main-table{margin: 20px 10px 0; width: 828px; overflow: hidden;}
       .table-part table,.table-all table{border-left: 1px solid #e6e6e6; border-top: 1px solid #e6e6e6; width: 827px;}
       .table-part td,.table-all td{border-right: 1px solid #e6e6e6; border-bottom: 1px solid #e6e6e6;
           background: #f9f9f9; height: 48px; line-height: 25px; text-align: center; font-size: 14px; padding: 0 10px;}
       .table-part .td-left,.table-all .td-left{text-align: left;}

       .btn-open,.btn-off{ border: 1px solid #e6e6e6; width: 71px; height: 23px; line-height: 23px; border-top: 1px solid #f9f9f9; text-indent: 15px;background: #f9f9f9; font-size: 12px; color: #666;text-decoration: none; cursor: pointer; margin: -1px auto 0 auto; position: relative;}
       .btn-open i,.btn-off i{display: inline-block; width: 12px; height: 8px; vertical-align: middle; margin-left: 10px;}
       .btn-open i{background: url(http://img1.soufun.com/house/images/jt_down.png) no-repeat;}
       .btn-off i{background: url(http://img1.soufun.com/house/images/jt_up.png) no-repeat;}

       /*项目简介*/
       .main-item .intro{font-size: 14px; line-height: 33px; color: #333; margin: 30px 10px 0; width: 828px; overflow:hidden;}
   </style>
</head>
<body>
<div class="main-cont clearfix">
    <!--左侧内容开始-->
    <div class="main-left" deep="2">
        <!--基本信息开始-->
        <div class="main-item">
            <h3>基本信息</h3>
            <div class="main-info clearfix">
                <div class="main-info-price"><span class="tit">价<i style="margin-right: 28px;"></i>格：</span><em>
                    均价约8500元/平方米
                </em></div>
                <div class="main-info-comment"><span class="tit">
						用户点评：</span>
                    <a href="#" class="comment">
							<span class="star">
							<i></i><i></i><i></i><i class="half-star"></i><i class="gray-star"></i>							</span>
                        <span style="margin-right: 5px;">3.27</span>
                        <span>[29条点评]</span>
                    </a>
                </div>
            </div>
            <ul class="list clearfix">
                <li>
                    <div class="list-left">物业类别：</div>

                    <div class="list-right" title="普通住宅">
                        普通住宅

                    </div>
                </li>
                <li>
                    <div class="list-left">项目特色：</div>
                    <div class="list-right" style="height:32px;">
                        <span class="tag">品牌地产</span>
                    </div></li>
                <li>
                    <div class="list-left">建筑类别：</div>
                    <div class="list-right"><span class="bulid-type">																板楼
								 高层 超高层															 </span></div>
                </li>
                <li>
                    <div class="list-left">装修状况：</div>
                    <div class="list-right">
                        非毛坯
                    </div>
                </li>
                <li>
                    <div class="list-left">产权年限：</div>
                    <div class="list-right">
                        <div class="clearfix cqnx_512">


                            <p style="width: 130px;float: left;">普通住宅:70年</p>


                        </div>
                    </div>

                </li>

                <li>
                    <div class="list-left">环线位置：</div>
                    <div class="list-right">    			    	绕城以外

                    </div>
                </li>
                <li class="list-text">
                    <div class="list-left">开<i style="margin-right: 6px;"></i>发<i style="margin-right: 6px;"></i> 商：</div>
                    <div class="list-right-text"><a href="#" target="_blank">四川崇州贝德投资有限公司</a></div>
                </li>
                <li class="list-text">
                    <div class="list-left">楼盘地址：</div>
                    <div class="list-right-text">光华大道西段R26;新城大道与羊安路交汇处</div>
                </li>
            </ul>
        </div>
        <!--基本信息结束-->
        <!--销售信息开始-->
        <div class="main-item">
            <h3>销售信息</h3>
            <ul class="list clearfix">
                <li>
                    <div class="list-left">销售状态：</div>
                    <div class="list-right">
                        在售</div>
                </li>
                <li>
                    <div class="list-left">楼盘优惠：</div>
                    <div class="list-right">
                        暂无
                    </div>
                </li>
                <li>
                    <div class="list-left">开盘时间：</div>
                    <div class="list-right">2018年7月13日10#及12#开盘<a href="#" target="_blank" class="item-a">[开盘时间详情]</a></div>
                </li>
                <li>
                    <div class="list-left">交房时间：</div>
                    <div class="list-right">预计2020年10月底首批次交房</div>
                </li>
                <li>
                    <div class="list-left">售楼地址：</div>
                    <div class="list-right" title="光华大道西段R26;新城大道与羊安路交汇处">光华大道西段R26;新城大道与羊安路交汇处</div>
                </li>
                <li>
                    <div class="list-left">咨询电话：</div>
                    <div class="list-right c00">400-890-0000 转 848359</div>
                </li>
                <li class="list-text">
                    <div class="list-left">主力户型：</div>
                    <div class="list-right-text">
                        <a href="#">二居(4)  </a>
                        <a href="#">三居(13)  </a>
                        <a href="#">四居(2)  </a>

                    </div>
                </li>
                <li class="list-text">
                    <div class="list-left w84">预售许可证：</div>
                    <div class="list-right-text w730"></div>
                </li>
            </ul>
            <div class="main-table">
                <div class="table-part">
                    <table cellpadding="0" cellspacing="0">
                        <tbody><tr>
                            <td width="224">预售许可证</td>
                            <td width="175">发证时间</td>
                            <td width="364">绑定楼栋</td>
                        </tr>
                        <tr>
                            <td>成房预售崇字第891号</td>
                            <td>2018-06-14</td>
                            <td class="td-left">1期10# 1期12# </td>
                        </tr>
                        </tbody></table>
                    <div class="btn-open">展开<i></i></div>
                </div>
                <div class="table-all" style="display: none;" data-filtered="filtered">
                    <table cellpadding="0" cellspacing="0" data-filtered="filtered">

                        <tbody data-filtered="filtered"><tr data-filtered="filtered">
                            <td width="224" data-filtered="filtered">预售许可证</td>
                            <td width="175" data-filtered="filtered">发证时间</td>
                            <td width="364" data-filtered="filtered">绑定楼栋</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">成房预售崇字第891号</td>
                            <td data-filtered="filtered">2018-06-14</td>
                            <td class="td-left" data-filtered="filtered">1期10# 1期12# </td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">成房预售崇字第881号</td>
                            <td data-filtered="filtered">2018-04-20</td>
                            <td class="td-left" data-filtered="filtered">1期11# 1期8# 1期9# </td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">成房预售崇字第871号</td>
                            <td data-filtered="filtered">2018-02-06</td>
                            <td class="td-left" data-filtered="filtered">1期1# 1期13# 1期14# 1期2# 1期3# 1期4# 1期5# 1期6# 1期7# </td>
                        </tr>
                        </tbody></table>
                    <div class="btn-off" data-filtered="filtered">收起<i data-filtered="filtered"></i></div>
                </div>
            </div>
        </div>
        <!--销售信息结束-->


        <!--周边设施开始-->
        <div class="main-item">
            <h3>周边设施</h3>
            <ul class="sheshi_zb">
                <li class="jiaotong_color"><span>交通</span>公交：羊马公交站 ： 302B路 <br data-filtered="filtered">
                    羊马新城公交站：759路<br data-filtered="filtered">
                    自驾：沿文家场收费站进入成温邛高速路，行驶至羊马出口，进入羊马镇，随后进入羊马立交，直走进入新城大道</li>
                <li><span>幼儿园</span>1.   羊马中心幼儿园 2. 乖乖幼儿园3. 永盛中心幼儿园、春蕾幼儿园</li>
                <li><span>中小学</span>小学：  1. 羊马镇全友小学2、羊马镇中心小学3、羊马镇伏虎小学
                初中：羊马中学</li>
                <li><span>大学</span>大学：四川水利职业技术学院</li>
                <li><span>综合商场</span>商业：项目自带商业街、世纪华联购物中心、金逸影城</li>
                <li><span>医院</span>羊马社区卫生院、崇州市第二人民医院、温江区中医医院永盛分院、成都大学附属医院崇州分院等、羊马社区卫生服务中心</li>
                <li><span>银行</span>邮政银行、成都农村信用社等</li>
                <li><span>小区内部配套</span>商业街、会所</li>
            </ul>

        </div>


        <!--周边设施结束-->

        <!--小区规划开始-->
        <div class="main-item">
            <h3>小区规划</h3>
            <ul class="clearfix list">
                <li>
                    <div class="list-left">占地面积：</div>
                    <div class="list-right">236687平方米</div>
                </li>
                <li>
                    <div class="list-left">建筑面积：</div>
                    <div class="list-right">675157平方米</div>
                </li>
                <li>
                    <div class="list-left">容<i style="margin-right: 6px;"></i>积<i style="margin-right: 6px;"></i>率：</div>
                    <div class="list-right">3.00&nbsp; </div>
                </li>
                <li>
                    <div class="list-left">绿<i style="margin-right: 6px;"></i>化<i style="margin-right: 6px;"></i>率：</div>
                    <div class="list-right">30%</div>
                </li>
                <li>
                    <div class="list-left">停<i style="margin-right: 6px;"></i>车<i style="margin-right: 6px;"></i>位：</div>
                    <div class="list-right">A地块非机动2261辆，机动2316辆</div>
                </li>
                <li>
                    <div class="list-left">楼栋总数：</div>
                    <div class="list-right">36栋</div>
                </li>
                <li>
                    <div class="list-left">总<i style="margin-right: 6px;"></i>户<i style="margin-right: 6px;"></i>数：</div>
                    <div class="list-right">4513户</div>
                </li>
                <li>
                    <div class="list-left">物业公司：</div>
                    <div class="list-right">暂无资料</div>
                </li>
                <li>
                    <div class="list-left">物<i style="margin-right: 6px;"></i>业<i style="margin-right: 6px;"></i>费：</div>
                    <div class="list-right">暂无资料&nbsp;</div>
                </li>
                <li class="list-text">
                    <div class="list-left" style="width:90px">物业费描述：</div>
                    <div class="list-right-floor" style="width:730px">暂无资料</div>
                </li>
                <li class="list-text">
                    <div class="list-left">楼层状况：</div>
                    <div class="list-right-floor">共36栋，23-32层,</div>
                </li>
            </ul>
        </div>
        <!--小区规划结束-->
        <!--价格信息开始-->
        <div class="main-item">
            <h3>
                <a href="#" target="_blank" class="price-trend">查看价格走势 &gt;</a>
                价格信息
            </h3>
            <div class="main-table">
                <div class="table-part">
                    <table cellpadding="0" cellspacing="0">
                        <tbody><tr>
                            <td width="110">记录时间</td>
                            <td width="90">均价</td>
                            <td width="90">起价</td>
                            <td width="342">价格描述</td>
                        </tr>
                        <tr>
                            <td>2018-08-27</td>
                            <td>约8500元/㎡</td>
                            <td>&nbsp;</td>
                            <td class="td-left">恒大西辰绿洲目前均价约8500元/㎡，主推建面85-115㎡带装修房源，在售房源位于10#及12#</td>
                        </tr>
                        <tr>
                            <td>2018-08-21</td>
                            <td>约8500元/㎡</td>
                            <td>&nbsp;</td>
                            <td class="td-left">恒大西辰绿洲主推建面82-115㎡带装修房源，10#及12#在售，均价约8500元/㎡</td>
                        </tr>
                        <tr>
                            <td>2018-08-09</td>
                            <td>约8500元/㎡</td>
                            <td>&nbsp;</td>
                            <td class="td-left">恒大西辰绿洲目前均价约8500元/㎡，主推建面82-115㎡带装修房源，目前10栋及12栋房源在售</td>
                        </tr>
                        </tbody></table>
                    <div class="btn-open">展开<i></i></div>
                </div>
                <div class="table-all" style="display: none;" data-filtered="filtered">
                    <table cellpadding="0" cellspacing="0" data-filtered="filtered">
                        <tbody data-filtered="filtered"><tr data-filtered="filtered">
                            <td width="110" data-filtered="filtered">记录时间</td>
                            <td width="90" data-filtered="filtered">均价</td>
                            <td width="90" data-filtered="filtered">起价</td>
                            <td width="342" data-filtered="filtered">价格描述</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-08-27</td>
                            <td data-filtered="filtered">约8500元/㎡</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td class="td-left" data-filtered="filtered">恒大西辰绿洲目前均价约8500元/㎡，主推建面85-115㎡带装修房源，在售房源位于10#及12#</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-08-21</td>
                            <td data-filtered="filtered">约8500元/㎡</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td class="td-left" data-filtered="filtered">恒大西辰绿洲主推建面82-115㎡带装修房源，10#及12#在售，均价约8500元/㎡</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-08-09</td>
                            <td data-filtered="filtered">约8500元/㎡</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td class="td-left" data-filtered="filtered">恒大西辰绿洲目前均价约8500元/㎡，主推建面82-115㎡带装修房源，目前10栋及12栋房源在售</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-08-06</td>
                            <td data-filtered="filtered">约8500元/㎡</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td class="td-left" data-filtered="filtered">恒大西辰绿洲目前10#及12#房源在售，主推建面82-115㎡带装修房源，均价约8500元/㎡。</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-07-31</td>
                            <td data-filtered="filtered">约8500元/㎡</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td class="td-left" data-filtered="filtered">恒大西辰绿洲带装修房源价格约8500元/㎡，还有少量房源可选择，主要位于10#及12#，建面82-115㎡，详情请咨询售楼部。</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-07-20</td>
                            <td data-filtered="filtered">约8500元/㎡</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td class="td-left" data-filtered="filtered">恒大西辰绿洲目前还有少量建面82-115㎡，位于10#及12#，房源均价8500元/㎡，带装修，2020年10月底交房</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-07-17</td>
                            <td data-filtered="filtered">约8500元/㎡</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td class="td-left" data-filtered="filtered">恒大西辰绿洲10#及12#共计228套房源已于7月13日开盘选房，目前还有少量建面82-115㎡房源可供选择，带装修交付，房源均价8500元/㎡，将于2020年10月底交房，</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-07-09</td>
                            <td data-filtered="filtered">约8500元/㎡</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td class="td-left" data-filtered="filtered">恒大西辰绿洲即将推出面积区间为82-115㎡共计228套，该房源位于10号楼及12号楼，房源带装修，装修标准2900.59元/㎡，带装修均价约8500元/㎡</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-07-02</td>
                            <td data-filtered="filtered">约8500元/㎡</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td class="td-left" data-filtered="filtered">恒大西辰绿洲即将推出10号楼及12号楼，共计228套，面积区间为82-115㎡，房源带装修，装修标准2900.59元/㎡，带装修均价约8500元/㎡。预计7月初选房</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-06-21</td>
                            <td data-filtered="filtered">约8500元/㎡</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td class="td-left" data-filtered="filtered">项目即将推出10号楼及12号楼，共计228套，面积区间为82-115㎡，房源带装修，装修标准2900.59元/㎡，带装修均价约8500元/㎡。7月选房</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-06-16</td>
                            <td data-filtered="filtered">约8500元/㎡</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td class="td-left" data-filtered="filtered">恒大西辰绿洲10号楼及12号楼已取得预售证，本次将推出房源共计228套，面积区间为建面81-115㎡，带装修均价约8500元/㎡。</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-06-11</td>
                            <td data-filtered="filtered">约8500元/㎡</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td class="td-left" data-filtered="filtered">目前均价8500元/㎡，主推建筑面积为106-130㎡左右的住宅，预计2020年底非毛坯房交付</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-06-09</td>
                            <td data-filtered="filtered">约8500元/㎡</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td class="td-left" data-filtered="filtered">主推出建筑面积为106-130㎡左右的住宅，预计2020年底非毛坯房交付，均价约8500元/平方米。</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-05-29</td>
                            <td data-filtered="filtered">约8500元/㎡</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td class="td-left" data-filtered="filtered">目前主推出建筑面积为106-130㎡左右的住宅，预计2020年底非毛坯房交付，均价约8500元/平方米。</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-05-17</td>
                            <td data-filtered="filtered">约8500元/㎡</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td class="td-left" data-filtered="filtered">恒大西辰绿洲目前在售均价约8500元/平方米，主推出建筑面积为106-139㎡的住宅</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-05-09</td>
                            <td data-filtered="filtered">约8500元/㎡</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td class="td-left" data-filtered="filtered">恒大西辰绿洲即将加推8#、9#、11#共429套房源，产品建面81-136㎡，目前项目均价约8500元/㎡，主推出建筑面积为106-139㎡的非毛坯房产品</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-05-04</td>
                            <td data-filtered="filtered">约8500元/㎡</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td class="td-left" data-filtered="filtered">恒大西辰绿洲目前主推出建筑面积为106-139㎡的非毛坯房产品，预计2020年10月交房，均价约8500元/㎡。即将加推8#、9#、11#共429套房源，产品建面81-136㎡，</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-04-21</td>
                            <td data-filtered="filtered">约8500元/㎡</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td class="td-left" data-filtered="filtered">主推建筑面积为106-139㎡的非毛坯房产品，预计2020年10月份交房，均价约8500元/㎡</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-04-17</td>
                            <td data-filtered="filtered">约8500元/㎡</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td class="td-left" data-filtered="filtered">恒大西辰绿洲目前主推建筑面积为106-139㎡的非毛坯房产品，预计2020年10月份交房，均价约8500元/㎡</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-04-11</td>
                            <td data-filtered="filtered">约8500元/㎡</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td class="td-left" data-filtered="filtered">恒大西辰绿洲目前在售价格约8500元/㎡，非毛坯房，目前在售房源为建面106-139㎡产品</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-04-10</td>
                            <td data-filtered="filtered">约8500元/㎡</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td class="td-left" data-filtered="filtered">高层价格</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-03-30</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td data-filtered="filtered">约8500元/㎡</td>
                            <td class="td-left" data-filtered="filtered">在售房源价格8500元/㎡起，非毛坯房在售</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-03-24</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td data-filtered="filtered">约8500元/㎡</td>
                            <td class="td-left" data-filtered="filtered">在售房源价格8500元/㎡起</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-03-05</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td data-filtered="filtered">约8500元/㎡</td>
                            <td class="td-left" data-filtered="filtered">恒大西辰绿洲在售房源106-139平，106平均价8500元/平米；139平均价9000元/平米</td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-02-05</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td class="td-left" data-filtered="filtered">恒大西辰绿洲待售中，先售楼部接受咨询，首批次房源将推出高层住宅，具体的开盘时间、户型和价格待定，详询售楼处
                            </td>
                        </tr>
                        <tr data-filtered="filtered">
                            <td data-filtered="filtered">2018-01-09</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td data-filtered="filtered">&nbsp;</td>
                            <td class="td-left" data-filtered="filtered">该楼盘价格待定</td>
                        </tr>
                        </tbody></table>
                    <div class="btn-off" data-filtered="filtered">收起<i data-filtered="filtered"></i></div>
                </div>
            </div>
        </div>
        <!--价格信息结束-->
        <!--项目简介开始-->
        <div class="main-item">
            <h3>项目简介</h3>
            <p class="intro">
                恒大西辰绿洲项目位于成都羊马新城核心区域（新城大道与永和大道交叉口西侧），该项目规划总用地面积为236687.97㎡，规划总建筑面积为675157.14㎡，楼栋总数36栋，楼间距为120M--140M，均无底商，视野开阔。楼宇中间规划5000平人工湖泊，为业主提供了休闲、漫步的绿肺之所。另，项目本身打造了购物体验，将建成一个商业综合体，引进大型商超、餐饮、娱乐、健身等特色商业街区
            </p>
        </div>
        <!--项目简介结束-->
    </div>
    <!--左侧内容结束-->

</div>
</body>
</html>
