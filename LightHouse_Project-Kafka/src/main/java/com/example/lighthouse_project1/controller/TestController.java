package com.example.lighthouse_project1.controller;

import com.example.lighthouse_project1.KafkaMessages.MessageDao;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestController {
private static final String TOPIC_01="topic1";
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/test")
    public String sendMessage(@RequestParam(name = "id") int id,
                               @RequestParam(name= "username") String name,
                               @RequestParam(name = "location")   String location) {
        MessageDao messageDao=new MessageDao();
        messageDao.setBorn(location);
        messageDao.setID(id);
        messageDao.setNames(name);
        kafkaTemplate.send(TOPIC_01,new Gson().toJson(messageDao));
        return "发送成功";
    }
}
