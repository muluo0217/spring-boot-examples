package indi.zhaosheng.logaop.rest;

import indi.zhaosheng.logaop.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author muluo
 * @description
 * @date 2020/5/16 10:35
 */
@RestController
@RequestMapping
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping
    public String get(@RequestParam("p1") String p1, @RequestParam("p2") String p2) {
        testService.log();
        return p1 + " " + p2;
    }
}
