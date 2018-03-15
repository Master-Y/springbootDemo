package com.provider.demo.controller;

import com.provider.demo.service.Impl.RedisServiceImpl;
import com.provider.demo.vo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "redis")
public class redisTestController {

    @Autowired
    private RedisServiceImpl redisService;

    @PostMapping("setString/{key}")
    public String test(@PathVariable String key){
        redisService.set(key,"123");
        return (String) redisService.get(key);
    }

    @PostMapping("setHash")
    public String setHash(){
        Student student = new Student();
        student.setId("jy");
        student.setName("荆阳");
//        redisService.hmSet("haha","hehe","123");
//        redisService.hmSet("haha1","hehe1",student);
        redisService.hmSet("haha","hehe",student);
        redisService.hmSet("haha","hehe1",student);
        Student stu = (Student)redisService.hmGet("haha", "hehe");
        log.info("id:{},name:{}",stu.getId(),stu.getName());
        return (String) redisService.hmGet("haha","hehe");
    }

    @PostMapping("testList")
    public String testList(){
        Student student = new Student();
        student.setId("jy");
        student.setName("荆阳");
        redisService.lPush("enen","123");
        redisService.lPush("enen",student);
        List<Object> enen = redisService.lRange("enen", 0, 1);
        for(Object string : enen){
            System.out.println((String) string);
        }
        return "123";
    }
}
