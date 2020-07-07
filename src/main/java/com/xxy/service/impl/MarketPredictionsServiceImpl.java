package com.xxy.service.impl;

import com.xxy.dao.MarketPredictionsDao;
import com.xxy.entity.model.MarketPredictionsModel;
import com.xxy.entity.plan.MarketPredictions;
import com.xxy.entity.vo.MarketPredictionsVo;
import com.xxy.service.MarketPredictionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketPredictionsServiceImpl implements MarketPredictionsService {

    @Autowired
    private MarketPredictionsDao mapper;
    @Override
    public void addPredictions(MarketPredictionsVo vo) {
        mapper.add(vo);
    }

    @Override
    public List<MarketPredictionsModel> predictions(MarketPredictionsVo vo) {
        return mapper.predictions(vo);
    }
}
