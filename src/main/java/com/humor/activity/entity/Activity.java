package com.humor.activity.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 价格
     */
    private BigDecimal money;

    /**
     * 活动时间 单位：天
     */
    private String activityTime;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 主图
     */
    @Transient
    private String mainImg;

    /**
     * 轮播图
     */
    @Transient
    private List<String> slideImg;

    /**
     * 活动介绍
     */
    @Transient
    private List<String> activityImg;

    /**
     * 活动图片
     */
    private String img;

    /**
     * 浏览量
     */
    private Integer browseNum;

    /**
     * 购买量
     */
    private Integer buyNum;

    /**
     * 虚拟浏览量
     */
    private Integer fakeBrowseNum;

    /**
     * 虚拟购买量
     */
    private Integer fakeBuyNum;

    @CreatedDate
    private Date createDate;

    @LastModifiedDate
    private Date updateDate;

}
