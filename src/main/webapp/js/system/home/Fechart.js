$(function () {
    $.ajax({
        url: "./home/findByWeekExtension.shtml",
        type: "get",
        dataType: "json",
        success: function (data) {
            console.log(data);
            if (data.state == 1) {
                var name =[];
                var addw = [];//总新增
             /*   var adddh = [];//电话新增
                var addqt = [];//其他
                var addwl = [];//网络新增
                var addz = [];//转入新增
                var name = [];//部门
                var addg = [];//公共池*/
                var follow = [];//跟进
                var vis = [];//到访
                var dea = [];//成交
                for (var i = 0; i < data.content.length; i++) {
                    name.push(data.content[i].name);
                    addw.push(data.content[i].addw);
                  /*  adddh.push(data.content[i].adddh);
                    addqt.push(data.content[i].addqt);
                    addg.push(data.content[i].addg);
                    addwl.push(data.content[i].addwl);
                    addz.push(data.content[i].addz);*/
                   follow.push(data.content[i].follow);
                    vis.push(data.content[i].vis);
                    dea.push(data.content[i].dea);
                }
                //报表=====================部门==========================
                var department = echarts.init(document.getElementById('ChildOne'));
                option = {
                    title: {text: "销售数据", textStyle: {color: "red"}, left: "20%",},
                    tooltip: {
                        trigger: 'axis',
                        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                        }
                    },
                    legend: {
                        data: ['\n', '\n', '\n', '总新增', '跟进', '到访', '成交'],
                        textStyle: {color: "rgba(0, 217, 210,1)", fontSize: 16}
                    },
                    grid: {
                        left: '3%',
                        right: '50%',
                        top: '20%',
                        bottom: '15%',
                        containLabel: true,
                    },
                    xAxis: {
                        type: 'value',
                        min: 0,
                        // max: 500,
                        splitLine: {show: false},//去除网格线
                        axisLine: {lineStyle: {color: "rgba(0, 123, 198,0.65)", width: 1,},},
                        axisLabel: {
                            interval: 0,
//                                        rotate: 40,//倾斜度
                            show: true,
                            textStyle: {color: "rgba(0, 217, 210,1)", fontSize: "12"}
                        },
                    },
                    yAxis: {
                        type: 'category',
                        data: name,
                        axisLabel: {
                            interval: 0,
//                                        rotate: 40,//倾斜度
                            show: true,
                            textStyle: {color: "rgba(0, 217, 210,1)", fontSize: "12"}
                        },
                        axisLine: {lineStyle: {color: "rgba(0, 123, 198,0.65)", width: 1,},},
                    },
                    series: [
                        {
                            name: '总新增',
                            type: 'bar',
                            stack: '总量',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'insideRight'
                                }
                            },
                            data: addw,
//                      barMaxWidth:25,
                            barMinHeight: 25,
                        },
                       /* {
                            name: '电话新增',
                            type: 'bar',
                            stack: '总量',
                            label: {
                                normal: {
                                    show: true,
                                    // position: 'insideRight'
                                }
                            },
                            data: adddh,
                            // barMaxWidth:120,//控制叠状图的宽
                            barMinHeight: 25,//控制叠状图的高
                        },
                        {
                            name: '其他',
                            type: 'bar',
                            stack: '总量',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'insideRight'
                                }
                            },
                            data: addqt,
//                      barMaxWidth:10,
                            barMinHeight: 25,
                        },*/
                        {
                            name: '跟进',
                            type: 'bar',
                            stack: '总量',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'insideRight'
                                }
                            },
                            data: follow,
//                      barMaxWidth:25,
                            barMinHeight: 25,
                        },
                        {
                            name: '到访',
                            type: 'bar',
                            stack: '总量',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'insideRight'
                                }
                            },
                            data: vis,
//                      barMaxWidth:25,
                            barMinHeight: 25,
                        },
                        {
                            name: '成交',
                            type: 'bar',
                            stack: '总量',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'insideRight'
                                }
                            },
                            data: dea,
