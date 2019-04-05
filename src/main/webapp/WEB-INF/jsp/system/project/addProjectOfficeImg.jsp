<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/common.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<html>
<head>
	<style>
		.wrap {
			width: 700px;
			margin: auto;
		}

		.page-list-1 li {
			width: 20%;
			text-align: center;
			background: #ccc;
		}

		.pages-1 {
			position: relative;
		}

		.pages-1 .pages-item1 {
			position: relative;
			display: none;
		}

		.imageDiv {
			display: inline-block;
			width: 160px;
			height: 120px;
			-webkit-box-sizing: border-box;
			-moz-box-sizing: border-box;
			box-sizing: border-box;
			border: 1px dashed darkgray;
			background: #f8f8f8;
			position: relative;
			overflow: hidden;
			margin: 10px
		}

		.cover {
			position: absolute;
			z-index: 3;
			top: 0;
			left: 0;
			width: 160px;
			height: 130px;
			background-color: rgba(0, 0, 0, .3);
			display: none;
			line-height: 125px;
			text-align: center;
			cursor: pointer;
		}

		.cover .delbtn {
			color: red;
			font-size: 20px;
			z-index: 999;
		}

		.imageDiv:hover .cover {
			display: block;
		}

		.addImages {
			display: inline-block;
			width: 160px;
			height: 130px;
			-webkit-box-sizing: border-box;
			-moz-box-sizing: border-box;
			box-sizing: border-box;
			border: 1px dashed darkgray;
			background: #f8f8f8;
			position: relative;
			overflow: hidden;
			margin: 10px;
		}

		.text-detail {
			margin-top: 40px;
			text-align: center;
		}

		.text-detail span {
			font-size: 40px;
		}

		.file {
			position: absolute;
			top: 0;
			left: 0;
			width: 160px;
			height: 130px;
			opacity: 0;
		}

		.upBtn {
			position: relative;
			display: inline-block !important;
			overflow: hidden;
		}

		.upfile {
			display: inline-block !important;
			opacity: 0;
			position: absolute;
			left: 0
		}

		.bgf2 {
			background: #f2f2f2;
		}

		th {
			text-align: center
		}

		td {
			text-align: center;
			vertical-align: middle !important;
			padding: 0px !important;
		}

		.wid30 {
			width: 30%;
		}

		.floatr {
			float: right;
		}

		#targetbox {
			width: 100%;
			height: 40px;
			display: none;
		}

		.imgtd {
			width: 35%;
			padding: 5px;
		}

		.imgtd img {
			width: 160px;
			height: 120px;
			margin: 5px;
		}

		.img_tbody {
			margin-top: 100px;
		}
		.aactive{
			background: #1b6d85;
		}
	</style>
</head>

