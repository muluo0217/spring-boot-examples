package indi.zhaosheng.rocketmq.base.handler;

/**
 * @author zhaosheng
 * @version v1.0
 * @description:
 * @date 2020/9/8 11:25 下午
 */
public interface RocketMQMsgHandler {

    boolean handleMsg(String msg);
}
