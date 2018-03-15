package com.provider.demo.component;

import com.provider.demo.controller.ThreadServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class rabbitReceive {

    @Autowired
    private ThreadServiceImpl service;

    @RabbitListener(queues = "queue")
    public void processC(String str){
        Thread t = new Thread(service);
        t.start();
    }
}
