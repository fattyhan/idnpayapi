package com.wangyin.idn.wallet.api.mq;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hanxiaofei on 2016/12/21.
 */
@Configuration
public class SenderConfig {
    @Value("${kafka.bootstrap.servers}")
    private String bootstrapServers;

    @Bean(name = "producerConfigs")
    public Map producerConfigs() {
        Map props = new HashMap();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        //设置编码
        props.put("key.serializer.encoding","UTF-8");
        props.put("value.serializer.encoding","GBK");
        // 超时
        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, 5000);

        return props;
    }

    @Bean(name = "producerFactory")
    public ProducerFactory producerFactory() {
        return new DefaultKafkaProducerFactory(producerConfigs());
    }

    @Bean(name = "kafkaTemplate")
    public KafkaTemplate kafkaTemplate() {
        return new KafkaTemplate(producerFactory());
    }

    @Bean(name = "sender")
    public Sender sender() {
        return new Sender();
    }
}
