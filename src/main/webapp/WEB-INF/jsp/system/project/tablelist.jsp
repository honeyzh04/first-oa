<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

 <style type="text/css">
	 .tablelist {
    width: 100% !important;  
} 
 /*数据表格标题文字居中*/
.tablelist th {
	text-align: center;
	vertical-align: middle !important;
}

			ul li{
				list-style: none;
			}
			.projectName{
				clear: both;
				padding-top: 15px;
			}
			.projectName li{
				float: left;
				padding-right: 20px;
			}

</style>
	
<body>
<div>
	<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
		<ul class="layui-tab-title">
			<li class="layui-this">商铺项目</li>
			<li>公寓项目</li>
			<li>写字楼项目</li>
			<li>住宅项目</li>
		</ul>
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
				<div class="m-b-md">

                <div class="m-b-md">
                    <form class="form-inline" role="form" id="searchForm"
                          name="searchForm">
                        <div class="form-group">


                            <label class="control-label">项目名：
                                <input type="text" class="form-control" id="projectShopsName" name="ProjectShopsFormMap.projectName" placeholder="请输入商铺项目名">
                            </label>

                            <button id="searchShops" type="button" class="btn btn-info">搜索 &nbsp;&nbsp;<span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                            <ul class="projectName">
                                <li>区域：</li>
                                <li><input type="radio" name="ProjectShopsFormMap.region" id="" value=""  checked="checked" /><span>&nbsp;&nbsp;不限</span></li>
                                <li><input type="radio" name="ProjectShopsFormMap.region" id="" value="14" /><span>&nbsp;&nbsp;东区</span></li>
                                <li><input type="radio" name="ProjectShopsFormMap.region" id="" value="15" /><span>&nbsp;&nbsp;西区</span></li>
                                <li><input type="radio" name="ProjectShopsFormMap.region" id="" value="12" /><span>&nbsp;&nbsp;南区</span></li>
                                <li><input type="radio" name="ProjectShopsFormMap.region" id="" value="13" /><span>&nbsp;&nbsp;北区</span></li>
                            </ul>
                            <ul class="projectName">
                                <li>总价 ：</li>
                                <li><input type="radio" name="ProjectShopsFormMap.prices" id="" value=""  checked="checked" /><span>&nbsp;&nbsp;不限</span></li>
                                <li><input type="radio" name="ProjectShopsFormMap.prices" id="" value="0-20" /><span>&nbsp;&nbsp;20万以下</span></li>
                                <li><input type="radio" name="ProjectShopsFormMap.prices" id="" value="20-50" /><span>&nbsp;&nbsp;20-50万</span></li>
                                <li><input type="radio" name="ProjectShopsFormMap.prices" id="" value="50-100" /><span>&nbsp;&nbsp;50-100万</span></li>
                                <li><input type="radio" name="ProjectShopsFormMap.prices" id="" value="100-150" /><span>&nbsp;&nbsp;100-150万</span></li>
                                <li><input type="radio" name="ProjectShopsFormMap.prices" id="" value="150-200" /><span>&nbsp;&nbsp;150-200万</span></li>
                                <li><input type="radio" name="ProjectShopsFormMap.prices" id="" value="200-300" /><span>&nbsp;&nbsp;200-300万</span></li>
                                <li><input type="radio" name="ProjectShopsFormMap.prices" id="" value="300-500" /><span>&nbsp;&nbsp;300-500万</span></li>
                                <li><input type="radio" name="ProjectShopsFormMap.prices" id="" value="500-800" /><span>&nbsp;&nbsp;500-800万</span></li>
                                <li><input type="radio" name="ProjectShopsFormMap.prices" id="" value="800-10000" /><span>&nbsp;&nbsp;800万以上</span></li>
                            </ul>
                            <ul class="projectName">
                                <li>面积 ：</li>
                                <li><input type="radio" name="ProjectShopsFormMap.area" id="" value=""   checked="checked" /><span>&nbsp;&nbsp;不限</span></li>
                                <li><input type="radio" name="ProjectShopsFormMap.area" id="" value="0-20" /><span>&nbsp;&nbsp;20㎡以下</span></li>
                                <li><input type="radio" name="ProjectShopsFormMap.area" id="" value="20-50" /><span>&nbsp;&nbsp;20-50㎡</span></li>
                                <li><input type="radio" name="ProjectShopsFormMap.area" id="" value="50-100" /><span>&nbsp;&nbsp;50-100㎡</span></li>
                                <li><input type="radio" name="ProjectShopsFormMap.area" id="" value="100-150" /><span>&nbsp;&nbsp;100-150㎡</span></li>
                                <li><input type="radio" name="ProjectShopsFormMap.area" id="" value="150-200" /><span>&nbsp;&nbsp;150-200㎡</span></li>
                                <li><input type="radio" name="ProjectShopsFormMap.area" id="" value="200-300" /><span>&nbsp;&nbsp;200-300㎡</span></li>
                                <li><input type="radio" name="ProjectShopsFormMap.area" id="" value="300-500" /><span>&nbsp;&nbsp;300-500㎡</span></li>
                                <li><input type="radio" name="ProjectShopsFormMap.area" id="" value="500-1000" /><span>&nbsp;&nbsp;500-1000㎡</span></li>
                                <li><input type="radio" name="ProjectShopsFormMap.area" id="" value="1000-10000" /><span>&nbsp;&nbsp;1000㎡以上</span></li>
                            </ul>

                        </div>
                    </form>
                </div>
					<header class="panel-heading">
						<div class="doc-buttons">
							<c:forEach items="${resShops}" var="key">
								${key.description}
							</c:forEach>

						</div>
					</header>


                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_content">

                                <!-- 数据table代码 -->
                                <table id="datatableShops" class="tablelist row-border table table-striped table-striped "  style=" text-align:center;vertical-align: middle!important" >
                                    <thead >
                                    <tr >
                                        <!-- <th ><input type="checkbox" id="checkAll"></th> -->
                                        <th >选择</th>
                                        <th >项目名</th>
                                        <th >项目位置</th>
                                        <th >类型</th>
                                        <th >面积</th>
                                        <th >单价</th>
                                        <th >总价</th>
                                        <th >区域</th>
                                        <th >状况</th>
                                        <th >菲斯特联系人</th>
                                        <th >项目联系人</th>
                                        <th >电话</th>
                                        <th >项目描述</th>
                                        <!-- <th >操作</th> -->

                                    </tr>
                                    </thead>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
			</div>
			<div class="layui-tab-item">
				<div class="m-b-md">

					<div class="m-b-md">
						<form class="form-inline" role="form" id="searchForm"
							  name="searchForm">
							<div class="form-group">


								<label class="control-label">项目名：
									<input type="text" class="form-control" id="projectApartmentName" name="ProjectApartmentFormMap.projectName" placeholder="请输入公寓项目名">
								</label>

								<button id="searchApartment" type="button" class="btn btn-info">搜索 &nbsp;&nbsp;<span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
								<ul class="projectName">
									<li>区域：</li>
									<li><input type="radio" name="ProjectApartmentFormMap.region" id="" value=""  checked="checked" /><span>&nbsp;&nbsp;不限</span></li>
									<li><input type="radio" name="ProjectApartmentFormMap.region" id="" value="14" /><span>&nbsp;&nbsp;东区</span></li>
									<li><input type="radio" name="ProjectApartmentFormMap.region" id="" value="15" /><span>&nbsp;&nbsp;西区</span></li>
									<li><input type="radio" name="ProjectApartmentFormMap.region" id="" value="12" /><span>&nbsp;&nbsp;南区</span></li>
									<li><input type="radio" name="ProjectApartmentFormMap.region" id="" value="13" /><span>&nbsp;&nbsp;北区</span></li>
								</ul>
								<ul class="projectName">
									<li>总价 ：</li>
									<li><input type="radio" name="ProjectApartmentFormMap.prices" id="" value=""  checked="checked" /><span>&nbsp;&nbsp;不限</span></li>
									<li><input type="radio" name="ProjectApartmentFormMap.prices" id="" value="0-20" /><span>&nbsp;&nbsp;20万以下</span></li>
									<li><input type="radio" name="ProjectApartmentFormMap.prices" id="" value="20-50" /><span>&nbsp;&nbsp;20-50万</span></li>
									<li><input type="radio" name="ProjectApartmentFormMap.prices" id="" value="50-100" /><span>&nbsp;&nbsp;50-100万</span></li>
									<li><input type="radio" name="ProjectApartmentFormMap.prices" id="" value="100-150" /><span>&nbsp;&nbsp;100-150万</span></li>
									<li><input type="radio" name="ProjectApartmentFormMap.prices" id="" value="150-200" /><span>&nbsp;&nbsp;150-200万</span></li>
									<li><input type="radio" name="ProjectApartmentFormMap.prices" id="" value="200-300" /><span>&nbsp;&nbsp;200-300万</span></li>
									<li><input type="radio" name="ProjectApartmentFormMap.prices" id="" value="300-500" /><span>&nbsp;&nbsp;300-500万</span></li>
									<li><input type="radio" name="ProjectApartmentFormMap.prices" id="" value="500-800" /><span>&nbsp;&nbsp;500-800万</span></li>
									<li><input type="radio" name="ProjectApartmentFormMap.prices" id="" value="800-10000" /><span>&nbsp;&nbsp;800万以上</span></li>
								</ul>
								<ul class="projectName">
									<li>面积 ：</li>
									<li><input type="radio" name="ProjectApartmentFormMap.area" id="" value=""   checked="checked" /><span>&nbsp;&nbsp;不限</span></li>
									<li><input type="radio" name="ProjectApartmentFormMap.area" id="" value="0-20" /><span>&nbsp;&nbsp;20㎡以下</span></li>
									<li><input type="radio" name="ProjectApartmentFormMap.area" id="" value="20-50" /><span>&nbsp;&nbsp;20-50㎡</span></li>
									<li><input type="radio" name="ProjectApartmentFormMap.area" id="" value="50-100" /><span>&nbsp;&nbsp;50-100㎡</span></li>
									<li><input type="radio" name="ProjectApartmentFormMap.area" id="" value="100-150" /><span>&nbsp;&nbsp;100-150㎡</span></li>
									<li><input type="radio" name="ProjectApartmentFormMap.area" id="" value="150-200" /><span>&nbsp;&nbsp;150-200㎡</span></li>
									<li><input type="radio" name="ProjectApartmentFormMap.area" id="" value="200-300" /><span>&nbsp;&nbsp;200-300㎡</span></li>
									<li><input type="radio" name="ProjectApartmentFormMap.area" id="" value="300-500" /><span>&nbsp;&nbsp;300-500㎡</span></li>
									<li><input type="radio" name="ProjectApartmentFormMap.area" id="" value="500-1000" /><span>&nbsp;&nbsp;500-1000㎡</span></li>
									<li><input type="radio" name="ProjectApartmentFormMap.area" id="" value="1000-10000" /><span>&nbsp;&nbsp;1000㎡以上</span></li>
								</ul>

							</div>
						</form>
					</div>
					<header class="panel-heading">
						<div class="doc-buttons">
							<c:forEach items="${resApartment}" var="key">
								${key.description}
							</c:forEach>

						</div>
					</header>


					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_content">

									<!-- 数据table代码 -->
									<table id="datatableApartment" class="tablelist row-border table table-striped table-striped "  style=" text-align:center;vertical-align: middle!important" >
										<thead >
										<tr >
											<!-- <th ><input type="checkbox" id="checkAll"></th> -->
											<th >选择</th>
											<th >项目名</th>
											<th >项目位置</th>
											<th >类型</th>
											<th >面积</th>
											<th >单价</th>
											<th >总价</th>
											<th >区域</th>
											<th >状况</th>
											<th >菲斯特联系人</th>
											<th >项目联系人</th>
											<th >电话</th>
											<th >项目描述</th>
											<!-- <th >操作</th> -->

										</tr>
										</thead>
									</table>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
			<div class="layui-tab-item">
				<div class="m-b-md">

					<div class="m-b-md">
						<form class="form-inline" role="form" id="searchShopsForm"
							  name="searchShopsForm">
							<div class="form-group">


								<label class="control-label">项目名：
									<input type="text" class="form-control" id="projectOfficeName" name="ProjectOfficeFormMap.projectName" placeholder="请输入商铺项目名">
								</label>

								<button id="searchOffice" type="button" class="btn btn-info">搜索 &nbsp;&nbsp;<span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
								<ul class="projectName">
									<li>区域：</li>
									<li><input type="radio" name="ProjectOfficeFormMap.region" id="" value=""  checked="checked" /><span>&nbsp;&nbsp;不限</span></li>
									<li><input type="radio" name="ProjectOfficeFormMap.region" id="" value="14" /><span>&nbsp;&nbsp;东区</span></li>
									<li><input type="radio" name="ProjectOfficeFormMap.region" id="" value="15" /><span>&nbsp;&nbsp;西区</span></li>
									<li><input type="radio" name="ProjectOfficeFormMap.region" id="" value="12" /><span>&nbsp;&nbsp;南区</span></li>
									<li><input type="radio" name="ProjectOfficeFormMap.region" id="" value="13" /><span>&nbsp;&nbsp;北区</span></li>
								</ul>
								<ul class="projectName">
									<li>总价 ：</li>
									<li><input type="radio" name="ProjectOfficeFormMap.prices" id="" value=""  checked="checked" /><span>&nbsp;&nbsp;不限</span></li>
									<li><input type="radio" name="ProjectOfficeFormMap.prices" id="" value="0-20" /><span>&nbsp;&nbsp;20万以下</span></li>
									<li><input type="radio" name="ProjectOfficeFormMap.prices" id="" value="20-50" /><span>&nbsp;&nbsp;20-50万</span></li>
									<li><input type="radio" name="ProjectOfficeFormMap.prices" id="" value="50-100" /><span>&nbsp;&nbsp;50-100万</span></li>
									<li><input type="radio" name="ProjectOfficeFormMap.prices" id="" value="100-150" /><span>&nbsp;&nbsp;100-150万</span></li>
									<li><input type="radio" name="ProjectOfficeFormMap.prices" id="" value="150-200" /><span>&nbsp;&nbsp;150-200万</span></li>
									<li><input type="radio" name="ProjectOfficeFormMap.prices" id="" value="200-300" /><span>&nbsp;&nbsp;200-300万</span></li>
									<li><input type="radio" name="ProjectOfficeFormMap.prices" id="" value="300-500" /><span>&nbsp;&nbsp;300-500万</span></li>
									<li><input type="radio" name="ProjectOfficeFormMap.prices" id="" value="500-800" /><span>&nbsp;&nbsp;500-800万</span></li>
									<li><input type="radio" name="ProjectOfficeFormMap.prices" id="" value="800-10000" /><span>&nbsp;&nbsp;800万以上</span></li>
								</ul>
								<ul class="projectName">
									<li>面积 ：</li>
									<li><input type="radio" name="ProjectOfficeFormMap.area" id="" value=""   checked="checked" /><span>&nbsp;&nbsp;不限</span></li>
									<li><input type="radio" name="ProjectOfficeFormMap.area" id="" value="0-20" /><span>&nbsp;&nbsp;20㎡以下</span></li>
									<li><input type="radio" name="ProjectOfficeFormMap.area" id="" value="20-50" /><span>&nbsp;&nbsp;20-50㎡</span></li>
									<li><input type="radio" name="ProjectOfficeFormMap.area" id="" value="50-100" /><span>&nbsp;&nbsp;50-100㎡</span></li>
									<li><input type="radio" name="ProjectOfficeFormMap.area" id="" value="100-150" /><span>&nbsp;&nbsp;100-150㎡</span></li>
									<li><input type="radio" name="ProjectOfficeFormMap.area" id="" value="150-200" /><span>&nbsp;&nbsp;150-200㎡</span></li>
									<li><input type="radio" name="ProjectOfficeFormMap.area" id="" value="200-300" /><span>&nbsp;&nbsp;200-300㎡</span></li>
									<li><input type="radio" name="ProjectOfficeFormMap.area" id="" value="300-500" /><span>&nbsp;&nbsp;300-500㎡</span></li>
									<li><input type="radio" name="ProjectOfficeFormMap.area" id="" value="500-1000" /><span>&nbsp;&nbsp;500-1000㎡</span></li>
									<li><input type="radio" name="ProjectOfficeFormMap.area" id="" value="1000-10000" /><span>&nbsp;&nbsp;1000㎡以上</span></li>
								</ul>

							</div>
						</form>
					</div>

					<header class="panel-heading">
						<div class="doc-buttons">
							<c:forEach items="${resOffice}" var="key">
								${key.description}
							</c:forEach>

						</div>
					</header>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_content">

									<!-- 数据table代码 -->
									<table id="datatableOffice" class="tablelist row-border table table-striped table-striped "  style=" text-align:center;vertical-align: middle!important" >
										<thead >
										<tr >
											<!-- <th ><input type="checkbox" id="checkAll"></th> -->
											<th >选择</th>
											<th >项目名</th>
											<th >项目位置</th>
											<th >类型</th>
											<th >面积</th>
											<th >单价</th>
											<th >总价</th>
											<th >区域</th>
											<th >状况</th>
											<th >菲斯特联系人</th>
											<th >项目联系人</th>
											<th >电话</th>
											<th >项目描述</th>
											<!-- <th >操作</th> -->

										</tr>
										</thead>
									</table>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
			<div class="layui-tab-item">
				<div class="m-b-md">

					<div class="m-b-md">
						<form class="form-inline" role="form" id="searchForm"
							  name="searchForm">
							<div class="form-group">


								<label class="control-label">项目名：
									<input type="text" class="form-control" id="projectHomeName" name="ProjectHomeFormMap.projectName" placeholder="请输入住宅项目名">
								</label>

								<button id="searchHome" type="button" class="btn btn-info">搜索 &nbsp;&nbsp;<span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
								<ul class="projectName">
									<li>区域：</li>
									<li><input type="radio" name="ProjectHomeFormMap.region" id="" value=""  checked="checked" /><span>&nbsp;&nbsp;不限</span></li>
									<li><input type="radio" name="ProjectHomeFormMap.region" id="" value="14" /><span>&nbsp;&nbsp;东区</span></li>
									<li><input type="radio" name="ProjectHomeFormMap.region" id="" value="15" /><span>&nbsp;&nbsp;西区</span></li>
									<li><input type="radio" name="ProjectHomeFormMap.region" id="" value="12" /><span>&nbsp;&nbsp;南区</span></li>
									<li><input type="radio" name="ProjectHomeFormMap.region" id="" value="13" /><span>&nbsp;&nbsp;北区</span></li>
								</ul>
								<ul class="projectName">
									<li>总价 ：</li>
									<li><input type="radio" name="ProjectHomeFormMap.prices" id="" value=""  checked="checked" /><span>&nbsp;&nbsp;不限</span></li>
									<li><input type="radio" name="ProjectHomeFormMap.prices" id="" value="0-20" /><span>&nbsp;&nbsp;20万以下</span></li>
									<li><input type="radio" name="ProjectHomeFormMap.prices" id="" value="20-50" /><span>&nbsp;&nbsp;20-50万</span></li>
									<li><input type="radio" name="ProjectHomeFormMap.prices" id="" value="50-100" /><span>&nbsp;&nbsp;50-100万</span></li>
									<li><input type="radio" name="ProjectHomeFormMap.prices" id="" value="100-150" /><span>&nbsp;&nbsp;100-150万</span></li>
									<li><input type="radio" name="ProjectHomeFormMap.prices" id="" value="150-200" /><span>&nbsp;&nbsp;150-200万</span></li>
									<li><input type="radio" name="ProjectHomeFormMap.prices" id="" value="200-300" /><span>&nbsp;&nbsp;200-300万</span></li>
									<li><input type="radio" name="ProjectHomeFormMap.prices" id="" value="300-500" /><span>&nbsp;&nbsp;300-500万</span></li>
									<li><input type="radio" name="ProjectHomeFormMap.prices" id="" value="500-800" /><span>&nbsp;&nbsp;500-800万</span></li>
									<li><input type="radio" name="ProjectHomeFormMap.prices" id="" value="800-10000" /><span>&nbsp;&nbsp;800万以上</span></li>
								</ul>
								<ul class="projectName">
									<li>面积 ：</li>
									<li><input type="radio" name="ProjectHomeFormMap.area" id="" value=""   checked="checked" /><span>&nbsp;&nbsp;不限</span></li>
									<li><input type="radio" name="ProjectHomeFormMap.area" id="" value="0-20" /><span>&nbsp;&nbsp;20㎡以下</span></li>
									<li><input type="radio" name="ProjectHomeFormMap.area" id="" value="20-50" /><span>&nbsp;&nbsp;20-50㎡</span></li>
									<li><input type="radio" name="ProjectHomeFormMap.area" id="" value="50-100" /><span>&nbsp;&nbsp;50-100㎡</span></li>
									<li><input type="radio" name="ProjectHomeFormMap.area" id="" value="100-150" /><span>&nbsp;&nbsp;100-150㎡</span></li>
									<li><input type="radio" name="ProjectHomeFormMap.area" id="" value="150-200" /><span>&nbsp;&nbsp;150-200㎡</span></li>
									<li><input type="radio" name="ProjectHomeFormMap.area" id="" value="200-300" /><span>&nbsp;&nbsp;200-300㎡</span></li>
									<li><input type="radio" name="ProjectHomeFormMap.area" id="" value="300-500" /><span>&nbsp;&nbsp;300-500㎡</span></li>
									<li><input type="radio" name="ProjectHomeFormMap.area" id="" value="500-1000" /><span>&nbsp;&nbsp;500-1000㎡</span></li>
									<li><input type="radio" name="ProjectHomeFormMap.area" id="" value="1000-10000" /><span>&nbsp;&nbsp;1000㎡以上</span></li>
								</ul>

							</div>
						</form>
					</div>

					<header class="panel-heading">
						<div class="doc-buttons">
							<c:forEach items="${resHome}" var="key">
								${key.description}
							</c:forEach>

						</div>
					</header>

					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_content">

									<!-- 数据table代码 -->
									<table id="datatableHome" class="tablelist row-border table table-striped table-striped "  style=" text-align:center;vertical-align: middle!important" >
										<thead >
										<tr >
											<!-- <th ><input type="checkbox" id="checkAll"></th> -->
											<th >选择</th>
											<th >项目名</th>
											<th >项目位置</th>
											<th >类型</th>
											<th >面积</th>
											<th >单价</th>
											<th >总价</th>
											<th >区域</th>
											<th >状况</th>
											<th >菲斯特联系人</th>
											<th >项目联系人</th>
											<th >电话</th>
											<th >项目描述</th>
											<!-- <th >操作</th> -->

										</tr>
										</thead>
									</table>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>

		</div>
	</div>



</div>

<script type="text/javascript" src="js/system/project/tablelist.js"></script>
		</body>
<script>
    layui.use('element', function(){
        var $ = layui.jquery;
        var element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

    });
</script>
