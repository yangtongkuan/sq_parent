package com.yang.sq.service.activity.impl;

import com.yang.sq.api.common.asserts.AssertUtils;
import com.yang.sq.api.domain.sys.SysTenantInfo;
import com.yang.sq.dao.activity.ActivityRepository;
import com.yang.sq.domain.po.activity.ActivityPo;
import com.yang.sq.service.activity.ActivityService;
import com.yang.sq.utils.TenantHolderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ActivityServiceImpl implements ActivityService {


    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public ActivityPo saveActivity(ActivityPo activity) {
        if (activity.getTenantId() == null) {
            SysTenantInfo tenantInfo = TenantHolderUtils.getSysTenantInfo();
            AssertUtils.isNull(tenantInfo, "未获取到客户标识");
            activity.setTenantId(tenantInfo.getId());
        }
        activity.setDelFlag(0).setCreateTime(new Date());
        return activityRepository.save(activity);
    }

    @Override
    public ActivityPo findById(Long id) {
        return null;
    }
}
