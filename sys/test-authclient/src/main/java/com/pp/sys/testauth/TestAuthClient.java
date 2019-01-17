package com.pp.sys.testauth;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Makkah at 2019/1/11 11:12
 */
@EnableAutoConfiguration
@Configuration
@EnableOAuth2Sso
@RestController
public class TestAuthClient {
    @RequestMapping("/client")
    public String home(Principal user) {
        return "Hello " + user.getName();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(TestAuthClient.class).run(args);
    }
}
