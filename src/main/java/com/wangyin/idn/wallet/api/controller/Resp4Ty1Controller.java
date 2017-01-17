package com.wangyin.idn.wallet.api.controller;

import com.wangyin.idn.wallet.api.mq.Sender;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hanxiaofei on 2016/12/20.
 */
@RestController
@RequestMapping(value = "/jwp")
public class Resp4Ty1Controller {
    private Logger LOGGER = Logger.getLogger(Resp4Ty1Controller.class.getName());
    @Value("${JWP_APPLICATION_ACCEPT_TOPIC}")
    private String jwpApp;
    @Autowired
    private Sender sender;

    @RequestMapping(value = "/jwp4ol", method = RequestMethod.GET)
    @ResponseBody
    String home(String hallelujah) {
        LOGGER.info("application accept successfully... ...");
        sender.sendMessage(jwpApp, "application accept successfully... ..." + hallelujah);
        return "HELLO "+hallelujah;
    }
}
