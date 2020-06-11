package com.yang.sq.service.test;

import com.yang.sq.model.entity.test.TestPro;

public interface TestProService {

    int save(TestPro pro);

    TestPro saveByJpa(TestPro pro);


}
