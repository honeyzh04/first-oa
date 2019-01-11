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
<div id="main" style="height:560px"></div>
<script>
    $(function(){
        var myChart = echarts.init(document.getElementById('main'));
        /*   data1 表示每个饼状图的名字，每个培训类型
             data2 表示每个饼状图，即每个培训类型的统计结果
         */

        var data1=[];
        var data2=[];
        var array=[];
		var deaId=$("#deaId").val();
        $.ajax({
            type:"post",
            url:"../customer/dealAllot.shtml?id="+ deaId,
            data:{},
            cache:false,
            async: false,
            dataType:"json",
            success : function (result) {

                for(var i in result){

                    data1.push(result[i].userName);
                    data2.push(result[i].commission);
                    var map={};
                    map.name=result[i].userName;
                    map.value=result[i].commission;
                    array[i]=map;

                }
              /*  myChart.setOption({ //加载数据图表

                    title : {
                        text: '成交佣金详细组成',
                        x:'center'
                    },
                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        orient : 'vertical',
                        x : 'left',
                        data:data1
                    },
                    toolbox: {
                        show : true,
                        feature : {
                            mark : {show: true},
                            dataView : {show: true, readOnly: false},
                            magicType : {
                                show: true,
                                type: ['pie', 'funnel'],
                                option: {
                                    funnel: {
                                        x: '25%',
                                        width: '50%',
                                        funnelAlign: 'left',
                                        max: 1548
                                    }
                                }
                            },
                            restore : {show: true},
                            saveAsImage : {show: true}
                        }
                    },
                    calculable : true,
                    series : [
                        {
                            name:'佣金详情:',
                            type:'pie',
                            radius : '55%',
                            center: ['50%', '60%'],
                            data:array
                        }
                    ]
                });*/
                myChart.setOption = ({
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b}: {c} ({d}%)"
                    },
                    legend: {
                        orient: 'vertical',
                        x: 'left',
                        data:['直达','营销广告','搜索引擎','邮件营销','联盟广告','视频广告','百度','谷歌','必应','其他']
                    },
                    series: [
                        {
                            name:'访问来源',
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
                            data:[
                                {value:335, name:'直达', selected:true},
                                {value:679, name:'营销广告'},
                                {value:1548, name:'搜索引擎'}
                            ]
                        },
                        {
                            name:'访问来源',
                            type:'pie',
                            radius: ['40%', '55%'],
                            label: {
                                normal: {
                                    formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
                                    backgroundColor: '#eee',
                                    borderColor: '#aaa',
                                    borderWidth: 1,
                                    borderRadius: 4,
                                    /*  shadowBlur:3,
                                      shadowOffsetX: 2,
                                      shadowOffsetY: 2,
                                       shadowColor: '#999',*/
                                    padding: [0, 7],
                                    rich: {
                                        a: {
                                            color: '#999',
                                            lineHeight: 22,
                                            align: 'center'
                                        },
                                        /*  abg: {
                                              backgroundColor: '#333',
                                              width: '100%',
                                              align: 'right',
                                              height: 22,
                                              borderRadius: [4, 4, 0, 0]
                                          },*/
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
                            data:[
                                {value:335, name:'直达'},
                                {value:310, name:'邮件营销'},
                                {value:234, name:'联盟广告'},
                                {value:135, name:'视频广告'},
                                {value:1048, name:'百度'},
                                {value:251, name:'谷歌'},
                                {value:147, name:'必应'},
                                {value:102, name:'其他'}
                            ]
                        }
                    ]
                });
            },
            error : function(result) {
                //请求失败时执行该函数
                layer.alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        });

    })

</script>

</body>
</html>


