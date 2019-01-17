package com.pp.sys.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Makkah at 2019/1/10 16:06
 */

@Configuration
@EnableAuthorizationServer
public class AuthConfig extends AuthorizationServerConfigurerAdapter {
//    @Resource
//    private DataSource dataSource;
//    @Autowired
//    private AuthenticationManager authenticationManager;

//    @Autowired
//    private UserDetailsService userDetailsService;


//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        super.configure(security);
//    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                //client Id
                .withClient("normal-app")
                .authorizedGrantTypes("authorization_code", "implicit")
                .authorities("ROLE_CLIENT")
                .scopes("read", "write")
                .resourceIds("sys-auth")
                .accessTokenValiditySeconds(36000);
    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.authenticationManager(this.authenticationManager);
//        endpoints.accessTokenConverter(accessTokenConverter());//jwt
//        endpoints.tokenStore(tokenStore());
//
//        //授权码存储
////        endpoints.authorizationCodeServices(redisAuthenticationCodeServices);
//    }
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
//        oauthServer.tokenKeyAccess("isAnonymous() || hasAuthority('ROLE_TRUSTED_CLIENT')");
//        oauthServer.checkTokenAccess("hasAuthority('ROLE_TRUSTED_CLIENT')");
//        //enable client to get the authenticated when using the /oauth/token to get a access token
//        //there is a 401 authentication is required if it doesn't allow form authentication for clients when access /oauth/token
//        oauthServer.allowFormAuthenticationForClients();
//    }
//    @Bean
//    public JwtAccessTokenConverter accessTokenConverter() {
//
//        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter() {
//            /**
//             * 重写增强token的方法
//             * 自定义返回相应的信息
//             *
//             */
//
//            @Override
//            public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
//
//                String userName = authentication.getUserAuthentication().getName();
//                // 与登录时候放进去的UserDetail实现类一直查看link{SecurityConfiguration}
//                User user = (User) authentication.getUserAuthentication().getPrincipal();
//                /** 自定义一些token属性 ***/
//                final Map<String, Object> additionalInformation = new HashMap<>();
//                additionalInformation.put("userName", userName);
//                additionalInformation.put("roles", user.getAuthorities());
//                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInformation);
//                OAuth2AccessToken enhancedToken = super.enhance(accessToken, authentication);
//                return enhancedToken;
//            }
//
//        };
//        // 测试用,资源服务使用相同的字符达到一个对称加密的效果,生产时候使用RSA非对称加密方式
//        accessTokenConverter.setSigningKey("123");
//        return accessTokenConverter;
//
//    }
//
//    @Bean
//    public TokenStore tokenStore() {
//
//        TokenStore tokenStore = new JwtTokenStore(accessTokenConverter());
//
//        return tokenStore;
//    }


//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        // 使用JdbcClientDetailsService客户端详情服务
//        clients.withClientDetails(new JdbcClientDetailsService(dataSource));
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
//        endpoints
//                .tokenStore(new RedisTokenStore(redisConnectionFactory))
//                .accessTokenConverter(jwtAccessTokenConverter())
//                .authenticationManager(authenticationManager)
//                .exceptionTranslator(pigWebResponseExceptionTranslator)
//                .reuseRefreshTokens(false)
//                .userDetailsService(userDetailsService);
//    }
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security
//                .allowFormAuthenticationForClients()
//                .tokenKeyAccess("isAuthenticated()")
//                .checkTokenAccess("permitAll()");
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
//        jwtAccessTokenConverter.setSigningKey(CommonConstant.SIGN_KEY);
//        return jwtAccessTokenConverter;
//    }

}

