package com.xxy.controller;

import ch.qos.logback.core.joran.action.ActionUtil;
import com.xxy.entity.model.DataTableModel;
import com.xxy.entity.model.JsonResponse;
import com.xxy.entity.model.ModelTable;
import com.xxy.entity.plan.Market;
import com.xxy.entity.vo.MaketPlanCateVo;
import com.xxy.entity.vo.MarketVo;
import com.xxy.entity.vo.MarketVoLayui;
import com.xxy.service.MarketService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 市场计划
 */
@Controller
@RequestMapping("market/")
public class MarketController {
    @Autowired
    private MarketService marketService;

    /** * @return
     */
    /**
    * @Description: TODO
    * @author: 谢星宇
    * @date: 2020/7/8 10:14
     * localhost:8181/erp/market/initMarket
     * 市场数据初始化
     * @Return: java.lang.String
    */
    @RequestMapping("initMarket")
    public String initMarket(){
        return "xxy/plan_market";
    }
    @RequestMapping("initCharts")
    public String initCharts(){
        return "xxy/market_charts";
    }
    @RequestMapping("initAddMarket")
    public String initAddMarket(){
        return "xxy/add_plan_market";
    }
    @RequestMapping("getPlanMarket")
    @ResponseBody
    public DataTableModel<MaketPlanCateVo> getMarket(MarketVoLayui vo){
        //查询行数
        Integer total  = marketService.findMaketPlanCateVo(vo).size();
        //计算
        vo.calc();
        DataTableModel<MaketPlanCateVo> model =new DataTableModel<>();
        //查询数据 ,自己根据需要处理异常
        List<MaketPlanCateVo> list = marketService.findMaketPlanCateVo(vo);

      /*  List<HeraRecordVo> voList = pair.snd().stream().map(record -> {
            HeraRecordVo recordVo = new HeraRecordVo();
            BeanUtils.copyProperties(record, recordVo);
            recordVo.setCreateTime(ActionUtil.getDefaultFormatterDate(new Date(record.getGmtCreate())));
            recordVo.setType(RecordTypeEnum.parseById(record.getType()).getType());
            if (isAdmin) {
                if (!cacheOwner.containsKey(record.getGid())) {
                    cacheOwner.put(record.getGid(), heraUserService.findById(record.getGid()).getName());
                }
                recordVo.setGName(cacheOwner.get(record.getGid()));
            } else {
                recordVo.setGName(ownerName);
            }
            return recordVo;
        }).collect(Collectors.toList());*/
        model.setCode(200);
        model.setMsg("");
        model.setCount(total);
        model.setData(list);
        return model;
    }

    @RequestMapping("delMarket")
    @ResponseBody
    public JsonResponse delMarket(Integer id){
        marketService.delMarket(id);
        return new JsonResponse(true,"删除成功");
    }

    @RequestMapping("addMarket")
    @ResponseBody
    public JsonResponse addMarket(Market market){

        market.setCreatetime(new Date());
        market.setIscheck(0);
        marketService.insertMarket(market);
        return new JsonResponse(true,"添加成功");
    }
}
