package com.example.lighthouse_project1.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.example.lighthouse_project1.clickhouseController.*;

import java.sql.*;

@Component
public class KafkaConsumer<ps, conn> {

    public KafkaConsumer() throws SQLException {
    }

    @KafkaListener(topics = {"topic1"})
    public void onMessage(ConsumerRecord<String, String> record) throws ClassNotFoundException {
        JSONObject jsonObject = JSON.parseObject(record.value());
        String names = (String) jsonObject.get("names");
        String location = (String) jsonObject.get("location");
        Integer ID = (Integer) jsonObject.get("ID");
        //存入数据库
        deptDAO deptDAO = new deptDAO();
        deptDAO.add(ID,names,location);

        System.out.println(ID);
        System.out.println(names);
        System.out.println(location);
        //input data to clickhouse
        System.out.println("从" + record.topic() + "主题" + "第" + record.partition() + "分区" + "消费数据:" + record.value());


    }
}