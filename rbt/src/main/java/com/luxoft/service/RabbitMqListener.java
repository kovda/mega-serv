package com.luxoft.service;

import com.luxoft.dto.SimpleMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqListener {

    private static final Logger LOG = LoggerFactory.getLogger(RabbitMqListener.class);

    @RabbitListener(queues = {"${mc.queue}"})
    public void listenMessage(SimpleMessage message) {
        LOG.debug(message.getMessage() + ", " + message.getId());
    }
}
