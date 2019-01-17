package com.pp.wms.storage.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pp.wms.storage.util.IDCardUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Makkah at 2019/1/15 16:56
 */
@RestController
public class IDCardController {
    @Resource
    private IDCardUtil idCardUtil;

    @GetMapping("/isLegal")
    boolean isLegal(@RequestParam(value = "idCard", required = true) String idCard) {
        return idCardUtil.isLegal(idCard);
    }

    @GetMapping("/birthday")
//    @JsonFormat(pattern = "yyyy-MM-dd")
    Date getBirthday(@RequestParam(value = "idCard", required = true) String idCard) {
        return idCardUtil.getBirthday(idCard);
    }

    @GetMapping("/gender")
    Integer getGender(@RequestParam(value = "idCard", required = true) String idCard) {
        return idCardUtil.getGender(idCard);
    }
}
