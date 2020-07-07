package com.xxy.dao;

import com.xxy.baseDao.BaseDao;
import com.xxy.entity.plan.Market;
import com.xxy.entity.vo.MaketPlanCateVo;
import com.xxy.entity.vo.MarketVo;
import com.xxy.entity.vo.MarketVoLayui;
import com.xxy.mybatis.ErpInsertLangDriver;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MarketDao extends BaseDao<Market> {

    public List<MaketPlanCateVo> findMaketPlanCateVo(MarketVoLayui vo);

    @Delete("delete from t_plan_market where id=#{id}")
    public void deleteById(Integer id);

    /*@Insert("insert into t_plan_market(assignee,detail,ischeck,name,number,createtime,endtime,typeid) " +
            "value(#{market.assignee},#{market.detail},#{market.ischeck},#{market.name},#{market.number},#{market.createtime},#{market.endtime},#{market.typeid})")
   */
    @Insert("insert into t_plan_market (#{market})")
    @Lang(ErpInsertLangDriver.class)
    public void insertMarket( Market market);

    @Update("update t_plan_market set assignee=#{assignee}")
    public void updateMarket(@Param("market") Market market);
}
