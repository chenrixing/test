package com.pp.sys.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;


/**
 * Created by Makkah at 2019/1/10 15:54
 */
@EnableDiscoveryClient
@EnableAuthorizationServer
@SpringBootApplication
public class SysAuth {
    public static void main(String[] args) {
        SpringApplication.run(SysAuth.class, args);
    }
}
