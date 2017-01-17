package com.wangyin.idn.wallet.api.mq;

import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

/**
 * Created by hanxiaofei on 2016/12/21.
 */

public class Receiver {
    private Logger LOGGER =  Logger.getLogger(Receiver.class.getName());

    private CountDownLatch latch = new CountDownLatch(1);

    //ID 区分不同类型消息所在的配置文件，可以用一个支持多个
    @KafkaListener(id = "mq",topics = "${JWP_APPLICATION_ACCEPT_TOPIC}")
    public void receiveMessage(String message) {
        LOGGER.info("received message='{}'"+message);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
