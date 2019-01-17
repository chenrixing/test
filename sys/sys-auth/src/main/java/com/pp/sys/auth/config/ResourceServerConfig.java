//package com.pp.sys.auth.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//
///**
// * Created by Makkah at 2019/1/10 17:26
// */
////@EnableAutoConfiguration(exclude = {
////        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
////})
//@Configuration
//@EnableResourceServer
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        // @formatter:off
//        http.authorizeRequests().anyRequest().authenticated();
////        http.antMatcher("/client").authorizeRequests().anyRequest().authenticated();
//        // @formatter:on
//    }
//}
