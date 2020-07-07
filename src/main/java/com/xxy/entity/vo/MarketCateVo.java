package com.xxy.entity.vo;

public class MarketCateVo {
    private Integer page ; //jqueryTable自带的当前页面
    private Integer limit ; //jqueryTable自带的传入参数默认10

    private Integer start  ;  //分页的start
    private Integer offset ; //分页的offset
    private Integer id;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void calc(){
        //计算得到分页的 start 与  offset   最好封装成方法调用,因为这段代码要不断使用
        this.start = (this.page - 1) * this.limit ;
        this.offset = this.limit ;


    }
}
