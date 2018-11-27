
var pageii = null;
$(function() {


	//个人日报表
	$("#peReport").click("click", function() {
        peReport();
	});
	//部门日报表
	$("#deReport").click("click", function() {
        deReport();

	});

    $("#dayadd").click("click", function() {
        dayadd();

    });

    $("#weekadd").click("click", function() {
        weekadd();

    });

    $("#monthadd").click("click", function() {
        monthadd();

    });

    $("#dedayadd").click("click", function() {
        dedayadd();

    });

    $("#deweekadd").click("click", function() {
        deweekadd();

    });

    $("#demonthadd").click("click", function() {
       demonthadd();

    });
});


/**
 *  个人报表确认
 * @returns
 */
function peReport() {
	pageii = layer.open({
		title : "个人日报表确认单",
		type : 2,
area : [ "1040px", "80%" ],
    content : './personal/pereportUI.shtml'
});
}


/**
 *  部门报表确认
 * @returns
 */
function deReport() {
    pageii = layer.open({
        title : "部门日报表确认单",
        type : 2,
        area : [ "1040px", "80%" ],
        content : './personal/dereportUI.shtml'
    });
}

/**
 * 添加日目标
 */
function dayadd() {
    pageii = layer.open({
        title : "制定日目标",
        type : 2,
        area : [ "530px", "500px" ],
        content : './personal/dayaddUI.shtml'
    });
}

/**
 * 添加周目标
 */
function weekadd() {
    pageii = layer.open({
        title : "制定周目标",
        type : 2,
        area : [ "530px", "500px" ],
        content : './personal/weekaddUI.shtml'
    });
}

/**
 * 添加月目标
 */
function monthadd() {
    pageii = layer.open({
        title : "制定月目标",
        type : 2,
        area : [ "530px", "500px" ],
        content : './personal/monthaddUI.shtml'
    });
}
/**
 * 添加部门日目标
 */
function dedayadd() {
    pageii = layer.open({
        title : "制定日目标",
        type : 2,
        area : [ "530px", "500px" ],
        content : './personal/dedayaddUI.shtml'
    });
}

/**
 * 添加周目标
 */
function deweekadd() {
    pageii = layer.open({
        title : "制定周目标",
        type : 2,
        area : [ "530px", "500px" ],
        content : './personal/deweekaddUI.shtml'
    });
}

/**
 * 添加月目标
 */
function demonthadd() {
    pageii = layer.open({
        title : "制定月目标",
        type : 2,
        area : [ "530px", "500px" ],
        content : './personal/demonthaddUI.shtml'
    });
}