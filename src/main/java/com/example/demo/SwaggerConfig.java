package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    public static final String CONTROLLER_PACKAGE = "com.example.demo.controller";

    @Value("${api.title}")
    private String title;

    @Value("${api.description}")
    private String description;

    @Value("${api.version}")
    private String version;

    @Value("${api.termsOfServiceUrl}")
    private String termsOfServiceUrl;

    @Value("${api.contact.name}")
    private String contactName;

    @Value("${api.contact.email}")
    private String contactEmail;

    @Value("${api.contact.url}")
    private String contactUrl;

    @Value("${api.license.name}")
    private String licenseName;

    @Value("${api.license.url}")
    private String licenseUrl;

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version)
                .termsOfServiceUrl(termsOfServiceUrl)
                .contact(new springfox.documentation.service.Contact(contactName, contactUrl, contactEmail))
                .license(licenseName)
                .licenseUrl(licenseUrl)
                .build();
    }

    @Bean
    public Docket firstApi() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage(CONTROLLER_PACKAGE))
                .paths(PathSelectors.ant("/api/first/**"))
                .build()
                .groupName("First API")
                .apiInfo(apiInfo());
    }

    @Bean
    public Docket secondApi() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage(CONTROLLER_PACKAGE))
                .paths(PathSelectors.ant("/api/second/**"))
                .build()
                .groupName("Second API")
                .apiInfo(apiInfo());
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage(CONTROLLER_PACKAGE))
                .paths(PathSelectors.ant("/api/product/**"))
                .build()
                .groupName("Product API")
                .apiInfo(apiInfo());
    }

    @Bean
    public Docket inventoryApi() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage(CONTROLLER_PACKAGE))
                .paths(PathSelectors.ant("/api/inventory/**"))
                .build()
                .groupName("Inventory API")
                .apiInfo(apiInfo());
    }

    @Bean
    public Docket storeApi() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage(CONTROLLER_PACKAGE))
                .paths(PathSelectors.ant("/api/store/**"))
                .build()
                .groupName("Store API")
                .apiInfo(apiInfo());
    }
}
