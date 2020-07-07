package com.xxy.controller;

import com.xxy.entity.model.DataTableModel;
import com.xxy.entity.model.JsonResponse;
import com.xxy.entity.model.MarketPredictionsModel;
import com.xxy.entity.model.ModelTable;
import com.xxy.entity.plan.MarketPredictions;
import com.xxy.entity.vo.MarketPredictionsVo;
import com.xxy.service.MarketPredictionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("MarketPredictions/")
public class MarketPredictionsController {
    @Autowired
    private MarketPredictionsService service;
    @RequestMapping("initPredictions")
    public String initPredictions(){
        return "xxy/market_predictions";
    }

    @PostMapping("addPredictions")
    @ResponseBody
    public JsonResponse addPredictions(MarketPredictionsVo vo){
        vo.setPromoter("张三");
        service.addPredictions(vo);
        return new JsonResponse(true,"添加成功");
    }

    //预测
    @ResponseBody
    @RequestMapping("predictions")
    public DataTableModel<MarketPredictionsModel> predictions(MarketPredictionsVo vo)   {
        DataTableModel<MarketPredictionsModel> table=new DataTableModel<>();
        List<MarketPredictionsModel> list = service.predictions(vo);
        table.setData(list);
        table.setCount(2);
        table.setCode(200);
        table.setMsg("");
        return table;
    }

}
  /*  select t1.id as id,t1.name as xname ,t1.number AS xnum ,t1.createtime as xtime
from t_plan_market  t1,(
	select id ,name,MAX(number) as xnum,createtime from t_plan_market
		WHERE createtime >= CAST('2020-1-1' AS date)
						AND createtime <= CAST('2020-6-1' AS date)
						GROUP BY NAME  HAVING NAME = '主机'
)  t2
where t2.xnum=t1.number and t2.name=t1.name

UNION
select t1.id as id,t1.name as iname ,t1.number AS inum ,t1.createtime  as itime
from (
	select id ,name,MIN(number) inum,createtime from t_plan_market
		WHERE createtime >= CAST('2020-1-1' AS date)
						AND createtime <= CAST('2020-6-1' AS date)
						GROUP BY NAME  HAVING NAME = '主机'
) as t2,t_plan_market as t1
where t2.inum=t1.number and t2.name=t1.name*/