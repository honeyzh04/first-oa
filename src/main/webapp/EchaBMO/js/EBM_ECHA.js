$(function() {
	function Aja() {
		$
				.ajax({
					url : "http://win.firstjia.com/first-oa/TVreport/shows.shtml",
					type : "get",
					cache : false,
					dataType : "jsonp",
					jsonp : "callback",
					jsonpCallback : "getMessage",
					success : function(data) {
						var names = [];
						var Xaddw = [];
						for (i = 0; i < data.rankDeAddMonth.length; i++) {
							if (data.rankDeAddMonth[i].addw !== 0) {
								names.push(data.rankDeAddMonth[i].name);
								Xaddw.push(data.rankDeAddMonth[i].addw);
								var myChart = echarts
										.init(document
												.getElementById("EC_BMB_All_center_left_Bmen_Add"));
								option = {
									title : {
										text : "新增排行榜",
										textStyle : {
											color : "#fff",
										}
									},
									grid : {
										left : "4%",
										right : "4%",
										bottom : "3%",
										containLabel : true,
										x : 130
									},
									tooltip : {},
									xAxis : {
										type : "value",
										splitLine : {
											show : false
										},
										axisLabel : {
											show : true,
											textStyle : {
												color : "#fff"
											}
										},
										axisLine : {
											lineStyle : {
												color : "rgba(0, 123, 198,0.65)",
												width : 1,
											}
										}
									},
									yAxis : {
										type : "category",
										data : names,
										axisLabel : {
											interval : 0,
											rotate : 40,
											show : true,
											textStyle : {
												color : "#fff"
											}
										},
										axisLine : {
											lineStyle : {
												color : "rgba(0, 123, 198,0.65)",
												width : 1,
											},
										},
									},
									series : [ {
										name : "排行",
										type : "bar",
										barMinHeight : 20,
										data : Xaddw,
										label : {
											normal : {
												show : true,
												position : "insideRight"
											}
										},
										itemStyle : {
											normal : {
												color : "rgba(0, 123, 198,0.65)"
											}
										}
									} ]
								};
								myChart.setOption(option);
								window.onresize = myChart.resize
							} else {
								$("#EC_BMB_All_center_left_Bmen_Add").text(
										"暂无新增数据")
							}
						}
						var followName = [];
						var Ffollow = [];
						for (i = 0; i < data.rankDeFollowMonth.length; i++) {
							if (data.rankDeFollowMonth[i].follow !== 0) {
								followName.push(data.rankDeFollowMonth[i].name);
								Ffollow.push(data.rankDeFollowMonth[i].follow);
								var Follow = echarts
										.init(document
												.getElementById("EC_BMB_All_center_left_Bmen_follow"));
								option = {
									title : {
										text : "跟进排行榜",
										textStyle : {
											color : "#fff"
										}
									},
									grid : {
										left : "4%",
										right : "4%",
										bottom : "3%",
										containLabel : true,
										x : 130
									},
									tooltip : {},
									xAxis : {
										type : "value",
										splitLine : {
											show : false
										},
										axisLabel : {
											show : true,
											textStyle : {
												color : "#fff",
												left : 0
											}
										},
										axisLine : {
											lineStyle : {
												color : "rgba(0, 123, 198,0.65)",
												width : 1,
											}
										},
									},
									yAxis : {
										type : "category",
										data : followName,
										axisLabel : {
											interval : 0,
											rotate : 40,
											show : true,
											textStyle : {
												color : "#fff"
											}
										},
										axisLine : {
											lineStyle : {
												color : "rgba(0, 123, 198,0.65)",
												width : 1,
											},
										},
									},
									series : [ {
										name : "排行",
										type : "bar",
										barMinHeight : 20,
										data : Ffollow,
										label : {
											normal : {
												show : true,
												position : "insideRight"
											}
										},
										itemStyle : {
											normal : {
												color : "rgba(0, 123, 198,0.65)"
											}
										}
									} ]
								};
								Follow.setOption(option);
								window.onresize = Follow.resize
							} else {
								$("#EC_BMB_All_center_left_Bmen_follow").text(
										"暂无跟进数据")
							}
						}
						var VisName = [];
						var Vvis = [];
						for (i = 0; i < data.rankDeVisMonth.length; i++) {
							if (data.rankDeVisMonth[i].vis !== 0) {
								VisName.push(data.rankDeVisMonth[i].name);
								Vvis.push(data.rankDeVisMonth[i].vis);
								var Vis = echarts
										.init(document
												.getElementById("EC_BMB_All_center_left_Bmen_vis"));
								option = {
									title : {
										text : "到访排行榜",
										textStyle : {
											color : "#fff"
										}
									},
									grid : {
										left : "4%",
										right : "4%",
										bottom : "3%",
										containLabel : true,
										x : 130
									},
									tooltip : {},
									xAxis : {
										splitLine : {
											show : false
										},
										axisLabel : {
											show : true,
											textStyle : {
												color : "#fff"
											}
										},
										axisLine : {
											lineStyle : {
												color : "rgba(0, 123, 198,0.65)",
												width : 1,
											}
										}
									},
									yAxis : {
										type : "category",
										data : VisName,
										axisLabel : {
											interval : 0,
											rotate : 40,
											show : true,
											textStyle : {
												color : "#fff"
											}
										},
										axisLine : {
											lineStyle : {
												color : "rgba(0, 123, 198,0.65)",
												width : 1,
											},
										},
									},
									series : [ {
										name : "排行",
										type : "bar",
										barMinHeight : 20,
										data : Vvis,
										label : {
											normal : {
												show : true,
												position : "insideRight"
											}
										},
										itemStyle : {
											normal : {
												color : "rgba(0, 123, 198,0.65)"
											}
										}
									} ]
								};
								Vis.setOption(option);
								window.onresize = Vis.resize
							} else {
								$("#EC_BMB_All_center_left_Bmen_vis").text(
										"暂无到访数据")
							}
						}
						var DeaName = [];
						var DDea = [];
						for (i = 0; i < data.rankDeDeaMonth.length; i++) {
							if (data.rankDeDeaMonth[i].dea !== 0) {
								DeaName.push(data.rankDeDeaMonth[i].name);
								DDea.push(data.rankDeDeaMonth[i].dea);
								var DeaD = echarts
										.init(document
												.getElementById("EC_BMB_All_center_left_Bmen_Dea"));
								option = {
									title : {
										text : "部门成交新增排行",
										textStyle : {
											color : "#fff"
										}
									},
									grid : {
										left : "4%",
										right : "4%",
										bottom : "3%",
										containLabel : true,
										x : 130
									},
									tooltip : {},
									xAxis : {
										splitLine : {
											show : false
										},
										axisLabel : {
											show : true,
											textStyle : {
												color : "#fff",
											}
										},
										axisLine : {
											lineStyle : {
												color : "rgba(0, 123, 198,0.65)",
												width : 1,
											}
										}
									},
									yAxis : {
										type : "category",
										data : DeaName,
										axisLabel : {
											interval : 0,
											rotate : 40,
											show : true,
											textStyle : {
												color : "#fff",
												fontSize : "12"
											}
										},
										axisLine : {
											lineStyle : {
												color : "rgba(0, 123, 198,0.65)",
												width : 1,
											},
										},
									},
									series : [ {
										name : "排行",
										type : "bar",
										barMinHeight : 20,
										data : DDea,
										label : {
											normal : {
												show : true,
												position : "insideRight"
											}
										},
										itemStyle : {
											normal : {
												color : "rgba(0, 123, 198,0.65)"
											}
										}
									} ]
								};
								DeaD.setOption(option);
								window.onresize = DeaD.resize
							} else {
								$("#EC_BMB_All_center_left_Bmen_Dea").text(
										"暂无成交数据")
							}
						}
						var PerAddBNam = [];
						var PerAddUsername = [];
						var PerAdd = [];
						for (i = 0; i < data.rankPerAddMonth.length; i++) {
							if (data.rankPerAddMonth[i].addw !== 0) {
								PerAddBNam.push(data.rankPerAddMonth[i].name);
								PerAddUsername
										.push(data.rankPerAddMonth[i].userName);
								PerAdd.push(data.rankPerAddMonth[i].addw);
								var PerAddj = echarts
										.init(document
												.getElementById("EC_BMB_All_center_left_bottom_grr"));
								option = {
									title : {
										text : "个人当月新增排行",
										textStyle : {
											color : "#fff"
										}
									},
									grid : {
										left : "4%",
										right : "4%",
										bottom : "3%",
										containLabel : true,
										x : 130
									},
									tooltip : {},
									xAxis : {
										splitLine : {
											show : false
										},
										axisLabel : {
											show : true,
											textStyle : {
												color : "#fff",
											}
										},
										axisLine : {
											lineStyle : {
												color : "rgba(0, 123, 198,0.65)",
												width : 1,
											}
										}
									},
									yAxis : [
											{
												type : "category",
												data : PerAddBNam,
												axisLabel : {
													interval : 0,
													rotate : 40,
													show : true,
													textStyle : {
														color : "#fff",
														fontSize : "12"
													}
												},
												axisLine : {
													lineStyle : {
														color : "rgba(0, 123, 198,0.65)",
														width : 1,
													},
												},
											},
											{
												type : "category",
												axisTick : {
													show : false
												},
												axisLine : {
													onZero : false,
													lineStyle : {
														color : "rgba(0, 123, 198,0.65)",
													},
												},
												axisLabel : {
													textStyle : {
														color : "#fff",
													}
												},
												data : PerAddUsername,
												position : "right",
												nameLocation : "end",
												nameTextStyle : {
													color : "#30ad3a",
													fontWeight : "normal",
													padding : [ 0, 0, 0, 200 ],
												},
											}, ],
									series : [ {
										name : "排行",
										type : "bar",
										data : PerAdd,
										label : {
											normal : {
												show : true,
												position : "insideRight"
											}
										},
										itemStyle : {
											normal : {
												color : "rgba(0, 123, 198,0.65)"
											}
										},
									} ]
								};
								PerAddj.setOption(option);
								window.onresize = PerAddj.resize
							} else {
								$("#EC_BMB_All_center_left_bottom_grr").text(
										"暂无个人新增数据")
							}
						}
						var PerfollowBName = [];
						var PerfollowUsername = [];
						var Perfollow = [];
						for (i = 0; i < data.rankPerFollowMonth.length; i++) {
							if (data.rankPerAddMonth[i].follow !== 0) {
								PerfollowBName
										.push(data.rankPerFollowMonth[i].name);
								PerfollowUsername
										.push(data.rankPerFollowMonth[i].userName);
								Perfollow
										.push(data.rankPerFollowMonth[i].follow);
								var PerFllowR = echarts
										.init(document
												.getElementById("EC_BMB_All_center_left_bottom_gere"));
								option = {
									title : {
										text : "个人当月跟进排行",
										textStyle : {
											color : "#fff"
										}
									},
									grid : {
										left : "4%",
										right : "4%",
										bottom : "3%",
										containLabel : true,
										x : 130
									},
									tooltip : {},
									xAxis : {
										splitLine : {
											show : false
										},
										axisLabel : {
											show : true,
											textStyle : {
												color : "#fff",
											}
										},
										axisLine : {
											lineStyle : {
												color : "rgba(0, 123, 198,0.65)",
												width : 1,
											}
										}
									},
									yAxis : [
											{
												type : "category",
												data : PerfollowBName,
												axisLabel : {
													interval : 0,
													rotate : 40,
													show : true,
													textStyle : {
														color : "#fff",
														fontSize : "12"
													}
												},
												axisLine : {
													lineStyle : {
														color : "rgba(0, 123, 198,0.65)",
														width : 1,
													},
												},
											},
											{
												type : "category",
												axisTick : {
													show : false
												},
												axisLine : {
													onZero : false,
													lineStyle : {
														color : "rgba(0, 123, 198,0.65)",
													},
												},
												axisLabel : {
													textStyle : {
														color : "#fff",
													}
												},
												data : PerfollowUsername,
												position : "right",
												nameLocation : "end",
												nameTextStyle : {
													color : "#30ad3a",
													fontWeight : "normal",
													padding : [ 0, 0, 0, 200 ],
												},
											}, ],
									series : [ {
										name : "排行",
										type : "bar",
										barMinHeight : 20,
										data : Perfollow,
										label : {
											normal : {
												show : true,
												position : "insideRight"
											}
										},
										itemStyle : {
											normal : {
												color : "rgba(0, 123, 198,0.65)"
											}
										},
									} ]
								};
								PerFllowR.setOption(option);
								window.onresize = PerFllowR.resize
							} else {
								$("#EC_BMB_All_center_left_bottom_gere").text(
										"暂无个人跟进数据")
							}
						}
						var PerVisBName = [];
						var PerVisUsername = [];
						var PerVis = [];
						for (i = 0; i < data.rankPerVisMonth.length; i++) {
							if (data.rankPerVisMonth[i].vis !== 0) {
								PerVisBName.push(data.rankPerVisMonth[i].name);
								PerVisUsername
										.push(data.rankPerVisMonth[i].userName);
								PerVis.push(data.rankPerVisMonth[i].vis);
								var PerVisV = echarts
										.init(document
												.getElementById("EC_BMB_All_center_left_bottom_geren"));
								option = {
									title : {
										text : "个人当月到访排行",
										textStyle : {
											color : "#fff"
										}
									},
									grid : {
										left : "4%",
										right : "4%",
										bottom : "3%",
										containLabel : true,
										x : 130
									},
									tooltip : {},
									xAxis : {
										splitLine : {
											show : false
										},
										axisLabel : {
											show : true,
											textStyle : {
												color : "#fff",
											}
										},
										axisLine : {
											lineStyle : {
												color : "rgba(0, 123, 198,0.65)",
												width : 1,
											}
										}
									},
									yAxis : [
											{
												type : "category",
												data : PerVisBName,
												axisLabel : {
													interval : 0,
													rotate : 40,
													show : true,
													textStyle : {
														color : "#fff",
														fontSize : "12"
													}
												},
												axisLine : {
													lineStyle : {
														color : "rgba(0, 123, 198,0.65)",
														width : 1,
													},
												},
											},
											{
												type : "category",
												axisTick : {
													show : false
												},
												axisLine : {
													onZero : false,
													lineStyle : {
														color : "rgba(0, 123, 198,0.65)",
													},
												},
												axisLabel : {
													textStyle : {
														color : "#fff",
													}
												},
												data : PerVisUsername,
												position : "right",
												nameLocation : "end",
												nameTextStyle : {
													color : "#30ad3a",
													fontWeight : "normal",
													padding : [ 0, 0, 0, 200 ],
												},
											}, ],
									series : [ {
										name : "排行",
										type : "bar",
										barMinHeight : 20,
										data : PerVis,
										label : {
											normal : {
												show : true,
												position : "insideRight"
											}
										},
										itemStyle : {
											normal : {
												color : "rgba(0, 123, 198,0.65)"
											}
										},
									} ]
								};
								PerVisV.setOption(option);
								window.onresize = PerVisV.resize
							} else {
								$("#EC_BMB_All_center_left_bottom_geren").text(
										"暂无个人到访数据")
							}
						}
						var PerdeaBName = [];
						var PerdeaUserName = [];
						var Perdea = [];
						for (i = 0; i < data.rankPerDeaMonth.length; i++) {
							if (data.rankPerDeaMonth[i].dea !== 0) {
								PerdeaBName.push(data.rankPerDeaMonth[i].name);
								PerdeaUserName
										.push(data.rankPerDeaMonth[i].userName);
								Perdea.push(data.rankPerDeaMonth[i].dea);
								var Perdeav = echarts
										.init(document
												.getElementById("EC_BMB_All_center_left_bottom_gerens"));
								option = {
									title : {
										text : "个人当月成交排行",
										textStyle : {
											color : "#fff"
										}
									},
									grid : {
										left : "4%",
										right : "4%",
										bottom : "3%",
										containLabel : true,
										x : 130
									},
									tooltip : {},
									xAxis : {
										splitLine : {
											show : false
										},
										axisLabel : {
											show : true,
											textStyle : {
												color : "#fff",
											}
										},
										axisLine : {
											lineStyle : {
												color : "rgba(0, 123, 198,0.65)",
												width : 1,
											}
										}
									},
									yAxis : [
											{
												type : "category",
												data : PerdeaBName,
												axisLabel : {
													interval : 0,
													rotate : 40,
													show : true,
													textStyle : {
														color : "#fff",
														fontSize : "12"
													}
												},
												axisLine : {
													lineStyle : {
														color : "rgba(0, 123, 198,0.65)",
														width : 1,
													},
												},
											},
											{
												type : "category",
												axisTick : {
													show : false
												},
												axisLine : {
													onZero : false,
													lineStyle : {
														color : "rgba(0, 123, 198,0.65)",
													},
												},
												axisLabel : {
													textStyle : {
														color : "#fff",
													}
												},
												data : PerdeaUserName,
												position : "right",
												nameLocation : "end",
												nameTextStyle : {
													color : "#30ad3a",
													fontWeight : "normal",
													padding : [ 0, 0, 0, 200 ],
												},
											}, ],
									series : [ {
										name : "排行",
										type : "bar",
										barMinHeight : 20,
										data : Perdea,
										label : {
											normal : {
												show : true,
												position : "insideRight"
											}
										},
										itemStyle : {
											normal : {
												color : "rgba(0, 123, 198,0.65)"
											}
										},
									} ]
								};
								Perdeav.setOption(option);
								window.onresize = Perdeav.resize
							} else {
								$("#EC_BMB_All_center_left_bottom_gerens")
										.text("暂无个人成交数据")
							}
						}
						function getMap(jisd) {
							var map = new BMap.Map(
									"EC_BMB_All_center_center_map", {
										enableMapClick : false
									});
							map.centerAndZoom(new BMap.Point(104.072329,
									30.66342), 13);
							map.enableScrollWheelZoom(true);
							map.setMapStyle({
								style : "bluish"
							});
							var img = new Image();
							var data = [];
							var citys = [];
							for (var m = 0; m < jisd.length; m++) {
								var wei = jisd[m].lat;
								var jin = jisd[m].lng;
								citys.push({
									lat : wei,
									lng : jin,
								});
								for (i = 0; i < citys.length; i++) {
									data.push({
										geometry : {
											type : "Point",
											coordinates : [ citys[i].lng,
													citys[i].lat ],
										},
									})
								}
								var dataSet = new mapv.DataSet(data);
								var options = {
									fillStyle : "rgba(255, 50, 50, 0.6)",
									shadowColor : "rgba(255, 50, 50, 1)",
									methods : {
										click : function(item) {
											console.log(item)
										}
									},
									size : 5,
									draw : "simple"
								};
								var mapvLayer = new mapv.baiduMapLayer(map,
										dataSet, options)
							}
						}
						getMap(data.projectFormMap);
						var LBname = [];
						var LBaddz = [];
						var LBvis = [];
						var LBfollow = [];
						var LBdea = [];
						var LBadddh = [];
						var LBaddwl = [];
						for (i = 0; i < data.departMonth.length; i++) {
							LBname.push(data.departMonth[i].name);
							LBaddz.push(data.departMonth[i].addz);
							LBvis.push(data.departMonth[i].vis);
							LBfollow.push(data.departMonth[i].follow);
							LBdea.push(data.departMonth[i].dea);
							LBadddh.push(data.departMonth[i].adddh);
							LBaddwl.push(data.departMonth[i].addwl);
							var EchartsLB = echarts
									.init(document
											.getElementById("EC_BMB_All_center_center_bottom"));
							option = {
								timeline : {
									axisType : "category",
									data : LBname,
									inverse : false,
									left : 50,
									top : 324,
									autoPlay : true,
									playInterval : 1000,
									label : {
										normal : {
											textStyle : {
												fontSize : 12,
												color : "white",
											},
											rotate : -10,
										},
										emphasis : {
											textStyle : {
												color : "white",
											}
										},
									},
									lineStyle : {
										color : "#fff",
										width : 1,
										type : "solid",
									},
									controlStyle : {
										showNextBtn : false,
										showPrevBtn : false,
										normal : {
											color : "#666",
											borderColor : "#666"
										},
										emphasis : {
											color : "#aaa",
											borderColor : "#aaa"
										}
									},
								},
								options : [ {
									title : {
										text : "当月新增图",
										textStyle : {
											color : "white",
											Align : "center"
										},
										textAlign : "left"
									},
									grid : {},
									tooltip : {
										show : true,
									},
									xAxis : [ {
										type : "category",
										data : LBname,
										show : false,
										axisLabel : {
											show : false,
											textStyle : {
												color : "#999",
												fontWeight : "bold",
											},
											interval : 0,
										},
										axisTick : {
											show : false
										}
									} ],
									yAxis : [ {
										type : "value",
										axisLine : {
											lineStyle : {
												color : "#fff",
												width : 1,
											},
										},
										splitLine : {
											show : false
										},
										axisTick : {
											show : false
										}
									} ],
									series : [ {
										type : "scatter",
										data : LBaddz,
										symbolSize : 30,
										label : {
											normal : {
												show : true,
												position : "insideRight",
												color : "#fff"
											}
										},
										itemStyle : {
											normal : {
												color : "red"
											}
										},
									} ]
								}, {
									title : {
										text : "当月到访图",
									},
									series : [ {
										type : "scatter",
										symbolSize : 40,
										data : LBvis,
										barMinHeight : 20,
										label : {
											normal : {
												show : true,
												position : "insideRight",
											}
										},
										itemStyle : {
											normal : {
												color : "orange"
											}
										},
									} ]
								}, {
									title : {
										text : "当月跟进图",
									},
									series : [ {
										type : "scatter",
										data : LBfollow,
										symbolSize : 40,
										barMinHeight : 20,
										label : {
											normal : {
												show : true,
												position : "insideRight",
												color : "black"
											}
										},
										itemStyle : {
											normal : {
												color : "yellow"
											}
										},
									} ]
								}, {
									title : {
										text : "当月成交图",
									},
									series : [ {
										type : "scatter",
										data : LBdea,
										symbolSize : 40,
										barMinHeight : 20,
										label : {
											normal : {
												show : true,
												position : "insideRight",
												color : "black"
											}
										},
										itemStyle : {
											normal : {
												color : "greenyellow"
											}
										},
									} ]
								}, {
									title : {
										text : "当月电话新增",
									},
									series : [ {
										type : "scatter",
										data : LBadddh,
										symbolSize : 40,
										barMinHeight : 20,
										label : {
											normal : {
												show : true,
												position : "insideRight"
											}
										},
										itemStyle : {
											normal : {
												color : "cyan"
											}
										},
									} ]
								}, {
									title : {
										text : "当月网络新增",
									},
									series : [ {
										type : "scatter",
										data : LBaddwl,
										symbolSize : 40,
										barMinHeight : 20,
										label : {
											normal : {
												show : true,
												position : "insideRight",
												color : "#fff"
											}
										},
										itemStyle : {
											normal : {
												color : "blue"
											}
										},
									} ]
								}, ]
							};
							EchartsLB.setOption(option);
							window.onresize = EchartsLB.resize;
							EchartsLB.onresize = EchartsLB.resize
						}
						var n = 0;
						console.log(data.denorth1days.length);
						setInterval(
								function() {
									var departMonthDaysname = [];
									var departMonthDaysvis = [];
									var departMonthDaysfollow = [];
									var departMonthDaysAddz = [];
									var departMonthDaysDea = [];
									var departMonthDaysAddwl = [];
									var departMonthDaysAddw = [];
									var departMonthDaysAddqt = [];
									var departMonthDaysAddg = [];
									var departMonthDaysAdddh = [];
									departMonthDaysname.push(
											data.denorth1days[n].name,
											data.desouth1days[n].name,
											data.desouth2days[n].name,
											data.desouth3days[n].name,
											data.deeast1days[n].name,
											data.dewest1days[n].name);
									departMonthDaysAddz.push(
											data.denorth1days[n].addz,
											data.desouth1days[n].addz,
											data.desouth2days[n].addz,
											data.desouth3days[n].addz,
											data.deeast1days[n].addz,
											data.dewest1days[n].addz);
									departMonthDaysvis.push(
											data.denorth1days[n].vis,
											data.desouth1days[n].vis,
											data.desouth2days[n].vis,
											data.desouth3days[n].vis,
											data.deeast1days[n].vis,
											data.dewest1days[n].vis);
									departMonthDaysfollow.push(
											data.denorth1days[n].follow,
											data.desouth1days[n].follow,
											data.desouth2days[n].follow,
											data.desouth3days[n].follow,
											data.deeast1days[n].follow,
											data.dewest1days[n].follow);
									departMonthDaysDea.push(
											data.denorth1days[n].dea,
											data.desouth1days[n].dea,
											data.desouth2days[n].dea,
											data.desouth3days[n].dea,
											data.deeast1days[n].dea,
											data.dewest1days[n].dea);
									departMonthDaysAddwl.push(
											data.denorth1days[n].addwl,
											data.desouth1days[n].addwl,
											data.desouth2days[n].addwl,
											data.desouth3days[n].addwl,
											data.deeast1days[n].addwl,
											data.dewest1days[n].addwl);
									departMonthDaysAddw.push(
											data.denorth1days[n].addw,
											data.desouth1days[n].addw,
											data.desouth2days[n].addw,
											data.desouth3days[n].addw,
											data.deeast1days[n].addw,
											data.dewest1days[n].addw);
									departMonthDaysAddqt.push(
											data.denorth1days[n].addqt,
											data.desouth1days[n].addqt,
											data.desouth2days[n].addqt,
											data.desouth3days[n].addqt,
											data.deeast1days[n].addqt,
											data.dewest1days[n].addqt);
									departMonthDaysAddg.push(
											data.denorth1days[n].addg,
											data.desouth1days[n].addg,
											data.desouth2days[n].addg,
											data.desouth3days[n].addg,
											data.deeast1days[n].addg,
											data.dewest1days[n].addg);
									departMonthDaysAdddh.push(
											data.denorth1days[n].adddh,
											data.desouth1days[n].adddh,
											data.desouth2days[n].adddh,
											data.desouth3days[n].adddh,
											data.deeast1days[n].adddh,
											data.dewest1days[n].adddh);
									var EC_BMB_All_center_right_top = echarts
											.init(document
													.getElementById("EC_BMB_All_center_right_top"));
									option = {
										title : {
											text : "当月第"
													+ data.dewest1days[n].days
													+ "天数据图",
											textStyle : {
												color : "#fff",
											}
										},
										grid : {
											left : "2%",
											right : "2%",
											bottom : "3%",
											containLabel : true,
											x : 130
										},
										tooltip : {},
										xAxis : {
											splitLine : {
												show : false
											},
											axisLabel : {
												show : true,
												textStyle : {
													color : "#fff",
												}
											},
											axisLine : {
												lineStyle : {
													color : "rgba(0, 123, 198,0.65)",
													width : 1,
												}
											}
										},
										yAxis : [
												{
													type : "category",
													data : departMonthDaysname,
													axisLabel : {
														interval : 0,
														rotate : 40,
														show : true,
														textStyle : {
															color : "#fff",
															fontSize : "12"
														}
													},
													axisLine : {
														lineStyle : {
															color : "rgba(0, 123, 198,0.65)",
															width : 1,
														},
													},
												}, ],
										series : [ {
											name : "新增",
											type : "bar",
											stack : "总量",
											barMinHeight : 20,
											data : departMonthDaysAddz,
											label : {
												normal : {
													show : true,
													position : "insideRight",
													color : "red"
												}
											},
											itemStyle : {
												normal : {
													color : "#ccffff"
												}
											},
										}, {
											name : "到访",
											type : "bar",
											stack : "总量",
											barMinHeight : 20,
											data : departMonthDaysvis,
											label : {
												normal : {
													show : true,
													position : "insideRight",
													color : "red"
												},
											},
											itemStyle : {
												normal : {
													color : "#99ffff"
												}
											},
										}, {
											name : "跟进",
											type : "bar",
											stack : "总量",
											barMinHeight : 20,
											data : departMonthDaysfollow,
											label : {
												normal : {
													show : true,
													position : "insideRight",
													color : "red"
												},
											},
											itemStyle : {
												normal : {
													color : "#66ffff"
												}
											},
										}, {
											name : "成交",
											type : "bar",
											stack : "总量",
											barMinHeight : 20,
											data : departMonthDaysDea,
											label : {
												normal : {
													show : true,
													position : "insideRight",
													color : "red"
												},
											},
											itemStyle : {
												normal : {
													color : "#00F7DE",
												}
											},
										}, {
											name : "新增网络",
											type : "bar",
											stack : "总量",
											barMinHeight : 20,
											data : departMonthDaysAddwl,
											label : {
												normal : {
													show : true,
													position : "insideRight",
													color : "red"
												},
											},
											itemStyle : {
												normal : {
													color : "#00ffff"
												}
											},
										}, {
											name : "新增外部",
											type : "bar",
											stack : "总量",
											barMinHeight : 20,
											data : departMonthDaysAddw,
											label : {
												normal : {
													show : true,
													position : "insideRight",
													color : "red"
												},
											},
											itemStyle : {
												normal : {
													color : "#99ccff"
												}
											},
										}, {
											name : "新增其它",
											type : "bar",
											stack : "总量",
											barMinHeight : 20,
											data : departMonthDaysAddqt,
											label : {
												normal : {
													show : true,
													position : "insideRight",
													color : "red"
												},
											},
											itemStyle : {
												normal : {
													color : "#ccccff"
												}
											},
										}, {
											name : "新增公共池",
											type : "bar",
											stack : "总量",
											barMinHeight : 20,
											data : departMonthDaysAddg,
											label : {
												normal : {
													show : true,
													position : "insideRight",
													color : "red"
												},
											},
											itemStyle : {
												normal : {
													color : "#ffccff"
												}
											},
										}, {
											name : "新增电话",
											type : "bar",
											stack : "总量",
											barMinHeight : 20,
											data : departMonthDaysAdddh,
											label : {
												normal : {
													show : true,
													position : "insideRight",
													color : "red"
												},
											},
											itemStyle : {
												normal : {
													color : "#ccccff"
												}
											},
										}, ]
									};
									EC_BMB_All_center_right_top
											.setOption(option);
									window.onresize = EC_BMB_All_center_right_top.resize;
									n++;
									if (n == data.denorth1days.length) {
										n = 0
									}
								}, 1000);
						var departdayName = [];
						var departdayvis = [];
						var departdayfollow = [];
						var departdayAddz = [];
						var departdayDea = [];
						var departdayAddwl = [];
						var departdayAddw = [];
						var departdayAddqt = [];
						var departdayAddg = [];
						var departdayAdddh = [];
						for (i = 0; i < data.departday.length; i++) {
							departdayAddz.push(data.departday[i].addz);
							departdayName.push(data.departday[i].name);
							departdayvis.push(data.departday[i].vis);
							departdayfollow.push(data.departday[i].follow);
							departdayDea.push(data.departday[i].dea);
							departdayAddwl.push(data.departday[i].addwl);
							departdayAddw.push(data.departday[i].addw);
							departdayAddqt.push(data.departday[i].addqt);
							departdayAddg.push(data.departday[i].addg);
							departdayAdddh.push(data.departday[i].addh)
						}
						var EC_BMB_All_center_right_bot = echarts.init(document
								.getElementById("EC_BMB_All_center_right_bot"));
						option = {
							padding : [ 5, 10, 5, 5 ],
							legend : {
								data : [ "新增", "到访", "跟进", "成交", "新增网络",
										"新增外部", "新增其它", "新增公共池", "新增电话" ],
								textStyle : {
									color : "#fff",
									fontSize : 12
								}
							},
							grid : {
								left : "0",
								right : "4%",
								bottom : "3%",
								containLabel : true,
								x : 130
							},
							tooltip : {
								trigger : "axis",
								show : true
							},
							xAxis : {
								type : "value",
								splitLine : {
									show : false
								},
								axisLabel : {
									show : true,
									textStyle : {
										color : "#fff",
									}
								},
								axisLine : {
									lineStyle : {
										color : "rgba(0, 123, 198,0.65)",
										width : 1,
									}
								}
							},
							yAxis : [ {
								type : "category",
								data : departdayName,
								axisLabel : {
									interval : 0,
									rotate : 40,
									show : true,
									textStyle : {
										color : "#fff",
										fontSize : "12"
									}
								},
								axisLine : {
									lineStyle : {
										color : "rgba(0, 123, 198,0.65)",
										width : 1,
									},
								},
							}, ],
							series : [ {
								name : "新增",
								type : "bar",
								stack : "总量",
								data : departdayAddz,
								barMinHeight : 20,
								barMaxHeight : 50,
								label : {
									normal : {
										show : true,
										position : "insideRight",
										color : "red"
									}
								},
								itemStyle : {
									normal : {
										color : "#ccffff"
									}
								},
							}, {
								name : "到访",
								type : "bar",
								barMinHeight : 20,
								stack : "总量",
								data : departdayvis,
								label : {
									normal : {
										show : true,
										position : "insideRight",
										color : "red"
									},
								},
								itemStyle : {
									normal : {
										color : "#99ffff"
									}
								},
							}, {
								name : "跟进",
								type : "bar",
								barMinHeight : 20,
								stack : "总量",
								data : departdayfollow,
								barWidth : 30,
								label : {
									normal : {
										show : true,
										position : "insideRight",
										color : "red"
									},
								},
								itemStyle : {
									normal : {
										color : "#66ffff"
									}
								},
							}, {
								name : "成交",
								type : "bar",
								barMinHeight : 20,
								stack : "总量",
								data : departdayDea,
								label : {
									normal : {
										show : true,
										position : "insideRight",
										color : "red"
									},
								},
								itemStyle : {
									normal : {
										color : "#00F7DE",
									}
								},
							}, {
								name : "新增网络",
								type : "bar",
								barMinHeight : 20,
								stack : "总量",
								data : departdayAddwl,
								label : {
									normal : {
										show : true,
										position : "insideRight",
										color : "red"
									},
								},
								itemStyle : {
									normal : {
										color : "#00ffff"
									}
								},
							}, {
								name : "新增外部",
								type : "bar",
								barMinHeight : 20,
								stack : "总量",
								data : departdayAddw,
								label : {
									normal : {
										show : true,
										position : "insideRight",
										color : "red"
									},
								},
								itemStyle : {
									normal : {
										color : "#99ccff"
									}
								},
							}, {
								name : "新增其它",
								type : "bar",
								barMinHeight : 20,
								stack : "总量",
								data : departdayAddqt,
								label : {
									normal : {
										show : true,
										position : "insideRight",
										color : "red"
									},
								},
								itemStyle : {
									normal : {
										color : "#ccccff"
									}
								},
							}, {
								name : "新增公共池",
								type : "bar",
								barMinHeight : 20,
								stack : "总量",
								data : departdayAddg,
								label : {
									normal : {
										show : true,
										position : "insideRight",
										color : "red"
									},
								},
								itemStyle : {
									normal : {
										color : "#ffccff"
									}
								},
							}, {
								name : "新增电话",
								type : "bar",
								barMinHeight : 20,
								stack : "总量",
								daya : departdayAdddh,
								label : {
									normal : {
										show : true,
										position : "insideRight",
										color : "red"
									},
								},
								itemStyle : {
									normal : {
										color : "#ccccff"
									}
								},
							} ]
						};
						EC_BMB_All_center_right_bot.setOption(option);
						window.onresize = EC_BMB_All_center_right_bot.resize
					},
					error : function() {
						alert("发生异常")
					}
				});
		function getMessage(jsonp) {
			alert("message:" + jsonp);
			console.log("message:" + jsonp)
		}
	}
	Aja();
	setInterval(function() {
		Aja()
	}, 3600000);
	var index = 0;
	var timer = setInterval(function() {
		index = (index == 3) ? 0 : index + 1;
		$(".leftTO").hide().eq(index).show()
	}, 3000);
	var indexg = 0;
	var timers = setInterval(function() {
		indexg = (indexg == 3) ? 0 : indexg + 1;
		$(".geren").hide().eq(indexg).show()
	}, 3000)
});