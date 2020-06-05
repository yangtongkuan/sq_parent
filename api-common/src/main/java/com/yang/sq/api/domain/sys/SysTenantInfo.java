package com.yang.sq.api.domain.sys;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SysTenantInfo {
    private Long id;
    private String tenantName;

}
