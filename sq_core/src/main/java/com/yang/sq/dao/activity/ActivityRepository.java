package com.yang.sq.dao.activity;

import com.yang.sq.domain.po.activity.ActivityPo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<ActivityPo, Long> {
}
