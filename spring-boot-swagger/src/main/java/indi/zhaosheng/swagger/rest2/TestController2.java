package indi.zhaosheng.swagger.rest2;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author muluo
 * @description
 * @date 2020/5/17 17:10
 */
@RestController
@RequestMapping
@Api(tags = "TestController2")
public class TestController2 {

    @GetMapping
    @ApiOperation("获取数据")
    public String get() {
        return "success";
    }
}
