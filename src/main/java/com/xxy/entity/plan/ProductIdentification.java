package com.xxy.entity.plan;

import javax.persistence.*;

/**
 * 产品标识标
 */
@Entity
@Table(name = "t_plan_proidentification")
public class ProductIdentification {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer illustrate;//说明

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getIllustrate() {
        return illustrate;
    }

    public void setIllustrate(Integer illustrate) {
        this.illustrate = illustrate;
    }
}
