package com.yang.sq.service.sys;

import com.yang.sq.api.domain.sys.SysTenantInfo;
import org.springframework.stereotype.Service;

@Service
public class SysTenantServiceImpl implements SysTenantService {

    @Override
    public SysTenantInfo findByTenant(String tenant) {
        return new SysTenantInfo().setId(1L);
    }
}