//                      barMaxWidth:25,
                            barMinHeight: 25,
                        },
                      /*  {
                            name: '网络新增',
                            type: 'bar',
                            stack: '总量',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'insideRight'
                                }
                            },
                            data: addwl,
//                      barMaxWidth:25,
                            barMinHeight: 25,
                        },*/
                    /*    {
                            name: '转入新增',
                            type: 'bar',
                            stack: '总量',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'insideRight'
                                }
                            },
                            data: addz,
//                      barMaxWidth:25,
                            barMinHeight: 25,
                        },*/

                       /* {
                            name: '公共池',
                            type: 'bar',
                            stack: '总量',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'insideRight'
                                }
                            },
                            data: addg,
//                      barMaxWidth:25,
                            barMinHeight: 25,
                        },*/

                    ]
                };
                department.setOption(option);
                window.onresize = department.resize;
                //===================================================
            } else if (data.state == 2) {


                var vis = [];//到访
                var dea = [];//成交

                var userName = [];//部门
                var addw = [];//总新增

                var follow = [];//跟进

                for (var i = 0; i < data.content.length; i++) {

                    vis.push(data.content[i].vis);
                    dea.push(data.content[i].dea);

                    userName.push(data.content[i].userName);
                    addw.push(data.content[i].addw);

                    follow.push(data.content[i].follow);
                }
                //报表=====================部门==========================
                var department = echarts.init(document.getElementById('ChildOne'));
                option = {
                    title: {text: "本周销售报表", textStyle: {color: "red"}, left: "20%",},
                    tooltip: {
                        trigger: 'axis',
                        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                        }
                    },
                    legend: {
                        data: ['\n', '\n', '\n',  '总新增' , '跟进', '到访', '成交', ],
                        textStyle: {color: "rgba(0, 217, 210,1)", fontSize: 16}
                    },
                    grid: {
                        left: '3%',
                        right: '50%',
                        top: '20%',
                        bottom: '15%',
                        containLabel: true,
                    },
                    xAxis: {
                        type: 'value',
                        min: 0,
                        // max: 500,
                        splitLine: {show: false},//去除网格线
                        axisLine: {lineStyle: {color: "rgba(0, 123, 198,0.65)", width: 1,},},
                        axisLabel: {
                            interval: 0,
//                                        rotate: 40,//倾斜度
                            show: true,
                            textStyle: {color: "rgba(0, 217, 210,1)", fontSize: "14"}
                        },
                    },
                    yAxis: {
                        type: 'category',
                        data: userName,
                        axisLabel: {
                            interval: 0,
//                                        rotate: 40,//倾斜度
                            show: true,
                            textStyle: {color: "rgba(0, 217, 210,1)", fontSize: "14"}
                        },
                        axisLine: {lineStyle: {color: "rgba(0, 123, 198,0.65)", width: 1,},},
                    },
                    series: [
                        {
                            name: '总新增',
                            type: 'bar',
                            stack: '总量',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'insideRight'
                                }
                            },
                            data: addw,
                             barMaxWidth:125,
                            barMinHeight: 25,
                        },

                        {
                            name: '跟进',
                            type: 'bar',
                            stack: '总量',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'insideRight'
                                }
                            },
                            data: follow,
                            barMaxWidth:55,
                            barMinHeight: 35,
                        },
                        {
                            name: '到访',
                            type: 'bar',
                            stack: '总量',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'insideRight'
                                }
                            },
                            data: vis,
                     barMaxWidth:35,
                            barMinHeight: 25,
                        },
                        {
                            name: '成交',
                            type: 'bar',
                            stack: '总量',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'insideRight'
                                }
                            },
                            data: dea,
                     barMaxWidth:35,
                            barMinHeight: 25,
                        },


                    ]
                };
                department.setOption(option);
                window.onresize = department.resize;
                //===================================================


            } else {
                alert(data.message)
            }
        }
    });

