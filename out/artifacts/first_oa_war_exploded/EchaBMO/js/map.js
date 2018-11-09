$(function () {
    // 百度地图API功能
    // var map = new BMap.Map("EC_BMB_All_center_center_map", {
    //     enableMapClick: false
    // });
    // // 创建Map实例
    // map.centerAndZoom(new BMap.Point(104.15387779714175, 30.631074634361198), 13)
    // map.enableScrollWheelZoom(true); // 开启鼠标滚轮缩放
    // // marker = new BMap.Marker(point);  // 创建标注
    // // map.addOverlay(marker)
    // map.setMapStyle({
    //     style: 'midnight',
    // });
    //
    // var img = new Image();
    // img.src = './Image/fly.png';
    //
    // var data = [];
    //     var citys=[
    //         {
    //             lat:30.631074634361198,
    //             lng:104.15387779714175
    //         },
    //         {
    //             lat:30.56642630713711,
    //             lng:104.27452778475143
    //         },
    //         {
    //             lat:30.78372590958852,
    //             lng:103.92970562186413
    //         },
    //         {
    //             lat:30.618364345135504,
    //             lng:104.1585132751936
    //         },
    //         {
    //             lat:30.547433284041187,
    //             lng:104.05320296009057
    //         }
    //     ]
    // // 构造数据
    //        for (i=0;i<citys.length;i++){
    //            data.push({
    //                geometry: {
    //                    type: 'Point',
    //                    coordinates: [citys[i].lng,citys[i].lat]
    //                },
    //                // count: 30 * Math.random(),
    //                icon: img,
    //            });
    //        }
    // var dataSet = new mapv.DataSet(data);
    // var options = {
    //     fillStyle: 'rgba(255, 50, 50, 0.6)',
    //     shadowColor: 'rgba(255, 50, 50, 1)',
    //     shadowBlur: 30,
    //     // globalCompositeOperation: 'lighter',
    //     methods: {
    //         click: function (item){
    //             console.log(item);
    //         }
    //     },
    //     size: 30,
    //     width: 20,
    //     height: 20,
    //     //自定义图标
    //     draw:"icon",
    // }
    //
    // var mapvLayer = new mapv.baiduMapLayer(map, dataSet, options);

    // dataSet.set(data); // 修改数据
    // mapvLayer.show(); // 显示图层
    // mapvLayer.hide(); // 删除图层


    //
    // var mapChart;
    // // var option;
    // $.get('Js/lunboBaobiao/chengdu.json', function (chengdujson) {
    //     echarts.registerMap('成都', chengdujson);
    //     mapChart = echarts.init(document.getElementById('EC_BMB_All_center_center_map'));
    //     option = {
    //         title:{
    //             text: '成都市分布图',
    //             textStyle:{
    //                 color:'#fff'
    //             },
    //             left: 'center'
    //         },
    //         // toolbox: {
    //         //     show: true,
    //         //     orient: 'vertical',
    //         //     left: 'right',
    //         //     top: 'center',
    //         //     feature: {
    //         //         dataView: {readOnly: false},
    //         //         restore: {},
    //         //         saveAsImage: {}
    //         //     }
    //         // },
    //         // visualMap: {
    //         //     min: 800,
    //         //     max:50000,
    //         //     text:['High','Low'],
    //         //     realtime: false,
    //         //     calculable: true,
    //         //     inRange: {
    //         //         color: ['lightskyblue','yellow', 'orangered','orangered']
    //         //     }
    //         // },
    //         tooltip: {
    //             trigger: 'item',
    //             formatter: '{b}<br/>{c} (个)'
    //         },
    //         toolbox: {
    //             show: true,
    //             orient: 'vertical',
    //             left: 'right',
    //             top: 'center',
    //             feature: {
    //                 dataView: {readOnly: false},
    //                 restore: {},
    //                 saveAsImage: {}
    //             }
    //         },
    //         series:[
    //             {
    //                 type: 'map',
    //                 map: '成都', // 自定义扩展图表类型
    //                 aspectScale: 0.7, //地图长宽比. default: 0.75
    //                 zoom: 1.1, //控制地图的zoom，动手自己更改下 看看什么效果吧
    //                 roam: true,
    //                 itemStyle:{
    //                     normal:{
    //                         // color:'red',
    //                         label:{
    //                             show:true,
    //                             //字体颜色b
    //                             // color:'red',
    //                             color: 'rgba(0, 0, 0,0.8)',
    //                             fontFamily:'微软雅黑',
    //                             fontSize: '7',
    //                         },
    //                         areaStyle:{color:'red'}
    //                       },
    //                     emphasis:{label:{show:false}}
    //                 }
    //             }
    //         ]
    //     }
    //     mapChart.setOption(option);
    //
    // });



})