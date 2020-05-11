package indi.zhaosheng.springbootrocketmq.rest;

import indi.zhaosheng.springbootrocketmq.constants.MQConstant;
import indi.zhaosheng.springbootrocketmq.mq.producer.TestNormalProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author muluo
 * @description
 * @date 2020/5/11 23:50
 */
@RestController
@RequestMapping("mq")
public class TestSendMsgController {

    @Autowired
    private TestNormalProducer testNormalProducer;

    @GetMapping
    public String send(@RequestParam("msg") String msg) {
        testNormalProducer.sendMsg(MQConstant.Producer.NORMAL_TAG, msg);
        return "send success";
    }
}
