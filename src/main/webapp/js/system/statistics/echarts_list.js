$(function () {
    var myChart = echarts.init(document.getElementById('TwoLineChart'));
    // 显示标题，图例和空的坐标轴
    myChart.setOption({
        title: {
            text: '本月各部门新增'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['网络部', '东一', '东二', '南一', '南二', '西一', '北一']
        },
        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        xAxis: {
            type: 'category',
            boundaryGap: false, //取消左侧的间距
            data: ['1号', '2号', '3号', '4号', '5号', '6号', '7号', '8号', '9号', '10号', '11号', '12号', '13号', '14号', '15号', '16号', '17号', '18号', '19号', '20号', '21号', '22号', '23号', '24号', '25号', '26号', '27号', '28号', '29号', '30号', '31号']
        },
        yAxis: {
            type: 'value',
            splitLine: {show: false},//去除网格线
            axisLabel: {
                formatter: '{value} 组'
            },
            name: ''
        },
        series: [{
            name: '网络部',
            type: 'line',
            stack: '总量',
            symbol: 'emptydiamond',    //设置折线图中表示每个坐标点的符号 emptycircle：空心圆；emptyrect：空心矩形；circle：实心圆；emptydiamond：菱形
            data: []
        }, {
            name: '东一',
            type: 'line',
            stack: '总量',
            symbol: 'emptydiamond',
            data: []
        }, {
            name: '东二',
            type: 'line',
            stack: '总量',
            symbol: 'emptydiamond',
            data: []
        }, {
            name: '南一',
            type: 'line',
            stack: '总量',
            symbol: 'emptydiamond',
            data: []
        }, {
            name: '南二',
            type: 'line',
            stack: '总量',
            symbol: 'emptydiamond',
            data: []
        }, {
            name: '西一',
            type: 'line',
            stack: '总量',
            symbol: 'emptydiamond',
            data: []
        }, {
            name: '北一',
            type: 'line',
            stack: '总量',
            symbol: 'emptydiamond',
            data: []
        }]
    });
    myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画
    //类别数组（实际用来盛放X轴坐标值）
    var series1 = [];
    var series2 = [];
    var series3 = [];
    var series4 = [];
    var series5 = [];
    var series6 = [];
    var series7 = [];
    $.ajax({
        type: 'post',
        url: ' ./statistics/findDedays.shtml',//请求数据的地址
        dataType: "json",        //返回数据形式为json
        success: function (result) {
            console.log("da" + result)
            //请求成功时执行该函数内容，result即为服务器返回的json对象
            $.each(result, function (index, item) {
                if (item.id == 28) { //挨个取出类别并填入类别数组
                    series1.push(item.addw);
                } else if (item.id == 16) {
                    series2.push(item.addw);
                } else if (item.id == 17) {
                    series3.push(item.addw);
                }else if (item.id == 20) {
                    series4.push(item.addw);
                }else if (item.id == 21) {
                    series5.push(item.addw);
                }else if (item.id == 18) {
                    series6.push(item.addw);
                }else if (item.id == 24) {
                    series7.push(item.addw);
                }


            });

            myChart.hideLoading();    //隐藏加载动画
            myChart.setOption({        //加载数据图表
                series: [
                    {
                        data: series1
                    }, {
                        data: series2
                    }, {
                        data: series3
                    }, {
                        data: series4
                    }, {
                        data: series5
                    }, {
                        data: series6
                    }, {
                        data: series7
                    }]
            });
        },
        error: function (errorMsg) {
            //请求失败时执行该函数
            layer.alert("图表请求数据失败!");
            myChart.hideLoading();
        }
    });

    var myChart1 = echarts.init(document.getElementById('TwoLineChart1'));
    // 显示标题，图例和空的坐标轴
    myChart1.setOption({
        title: {
            text: '本月各部门跟进'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['网络部', '东一', '东二', '南一', '南二', '西一', '北一']
        },
        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        xAxis: {
            type: 'category',
            boundaryGap: false, //取消左侧的间距
            data: ['1号', '2号', '3号', '4号', '5号', '6号', '7号', '8号', '9号', '10号', '11号', '12号', '13号', '14号', '15号', '16号', '17号', '18号', '19号', '20号', '21号', '22号', '23号', '24号', '25号', '26号', '27号', '28号', '29号', '30号', '31号']
        },
        yAxis: {
            type: 'value',
            splitLine: {show: false},//去除网格线
            axisLabel: {
                formatter: '{value} 组'
            },
            name: ''
        },
        series: [{
            name: '网络部',
            type: 'line',
            stack: '总量',
            symbol: 'emptydiamond',    //设置折线图中表示每个坐标点的符号 emptycircle：空心圆；emptyrect：空心矩形；circle：实心圆；emptydiamond：菱形
            data: []
        }, {
            name: '东一',
            type: 'line',
            stack: '总量',
            symbol: 'emptydiamond',
            data: []
        }, {
            name: '东二',
            type: 'line',
            stack: '总量',
            symbol: 'emptydiamond',
            data: []
        }, {
            name: '南一',
            type: 'line',
            stack: '总量',
            symbol: 'emptydiamond',
            data: []
        }, {
            name: '南二',
            type: 'line',
            stack: '总量',
            symbol: 'emptydiamond',
            data: []
        }, {
            name: '西一',
            type: 'line',
            stack: '总量',
            symbol: 'emptydiamond',
            data: []
        }, {
            name: '北一',
            type: 'line',
            stack: '总量',
            symbol: 'emptydiamond',
            data: []
        }]
    });
    myChart1.showLoading();    //数据加载完之前先显示一段简单的loading动画
    //类别数组（实际用来盛放X轴坐标值）
    var series8 = [];
    var series9 = [];
    var series10 = [];
    var series11 = [];
    var series12 = [];
    var series13 = [];
    var series14 = [];
    $.ajax({
        type: 'post',
        url: ' ./statistics/findDedays.shtml',//请求数据的地址
        dataType: "json",        //返回数据形式为json
        success: function (result) {
            console.log("da" + result)
            //请求成功时执行该函数内容，result即为服务器返回的json对象
            $.each(result, function (index, item) {
                if (item.id == 28) { //挨个取出类别并填入类别数组
                    series8.push(item.follow);
                } else if (item.id == 16) {
                    series9.push(item.follow);
                } else if (item.id == 17) {
                    series10.push(item.follow);
                }else if (item.id == 20) {
                    series11.push(item.follow);
                }else if (item.id == 21) {
                    series12.push(item.follow);
                }else if (item.id == 18) {
                    series13.push(item.follow);
                }else if (item.id == 24) {
                    series14.push(item.follow);
                }


            });

            myChart1.hideLoading();    //隐藏加载动画
            myChart1.setOption({        //加载数据图表
                series: [
                    {
                        data: series8
                    }, {
                        data: series9
                    }, {
                        data: series10
                    }, {
                        data: series11
                    }, {
                        data: series12
                    }, {
                        data: series13
                    }, {
                        data: series14
                    }]
            });
        },
        error: function (errorMsg) {
            //请求失败时执行该函数
            layer.alert("图表请求数据失败!");
            myChart1.hideLoading();
        }
    });
    var myChart2= echarts.init(document.getElementById('TwoLineChart2'));
    // 显示标题，图例和空的坐标轴
    myChart2.setOption({
        title: {
            text: '本月各部门带访'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['网络部', '东一', '东二', '南一', '南二', '西一', '北一']
        },
        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        xAxis: {
            type: 'category',
            boundaryGap: false, //取消左侧的间距
            data: ['1号', '2号', '3号', '4号', '5号', '6号', '7号', '8号', '9号', '10号', '11号', '12号', '13号', '14号', '15号', '16号', '17号', '18号', '19号', '20号', '21号', '22号', '23号', '24号', '25号', '26号', '27号', '28号', '29号', '30号', '31号']
        },
        yAxis: {
            type: 'value',
            splitLine: {show: false},//去除网格线
            axisLabel: {
                formatter: '{value} 组'
            },
            name: ''
        },
        series: [{
            name: '网络部',
            type: 'line',
            stack: '总量',
            symbol: 'emptydiamond',    //设置折线图中表示每个坐标点的符号 emptycircle：空心圆；emptyrect：空心矩形；circle：实心圆；emptydiamond：菱形
            data: []
        }, {
            name: '东一',
            type: 'line',
            stack: '总量',
            symbol: 'emptydiamond',
            data: []
        }, {
            name: '东二',
            type: 'line',
            stack: '总量',
            symbol: 'emptydiamond',
            data: []
        }, {
            name: '南一',
            type: 'line',
            stack: '总量',
            symbol: 'emptydiamond',
            data: []
        }, {
            name: '南二',
            type: 'line',
            stack: '总量',
            symbol: 'emptydiamond',
            data: []
        }, {
            name: '西一',
            type: 'line',
            stack: '总量',
            symbol: 'emptydiamond',
            data: []
        }, {
            name: '北一',
            type: 'line',
            stack: '总量',
            symbol: 'emptydiamond',
            data: []
        }]
    });
    myChart2.showLoading();    //数据加载完之前先显示一段简单的loading动画
    //类别数组（实际用来盛放X轴坐标值）
    var series15 = [];
    var series16 = [];
    var series17 = [];
    var series18 = [];
    var series19 = [];
    var series20 = [];
    var series21 = [];
    $.ajax({
        type: 'post',
        url: ' ./statistics/findDedays.shtml',//请求数据的地址
        dataType: "json",        //返回数据形式为json
        success: function (result) {
            console.log("da" + result)
            //请求成功时执行该函数内容，result即为服务器返回的json对象
            $.each(result, function (index, item) {
                if (item.id == 28) { //挨个取出类别并填入类别数组
                    series15.push(item.vis);
                } else if (item.id == 16) {
                    series16.push(item.vis);
                } else if (item.id == 17) {
                    series17.push(item.vis);
                }else if (item.id == 20) {
                    series18.push(item.vis);
                }else if (item.id == 21) {
                    series19.push(item.vis);
                }else if (item.id == 18) {
                    series20.push(item.vis);
                }else if (item.id == 24) {
                    series21.push(item.vis);
                }


            });

            myChart2.hideLoading();    //隐藏加载动画
            myChart2.setOption({        //加载数据图表
                series: [
                    {
                        data: series15
                    }, {
                        data: series16
                    }, {
                        data: series17
                    }, {
                        data: series18
                    }, {
                        data: series19
                    }, {
                        data: series20
                    }, {
                        data: series21
                    }]
            });
        },
        error: function (errorMsg) {
            //请求失败时执行该函数
            layer.alert("图表请求数据失败!");
            myChart2.hideLoading();
        }
    });
});

