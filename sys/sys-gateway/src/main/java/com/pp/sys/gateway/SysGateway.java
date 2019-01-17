package com.pp.sys.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Makkah at 2019/1/10 14:47
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SysGateway {
    public static void main(String[] args) {
        SpringApplication.run(SysGateway.class, args);
    }
}
