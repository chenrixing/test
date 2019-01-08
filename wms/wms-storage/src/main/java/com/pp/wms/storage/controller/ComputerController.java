package com.pp.wms.storage.controller;

import com.pp.wms.storage.domain.Computer;
import com.pp.wms.storage.mapper.ComputerMapper;
import com.pp.wms.storage.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * PP
 * Created by Makkah at 2019/1/8 15:08
 */
@RestController
public class ComputerController {
    // @Value可以从配置文件获取value，如果本地配置文件没有此变量，则是在云端配置文件中
    @Value("${pp.hello}")
    String hello;

    @Autowired
    private ComputerService computerService;

    @RequestMapping(value = "/computer", method = RequestMethod.GET)
    String testComputer() {
        return "Hello test computer!";
    }

    @RequestMapping(value = "/computer/getAll", method = RequestMethod.GET)
    List<Computer> getAll() {
        return computerService.getAll();
    }

    @RequestMapping(value = "/helloPP", method = RequestMethod.GET)
    String helloPP() {
        return hello;
    }
}
