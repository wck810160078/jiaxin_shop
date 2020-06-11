package com.jiaxin.shop.controller;

import com.jiaxin.shop.utils.Msg;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Resource
    RedisTemplate redisTemplate;

    @GetMapping("/test")
    public String test(){
        redisTemplate.opsForValue().set("a","1");
        String a = redisTemplate.opsForValue().get("a").toString();
        System.out.println(a);
        return "正在开发中，敬请期待";
    }

    @GetMapping("/login/warning")
    public Msg loginWarning(){
        return Msg.fail("未登录").setCode(400);
    }




}
