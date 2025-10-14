package com.testprojg.testproja.controller;

import com.testprojg.testproja.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Test {

    @Autowired
    TestService testService;

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
}
