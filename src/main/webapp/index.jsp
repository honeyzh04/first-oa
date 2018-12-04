<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>  
	<%@include file="/common/common.jspf"%> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="author" content="Mosaddek" />
    <meta name="keyword" content="first,fangfaxian,admin" />
    <meta name="description" content="" />

    <link rel="shortcut icon" href="javascript:;" type="image/png">

    <title>first地产</title>

    <!--common style-->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet">



</head>

<body class="sticky-header" ">

    <section>
        <!-- 左侧菜单栏  start-->
        <div class="sidebar-left">
            <!--responsive view logo start-->
             <div class="logo dark-logo-bg visible-xs-* visible-sm-*">
                <a href="index.shtml">
                    
                    <!--<i class="fa fa-maxcdn"></i>-->
                    <span class="brand-name">fangfaxian.菲斯特地产</span>
                   
                </a>
            </div>
            <!--responsive view logo end-->

            <div class="sidebar-left-info">
                <!-- visible small devices start-->
                <div class=" search-field">  </div>
                <!-- visible small devices end-->
					<!-- nav -->
								
									<ul class="nav nav-pills nav-stacked side-navigation">
										 <li>
                       					 <h3 class="navigation-title">导航</h3>
                   						 </li>
										<c:forEach var="key" items="${list}" varStatus="s">
											<!-- <li class="active"> 某一项展开-->
											<li class="menu-list">
											<a href="javascript:void(0)"
												> 
													<c:if
														test="${s.index==0}">
														<i class="fa fa-dashboard icon"> <b class="bg-danger"></b>
														</i>
													</c:if> 
													<c:if test="${s.index==1}">
														<i class="fa fa-pencil-square icon"> <b
															class="bg-warning"></b>
														</i>
													</c:if> 
													<c:if test="${s.index==2}">
														<i class="fa fa-columns icon"> <b class="bg-primary"></b>
														</i>
													</c:if> 
													<c:if test="${s.index==3}">
														<i class="fa fa-cubes"> <b class="bg-info"></b>
														</i>
													</c:if>
													<c:if test="${s.index==4}">
														<i class="fa fa-book icon"> <b class="bg-info"></b>
														</i>
													</c:if> 
													<c:if test="${s.index==5}">
														<i class="fa fa-th-list icon"> <b class="bg-success"></b>
														</i>
													</c:if> 
													<c:if test="${s.index==6}">
														<i class="fa fa-paper-plane  icon" > <b class="bg-success"></b>
														</i>
													</c:if> 
													<c:if test="${s.index==7}">
														<i class="fa fa-user  icon" > <b class="bg-success"></b>
														</i>
													</c:if> 
													<c:if test="${s.index==8}">
														<i class="fa fa-cog  icon" > <b class="bg-success"></b>
														</i>
													</c:if> 
													
													 <span>${key.name}</span>
											</a>

												<ul class="child-list">
													<c:forEach var="kc" items="${key.children}">
														<li class="active"><a
															href="javascript:void(0)"
															class="active" nav-n="${key.name},${kc.name},${kc.resUrl}?id=${kc.id}"> <i class="fa fa-angle-right"></i> <span>${kc.name}</span>
														</a></li>
													</c:forEach>
												</ul></li>
										</c:forEach>
									</ul>
								
            </div>
        </div>
        <!-- 左侧菜单栏 end-->

        <!-- 正文内容  start-->
        <div class="body-content" >
        	  <!--标题部分  start-->
            <div class="header-section">

                <!--  标志和标志图标 start-->
               
 		
                <!--标志和标志图标 end-->

                <!--切换按钮 开始-->
                <a class="toggle-btn"><i class="fa fa-outdent"></i></a>
                <!--切换按钮 end-->

                <!--精彩  换肤start-->
                <div id="navbar-collapse-1" class="navbar-collapse collapse yamm mega-menu">
                    <ul class="nav navbar-nav">
                        <!-- Classic list -->
                        <li class="dropdown"><a href="javascript:;" data-toggle="dropdown" class="dropdown-toggle">Mega <b
                                class=" fa fa-angle-down"></b></a>
                            <ul class="dropdown-menu wide-full">
                                <li>
                                    <!-- Content container to add padding -->
                                    <div class="yamm-content">
                                        <div class="row">
                                           
                                            <ul class="col-sm-3 list-unstyled">
                                                <li>
                                                    <p class="title">后续更新</p>
                                                </li>
                                                <li>
                                                    <a href="javascript:;">
                                                        <img class="icon-img" src="img/mega-menu/mega_icon1.png" alt="" />
                                                                <span class="icon-desk">
                                                                                        <span class="d-title">后续更新1</span>
                                                                <span class="d-desk">菲斯特地产</span>
                                                                </span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="javascript:;">
                                                        <img class="icon-img" src="img/mega-menu/mega_icon2.png" alt="" />
                                                                <span class="icon-desk">
                                                                                        <span class="d-title">后续更新2</span>
                                                                <span class="d-desk">菲斯特地产</span>
                                                                </span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="javascript:;">
                                                        <img class="icon-img" src="img/mega-menu/mega_icon3.png" alt="" />
                                                                <span class="icon-desk">
                                                                                        <span class="d-title">后续更新3</span>
                                                                <span class="d-desk">菲斯特地产</span>
                                                                </span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="javascript:;">
                                                        <img class="icon-img" src="img/mega-menu/mega_icon4.png" alt="" />
                                                                <span class="icon-desk">
                                                                                        <span class="d-title">后续更新4</span>
                                                                <span class="d-desk">菲斯特地产</span>
                                                                </span>
                                                    </a>
                                                </li>

                                            </ul>
                                            <ul class="col-sm-3 list-unstyled custom-nav-img">
                                                <li>
                                                    <p class="title">公告</p>
                                                </li>
                                                <li>

                                                    <p class="desk">企业文化<br>
								口号： 每天进一步，踏上成功路 。只要精神不滑坡，办法总比困难多 。<br>

								宗旨： 发展企业 富裕员工 奉献社会。<br>

								精神： 务实 激情 超越<br>

								目标：一鼓作气，挑战佳绩<br>

								作风：高标准 高效率 严格管理 严格要求 严格执纪 严格奖罚。</p>
                                                </li>
                                                <li><span class="mega-bg"></span></li>
                                            </ul>

                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </li>

                        <!-- 更换主题 -->
                        <li class="dropdown"><a href="javascript:;" data-toggle="dropdown" class="dropdown-toggle"> 一键换肤  <b
                                class=" fa fa-angle-down"></b></a>
                            <ul role="menu" class="dropdown-menu language-switch">
                                <li>
                                    <a tabindex="-1" href="javascript:;"><span> 简洁 </span><img src="img/skin/aq.png" alt=""/></a>
                                </li>
                                <li>
                                    <a tabindex="-1" href="javascript:;"><span> 炫酷 </span> <img src="img/skin/aq.png" alt=""/></a>
                                </li>
                                <li>
                                    <a tabindex="-1" href="javascript:;"><span> 清新  </span> <img src="img/skin/aq.png" alt=""/></a>
                                </li>
                                <li>
                                    <a tabindex="-1" href="javascript:;"><span> 经典 </span> <img src="img/skin/aq.png" alt=""/></a>
                                </li>
                                <li>
                                    <a tabindex="-1" href="javascript:;"><span> 热情 </span> <img src="img/skin/aq.png" alt=""/></a>
                                </li>
                            </ul>
                        </li>

                    </ul>
                </div>
                <!--精彩  语言  end-->
                <div class="notification-wrap">
                <!--左侧 通知栏 start-->
                <div class="left-notification">
                <ul class="notification-menu">
                <!--mail info start-->
                <li class="d-none">
                    <a href="javascript:;" class="btn btn-default dropdown-toggle info-number" data-toggle="dropdown">
                        <i class="fa fa-envelope-o"></i>
                            <span class="badge bg-primary" id="number"></span>
                    </a>

                    <div class="dropdown-menu dropdown-title">
                        <div class="title-row">
                            <h5 class="title purple">
                             	   你有预约客户未联系
                            </h5>
                            <a  href="#" onclick="javascript:ordered();" class="btn-primary btn-view-all">查看</a>
                        </div>
                        <div class="notification-list mail-list">
                            <a href="javascript:;" class="single-mail">
                                <span class="icon bg-primary">
                                    约
                                </span>
                                <span class="badge bg-primary"></span>
                                <strong>今日预约客户</strong>
                                <p>
                                    <small>请及时联系</small>
                                </p>



                            </a>
