package com.book.bookservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "Books", groupId = "someId_to_identify_during scaling")
    void listener(String data) {
        System.out.println(data);
    }
}
