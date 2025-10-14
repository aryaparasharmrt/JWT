package com.testprojg.testproja.Service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public int addNumbers(int a, int b) {
        int sum = a + b;
        System.out.println("Adding " + a + " + " + b + " = " + sum);
        return sum;
    }
}
