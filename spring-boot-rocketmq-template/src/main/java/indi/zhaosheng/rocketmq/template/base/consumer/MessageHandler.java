package indi.zhaosheng.rocketmq.template.base.consumer;

/**
 * @author zhaosheng
 * @version v1.0
 * @description:
 * @date 2020/9/2 11:59 下午
 */
public interface MessageHandler {

    boolean onMsg(String msg);
}