<%--
                            <a href="javascript:;" class="single-mail">
                                <span class="icon bg-success">
                                    A
                                </span>
                                <strong>菲斯特地产 </strong>
                                <small> 菲斯特地产</small>
                                <p>
                                    <small>菲斯特地产</small>
                                </p>
                                <span class="un-read tooltips" data-original-title="Mark as Read" data-toggle="tooltip" data-placement="left">
                                    <i class="fa fa-circle"></i>
                                </span>
                            </a>
                            --%>
                        </div>
                    </div>
                </li>
                <!--mail info end-->

                <!--task info start-->
                <li class="d-none">
                    <a href="javascript:;" class="btn btn-default dropdown-toggle info-number" data-toggle="dropdown">
                        <i class="fa fa-bell-o"></i>
                        <span class="badge bg-success">0</span>
                    </a>

                    <div class="dropdown-menu dropdown-title">
                        <div class="title-row">
                            <h5 class="title green">
                          		      你有未读通知
                            </h5>

                            <a  href="#" onclick="javascript:awardCustomer();"  class="btn-primary btn-view-all">查看</a>
                        </div>
                        <div class="notification-list task-list">
                            <a href="javascript:;">
                                <span class="icon ">
                                    <i class="fa fa-paw green-color"></i>
                                </span>
                                <span class="task-info">
                               	菲斯特地产
                                <small> 菲斯特地产</small>
                                    </span>
                            </a>
                            <a href="javascript:;">
                                <span class="icon ">
                                    <i class="fa fa-line-chart blue-color"></i>
                                </span>
                                <span class="task-info">菲斯特地产
                                <small> 菲斯特地产</small>

                              
                                </span>
                            </a>
                            <a href="javascript:;">
                                <span class="icon ">
                                    <i class="fa fa-heart purple-color"></i>
                                </span>
                                <span class="task-info">菲斯特地产
                                <small> 菲斯特地产</small>
                                    </span>

                           
                        </div>
                    </div>
                </li>
                <!--task info end-->

                <!--notification info start-->
                <li>
                    <a href="javascript:;" class="btn btn-default dropdown-toggle info-number" data-toggle="dropdown">
                        <i class="fa fa-cubes"></i>
                        
                    </a>

                    <div class="dropdown-menu dropdown-title ">

                        <div class="title-row">
                            <h5 class="title yellow">
                   		            销售百问
                            </h5>
                            <a  href="#" onclick="javascript:interlocutionLayer();"  class="btn-warning btn-view-all">让我来帮助你吧</a>
                        </div>
                     
                    </div>
                </li>
                <!--notification info end-->
                </ul>
                </div>
                <!--左侧 通知栏  end-->


                <!--右侧 通知栏 start-->
                <div class="right-notification">
                    <ul class="notification-menu">
                    

                        <li>
                            <a href="javascript:;" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                <img src="img/avatar-mini.png" alt="">${userFormMap.accountName}
                              
                                <span class=" fa fa-angle-down"></span>
                            </a>
                            <ul class="dropdown-menu dropdown-usermenu purple pull-right">
                               
                                <li>
                                    <a href="javascript:;">
                                        <span class="badge bg-danger pull-right">100%</span>
                                        <span>个人信息</span>
                                    </a>
                                </li>
                                <li>
                                <a href="#" onclick="javascript:updatePasswordLayer();">密码修改</a>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        <span class="label bg-info pull-right">new</span>
                                   	     帮助
                                    </a>
                                </li>
                                <li><a href="login.jsp"><i class="fa fa-sign-out pull-right"></i>退出登录</a></li>
                            </ul>
                        </li>
                        <li>
                       
                        </li>

                    </ul>
                </div>
                <!--右侧 通知栏 start-->
                </div>

            </div>
            <!--标题部分  end-->
			<!--工作内容  start-->
			<section id="content"  style="background-color:#fff">
					<section id="id_vbox" class="vbox">
						<ul class="breadcrumb no-border no-radius b-b b-light" id="topli">
						</ul>
						<!--正文  start-->
						<section class="scrollable" ">
						<div id="loadhtml" >  </div>
						
						</section>
						
					</section>
				<div style="height:110px ;background-color: #fff;"></div> 
				</section>
             <!--工作内容 end-->
            <!--footer section start-->
            <footer class="footer">
          				       <div>
          				       <span>菲斯特房地产</span>
          				       </div>   
            </footer>
            <!--footer section end--> 
			
            </div>
        <!-- 正文内容   end-->
			
      
    </section>
		
   

