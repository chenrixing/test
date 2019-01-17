package com.pp.sys.auth.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Makkah at 2019/1/10 17:12
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 允许通过的请求，ps:必须允许所有用户访问我们的登录页（例如未验证的用户，否则验证流程就会进入死循环）
                .antMatchers("login", "/login.html").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()                                // 配置登录表单
                .loginPage("/login.html")                   // 登录页路径
                .loginProcessingUrl("/authentication/form") // 请求路径
                .failureUrl("/error.html")                  // 错误页面
                .defaultSuccessUrl("/success.html")         // 成功页面
                .permitAll();   // 这个formLogin().permitAll()方法允许所有用户基于表单登录访问/login这个page。
        //默认都会产生一个hiden标签 里面有安全相关的验证 防止请求伪造 这边我们暂时不需要 可禁用掉
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin")
                .password(new BCryptPasswordEncoder().encode("123456"))
                .roles("USER");
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("123456").roles("USER");
    }
}