//=========新增、带访、成交数据排行=============
    $.ajax({
        url: "./home/rank.shtml",
        type: "get",
        cache: false,
        dataType: "json",

        success: function (data) {
            console.log("ad" + data);

            if (data.state == 1) {
                // console.log(data)
                //个人成交
                var userName = [], name = [], dea = [];
                //个人带访
                var rankPername = [], rankPerVis = [], rankPeruserName = [];
                //个人新增
                var rankPerDname = [], rankPerDaddw = [], rankPerDuserName = [];

                /*===个人成交===*/
                for (var i = 0; i < data.content.rankPerDeaMonth.length; i++) {
                    userName.push(data.content.rankPerDeaMonth[i].userName);
                    name.push(data.content.rankPerDeaMonth[i].name);
                    dea.push(data.content.rankPerDeaMonth[i].dea);
                }

                /*====个人带访===*/
                for (var i = 0; i < data.content.rankPerVisMonth.length; i++) {
                    rankPerVis.push(data.content.rankPerVisMonth[i].vis);
                    rankPername.push(data.content.rankPerVisMonth[i].name);
                    rankPeruserName.push(data.content.rankPerVisMonth[i].userName);
                }
                /*=====个人新增===*/
                for (var i = 0; i < data.content.rankPerAddMonth.length; i++) {
                    rankPerDname.push(data.content.rankPerAddMonth[i].name);
                    rankPerDaddw.push(data.content.rankPerAddMonth[i].addw);
                    rankPerDuserName.push(data.content.rankPerAddMonth[i].userName);
                }
                /*===============个人成交====================*/
                var Perdeav = echarts.init(document.getElementById("rankPerDea"));
                option = {
                    title: {
                        text: "本月成交排行",
                        textStyle: {color: "rgba(0, 217, 210,1)",},
                        left: "center"
                    },
                    grid: {left: "4%", right: "4%", bottom: "3%", containLabel: true, x: 130},
                    tooltip: {},
                    grid: {
                        left: '3%',
                        right: '10%',
                        top: '15%',
                        bottom: '15%',
                        containLabel: true
                    },
                    xAxis: {
                        splitLine: {show: false},
                        axisLabel: {show: true, textStyle: {color: "rgba(0, 217, 210,1)"}},
                        axisLine: {lineStyle: {color: "rgba(0, 123, 198,0.65)", width: 1,}}
                    },
                    yAxis: [{
                        type: "category",
                        data: name,
                        axisLabel: {
                            interval: 0,
                            rotate: 40,
                            show: true,
                            textStyle: {color: "rgba(0, 217, 210,1)", fontSize: "12"}
                        },
                        axisLine: {lineStyle: {color: "rgba(0, 123, 198,0.65)", width: 1,},},
                    }, {
                        type: "category",
                        axisTick: {show: false},
                        axisLine: {onZero: false, lineStyle: {color: "rgba(0, 123, 198,0.65)",},},
                        axisLabel: {textStyle: {color: "rgba(0, 217, 210,1)", fontSize: "12"}},
                        data: userName,
                        position: "right",
                        nameLocation: "end",
                        nameTextStyle: {color: "#30ad3a", fontWeight: "normal", padding: [0, 0, 0, 200],},
                    },],
                    series: [{
                        name: "排行",
                        type: "bar",
                        data: dea,
                        label: {normal: {show: true, position: "insideRight"}},
                        itemStyle: {normal: {color: "#c2c4b5"}},
                    }]
                };
                Perdeav.setOption(option);
                window.onresize = Perdeav.resize
                /*===============个人带访============================*/
                var PerVisV = echarts.init(document.getElementById("rankPerVis"));
                option = {
                    title: {
                        text: "本月到访排行",
                        textStyle: {color: "rgba(0, 217, 210,1)"},
                        left: "center"
                    },
                    grid: {
                        left: '3%',
                        right: '10%',
                        top: '15%',
                        bottom: '15%',
                        containLabel: true
                    },
                    tooltip: {},
                    xAxis: {
                        splitLine: {show: false},
                        axisLabel: {show: true, textStyle: {color: "rgba(0, 217, 210,1)"}},
                        axisLine: {lineStyle: {color: "rgba(0, 123, 198,0.65)", width: 1,}}
                    },
                    yAxis: [{
                        type: "category",
                        data: rankPername,
                        axisLabel: {
                            interval: 0,
                            rotate: 40,
                            show: true,
                            textStyle: {color: "rgba(0, 217, 210,1)", fontSize: "12"}
                        },
                        axisLine: {lineStyle: {color: "rgba(0, 123, 198,0.65)", width: 1,},},
                    }, {
                        type: "category",
                        axisTick: {show: false},
                        axisLine: {onZero: false, lineStyle: {color: "rgba(0, 123, 198,0.65)",},},
                        axisLabel: {textStyle: {color: "rgba(0, 217, 210,1)", fontSize: "12"}},
                        data: rankPeruserName,
                        position: "right",
                        nameLocation: "end",
                        nameTextStyle: {color: "#30ad3a", fontWeight: "normal", padding: [0, 0, 0, 200],},
                    },],
                    series: [{
                        name: "排行",
                        type: "bar",
                        barMinHeight: 20,
                        data: rankPerVis,
                        label: {normal: {show: true, position: "insideRight"}},
                        // itemStyle: {normal: {color: "rgba(0, 123, 198,0.65)"}},
                        itemStyle: {normal: {color: "rgba(0, 217, 210,1)"}},
                    }]
                };
                PerVisV.setOption(option);
                window.onresize = PerVisV.resize
                /*=================个人新增=================================*/
                var PerAddj = echarts.init(document.getElementById("rankPerAdd"));
                option = {
                    title: {
                        text: "本月新增排行",
                        textStyle: {color: "rgba(0, 217, 210,1)"},
                        left: "center"
                    },
                    grid: {
                        left: '3%',
                        right: '10%',
                        top: '15%',
                        bottom: '15%',
                        containLabel: true
                    },
                    tooltip: {},
                    xAxis: {
                        splitLine: {show: false},
                        axisLabel: {show: true, textStyle: {color: "rgba(0, 217, 210,1)"}},
                        axisLine: {lineStyle: {color: "rgba(0, 123, 198,0.65)", width: 1,}}
                    },
                    yAxis: [{
                        type: "category",
                        data: rankPerDname,
                        axisLabel: {
                            interval: 0,
                            rotate: 40,
                            show: true,
                            textStyle: {color: "rgba(0, 217, 210,1)", fontSize: "12"}
                        },
                        axisLine: {lineStyle: {color: "rgba(0, 123, 198,0.65)", width: 1,},},
                    }, {
                        type: "category",
                        axisTick: {show: false},
                        axisLine: {onZero: false, lineStyle: {color: "rgba(0, 123, 198,0.65)",},},
                        axisLabel: {textStyle: {color: "rgba(0, 217, 210,1)", fontSize: "12"}},
                        data: rankPerDuserName,
                        position: "right",
                        nameLocation: "end",
                        nameTextStyle: {
                            color: "rgba(0, 217, 210,1)",
                            fontWeight: "normal",
                            padding: [0, 0, 0, 200],
                        },
                    },],
                    series: [{
                        name: "新增排行",
                        type: "bar",
                        data: rankPerDaddw,
                        label: {normal: {show: true, position: "insideRight"}},
                        // itemStyle: {normal: {color: "rgba(0, 123, 198,0.65)"}},
                        itemStyle: {normal: {color: "rgba(0, 217, 210,1)"}},
                    }]
                };
                PerAddj.setOption(option);
                window.onresize = PerAddj.resize

                /*==================================================*/
            } else {
                alert(data.message)
            }

        }
    })

