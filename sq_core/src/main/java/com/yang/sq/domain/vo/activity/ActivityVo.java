package com.yang.sq.domain.vo.activity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ActivityVo implements Serializable {

    private Long id;                // id
    private String customId;        // 客户id
    private String ActivityName;    // 活动名称
    private Date startTime;         // 开始时间
    private Date endTime;           // 结束时间
    private int openState;          // 是否打开
    private int delFlag;            // 是否删除
    private Long createUserId;      // 创建者id
    private Date createTime;        // 创建时间
    private Long updateUserId;      // 更新者id
    // private Date updateTime;        // 更新时间
}
