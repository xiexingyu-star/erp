package com.xxy.service.impl;

import com.xxy.dao.MarketCategoryDao;
import com.xxy.entity.plan.Category;
import com.xxy.entity.vo.MarketCateVo;
import com.xxy.service.MarketCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketCateServiceImpl implements MarketCateService {
    @Autowired
    private MarketCategoryDao mapper;

    public List<Category> findMarketCate(MarketCateVo vo){
      return  mapper.findMarketCate(vo);
    }

    public Category findMarketCateById(Integer id){
        return mapper.findMarketCateById(id);
    }

    public void updateMarketCate( Category category){
        mapper.updateMarketCate(category);
    }

    @Override
    public List<Category> findAll() {
        return mapper.selectAll();
    }
}
