package com.xxy.entity.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="t_nav")
public class Nav {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id ;

    private String title ;
    private String icon ;
    private String href ;    //点击的连接
    private String spread;  //是否展开 false 不展开
    private String parentId ; //设置父菜单 0 为顶层菜单

    private int privliage ; //访问级别 0 所有人  1，登录 2，管理员

    @Transient    //在表中不生成字段
    private List<Nav> children = new ArrayList<Nav>();

    public Integer getId() {
        return id;
    }


    public String getParentId() {
        return parentId;
    }


    public void setParentId(String parentId) {
        this.parentId = parentId;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getSpread() {
        return spread;
    }

    public void setSpread(String spread) {
        this.spread = spread;
    }

    public int getPrivliage() {
        return privliage;
    }

    public void setPrivliage(int privliage) {
        this.privliage = privliage;
    }

    public List<Nav> getChildren() {
        return children;
    }

    public void setChildren(List<Nav> children) {
        this.children = children;
    }





}
