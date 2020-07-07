package com.xxy.service.impl;

import com.xxy.dao.MarketDao;
import com.xxy.entity.plan.Market;
import com.xxy.entity.vo.MaketPlanCateVo;
import com.xxy.entity.vo.MarketVo;
import com.xxy.entity.vo.MarketVoLayui;
import com.xxy.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MarketServiceImpl implements MarketService {

    @Autowired
    private MarketDao mapper;

    public List<MaketPlanCateVo> findMaketPlanCateVo(MarketVoLayui vo){
      return   mapper.findMaketPlanCateVo(vo);
    }

    @Override
    public void insertMarket(Market market) {
        mapper.insertMarket(market);
    }

    @Override
    public void updateMarket(Market market) {
        mapper.updateMarket(market);
    }

    @Override
    public void delMarket(Integer id) {
        mapper.deleteById(id);
    }
}
