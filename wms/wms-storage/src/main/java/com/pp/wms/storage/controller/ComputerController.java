package com.pp.wms.storage.controller;

import com.pp.wms.storage.domain.entity.Computer;
import com.pp.wms.storage.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping(value = "/computer/getAllComputers", method = RequestMethod.GET)
    List<Computer> getAllComputers() {
        return computerService.getAllComputers();
    }

}