<!-- 将JS放在文档的结尾，这样页面加载速度更快。 -->

<!-- 滚动条美化插件-->
<script src="js/jquery.nicescroll.js" type="text/javascript"></script>


<!--所有页面的通用脚本，左侧菜单栏-->

<script src="js/scripts.js"></script>

	
<script type="text/javascript">
	$(function() {

		var tb = $("#loadhtml");
		//tb.html(CommnUtil.loadingImg());
		tb.load("./welcome.jsp");
		$("[nav-n]").each(function () {
				$(this).bind("click",function(){
						var nav = $(this).attr("nav-n");
						var sn = nav.split(",");
						var html = '<li><i class="fa fa-home"></i>';
						html+='<a href="index.shtml">&nbsp;&nbsp;主页</a></li>';
						for(var i=0;i<2;i++){
							html+='<li><a href="javascript:void(0)">'+sn[i]+'</a></li>';
						}
						$("#topli").html(html);
						var tb = $("#loadhtml");
						tb.html(CommnUtil.loadingImg());
						tb.load("${pageContext.request.contextPath}"+sn[2]);
				});
			});



           // setInterval("startRequest()",1000);
        startRequest();

        setInterval(startRequest,1000000);

            //getLoc();


		});
    function startRequest() {

        $.ajax({
            "url" : "./customer/findNtrackDate.shtml",
            "data" : "",
            "type" : "GET",
            "dataType" : "json",
            "success" : function(obj) {
                console.log(obj.number);
                var number = obj.number;
                $("#number").html(number);
            },
            error : function() {
                layer.alert("请与管理员联系");
            }
        });
    }

</script>


</body>
</html>
