package com.xxy.controller;

import com.xxy.entity.model.DataTableModel;
import com.xxy.entity.model.JsonResponse;
import com.xxy.entity.model.ModelTable;
import com.xxy.entity.plan.Category;
import com.xxy.entity.vo.MaketPlanCateVo;
import com.xxy.entity.vo.MarketCateVo;
import com.xxy.service.MarketCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("marketcate/")
public class MarketCateController {
    @Autowired
    private MarketCateService marketCateService;

    @RequestMapping("initMarketCate")
    public String initMarketCate(){
        return "xxy/marketcate";
    }

    @RequestMapping("marketcateData")
    @ResponseBody
    public DataTableModel<Category> marketcateData(MarketCateVo vo){
        //查询行数
        Integer total  = marketCateService.findMarketCate(vo).size();
        //计算
        vo.calc();

        DataTableModel<Category> model=new DataTableModel<>();
        //查询数据 ,自己根据需要处理异常
        List<Category> list =  marketCateService.findMarketCate(vo);

        model.setCode(200);
        model.setCount(total);
        model.setData(list);
        return model;
    }

    @ResponseBody
    @RequestMapping("findCateById")
    public JsonResponse findCateById(Integer id){
        Category category = marketCateService.findMarketCateById(id);
        return new JsonResponse(true,category);
    }
    @ResponseBody
    @RequestMapping("updateMarketCate")
    public JsonResponse updateMarketCate(Category category){
        marketCateService.updateMarketCate(category);
        return  new JsonResponse(true,"修改成功");
    }

    @RequestMapping("findAll")
    @ResponseBody
    public JsonResponse findAll(){
        List<Category> list = marketCateService.findAll();
        return new JsonResponse(true,list);
    }
}
