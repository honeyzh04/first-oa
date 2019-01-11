<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/common.jspf"%>

	</head>
<body>
<input type="hidden" class="form-control checkacc"
	   value="${deaId}" id="deaId">
<div id="graphs" style="width:1000px;height:600px;">
<script type="text/javascript">
    $(function(){
        drawEchart();
    });

    function drawEchart(){
        var graphs = echarts.init(document.getElementById("graphs"));
        var deaId=$("#deaId").val();
        $.post('../customer/dealAllot.shtml',{"id": deaId}, function(data){
            console.log(data)
            var dealAllot = data.dealAllot;
            var dealUserAllot = data.dealUserAllot;
            console.log(data.dealAllot)
            option = {
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b}: {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    x: 'left',
                    data:[]
                },
                series: [
                    {
                        name:'佣金拆分',
                        type:'pie',
                        selectedMode: 'single',
                        radius: [0, '30%'],

                        label: {
                            normal: {
                                position: 'inner'
                            }
                        },
                        labelLine: {
                            normal: {
                                show: false
                            }
                        },
                        data:[]
                    },
                    {
                        name:'佣金明细',
                        type:'pie',
                        radius: ['40%', '55%'],
                        label: {
                            normal: {
                                formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
                                backgroundColor: '#eee',
                                borderColor: '#aaa',
                                borderWidth: 1,
                                borderRadius: 4,
                                rich: {
                                    a: {
                                        color: '#999',
                                        lineHeight: 22,
                                        align: 'center'
                                    },
                                    hr: {
                                        borderColor: '#aaa',
                                        width: '100%',
                                        borderWidth: 0.5,
                                        height: 0
                                    },
                                    b: {
                                        fontSize: 16,
                                        lineHeight: 33
                                    },
                                    per: {
                                        color: '#eee',
                                        backgroundColor: '#334455',
                                        padding: [2, 4],
                                        borderRadius: 2
                                    }
                                }
                            }
                        },
                        data:[]
                    }
                ]
            };
            for(var i = 0; i < dealAllot.length; i++){
                option.series[0].data.push({name:dealAllot[i].type, value:dealAllot[i].commission});
            }
            for(var i = 0; i < dealUserAllot.length; i++){

                option.legend.data.push(dealUserAllot[i].userName);
                option.series[1].data.push({name:dealUserAllot[i].userName, value:dealUserAllot[i].commission});
            }
            graphs.setOption(option);
        },"json" );
    }
</script>


</body>
</html>


