package org.example.springCloudAlibabaDemoAdmin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试")
@RestController
@RequestMapping("/test")
public class TestController {
    @ApiOperation(value = "获取测试值")
    @GetMapping("/value")
    public String test(){
        return "test";
    }
}
