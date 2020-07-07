package com.xxy.dao;

import com.xxy.baseDao.BaseDao;
import com.xxy.entity.model.MarketPredictionsModel;
import com.xxy.entity.plan.MarketPredictions;
import com.xxy.entity.vo.MarketPredictionsVo;
import com.xxy.mybatis.ErpInsertLangDriver;
import com.xxy.mybatis.ErpSelectLangDriver;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MarketPredictionsDao extends BaseDao<MarketPredictions> {
    //预测
    @Select(" select t1.id as id,t1.name as name ,t1.number AS number ,t1.createtime as createtime\n" +
            " from t_plan_market  t1,(\n" +
            " select id ,name,MAX(number) as xnum,createtime from t_plan_market\n" +
            " WHERE createtime >= CAST(#{startTime} AS date)\n" +
            " AND createtime <= CAST(#{endTime} AS date)\n" +
            " GROUP BY NAME  HAVING NAME = #{name}\n" +
            ")  t2\n" +
            " where t2.xnum=t1.number and t2.name=t1.name\n" +
            "\n" +
            " UNION\n" +
            " select t1.id as id,t1.name as name ,t1.number AS number ,t1.createtime  as createtime\n" +
            " from (\n" +
            " select id ,name,MIN(number) inum,createtime from t_plan_market\n" +
            " WHERE createtime >= CAST(#{startTime} AS date)\n" +
            " AND createtime <= CAST(#{endTime} AS date)\n" +
            " GROUP BY NAME  HAVING NAME = #{name}\n" +
            " ) as t2,t_plan_market as t1\n" +
            " where t2.inum=t1.number and t2.name=t1.name")
    @Lang(ErpSelectLangDriver.class)
    public List<MarketPredictionsModel> predictions(MarketPredictionsVo vo);

    @Insert("insert into t_plan_marketpredictions (#{vo})")
    @Lang(ErpInsertLangDriver.class)
    public void add(MarketPredictionsVo vo);
}
