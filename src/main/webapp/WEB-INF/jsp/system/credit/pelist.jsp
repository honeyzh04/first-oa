<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


</head>
<body>


<div class="score-con">
    <div class="score-grow">
        <div class="score-tit"><span class="base-score score-tit-icon"></span>积分成长</div>
        <ul class="my-score">
            <li><span class="base-score my-score-icon1"></span>我的积分：<span id="myIntegralNum">-</span></li>
        </ul>
        <div class="score-grow-line">
            <ul class="score-stage-num">
                <li>0</li>
                <li>100</li>
                <li>200</li>
                <li>500</li>
                <li>1000</li>
                <li>5000</li>
                <li>10000</li>
                <li>50000</li>
                <li>100000</li>
            </ul>
            <div class="score-all-bg">
                <div class="base-score score-on" id="barScoreW" style="width:0%">
                    <!-- 改变这个宽度实现进度条效果 -->
                    <div class="score-num-on" id="barScoreBox">
                        <span class="base-score score-num-on-icon"></span>
                        <span class="score-num" id="barScoreNum">0</span>
                    </div>
                </div>
            </div>
        </div>
        <!--div class="score-grow-other">积分内测中，后续将可用于多种用途，敬请期待。内测结束后将会清空积分。</div-->
    </div>

    <div class="medal-change">
        <div class="score-tit">
            <div class="score-title">
                <span class="base-score score-tit-icon"></span>积分兑换
            </div>
            <div class="bind-info">
                当前绑定大区：
                <div id="spanNotBind_389471" class="bind-div">
                    <a href="javascript:amsInit(101099, 389470);" class="bind-btn">【绑定大区】</a>
                </div>
                <div id="spanBind_389471" class="bind-div" style="display:none">
                    【<span id="area_info_389471"></span>】-【<span id="role_info_389471"></span>】
                    <a href="javascript:amsInit(101099, 389470);" class="bind-btn">【更改绑定】</a>
                    <a href="javascript:;" id="button_391314" class="bind-btn">【兑换记录】</a>
                </div>
            </div>
        </div>
        <ul class="score-ul">
            <li>
                <div class="score-img-box"><img
                        src="//game.gtimg.cn/images/dnf/community2016/images/score/score-a15.png" alt=""></div>
                <p>卡妮娜的手工面包*1</p>
                <span>2积分</span>
                <a href="javascript:exchangeGift(1);">兑换</a>
            </li>
            <li>
                <div class="score-img-box"><img
                        src="//game.gtimg.cn/images/dnf/community2016/images/score/score-a14.png" alt=""></div>
                <p>卡妮娜的赫顿玛尔牛奶*1</p>
                <span>2积分</span>
                <a href="javascript:exchangeGift(2);">兑换</a>
            </li>

        </ul>
        <div class="medal-tips">
            <h4>积分规则：</h4>
            <ul>
                <li>1.为避免积分数值偏差,积分每一年清零一次.</li>
                <li>2.上传违规作品1次扣50积分,3次以上盗图扣光所有积分.(违规作品：非DNF相关作品,非上传者本人作品且无授权)</li>
                <li>3.Q币每人每月限兑换10个,黑钻7天每人每月限兑换1个.</li>
            </ul>
            <img src="//game.gtimg.cn/images/dnf/community2016/images/public/score-img.png" width="444" height="190"
                 class="score-img" alt="">
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    $(function() {
        find()

    });
    function find() {
        $.ajax({
            "url" : "./credit/findUserCredit.shtml",
            "date":"",
            "type" : "GET",
            "dataType" : "json",
            "success" : function(obj) {
                console.log(obj);

            },
            error : function() {
                alert("请与管理员联系");
            }
        });
    }
</script>