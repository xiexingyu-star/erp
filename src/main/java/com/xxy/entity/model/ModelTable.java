package com.xxy.entity.model;

import java.util.List;

/**
 * layui.table的数据格式
 * @param <T>
 */
public class ModelTable<T> {

    private Integer total;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    private List<T> rows;
}
