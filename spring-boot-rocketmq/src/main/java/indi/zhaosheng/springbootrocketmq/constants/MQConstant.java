package indi.zhaosheng.springbootrocketmq.constants;

/**
 * @author muluo
 * @description
 * @date 2020/5/11 22:10
 */
public class MQConstant {

    private MQConstant() {
    }

    /*********************生产者*********************/
    public static class Producer {
        public static final String NORMAL_TOPIC = "normalTopic1";
        public static final String NORMAL_TAG = "normalTag1";
        public static final String NORMAL_GROUP = "normalGroup1";

        public static final String ORDERLY_TOPIC = "orderlyTopic1";
        public static final String ORDERLY_TAG = "orderlyTag1";
        public static final String ORDERLY_GROUP = "orderlyGroup1";
    }

    /*********************消费者*********************/
    public static class Consumer {

        public static final String NORMAL_TOPIC = Producer.NORMAL_TOPIC;
        public static final String NORMAL_TAG = Producer.NORMAL_TAG;
        public static final String NORMAL_GROUP = "normalGroup1";

        public static final String ORDERLY_TOPIC = Producer.ORDERLY_TOPIC;
        public static final String ORDERLY_TAG = Producer.ORDERLY_TAG;
        public static final String ORDERLY_GROUP = "normalGroup2";
    }
}
