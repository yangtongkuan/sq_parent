package com.yang.sq.dao.jpa.test;

import com.yang.sq.model.entity.test.TestPro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestProRepository extends JpaRepository<TestPro,Long> {
}
