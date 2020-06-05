package com.yang.sq.domain.po.activity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
    @GeneratedValue
    @ApiModelProperty(value = "唯一标识id")
    private Long id;                // id

    @ApiModelProperty(value = "租户id",required = true)
    private Long tenantId;          // 租户id

    @ApiModelProperty(value = "活动名称", required = true)
    private String ActivityName;    // 活动名称

    @ApiModelProperty(value = "开始时间", required = true)
    private Date startTime;         // 开始时间

    @ApiModelProperty(value = "结束时间", required = true)
    private Date endTime;           // 结束时间

    @ApiModelProperty(value = "是否开启")
    private int openState;          // 是否打开

    @ApiModelProperty(value = "是否删除")
    private int delFlag;            // 是否删除

    @ApiModelProperty(value = "创建者id")
    private Long createUserId;      // 创建者id

    @ApiModelProperty(value = "创建时间")
    private Date createTime;        // 创建时间

    @ApiModelProperty(value = "更新者id")
    private Long updateUserId;      // 更新者id

//    private Date updateTime;        // 更新时间
}
