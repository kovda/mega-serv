package com.luxoft.controller;

import com.luxoft.dto.SimpleMessage;
import com.luxoft.service.RabbitPoster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/rbt")
public class RbtController {

    @Autowired
    private RabbitPoster poster;

    @PostMapping("/mcpost")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sendToMc(String message) {
        SimpleMessage smessage = new SimpleMessage(ThreadLocalRandom.current().nextLong(1000L), message);
        poster.postSimple(smessage);
    }

}
