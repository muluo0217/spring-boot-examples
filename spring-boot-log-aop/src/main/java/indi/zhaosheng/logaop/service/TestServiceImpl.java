package indi.zhaosheng.logaop.service;

import indi.zhaosheng.logaop.annotation.LogService;
import org.springframework.stereotype.Service;

/**
 * @author muluo
 * @description
 * @date 2020/5/16 10:34
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    @LogService("在service方法上拦截打印")
    public void log() {

    }
}
