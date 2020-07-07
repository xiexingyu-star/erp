package com.xxy.service;

import com.xxy.entity.plan.Market;
import com.xxy.entity.vo.MaketPlanCateVo;
import com.xxy.entity.vo.MarketVo;
import com.xxy.entity.vo.MarketVoLayui;

import java.util.List;

public interface MarketService {

    public List<MaketPlanCateVo> findMaketPlanCateVo(MarketVoLayui vo);


    public void insertMarket(Market market);

    public void updateMarket(Market market);

    public void delMarket(Integer id);
}
