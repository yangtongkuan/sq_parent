package com.yang.sq.dao.sys;

import com.yang.sq.api.domain.sys.SysTenantInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysTenantRepository extends JpaRepository<SysTenantInfo, Long> {
    SysTenantInfo findByTenant(String tenant);
}