<body>
<div class="wrap">
	<ul class="nav nav-tabs page-list-1">
		<li class="active list-item1"><a href="#">实景图</a></li>
		<li class="list-item1"><a href="#">户型图</a></li>
		<li class="list-item1"><a href="#">配套图</a></li>
		<li class="list-item1"><a href="#">效果图</a></li>
		<li class="list-item1"><a href="#">其他</a></li>

	</ul>
	<div class="pages-1">
		<!-- 实景图 -->
		<div class="pages-item1">
			<form method="post" action="" id="up_img1"
				  enctype="multipart/form-data" multipart="multipart">
				<table class="table table-bordered">
					<thead>
					<tr class="bgf2">
						<th class="wid30">预览</th>
						<th>文件名</th>
						<th>大小</th>
						<th>状态</th>
					</tr>
					</thead>
					<tbody class="tbody" id="box1">
					</tbody>
				</table>
				<div class="upBtn sjimg" style="width:60%;float:left">
					<span class="btn btn-success">选择多文件</span>
					<input type='file' name='pictureFile' class="upfile sjbtn "  multiple>
				</div>
				<input type="hidden" name="type" value="1" class="typeid">
				<input type="hidden" name="proId" value="${proId}" class="proid">
				<div class="floatr"><button type="submit" class="btn btn-info sjsubmit">开始上传</button></div>
			</form>

			<table class="table table-bordered img_tbody">
				<caption>已添加图片</caption>
				<thead>
				<tr class="bgf2">
					<th>预览</th>
					<th>文件名</th>
					<th>操作</th>
				</tr>
				</thead>
				<tbody class="tbody" id="sj_img_box">
				</tbody>
			</table>
		</div>
		<!-- 户型图 -->
		<div class="pages-item1">
			<form method="post" action="" id="up_img2"
				  enctype="multipart/form-data" multipart="multipart">
				<table class="table table-bordered">
					<thead>
					<tr class="bgf2">
						<th class="wid30">预览</th>
						<th>文件名</th>
						<th>大小</th>
						<th>状态</th>
					</tr>
					</thead>
					<tbody class="tbody" id="box2">
					</tbody>
				</table>
				<div class="upBtn hximg" style="width:60%;float:left">
					<span class="btn btn-success">选择多文件</span>
					<input type='file' name='pictureFile' class="upfile hxbtn" multiple>
				</div>
				<input type="hidden" name="type" value="2" class="typeid">
				<input type="hidden" name="proId" value="${proId}" class="proid">
				<div class="floatr"><button type="submit" class="btn btn-info hxsubmit">开始上传</button></div>
			</form>
			<table class="table table-bordered img_tbody">
				<caption>已添加图片</caption>
				<thead>
				<tr class="bgf2">
					<th>预览</th>
					<th>文件名</th>
					<th>操作</th>
				</tr>
				</thead>
				<tbody class="tbody" id="hx_img_box">
				</tbody>
			</table>
		</div>

		<!-- 配套图 -->
		<div class="pages-item1">
			<form method="post" action="" id="up_img3"
				  enctype="multipart/form-data" multipart="multipart">
				<table class="table table-bordered">
					<thead>
					<tr class="bgf2">
						<th class="wid30">预览</th>
						<th>文件名</th>
						<th>大小</th>
						<th>状态</th>
					</tr>
					</thead>
					<tbody class="tbody" id="box3">
					</tbody>
				</table>
				<div class="upBtn ptimg" style="width:60%;float:left">
					<span class="btn btn-success">选择多文件</span>
					<input type='file' name='pictureFile' class="upfile ptbtn"  multiple >
				</div>
				<input type="hidden" name="type" value="3" class="typeid">
				<input type="hidden" name="proId"value="${proId}" class="proid">
				<div class="floatr"><button type="submit" class="btn btn-info ptsubmit">开始上传</button></div>
			</form>
			<table class="table table-bordered img_tbody">
				<caption>已添加图片</caption>
				<thead>
				<tr class="bgf2">
					<th>预览</th>
					<th>文件名</th>
					<th>操作</th>
				</tr>
				</thead>
				<tbody class="tbody" id="pt_img_box">
				</tbody>
			</table>
		</div>

		<!-- 效果图 -->
		<div class="pages-item1">
			<form method="post" action="" id="up_img4"
				  enctype="multipart/form-data" multipart="multipart">
				<div id="imglist"></div>

				<table class="table table-bordered">
					<thead>
					<tr class="bgf2">
						<th class="wid30">预览</th>
						<th>文件名</th>
						<th>大小</th>
						<th>状态</th>
					</tr>
					</thead>
					<tbody class="tbody" id="box4">
					</tbody>
				</table>
				<div class="upBtn xgimg" style="width:60%;float:left">
					<span class="btn btn-success">选择多文件</span>
					<input type='file' name='pictureFile' class="upfile xgbtn" multiple >
				</div>
				<input type="hidden" name="type" value="4" class="typeid">
				<input type="hidden" name="proId" value="${proId}" class="proid">
				<div class="floatr"><button type="submit" class="btn btn-info xgsubmit">开始上传</button></div>
			</form>
			<table class="table table-bordered img_tbody">
				<caption>已添加图片</caption>
				<thead>
				<tr class="bgf2">
					<th>预览</th>
					<th>文件名</th>
					<th>操作</th>
				</tr>
				</thead>
				<tbody class="tbody" id="xg_img_box">
				</tbody>
			</table>
		</div>

		<!-- 其他 -->
		<div class="pages-item1">
			<form method="post" action="" id="up_img5"
				  enctype="multipart/form-data" multipart="multipart">
				<div id="imglist"></div>

				<table class="table table-bordered">
					<thead>
					<tr class="bgf2">
						<th class="wid30">预览</th>
						<th>文件名</th>
						<th>大小</th>
						<th>状态</th>
					</tr>
					</thead>
					<tbody class="tbody" id="box5">
					</tbody>
				</table>
				<div class="upBtn qtimg" style="width:60%;float:left">
					<span class="btn btn-success">选择多文件</span>
					<input type='file' name='pictureFile' class="upfile qtbtn"   multiple>
				</div>
				<input type="hidden" name="type" value="5" class="typeid">
				<input type="hidden" name="proId" value="${proId}" class="proid">
				<div class="floatr"><button type="submit" class="btn btn-info qtsubmit">开始上传</button></div>
			</form>
			<table class="table table-bordered img_tbody">
				<caption>已添加图片</caption>
				<thead>
				<tr class="bgf2">
					<th>预览</th>
					<th>文件名</th>
					<th>操作</th>
				</tr>
				</thead>
				<tbody class="tbody" id="qt_img_box">
				</tbody>
			</table>
		</div>
	</div>
