package com.yang.sq.service.sys;

import com.yang.sq.api.domain.sys.SysTenantInfo;

public interface SysTenantService {

    SysTenantInfo findByTenant(String tenant);
}
