package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.common.support.RedisSupport;
import com.example.entity.RedisDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 咕噜科
 * ClassName: RedisController
 * date: 2021/8/30 1:21
 * Description:
 * version 1.0
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    private static final Logger log = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisSupport redisSupport;



    @RequestMapping("add")
    public Boolean add(@RequestBody RedisDTO redisDTO){
        boolean result = redisSupport.set(redisDTO.getKey(), JSON.toJSONString(redisDTO));
        return result;
    }

    @RequestMapping("del")
    public Boolean del(@RequestBody RedisDTO redisDTO){
        Boolean del = redisSupport.del(redisDTO.getKey());
        return del;
    }

    @RequestMapping("query")
    public String query(@RequestBody RedisDTO redisDTO){
        String result = redisSupport.get(redisDTO.getKey());
        log.info("result:{}",result);
        return result;
    }


}
