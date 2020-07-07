//加载表单模块
layui.use(['element','jquery','laydate','table','layer','form'], function() {
    var form = layui.form;


    var element = layui.element;
    //引入jquery
    var $ = layui.jquery;
    var table = layui.table;
    var laydate = layui.laydate;
    var layer=layui.layer;


    //执行一个laydate实例
    laydate.render({
        elem: '#startTime' //指定元素
        , trigger: 'click' //自动弹出控件的事件，采用click弹出
        , format: 'yyyy-MM-dd'
    });

    laydate.render({
        elem: '#endTime' //指定元素
        , trigger: 'click' //自动弹出控件的事件，采用click弹出
        , format: 'yyyy-MM-dd'
    });

    laydate.render({
        elem: '#st' //指定元素
        , trigger: 'click' //自动弹出控件的事件，采用click弹出
        , format: 'yyyy-MM-dd'
    });
    laydate.render({
        elem: '#et' //指定元素
        , trigger: 'click' //自动弹出控件的事件，采用click弹出
        , format: 'yyyy-MM-dd'
    });
    //分类加载
    $.get('/erp/marketcate/findAll', {}, function (data) {

        if (data.success) {
            let category = "";
            data.data.forEach(function (object, index) {
                category += '<option value="' + object.typeid + '">' + object.name + '</option>';
            });
            let select = $("select[name=typeid]");
            select.empty();
            select.append(category);
            form.render('select');
        }
    }, "json");

    //添加预测
    form.on('submit(addform)', function (data) {


        $.post('/erp/MarketPredictions/addPredictions'
            , {
                "typeid": data.field.typeid,
                "name": data.field.name,
                "messageSource": data.field.messageSource
                ,
                "messageLevel": data.field.messageLevel,
                "startTime": data.field.startTime,
                "endTime": data.field.endTime
            }
            , function (msg) {
                layer.alert(msg.message);
            }, 'json');


        return false;
    });

    //预测
    form.on('submit(predictions)', function (data) {

        let name = data.field.name;
        let startTime = data.field.startTime;
        let endTime = data.field.endTime;


         table.render({
            // 表格容器ID
            elem: '#ware_info'
            // 表格ID，必须设置，重载部分需要用到
            , id: 'tableOne'
            // 数据接口链接
            , url: "/erp/MarketPredictions/predictions"
            // 附加参数，post token
            , where: {
                name: name,
                startTime: startTime,
                endTime: endTime,
            }
            , method: 'post'
            // 分页 curr起始页，groups连续显示的页码，默认每页显示的条数
            , page: {
                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']
                , curr: 1
                , groups: 5
                , limit: 5
            }
            , response: {
                statusCode: 200 //规定成功的状态码，默认：0
            }
            , toolbar: '#toolbar'
            , defaultToolbar: ['filter', 'print', 'exports']
            , cols: [[
                {checkbox: true, fixed: true}
                , {field: 'id', width: 80, title: 'ID', sort: true,}
                , {field: 'name', width: 80, title: '名称'}
                , {field: 'number', width: 80, title: '最大(小)数量', sort: true}
                , {field: 'createtime', minWidth: 80, title: '创建日期',
                    templet: function (data) {
                        return getLocalTime(data.createtime);
                    }
                }

            ]]

        });

        return false;

    });
//刷新按钮
    table.on('toolbar(tableOne)', function (obj) {
        switch (obj.event) {
            case 'refresh':
                tableIns.reload();
                break;
        }
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
/*
//加载数据 最高
*/