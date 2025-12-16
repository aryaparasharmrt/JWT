package com.testprojg.testproja.Test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("secret123"));

        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(2);
        System.out.println(al.contains(2));
    }


}

