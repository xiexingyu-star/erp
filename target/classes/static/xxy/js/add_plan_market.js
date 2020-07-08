//加载表单模块
layui.use(['form','laydate','jquery','table'], function(){
    var form = layui.form;
    var table=layui.table;
    var laydate = layui.laydate;
    var $=layui.jquery;

    //分类加载
    $.get('/erp/marketcate/findAll',{},function (data) {

        if(data.success){
            let category="";
            data.data.forEach(function(object,index){
                category+='<option value="'+object.typeid+'">'+object.name+'</option>';
            });
            let select=$("select[name=marketcate]");
            select.empty();
            select.append(category);
            form.render('select');
        }
    },"json");


    form.render();
    //监听提交
    form.on('submit(formDemo)', function(data){

        //获取表单数据
        var typeid = $("select[name=marketcate]").val();
        var name = $("input[name=planname]").val();
        var detail = $("input[name=detail]").val();
        var assignee = $("input[name=assignee]").val();
        var number = $("input[name=number]").val();


        console.log(name+"-------"+typeid);
        //提交
        $.post('/erp/market/addMarket',{'typeid':typeid,'name':name,'detail':detail,'assignee':assignee,'number':number},function(data){
            if(data.success==true){
                layer.msg(data.message,{"icon":6});
                //刷新数据表格
                $('#Table').TableRefresh();
                $("input[type=text]").val("");
            }else{
                layer.msg(data.message,{"icon":5});
            }

        },'json');


        return false;
    });

    var tableIns=  table.render({
            // 表格容器ID
            elem: '#Table'
            // 表格ID，必须设置，重载部分需要用到
            , id: 'tableOne'
            // 数据接口链接
            , url: "/erp/market/getPlanMarket"
            // 附加参数，post token
            , where: {
                isCkeck:0
            }
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
                {checkbox: true, fixed: true}
                ,{field:'pid', minWidth:80, title: 'ID', sort: true,}
                ,{field:'pname', minWidth:80, title: '产品计划名称'}
                ,{field:'number', minWidth:80, title: '数量', sort: true }
                ,{field:'assignee', minWidth:80, title: '负责人'}
                ,{field:'ischeck', minWidth:80, title: '是否通过', sort: true}
                ,{field:'cid', minWidth:135, title: '类型', sort: true,templet:function (data) {
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




});

