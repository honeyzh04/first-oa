<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

 <style type="text/css">
element.style {
    height: 110px;
    background-color: #fff;
}
#div1{
    background: #ece9e9;;
  
    min-width: 600px;
    padding: 1px 0;
}
.people{
 margin-top:5px;
}
li{
 margin-top:5px;
}
.frist{
  
   
    margin: 0 auto;
    display: flex;
    padding: 5px 0;
    background: white;
    border: 1px solid #cccccc;
    overflow: hidden;

}
.divHU{
	line-height:18px;
	word-spacing:2px;
}
.cent{
   
    width: 99%;
    background: #ece9e9;
    margin: 10px auto;
    position: relative;


}


.cent_frist{
   
    width: 100%;
  
    background: white;
    position: relative;
    margin: 10px 0;
    color: black;
    padding: 5px 15px;

}
.cent_frist h1{
    margin: 5px 0;
   
    font-weight: bold;
    font-family: "Times New Roman", Times, serif;
    color:rgb(51,144,255);
   
    font-size: 15px


}
.cent_frist div{

   
    margin: 5px 0;
   
}

  
        #section1{
            width: 90%;
            margin: 0 auto;
            background-color: #cccccc;
            padding: 10px 0;
            display: none;
        }
        .content{
             width: 100%;
            padding: 10px;
            color: #666666;
            font-size: 14px;

        }
        .moreaa:hover{
        color:blue;}
    </style>


	

	<div class="m-b-md">
	
	<div class="m-b-md">
		<form class="form-inline" role="form" id="searchForm"
			name="searchForm">
			<div class="form-group">


				<label class="control-label">输入问题： <input type="text"
					class="form-control" id="que" name="userFormMap.userName"
					placeholder="请输入感兴趣的问题">
				</label>

				<button id="search" type="button" class="btn btn-info"
					onclick="find()">
					搜索 &nbsp;&nbsp;<span class="glyphicon glyphicon-search"
						aria-hidden="true"></span>
				</button>
				<button id="addAccount" type="button"
					class="btn btn-success buttona">
					提问 &nbsp;&nbsp;<span class="glyphicon glyphicon-plus"
						aria-hidden="true"></span>
				</button>

			</div>
		</form>
	</div>
	<header class="panel-heading">
 	<div class="doc-buttons">
		<c:forEach items="${res}" var="key">
			${key.description}
		</c:forEach>
		
	</div>
	</header> 
		<div id="hidebg"></div>


</div>
<div id="div1">

	<ol id="userId">
	
	</ol>
	<div class="table-responsive">
		<div id="paging" class="pagclass"></div>
	</div>
</div>
	<div class="col-lg-3  pull-right" id="pagea">
		
        </div>

	<script type="text/javascript">
	 $(function () { 
		 
		 find();
		
	 });
	

 
 
 
	function find(_this){
		$("#userId").html("");
		$("#pagea").html("");
		var que=$("#que").val();
		 var page = $(_this).attr("value");
		 console.log("que"+que);
		 console.log("page"+page);
		$.ajax({
			"url":"./interlocution/findQuestionsa.shtml",
			"data":{que:que,page:page},
			
			"type":"GET",
			"dataType":"json",
			"success":function(obj){
				console.log(obj);
				for(i=0;i<obj.list.length;i++){
					console.log(obj.list[i].question);
					var str ='<div class="cent" id="cent"><div class="cent_frist"><h1> Q:'+obj.list[i].question+'</h1> <div class="divHU"><br/>A:&nbsp;&nbsp;&nbsp;&nbsp;'+obj.list[i].answer+'<br /><div class="people">回答人：'+obj.list[i].createBy+'&nbsp;&nbsp; 编辑于：'+obj.list[i].createDate+
							'&nbsp;&nbsp;&nbsp;&nbsp;<a  href="#" onclick="interlocutioneditLayer(this);" value='+obj.list[i].aId+'>'+obj.list[i].edit+'</a>&nbsp;&nbsp;&nbsp;&nbsp;<a  href="#" onclick="interlocutiondeleLayer(this);" value='+obj.list[i].aId+'>'+obj.list[i].dele+'</a></div></div>'
						+'<a  href="#" onclick="interlocutionaddLayer(this);" value='+obj.list[i].id+'> 我来回答</a>'
						+'<div onclick="moreanswers(this);" value='+obj.list[i].id+' ><span class="moreaa"><i class="fa fa-comment" aria-hidden="true"></i>&nbsp;&nbsp;'+obj.list[i].sum+'条回答 &gt; &gt;</span><ol class="adav" id="adav"></ol></div></div></div>'
				
				
				
					$("#userId").append(str);
					
				}; 
				var pages="共 "+obj.pages+"页问题";
				$("#pages").append(pages);
				var pagea='<p id="pages">当前第'+obj.pageNum+'页/共'+obj.pages+'页/共'+obj.total+'条</p> <a href="#"   value='+obj.firstPage+' onclick="find(this)">首页&nbsp;&nbsp;</a><a href="#"  value='+obj.prePage+' onclick="find(this)">上一页&nbsp;&nbsp;</a> <a href="#"  value='+obj.nextPage+'  onclick="find(this)">下一页&nbsp;&nbsp;</a><a href="#"  value='+obj.lastPage+'  onclick="find(this)">尾页</a>'
					$("#pagea").append(pagea);
			},
			  error : function() {  
	              alert("请与管理员联系");  
	          }  
		});
		
	};
	var tmp="";
	 function moreanswers(_this)
		{
			$(_this).children(".adav").html("");
			var id = $(_this).attr("value");
			$.ajax({
				"url" : "./interlocution/findanswer.shtml",
				"data" : "id=" + id,
				"type" : "GET",
				"dataType" : "json",
				"success" : function(obj) {

					for (i = 0; i < obj.length; i++) {

						var stra = '</br><li>A:&nbsp;&nbsp;&nbsp;&nbsp;'
								+ obj[i].answer + '<br /><div class="people">回答人：'
								+ obj[i].createBy + '&nbsp;&nbsp; 编辑于：'
								+ obj[i].createDate +'&nbsp;&nbsp;&nbsp;&nbsp;<a  href="#" onclick="interlocutioneditLayer(this);" value='+obj[i].id+'>'+obj[i].edit+'</a> '+
								'&nbsp;&nbsp;&nbsp;&nbsp;<a  href="#" onclick="interlocutiondeleLayer(this);"  value='+obj[i].id+'>'+obj[i].dele+'</a></div></li>'

						$(_this).children(".adav").append(stra);
					}

				}
			});

			if (tmp == "") {
				$(_this).children(".adav").show();
				tmp = "1"
			} else {
				$(_this).children(".adav").hide();

				tmp = "";
			}

		}
	</script> 
	<script type="text/javascript" src="js/system/assistant/list.js"></script>  

