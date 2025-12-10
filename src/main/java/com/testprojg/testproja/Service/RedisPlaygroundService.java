package com.testprojg.testproja.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.connection.stream.StreamRecords;
//import org.springframework.data.redis.connection.stream.Range;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class RedisPlaygroundService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // ---------- STRING ----------
    public String setString(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        return "String stored";
    }

    public Object getString(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // ---------- HASH ----------
    public String setHash(String key, Map<String, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
        return "Hash stored";
    }

    public Object getHash(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    // ---------- LIST ----------
    public String pushList(String key, String value) {
        redisTemplate.opsForList().leftPush(key, value);
        return "Value added to List";
    }

    public List<Object> getList(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    // ---------- SET ----------
    public String addSet(String key, String value) {
        redisTemplate.opsForSet().add(key, value);
        return "Value added to Set";
    }

    public Set<Object> getSet(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    // ---------- SORTED SET (ZSET) ----------
    public String addZSet(String key, String member, double score) {
        redisTemplate.opsForZSet().add(key, member, score);
        return "Value added to Sorted Set";
    }

    public Set<Object> getZSet(String key) {
        return redisTemplate.opsForZSet().range(key, 0, -1);
    }

    // ---------- JSON ----------
    public String setJson(String key, Object json) {
        redisTemplate.opsForValue().set(key, json);
        return "JSON Stored";
    }

    public Object getJson(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // ---------- STREAM ----------
    public String addStream(String key, Map<String, String> body) {
        redisTemplate.opsForStream().add(
                StreamRecords.mapBacked(body).withStreamKey(key)
        );
        return "Stream entry added";
    }

//    public List<MapRecord<String, Object, Object>> getStream(String key) {
//        return redisTemplate
//                .opsForStream()
//                .range(key, Range.open("-", "+"));
//    }
}

