
//加载表单模块
layui.use(['element','jquery','laydate','table','layer','form'], function(){
    var form = layui.form;
    var laydate = layui.laydate;
    var element = layui.element;
    //引入jquery
    var $ = layui.jquery;
    var table = layui.table;
    var layer=layui.layer;



//表单提交事件
    form.on('submit(formDemo)', function(data){

    //得到文本框的值
    var id = $("input[name=cateid]").val();
    var name =  $("input[name=name]").val();
    var typeid =  $("input[name=typeid]").val();
     $.ajaxSettings.async = false;
    //提交数据到controller,进行修改
   var bool= $.post('/erp/marketcate/updateMarketCate',{'id':id,'name':name,'typeid':typeid},function(data){
    layer.msg(data.message,{"icon":6});
     tableIns.reload();
    $("input[type=text]").val("");
    },'json');




        return false;
    });




var tableIns=table.render({
    // 表格容器ID
    elem: '#Table'
    // 表格ID，必须设置，重载部分需要用到
    ,id:"tableOne"
    // 数据接口链接
    , url: "/erp/marketcate/marketcateData"
    // 附加参数，post token
    , where: {   }
    , method: 'get'
    // 分页 curr起始页，groups连续显示的页码，默认每页显示的条数
    , page: {
        layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']
        , curr: 1
        , groups: 5
        , limit: 10
    }
    , response: {
        statusCode: 200 //规定成功的状态码，默认：0
    }
    , toolbar: '#toolbar'
    , defaultToolbar: ['filter', 'print', 'exports']
    , cols: [[

        {field: 'id', minWidth: 80, title: 'ID',}
        , {field: 'name', minWidth: 80, title: '分类名称'}
        , {field: 'typeid', minWidth: 80, title: 'typeid' }
        ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}

    ]]

});
//监听行工具事件
table.on('tool(tableOne)', function(obj){
    var data = obj.data;
    console.log(obj)
    if(obj.event === 'del'){
        layer.confirm('真的删除行么', function(index){
            obj.del();
            layer.close(index);
        });
    } else if(obj.event === 'edit'){
        $.post('/erp/marketcate/findCateById',{'id':data.id},function(data){
//得到controller数据组装到表单
            $("input[name=cateid]").val(data.data.id);
            $("input[name=name]").val(data.data.name);
            $("input[name=typeid]").val(data.data.typeid);

        },'json');
    }
});


    //刷新按钮
    table.on('toolbar(tableOne)', function (obj) {
        switch (obj.event) {
            case 'refresh':
                tableIns.reload();
                break;
        }
    });



    form.render();
});