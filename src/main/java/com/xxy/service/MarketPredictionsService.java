package com.xxy.service;

import com.xxy.entity.model.MarketPredictionsModel;
import com.xxy.entity.plan.MarketPredictions;
import com.xxy.entity.vo.MarketPredictionsVo;

import java.util.List;

public interface MarketPredictionsService {

    public void addPredictions(MarketPredictionsVo mp);

    public List<MarketPredictionsModel> predictions(MarketPredictionsVo vo);
}
