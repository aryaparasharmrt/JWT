package com.testprojg.testproja.controller;

import com.testprojg.testproja.Entity.Person;
import com.testprojg.testproja.Repository.TestRepository;
import com.testprojg.testproja.Service.RedisPlaygroundService;
import com.testprojg.testproja.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("")
public class Test {

    private final TestRepository testRepository;

    @Autowired
    TestService testService;


    @Autowired
    RedisPlaygroundService redisService;

    public Test(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @GetMapping("/m1")
    public String m1() {
        System.out.println("This is method m1");
        return "Returning from Method m1";
    }

    @GetMapping("/add")
    public int addNumbers(@RequestParam int a, @RequestParam int b) {
        int sum = testService.addNumbers(a, b);
        return sum;
    }

    @PostMapping("/add-person")
    public String addPerson(@RequestParam String name) {
        System.out.println("Method Entry: addPerson");
        Person person1 = new Person(name);
        testService.savePerson(person1);
        return "Saved!";
    }

    @GetMapping("/get-person")
    public Person getPerson(@RequestParam Long id) {
        return testService.getPersonById(id);
    }

    @PostMapping("/redis/string/{key}")
    public String setString(@PathVariable String key, @RequestBody String value) {
        return redisService.setString(key, value);
    }

    @GetMapping("/redis/string/{key}")
    public Object getString(@PathVariable String key) {
        return redisService.getString(key);
    }

    // ---------- HASH ----------
    @PostMapping("/redis/hash/{key}")
    public String setHash(@PathVariable String key, @RequestBody Map<String, Object> map) {
        return redisService.setHash(key, map);
    }

    @GetMapping("/redis/hash/{key}")
    public Object getHash(@PathVariable String key) {
        return redisService.getHash(key);
    }

    // ---------- LIST ----------
    @PostMapping("/redis/list/{key}")
    public String pushList(@PathVariable String key, @RequestBody String value) {
        return redisService.pushList(key, value);
    }

    @GetMapping("/redis/list/{key}")
    public Object getList(@PathVariable String key) {
        return redisService.getList(key);
    }

    // ---------- SET ----------
    @PostMapping("/redis/set/{key}")
    public String addSet(@PathVariable String key, @RequestBody String value) {
        return redisService.addSet(key, value);
    }

    @GetMapping("/redis/set/{key}")
    public Object getSet(@PathVariable String key) {
        return redisService.getSet(key);
    }

    // ---------- SORTED SET (ZSET) ----------
    @PostMapping("/redis/zset/{key}")
    public String addZSet(
            @PathVariable String key,
            @RequestParam String member,
            @RequestParam double score
    ) {
        return redisService.addZSet(key, member, score);
    }

    @GetMapping("/redis/zset/{key}")
    public Object getZSet(@PathVariable String key) {
        return redisService.getZSet(key);
    }

    // ---------- JSON ----------
    @PostMapping("/redis/json/{key}")
    public String setJson(@PathVariable String key, @RequestBody Object json) {
        return redisService.setJson(key, json);
    }

    @GetMapping("/redis/json/{key}")
    public Object getJson(@PathVariable String key) {
        return redisService.getJson(key);
    }

    // ---------- STREAM ----------
    @PostMapping("/redis/stream/{key}")
    public String addStream(@PathVariable String key, @RequestBody Map<String, String> body) {
        return redisService.addStream(key, body);
    }

//    @GetMapping("/redis/stream/{key}")
//    public Object getStream(@PathVariable String key) {
//        return redisService.getStream(key);
//    }

}
