package com.wangyin.idn.wallet.api.mq;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * Created by hanxiaofei on 2016/12/21.
 */
public class Sender {
    private Logger LOGGER =  Logger.getLogger(Sender.class.getName());

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    public void sendMessage(String topic, String message) {
        ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send(topic, message);

        //mq 回执
        future.addCallback(
                new ListenableFutureCallback<SendResult<Integer, String>>() {

                    @Override
                    public void onSuccess(
                            SendResult<Integer, String> result) {
                        LOGGER.info("sent message='{}' with offset={}");
                    }

                    @Override
                    public void onFailure(Throwable ex) {
                        LOGGER.error("unable to send message='{}', message, ex");
                    }
                });
    }
}
