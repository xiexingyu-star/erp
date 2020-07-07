package com.xxy.entity.vo;

/**
 * 封装MaketPlan模块的页面到控制器传入参数
 * 传入参数一个模块只用1个
 * @author yoyo198212
 *
 */
public class MarketVoLayui {
	private Integer page ; //jqueryTable自带的当前页面
	private Integer limit ; //jqueryTable自带的传入参数默认10

	private Integer start  ;  //分页的start
	private Integer offset ; //分页的offset
	
	private String nameLike ; //模糊查询的参数
	private String startTime ;  //开始时间
	private String endTime ; //结束时间
	
	private String category ; //市场分类的id

	private Integer isCkeck;



	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getStart() {
		return start;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
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
	public String getNameLike() {
		return nameLike;
	}
	public void setNameLike(String nameLike) {
		this.nameLike = nameLike;
	}

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void calc(){
		//计算得到分页的 start 与  offset   最好封装成方法调用,因为这段代码要不断使用
		this.start = (this.page - 1) * this.limit ;
		this.offset = this.limit ;


	}


	public Integer getIsCkeck() {
		return isCkeck;
	}

	public void setIsCkeck(Integer isCkeck) {
		this.isCkeck = isCkeck;
	}
}
