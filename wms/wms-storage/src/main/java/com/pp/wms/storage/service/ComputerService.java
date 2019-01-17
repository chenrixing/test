package com.pp.wms.storage.service;

import com.pp.wms.storage.domain.entity.Computer;

import java.util.List;

/**
 * test
 * Created by Makkah at 2019/1/7 17:14
 */
public interface ComputerService {
    List<Computer> getAll();

    List<Computer> getAllComputers();
}
