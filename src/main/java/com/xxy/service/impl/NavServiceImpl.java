package com.xxy.service.impl;

import com.xxy.dao.NavDao;
import com.xxy.entity.model.Nav;
import com.xxy.service.NavService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NavServiceImpl implements NavService {

    @Autowired
    private NavDao mapper;

    /**
    * @Description: TODO
    * @author: 谢星宇
    * @date: 2020/7/7 11:42
    
    * @Return: java.util.List<com.xxy.entity.model.Nav>
    */
    @Override
    public List<Nav> iniNavMenu() {
        List<Nav> navs = mapper.selectAll();
        List<Nav> list=new ArrayList();
        //查一级菜单
        for (Nav n: navs){
            if(n.getParentId().equals("0")){
                list.add(n);
            }
        }
        for(Nav n:list){
            n.setChildren(getChild(n.getId()+"",navs));
        }

        return list;
    }

    /**

     * 递归查找子菜单
     * @param id
     *            当前菜单id
     * @param rootMenu
     *            要查找的列表
     * @return

     */
    private List<Nav> getChild(String id, List<Nav> rootMenu) {
        // 子菜单
        List<Nav> childList = new ArrayList<>();

        for (Nav menu : rootMenu) {

            // 遍历所有节点，将父菜单id与传过来的id比较

            if (StringUtils.isNotBlank(menu.getParentId())) {

                if (menu.getParentId().equals(id)) {

                    childList.add(menu);

                }

            }

        }


        return childList;

    }
}