//成交项目数据
    $.ajax({
        url: "./home/findByDeal.shtml",
        type: "get",
        dataType: "json",
        success: function (data) {
            console.log("1" + data);
            //===================================================================
            var x = 10;
            function time(number) {

                for (var i = number - 10; i < number; i++) {
                    var date = new Date(data.content[i].dealDate);
                    var y = date.getFullYear();
                    var m = date.getMonth() + 1;
                    var d = date.getDate();
                    m = m < 10 ? ("0" + m) : m;
                    d = d < 10 ? ("0" + d) : d;
                    var date1 = y + "-" + m + "-" + d;
                    /* for(var i=0;i<data.content.length;i++) {*/
                    $("#ChildTwo").append($(
                        "<div class='tivb'>" +
                        "<div class='DeaChild'>" + data.content[i].userName + "</div>" +
                        " <div class='DeaChild'>" + data.content[i].projectId + "</div>" +
                        "<div class='DeaChild'>" + data.content[i].commission + "</div>" +
                        "<div class='DeaChild'>" + date1 + "</div>" +
                        "</div>"
                    ));
                }
            }
            time(x);

            var gd = setInterval(function () {

                x = x + 10;
                if (x < data.content.length || x - data.content.length < 10) {
                    $('.tivb').empty();
                    time(x);
                }
                if (x >= data.content.length) {
                    x = 0;
                }
            }, 5000)
            //===================================================================

        }
    });
//================================
});