package com.pp.wms.storage.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * PP
 * Created by Makkah at 2019/1/8 14:15
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private final static String apiPackage;

    static {
        String packageName = SwaggerConfig.class.getPackage().getName();
        apiPackage = packageName.substring(0, packageName.lastIndexOf('.')) + ".controller";
    }

    @Value("${spring.cloud.client.ip-address}")
    String hostname;
    @Value("${server.port}")
    String port;
    @Value("${swagger.api-info.title}")
    String title;
    @Value("${swagger.api-info.description}")
    String description;
    @Value("${swagger.api-info.contact.name}")
    String contactName;
    @Value("${swagger.api-info.contact.url}")
    String contactUrl;
    @Value("${swagger.api-info.contact.email}")
    String contactEmail;
    @Value("${swagger.api-info.version}")
    String version;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage(apiPackage)).paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(title).description(description)
                .termsOfServiceUrl("http://" + hostname + ":" + port + "/")
                .contact(new Contact(contactName, contactUrl, contactEmail))
                .version(version).build();
    }
}

