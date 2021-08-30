package com.example.common.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@Slf4j
public class RedisSupport {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    public boolean lockKey(String key, String value, long time) {
        try   {
            redisTemplate.opsForValue().setIfAbsent(key,value, Duration.ofSeconds(time));
        } catch (Exception e) {
            log.error("redis lockKey error:", e);
            return false;
        }
        return false;
    }


    public boolean set(String key, String value) {
        try {
            stringRedisTemplate.opsForValue().set(key,value);
        }catch (Exception e){
            log.error("redis set value error!"+e);
            return false;
        }
        return true;
    }

    public String get(String key) {
        try {
            return stringRedisTemplate.opsForValue().get(key);
        }catch (Exception e){
            log.error("redis get value error!",e);
        }
        return null;
    }


    public Boolean exists(String key) {
        try {
            return redisTemplate.hasKey(key);
        }catch (Exception e){
            log.error("redis exists error!",e);
        }
        return null;
    }


    public Boolean del(String key) {
        try {
            return redisTemplate.delete(key);
        } catch (Exception e){
            log.error("redis del key error!",e);
            return false;
        }

    }

    public Boolean expire(String key, int seconds) {
        try {
            return redisTemplate.expire(key,Duration.ofSeconds(seconds));
        }catch (Exception e){
            log.error("redis expire error!",e);
        }
        return false;
    }

    public Long decrBy(String key, long integer) {
        try {
            return redisTemplate.opsForValue().decrement(key, integer);
        }catch (Exception e){
            log.error("redis decrBy error!",e);
        }
        return null;
    }


    public Long decr(String key) {
        try {
            return redisTemplate.opsForValue().decrement(key);
        }catch (Exception e){
            log.error("redis decr error!",e);
        }
        return null;

    }


    public Long incrBy(String key, long integer) {
        try {
            return redisTemplate.opsForValue().increment(key, integer);
        }catch (Exception e){
            log.error("redis incrBy error!",e);
        }
        return null;
    }


    public Double incrByFloat(String key, double value) {
        try {
            return redisTemplate.opsForValue().increment(key, value);
        }catch (Exception e){
            log.error("redis incrByFloat error!",e);
        }
        return null;
    }


    public Long incr(String key) {
        try {
            return redisTemplate.opsForValue().increment(key);
        }catch (Exception e){
            log.error("redis incr error!",e);
        }
        return null;
    }

    public String lpop(String key){
        try {
            return (String) redisTemplate.opsForList().leftPop(key);
        }catch (Exception e){
            log.error("redis lpop error!",e);
        }
        return null;

    }


    public String rpop(String key) {
        try {
            return (String) redisTemplate.opsForList().rightPop(key);
        }catch (Exception e){
            log.error("redis rpop error!",e);
        }
        return null;
    }

    public Long scard(String key){
        try {
            return redisTemplate.opsForSet().size(key);
        }catch (Exception e){
            log.error("redis scard error!",e);
        }
        return null;
    }

    public Long sadd(String key, String... members){
        try {
            return redisTemplate.opsForSet().add(key,members);
        }catch (Exception e){
            log.error("redis sadd error!",e);
        }
        return null;
    }

}
