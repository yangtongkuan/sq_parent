package com.yang.sq.controller.activity;

import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.yang.sq.api.common.result.R;
import com.yang.sq.domain.vo.TestVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tenant/v1/pri/activity/")
@Api(tags = "活动管理接口")
@ApiSort(2)
public class ActivityManagerController {
    @GetMapping("/test")
    @ApiOperation("测试返回数据")
    public R<TestVo> testResult() {
        TestVo vo = new TestVo("test");
        return R.success(vo);
    }


}
