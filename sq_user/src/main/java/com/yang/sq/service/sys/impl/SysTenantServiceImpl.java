package com.yang.sq.service.sys.impl;

import com.yang.sq.api.domain.sys.SysTenantInfo;
import com.yang.sq.dao.jpa.sys.SysTenantRepository;
import com.yang.sq.service.sys.SysTenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysTenantServiceImpl implements SysTenantService {

    @Autowired
    private SysTenantRepository sysTenantRepository;

    @Override
    public SysTenantInfo findByTenant(String tenant) {
        return sysTenantRepository.findByTenant(tenant);
    }
}