</div>
<div id="targetbox"></div>
<%--<div onclick="resetForm()">清空</div>--%>
</body>

<script src="${ctx}/js/system/project/jquery-Form.js"></script>
<script>
	var proid=document.getElementsByClassName('proid')[0];
    proid=proid.getAttribute("value")
    Setshowimg("#sj_img_box",proid, '1');
    function tab({
                     container = "tab-wrap",
                     item = "tab-item",
                     page = "tab-page",
                     ev = "click",
                     successStyle = ""
                 } = {}) {


        container = document.getElementsByClassName(container)[0];
        item = Array.from(document.getElementsByClassName(item));
        page = Array.from(document.getElementsByClassName(page));

        page.forEach((it, index) => {
            item[index].setAttribute("index", index);

        item[0].style.display = "block"; //默认设置


        function change() {

            item.forEach(e => {
                e.style.display = "none";

        });
            item[index].style.display = "block";
            var typeid = item[index].getElementsByClassName("typeid")[0].value;
            // var proid = item[index].getElementsByClassName("proid")[0].value;
            var imgbox = item[index].getElementsByTagName("tbody")[1].getAttribute("id");
            Setshowimg("#" + imgbox, proid, typeid)
        }
        it.addEventListener(ev, change, false);
    });

    }

    new tab({
        container: "page-list-1",
        item: "pages-item1",
        page: "list-item1",
        ev: "click"
    });

    $("li").click(function () {
        $("li").removeClass("active");
        $(this).addClass("active");

    })


    var imgOBJ={};

    var imgmsg ={};

    $('.sjbtn').click(function(){

        shijintu('.sjbtn',"#box1",0,imgmsg[0],'sjbtn','.sjimg')
    })

    $('.hxbtn').click(function(){
        shijintu('.hxbtn',"#box2",1,imgmsg[1],'hxbtn','.hximg')
    })

    $('.ptbtn').click(function(){
        shijintu('.ptbtn',"#box3",2,imgmsg[2],'ptbtn','.ptimg')
    })

    $('.xgbtn').click(function(){
        shijintu('.xgbtn',"#box4",3,imgmsg[3],'xgbtn','.xgimg')
    })

    $('.qtbtn').click(function(){
        shijintu('.qtbtn',"#box5",4,imgmsg[4],'qtbtn','.qtimg')
    })


    function shijintu(upbtn, showtbody, indexa, imgindex, inpname, inpwrap) {
        //实景图--------------------------------------------------------------
        // $(function () {

        if (imgmsg[indexa] == undefined) {
            imgmsg[indexa] = [];
        };
        function createfile() {
            $(upbtn).attr("class","upfile")
            $(inpwrap).append("<input type='file' name='pictureFile'    class='upfile " + inpname + "'>");
        }
        function showimg(url) {
            var img = '<div class="imageDiv"><img src="' + url + '"/> <div class="cover"><i class="delbtn">删除</i></div></div>';
            // $('#imglist').append(img);
            var imgObjPreview = document.getElementsByTagName("img");
            for (var i = 0; i < imgObjPreview.length; i++) {
                imgObjPreview[i].style.display = 'block';
                imgObjPreview[i].style.width = '160px';
                imgObjPreview[i].style.height = '120px';
            }
        }

        function addfile(imgFile) {
            var file = this.files[0];//上传的图片的所有信息
            //首先判断是否是图片
            if (!/image\/\w+/.test(file.type)) {
               layer.alert('上传的不是图片');
                return false;
            }
            //在此限制图片的大小
            var imgSize = file.size;

            //35160  计算机存储数据最为常用的单位是字节(B)
            //在此处我们限制图片大小为2M
            if (imgSize > 4 * 1024 * 1024) {
               layer.alert('上传的图片的大于4M,请重新选择');
                $(this).val('')
                return false;
            }
            //如果还想限制图片格式也可以通过input的accept属相限制，或者file.name属性值做判断
            //建议使用accept属性，简单，方便。具体可以查看我的另一片文章
            //将图片信息通过如下方法获得一个http格式的url路径
            var objUrl = getObjectURL(this.files[0]);

            imgmsg[indexa].push({ 'imgurl': objUrl, 'imgname': file.name, 'imgsize': file.size })

            var imghtml = "";
            for (var i = 0; i < imgmsg[indexa].length; i++) {
                imghtml += '<tr class="imgtr"><td class="wid30"><div class="imageDiv"><img src="' + imgmsg[indexa][i].imgurl + '"/> <div class="cover"><i class="delbtn" data-name="' + imgmsg[indexa][i].imgname + '">删除</i></div></div> </td>' +
                    '<td> ' + imgmsg[indexa][i].imgname + '</td>' +
                    '<td> ' + imgmsg[indexa][i].imgsize + '</td>' +
                    '<td>等待上传</td></tr>'
            }

            imgOBJ[indexa] = imgmsg[indexa];
            $(showtbody).html(imghtml)
            $(".delbtn").click(function () {
                $(this).parents("tr").remove();
                for (var a = 0; a < imgmsg[indexa].length; a++) {
                    if ($(this)[0].dataset.name == imgmsg[indexa][a].imgname) {
                        var index = imgmsg[indexa].indexOf(imgmsg[indexa][a]);

                        if (index > -1) {
                            imgmsg[indexa].splice(index, 1);
                        }
                    }
                }

            });
            //blob:http://127.0.0.1:8020/6bf47c99-496b-4cc4-ae73-27aa06987036url
            showimg(objUrl)
            //showimg($(this).val());
            //$(this).val()本地上传的图片的绝对路径无法实现Img现实的，要将其转换为http格式的路径方能实现显示
            $(this).hide();

            createfile();

            // $('.sjbtn').bind('change', addfile);
            $(upbtn).bind('change', addfile);

        }

        $(upbtn).bind('change', addfile);




        function getObjectURL(file) {
            var url = null;
            if (window.createObjectURL != undefined) { //
                url = window.createObjectURL(file);
            } else if (window.URL != undefined) {
                //仅简单的验证仅如下的浏览器支持 webkit or chrome ie11 ie10 firefox oprea
                url = window.URL.createObjectURL(file);
            } else if (window.webkitURL != undefined) { // webkit or chrome
                url = window.webkitURL.createObjectURL(file);
            }
            return url;
        };
    }
    $(".sjsubmit").click(function () {
        // let proid = $(this).parent().prev().val();
        let typeid = $(this).parent().prev().prev().val()
        checkform("up_img1", "#box1", "#sj_img_box", proid, typeid,0)
    })
    $(".hxsubmit").click(function () {
        // let proid = $(this).parent().prev().val();
        let typeid = $(this).parent().prev().prev().val()
        checkform("up_img2", "#box2", "#hx_img_box", proid, typeid,1)
    })
    $(".ptsubmit").click(function () {
        // let proid = $(this).parent().prev().val();
        let typeid = $(this).parent().prev().prev().val()
        checkform("up_img3", "#box3", "#pt_img_box", proid, typeid,2)
    })
    $(".xgsubmit").click(function () {
        // let proid = $(this).parent().prev().val();
        let typeid = $(this).parent().prev().prev().val()
        checkform("up_img4", "#box4", "#xg_img_box", proid, typeid,3)
    })
    $(".qtsubmit").click(function () {
        // let proid = $(this).parent().prev().val();
        let typeid = $(this).parent().prev().prev().val()
        checkform("up_img5", "#box5", "#qt_img_box", proid, typeid,4)
    })

    // ajaxForm提交表单
    function checkform(objform,imgboxq,imgbox,proid,type,imgarr) {


        var inpform = document.getElementById(objform);
        var inpimg = inpform.getElementsByClassName("imgtr");
        if (inpimg.length !== 0) {
            var options = {
                url: "../projectOffice/addImg.shtml",
                target: "#targetbox",
                success: function (data) {
                   layer.alert("提交成功");


                    // if (data == "success") {
                        $.ajax({
                            url: "../projectOffice/findImg.shtml?proId=" + proid + "&type=" + type,
                            type: 'get',
                            dataType: 'json',
                            success: function (res, error) {

                                if (res !== null) {
                                    var imghtml = "";
                                    for (var i = 0; i < res.length; i++) {
                                        imghtml += '<tr> <td class="imgtd"><img src="../img/project/office/' + proid+'/'+res[i].img + '"></td> <td>' + res[i].img + '</td> <td onclick="Delimg(this,' + res[i].id + ')"><button class="btn btn-danger">删除</button></td>'
                                    }
                                    $(imgbox).html(imghtml)
                                }
                            }
                        })
                    $(imgboxq).html("");

                    imgmsg[imgarr] = [];

                    document.getElementById(objform).reset();
                },

            };

            $("#"+objform).ajaxForm(options);

        } else {
           alert("请选择图片")
        }
    }

    function Delimg(obj, id) {


        var con;
        con = confirm("是否要删除该图片?"); //在页面上弹出对话框
        if (con == true) {
            $(obj).parent("tr").remove()
            $.ajax({
                url: "../projectOffice/deleteImg.shtml?id=" + id,
                type: 'get',
                dataType: 'json',
                success: function (res, error) {

                }
            })
        }
    }
	//图片回显
    function Setshowimg(imgbox, proid, type) {

        $.ajax({
            url: "../projectOffice/findImg.shtml?proId=" + proid + "&type=" + type,
            type: 'get',
            dataType: 'json',
            success: function (res, error) {

                if (res !== null) {
                    var imghtml = "";
                    for (var i = 0; i < res.length; i++) {

                        imghtml += '<tr> <td class="imgtd"><img src="../img/project/office/'  + proid+'/'+ res[i].img + '"></td>  <td>' + res[i].img + '</td>  <td onclick="Delimg(this,' + res[i].id + ')"><button class="btn btn-danger">删除</button></td>'

                    }
                    $(imgbox).html(imghtml)
                }

            }

        })

    }


</script>

</html>