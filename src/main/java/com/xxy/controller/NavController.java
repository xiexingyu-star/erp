package com.xxy.controller;

import com.xxy.entity.model.Nav;
import com.xxy.service.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/nav")
public class NavController {

    @Autowired
    private NavService navService;
    @RequestMapping("/initNavMenu")
    @ResponseBody
    public List<Nav> initNavMenu(){
        List<Nav> list = navService.iniNavMenu();
        return list;
    }

}
