
$(function () {
        var myChart = echarts.init(document.getElementById('TwoLineChart'));
        // 显示标题，图例和空的坐标轴
        myChart.setOption({
            title: {
                text: '本月个人报表'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['新增', '跟进', '带访']
            },
            toolbox: {
                show: true,
                feature: {
                    mark: { show: true },
                    dataView: { show: true, readOnly: false },
                    magicType: { show: true, type: ['line', 'bar'] },
                    restore: { show: true },
                    saveAsImage: { show: true }
                }
            },
            calculable: true,
            xAxis: {
                type: 'category',
                boundaryGap: false, //取消左侧的间距
                data: ['1号','2号','3号','4号','5号','6号','7号','8号','9号','10号','11号','12号','13号','14号','15号','16号','17号','18号','19号','20号','21号','22号','23号','24号','25号','26号','27号','28号','29号','30号','31号']
            },
            yAxis: {
                type: 'value',
                splitLine: { show: false },//去除网格线
                axisLabel: {
                    formatter: '{value} 组'
                },
                name: ''
            },
            series: [{
                name: '新增',
                type: 'line',
                symbol: 'emptydiamond',    //设置折线图中表示每个坐标点的符号 emptycircle：空心圆；emptyrect：空心矩形；circle：实心圆；emptydiamond：菱形
                data: []
            }, {
                    name: '跟进',
                    type: 'line',
                    symbol: 'emptydiamond',    //设置折线图中表示每个坐标点的符号 emptycircle：空心圆；emptyrect：空心矩形；circle：实心圆；emptydiamond：菱形
                    data: []
                },{
                    name: '带访',
                    type: 'line',
                    symbol: 'emptydiamond',    //设置折线图中表示每个坐标点的符号 emptycircle：空心圆；emptyrect：空心矩形；circle：实心圆；emptydiamond：菱形
                    data: []
                }]
        });
        myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画
        //类别数组（实际用来盛放X轴坐标值）
        var series1 = [];
        var series2 = [];
         var series3 = [];
        $.ajax({
            type: 'post',
            url:' ./personal/findPedays.shtml',//请求数据的地址
            dataType: "json",        //返回数据形式为json
            success: function (result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                $.each(result, function (index, item) {
                    //挨个取出类别并填入类别数组
                    series1.push(item.adds);
                    series2.push(item.follow);
                    series3.push(item.visit);
                });

                myChart.hideLoading();    //隐藏加载动画
                myChart.setOption({        //加载数据图表
                    series: [
                      {data: series1
                    },{data: series2
                    },{data: series3
                        }]
                });
            },
            error: function (errorMsg) {
                //请求失败时执行该函数
                layer.alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        });


});

