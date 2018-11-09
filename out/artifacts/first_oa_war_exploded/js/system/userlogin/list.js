$(function () {
	


//初始化表格对象

$('#datatable').DataTable({
	autoWidth: true,
	  searching: false,//禁用datatables搜索
	  processing: true,//载入数据的时候是否显示“载入中”
      serverSide: true,//开启服务器模式。分页，取数据等等的都放到服务端去
      "aLengthMenu" : [15,25,30], //更改显示记录数选项
      "bScrollCollapse" : true,
      
  	paging: true,
  	info: true,
  	 ordering: false,
    	
    	ajax: {
            url: "./userlogin/findByPage.shtml",// 数据请求地址
            type: "POST"
          
            
            /* data: function (params) {
            	//此处为定义查询条件 传给控制器的参数
            	//角色名称
                params.roleName = $("#theRoleName").val()
            } */
        },
columns: [
	 			
	           	 { data: "id" },
	       		 
	       		  { data: "accountName" },
	         		
	         	{  
	                 data : 'loginTime', 
	                    render:function(data,type,full,callback) {
     	                      
	                    		var date=new Date(data);
	                    	 var y=date.getFullYear();  
	                      var m=date.getMonth()+1;  
	                      var d=date.getDate();  
	                      var h=date.getHours();  
	                      var m1=date.getMinutes();  
	                      var s=date.getSeconds();  
	                      m = m<10?("0"+m):m;  
	                      d = d<10?("0"+d):d;  
	                      return y+"-"+m+"-"+d+" "+h+":"+m1+":"+s;  
	                    }},
	         		{ data: "loginIP" },
	         		
    	], 
     
         
    	oLanguage : {
			"sProcessing" :"<img src='./img/loading.gif' /> 努力加载数据中.",
			"sLengthMenu" : "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;每页显示 _MENU_ 条登录记录",
			"sZeroRecords" : "抱歉， 没有找到",
			"sInfo" : "从 _START_ 到 _END_ /共 _TOTAL_ 条登录信息",
			"sInfoEmpty" : "没有数据",
			"sInfoFiltered" : "(从 _MAX_ 条数据中检索)",
			"oPaginate" : {
				"sFirst" : "首页",
				"sPrevious" : "前一页",
				"sNext" : "后一页",
				"sLast" : "尾页"
			},
			"sZeroRecords" : "没有检索到数据",
			"sProcessing" : "<img src='./img/loading.gif' />"
		},
     

 });

	} );

	
