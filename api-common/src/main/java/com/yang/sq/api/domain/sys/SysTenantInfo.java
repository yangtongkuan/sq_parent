package com.yang.sq.api.domain.sys;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Accessors(chain = true)
@Table(name = "sys_tenant")
@Entity
public class SysTenantInfo {

    @Id
    private Long id;                    // 组织id
    private String tenant;              // 组织标识
    private String tenantName;          // 名称
    private String pcDeployUrl;         // pc地址
    private String prov;                // 省
    private String city;                // 市
    private String county;              // 区
    private String address;             // 地址
    private String phone;               // 客户电话
    private int delFlag;                // 是否删除
    private String note;                // 备注
    private Date createTime;            // 创建时间
    private String fVersion;            // 版本

}
