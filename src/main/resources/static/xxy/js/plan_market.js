//JavaScript代码区域
layui.use(['element','jquery','laydate','table','layer','form'], function(){
    var element = layui.element;
    //引入jquery
    var $ = layui.jquery;
    var table = layui.table;
    var laydate = layui.laydate;
    var layer=layui.layer;
    var form = layui.form;

   var tableIns= table.render({
        // 表格容器ID
        elem: '#ware_info'
        // 表格ID，必须设置，重载部分需要用到
        , id: 'tableOne'
        // 数据接口链接
        , url: "/erp/market/getPlanMarket"
        // 附加参数，post token
        , where: {}
        , method: 'post'
        // 分页 curr起始页，groups连续显示的页码，默认每页显示的条数
        , page: {
            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']
            , curr: 1
            , groups: 6
            , limit: 10
        }
        ,response: {
            statusCode: 200 //规定成功的状态码，默认：0
        }
        , toolbar: '#toolbar'
        , defaultToolbar: ['filter', 'print', 'exports']
        , cols: [[
            {checkbox: true, fixed: true}
            ,{field:'pid', width:80, title: 'ID', sort: true,}
            ,{field:'pname', width:80, title: '名称'}
            ,{field:'number', width:80, title: '数量', sort: true }
            ,{field:'assignee', width:80, title: '负责人'}
            ,{field:'ischeck', width:80, title: '是否通过', sort: true}
            ,{field:'startTime', minWidth:80, title: '创建日期', sort: true ,
            templet: function(data){return getLocalTime(data.startTime);}}
            ,{field:'endTime', minWidth:80, title: '完成日期', sort: true, templet:function(data){return getLocalTime(data.endTime);}}
            ,{field:'cid', width:135, title: '类型', sort: true,templet:function (data) {
                    var cate=data.cid;
                   var syncInfo="未确定类型";
                   if(cate ==4){
                       syncInfo ="三星主板";
                   }else if(cate ==1){
                       syncInfo ="富士通主板";
                   }else if(cate ==2){
                       syncInfo ="华硕主板";
                   }else if(cate ==3){
                       syncInfo ="技嘉主板";
                   }
                   return syncInfo;
               }}
            ,{field:'detail', width:135, title: '描述', sort: true}
        ]]

    });

    //刷新按钮
    table.on('toolbar(tableOne)', function (obj) {
        switch (obj.event) {
            case 'refresh':
                tableIns.reload();
                break;
        }
    });
  /*  $("#tables").dataTable({
        debug: true,
        check: true,
        pageCapacity:5,
        loading:false,
        oddEven:false,
        url: "/erp/market/getPlanMarket",
        style: {"font-size": "12px", "width": "1200px"},
        align:"center",
        ButtonStyle:{fontColor:"#ffffff",backgroundColor:"#10AA9C"},
        columns: [
            {ColumnName: "pid", title: "ID",  event: 'details', width: 30, align: 'center'},
            {ColumnName: "pname", title: "名称", width: 60, align: 'center'},
            {ColumnName: "number", title: "数量", width: 50, align: 'center'},
            {ColumnName: "assignee", title: "负责人", width: 50, align: 'center'},
            {ColumnName: "ischeck", title: "是否通过", width: 40, align: 'center'},
            {ColumnName: "startTime",
                title: "创建日期",
                width: 120,
                "render": function ChangeDateFormat(date) {
                var dateee = new Date(date).toJSON();
                return new Date(+new Date(dateee) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '')
                }},
            {ColumnName: "endTime", title: "完成日期", width: 120},
            {ColumnName: "cname", title: "类型", width: 80},
            {ColumnName: "detail", title: "描述", width: 100},

            {title: "查看", button: "show", buttonName: "查看", width: 50},//自定义的按钮
            {title: "编辑", button: "edit", buttonName: "编辑", width: 50},//自定义的按钮
            {title: "删除", button: "del", buttonName: "删除", width: 50}//自定义的按钮
        ],
        Click: function (row) {//内置事件行单击
            alert("单击："+row.id);
        },
        doubleClick: function (row) {//内置事件行双击事件
            alert("双击："+row.id);
        }
        ,
        editClick: function (row) {//自定义按钮事件，事件名是上面设置的按钮名+Click
            alert("自定义编辑："+row.id);

        }
        ,
        delClick: function (row) {
            layer.open({
                content: '确认是否删除？'
                ,btn: ['确认', '取消']
                ,yes: function(index, layero){
                    $.post('/erp/market/delMarket',{"id":row.pid},function (data) {
                        layer.msg(data.message);
                        $("#tables").TableRefresh();
                    },"json");
                    layer.close(index);
                }
                ,btn2: function(index, layero){
                    //按钮【按钮二】的回调
                    //return false 开启该代码可禁止点击该按钮关闭
                }
                ,cancel: function(){
                    //右上角关闭回调
                    //return false 开启该代码可禁止点击该按钮关闭
                }
            });


        },
        showClick: function (row) {
            alert("自定义查看："+row.name);
        }
    });
*/
//按产品计划名称进行模糊查询
    $("#nameLikeBtn").click(function(){
        var nameLike = $("input[name=nameLike]").val();
        if(nameLike==''){
            layer.msg('请正确输入名称',{"icon":5});
            return false ;
        }

        table.reload('tableOne', {
            method: 'get'
            , where: {
                'nameLike': nameLike,
            }
            , page: {
                curr: 1
            }
        });
        //按名称进行模糊搜索
      /*  $("#tables").dataTable({
            url: "/erp/market/getPlanMarket?nameLike="+nameLike
        });*/
        layer.msg('查询成功',{"icon":6});

    });

    //按市场分类进行搜索
    $("#maketCateBtn").click(function(){
        var cate = $("select[name=category]").val();

        if(cate==''){
            layer.msg('请正确选择分类',{"icon":5});
            return false ;
        }
        //发送请求
        //按时间进行搜索
        table.reload('tableOne', {
            method: 'get'
            , where: {
                'category': cate,
            }
            , page: {
                curr: 1
            }
        });

        layer.msg('查询成功',{"icon":6});
    });

    //按照时间进行搜索
    $("#btnTimeSearch").click(function(){
        let start = $("#startTime").val();
        let end = $("#endTime").val();

        if(start=='' || end ==''){
            layer.msg('请正确输入时间',{"icon":5});
            return false ;
        }
        //按时间进行搜索
        table.reload('tableOne', {
            method: 'get'
            , where: {
                'startTime': start,
                'endTime': end,
            }
            , page: {
                curr: 1
            }
        });


        layer.msg('查询成功',{"icon":6});

    });



    //执行一个laydate实例
    laydate.render({
        elem: '#startTime' //指定元素
        ,trigger: 'click' //自动弹出控件的事件，采用click弹出
        ,format:'yyyy-MM-dd'
    });

    laydate.render({
        elem: '#endTime' //指定元素
        ,trigger: 'click' //自动弹出控件的事件，采用click弹出
        ,format:'yyyy-MM-dd'
    });


});
/**
 * 格式化日期
 * @param timestamp
 * @returns {string}
 */
function getLocalTime(timestamp) {
    if(timestamp == null) {
        return "";
    }
    var date = new Date(timestamp);
    var newDate = date.toLocaleDateString().replace(/\//g, "-") + " " + date.toTimeString().substr(0, 8);
    return newDate;
}