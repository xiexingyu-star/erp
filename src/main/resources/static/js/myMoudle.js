layui.define(['jquery'], function(exports){ 
    var $ = layui.jquery;
    var obj = {
        name:'china_zhangsan',
        age:20
    };
    //输出接口,与文件名一致   myMoudle.js
    exports('myMoudle', obj);
});