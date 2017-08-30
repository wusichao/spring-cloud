package com.wusc.providerone.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    private AmqpTemplate template;
    public void send(String queue,String test){
        this.template.convertAndSend(queue,test);
    }
}
