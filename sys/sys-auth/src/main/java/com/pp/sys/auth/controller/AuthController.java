package com.pp.sys.auth.controller;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Created by Makkah at 2019/1/11 10:14
 */
@RestController
public class AuthController {
    @RequestMapping("/hello")
    public String Hello() {
        return "login";
    }

    @PatchMapping("/test/{id}")
    String test1() {
        return "1";
    }
    @PostMapping("/test/{id}")
    String test2() {
        return "2";
    }
    @GetMapping("/test/{id}")
    String test3() {
        return "3";
    }
    @DeleteMapping("/test/{id}")
    String test4() {
        return "4";
    }
    @PutMapping("/test/{id}")
    String test5() {
        return "5";
    }
}
