package com.luxoft.service;

import com.luxoft.dto.SimpleMessage;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitPoster {

    @Value("${mc.gate}")
    private String mcGate;

    @Autowired
    private AmqpTemplate template;

    public void postSimple(SimpleMessage message) {
        template.convertAndSend(mcGate, "", message);
    }

}
