package com.yang.sq.controller.activity;

import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.yang.sq.api.common.result.R;
import com.yang.sq.domain.po.activity.ActivityPo;
import com.yang.sq.domain.vo.TestVo;
import com.yang.sq.domain.vo.activity.ActivityVo;
import com.yang.sq.service.activity.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tenant/v1/pri/activity/")
@Api(tags = "活动管理接口")
@ApiSort(3)
public class ActivityManagerController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/test")
    @ApiOperation("测试返回数据")
    public R<TestVo> testResult() {
        TestVo vo = new TestVo("test");
        return R.success(vo);
    }

    @PostMapping("/save")
    @ApiOperation("创建活动")
    public R<ActivityVo> save(@RequestBody ActivityPo activityPo) {
        ActivityPo activity = activityService.saveActivity(activityPo);
        ActivityVo vo = new ActivityVo();
        BeanUtils.copyProperties(activity, vo);
        return R.success(vo);
    }


}
