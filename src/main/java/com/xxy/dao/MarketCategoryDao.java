package com.xxy.dao;

import com.xxy.baseDao.BaseDao;
import com.xxy.entity.plan.Category;
import com.xxy.entity.vo.MarketCateVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MarketCategoryDao extends BaseDao<Category> {

    public List<Category> findMarketCate(MarketCateVo vo);
    @Select("select id,name,typeid from t_plan_category where id=#{id}")
    public Category findMarketCateById(Integer id);
    @Update("update  t_plan_category set name=#{name},typeid=#{typeid} where id=#{id}")
    public void updateMarketCate(/*@Param("category")*/ Category category);
}
