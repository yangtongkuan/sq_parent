package com.yang.sq.domain.vo.activity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ActivityVo implements Serializable {

    @ApiModelProperty(value = "唯一标识id")
    private Long id;                // id

    @ApiModelProperty(value = "租户id", required = true)
    private Long tenantId;          // 租户id

    @ApiModelProperty(value = "活动名称", required = true)
    private String ActivityName;    // 活动名称

    @ApiModelProperty(value = "开始时间", required = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;         // 开始时间

    @ApiModelProperty(value = "结束时间", required = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;           // 结束时间

    @ApiModelProperty(value = "是否开启")
    private int openState;          // 是否打开

    @ApiModelProperty(value = "是否删除")
    private int delFlag;            // 是否删除

    @ApiModelProperty(value = "创建者id")
    private Long createUserId;      // 创建者id

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;        // 创建时间

    @ApiModelProperty(value = "更新者id")
    private Long updateUserId;      // 更新者id
}
