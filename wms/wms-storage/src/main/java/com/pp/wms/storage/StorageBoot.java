package com.pp.wms.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Makkah at 2019/1/8 11:02
 */
@SpringCloudApplication
@EnableSwagger2
@MapperScan("com.pp.wms.storage.mapper")
public class StorageBoot {
    public static void main(String[] args) {
        SpringApplication.run(StorageBoot.class, args);
    }
}
