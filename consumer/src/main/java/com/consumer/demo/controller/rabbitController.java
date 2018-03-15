package com.consumer.demo.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "rabbitMq")
public class rabbitController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @PostMapping(value = "send")
    public String send(){
        amqpTemplate.convertAndSend("queue","hello");
        return "success";
    }
}
