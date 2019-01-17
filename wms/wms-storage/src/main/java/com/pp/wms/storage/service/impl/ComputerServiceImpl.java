package com.pp.wms.storage.service.impl;

import com.pp.wms.storage.domain.entity.Computer;
import com.pp.wms.storage.mapper.ComputerMapper;
import com.pp.wms.storage.service.ComputerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Makkah at 2019/1/7 17:15
 */
@Service
public class ComputerServiceImpl implements ComputerService {
    @Resource
    private ComputerMapper computerMapper;

    @Override
    public List<Computer> getAll() {
        return computerMapper.getAll();
    }

    @Override
    public List<Computer> getAllComputers() {
        return computerMapper.getAllComputers();
    }
}
