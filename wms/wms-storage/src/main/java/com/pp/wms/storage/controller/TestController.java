package com.pp.wms.storage.controller;

import com.alibaba.fastjson.JSONObject;
import com.pp.wms.storage.domain.model.RestModel;
import com.pp.wms.storage.enums.Status;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Makkah at 2019/1/15 11:54
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/haha")
    RestModel<JSONObject> haha() {
        JSONObject 哈哈 = new JSONObject();
        ((JSONObject) 哈哈).put("h1", 1);
        ((JSONObject) 哈哈).put("h2", "22");
        return new RestModel<JSONObject>(Status.SUCCESS.getCode(), "SUCCESS", 哈哈);
    }

    @PatchMapping("/{id}")
    String test1() {
        return "1";
    }

    @PostMapping("/{id}")
    String test2() {
        return "2";
    }

    @GetMapping()
    RestModel<String> test3(@RequestParam("from") String from, @RequestParam("to") String to) {
        return new RestModel<String>(Status.SUCCESS.getCode(), "SUCCESS", from + "->" + to);
    }

    @DeleteMapping("/{id}")
    String test4() {
        return "4";
    }

    @PutMapping("/{id}")
    String test5() {
        return "5";
    }
}
