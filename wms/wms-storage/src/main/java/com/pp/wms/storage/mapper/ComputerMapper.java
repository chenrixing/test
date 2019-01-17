package com.pp.wms.storage.mapper;

import com.pp.wms.storage.domain.entity.Computer;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;
import java.util.List;

/**
 * test
 * Created by Makkah at 2019/1/7 16:34
 */
public interface ComputerMapper {
    @Select("SELECT * FROM computer")
    @Results({
            @Result(column = "create_time", property = "createTime", javaType = Timestamp.class),
            @Result(column = "update_time", property = "updateTime", javaType = Timestamp.class),
    })
    List<Computer> getAll();

    @Select("SELECT * FROM computer WHERE ISBN = #{ISBN}")
    @Results({
            @Result(column = "create_time", property = "createTime", javaType = Timestamp.class),
            @Result(column = "update_time", property = "updateTime", javaType = Timestamp.class),
    })
    Computer getOne(long id);

    List<Computer> getAllComputers();
}
