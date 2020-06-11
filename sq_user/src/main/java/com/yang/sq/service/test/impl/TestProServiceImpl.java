package com.yang.sq.service.test.impl;

import com.yang.sq.dao.jpa.test.TestProRepository;
import com.yang.sq.dao.mapper.test.TestProMapper;
import com.yang.sq.model.entity.test.TestPro;
import com.yang.sq.service.test.TestProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestProServiceImpl implements TestProService {

    @Autowired
    private TestProMapper testProMapper;

    @Autowired
    private TestProRepository testProRepository;

    @Override
    public int save(TestPro pro) {
        return testProMapper.save(pro);
    }

    @Override
    public TestPro saveByJpa(TestPro pro) {
        return testProRepository.save(pro);
    }
}
