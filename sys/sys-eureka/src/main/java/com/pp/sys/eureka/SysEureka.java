package com.pp.sys.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * WMS
 * Created by Makkah at 2019/1/8 10:39
 */
@EnableEurekaServer
@SpringBootApplication
public class SysEureka {
    public static void main(String[] args) {
        SpringApplication.run(SysEureka.class, args);
    }
}
