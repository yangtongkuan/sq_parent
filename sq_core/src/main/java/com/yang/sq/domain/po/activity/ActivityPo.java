package com.yang.sq.domain.po.activity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 活动 数据持久化对象
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "activity")
public class ActivityPo implements Serializable {

    @Id
    private Long id;                // id
    private Long tenantId;          // 租户id
    private String ActivityName;    // 活动名称
    private Date startTime;         // 开始时间
    private Date endTime;           // 结束时间
    private int openState;          // 是否打开
    private int delFlag;            // 是否删除
    private Long createUserId;      // 创建者id
    private Date createTime;        // 创建时间
    private Long updateUserId;      // 更新者id
    private Date updateTime;        // 更新时间
}
