package com.yang.sq.controller.test;

import com.yang.sq.api.common.result.R;
import com.yang.sq.model.entity.test.TestPro;
import com.yang.sq.service.test.TestProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestProController {

    @Autowired
    private TestProService testProService;

    @RequestMapping("/test/mapper")
    public R testMapper() {
        TestPro pro = new TestPro();
        pro.setTest("test");
        pro.setId(1L);
        int rows = testProService.save(pro);
        return R.success(rows);
    }

    @RequestMapping("/test/jpa")
    public R testJpa() {
        TestPro pro = new TestPro();
        pro.setTest("test");
        // pro.setId(2L);
        pro = testProService.saveByJpa(pro);
        return R.success(pro);
    }
}
