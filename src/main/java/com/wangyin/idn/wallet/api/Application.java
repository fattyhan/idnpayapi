package com.wangyin.idn.wallet.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by hanxiaofei on 2016/12/19.
 */
@EnableAutoConfiguration
//@ComponentScan(basePackages = "com.wangyin.idn.wallet.api")
@PropertySource({"classpath:config.properties","classpath:mq.properties"})
@SpringBootApplication
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
