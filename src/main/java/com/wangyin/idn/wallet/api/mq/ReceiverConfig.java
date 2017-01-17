package com.wangyin.idn.wallet.api.mq;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@EnableKafka
@Configuration
public class ReceiverConfig {

    @Value("${kafka.bootstrap.servers}")
    private String bootstrapServers;
    @Value("${JWP_APPLICATION_ACCEPT_TOPIC}")
    private String jwpApp;

    @Bean
    public Map consumerConfigs() {
        Map props = new HashMap();
        // 基础配置
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put("key.deserializer.encoding","UTF-8");
        props.put("value.deserializer.encoding","GBK");
        // group方式接入，主题消息可以有多个消费者
        props.put(ConsumerConfig.GROUP_ID_CONFIG, jwpApp);

        return props;
    }

    @Bean
    public ConsumerFactory consumerFactory() {
        return new DefaultKafkaConsumerFactory(consumerConfigs());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory());

        return factory;
    }

    @Bean
    public Receiver receiver() {
        return new Receiver();
    }
}
