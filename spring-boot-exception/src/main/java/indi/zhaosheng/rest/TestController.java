package indi.zhaosheng.rest;

import indi.zhaosheng.RespResult;
import indi.zhaosheng.exceptin.ErrorCodeEnum;
import indi.zhaosheng.exceptin.MyExceptionFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muluo
 * @description
 * @date 2020/5/18 22:10
 */
@RestController
@RequestMapping
public class TestController {

    @GetMapping("/ok")
    public RespResult<String> ok() {
        return RespResult.ok("hello world!");
    }

    @GetMapping("/err1")
    public RespResult<List<String>> err1() {
        List<String> list = new ArrayList<>();
        list.add("name不能为空");
        list.add("code不能为空");
        return RespResult.error(ErrorCodeEnum.ILLEGAL_PARAM.getCode(), ErrorCodeEnum.ILLEGAL_PARAM.getMsg(), list);
    }

    @GetMapping("/err2")
    public RespResult<Void> err2() {
        throw MyExceptionFactory.create(ErrorCodeEnum.ILLEGAL_PARAM);
    }
}
