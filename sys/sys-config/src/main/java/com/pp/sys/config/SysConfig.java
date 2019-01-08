package com.pp.sys.config;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * PP
 * Created by Makkah at 2019/1/8 16:19
 */
@EnableConfigServer
@SpringCloudApplication
public class SysConfig {
    public static void main(String[] args) {
        SpringApplication.run(SysConfig.class, args);
    }
}
