package com.yang.sq.service.activity;

import com.yang.sq.domain.po.activity.ActivityPo;

/**
 * 活动类
 */
public interface ActivityService {
    /**
     * save activity
     *
     * @param activity
     * @return
     */
    ActivityPo saveActivity(ActivityPo activity);

    /**
     * findByTenantId and id
     */
    ActivityPo findById(Long id);


}
