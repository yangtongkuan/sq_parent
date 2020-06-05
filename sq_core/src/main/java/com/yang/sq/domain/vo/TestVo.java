package com.yang.sq.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TestVo {

    @ApiModelProperty(value = "名称", notes = "名称note", required = true)
    private String name;

    public TestVo() {
    }

    public TestVo(String name) {
        this.name = name;
    }
}
