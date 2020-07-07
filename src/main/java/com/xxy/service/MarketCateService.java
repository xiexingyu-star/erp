package com.xxy.service;

import com.xxy.entity.plan.Category;
import com.xxy.entity.vo.MarketCateVo;

import java.util.List;

public interface MarketCateService {
    public List<Category> findMarketCate(MarketCateVo vo);

    public Category findMarketCateById(Integer id);

    public void updateMarketCate( Category category);

    public List<Category> findAll();
}
