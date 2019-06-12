package com.yuanqi.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: yq
 * @Date：2019/5/8 9:40
 * @Describe:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 用户信息操作api
     *
     * @return
     */
    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户信息")
                .apiInfo(userInfo())
                .select()
                //Controller所在路径
                .apis(RequestHandlerSelectors.basePackage("com.yuanqi.service.user"))
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo userInfo() {
        return new ApiInfoBuilder()
                .title("用户信息 API")
                .description("用户的增删改查")
                .termsOfServiceUrl("www.baidu.com")
                .contact("yuanqi")
                .version("0.0.1")
                .build();
    }

    /**
     * excelApi
     *
     * @return
     */
    @Bean
    public Docket excelApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("导入报表")
                .apiInfo(excelInfo())
                .select()
                //Controller所在路径
                .apis(RequestHandlerSelectors.basePackage("com.yuanqi.service.excel"))
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo excelInfo() {
        return new ApiInfoBuilder()
                .title("导入报表 API")
                .description("导入报表")
                .termsOfServiceUrl("www.baidu.com")
                .contact("yuanqi")
                .version("0.0.1")
                .build();
    }

    /**
     * 商品信息操作api
     *
     * @return
     */
    @Bean
    public Docket commodityApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("商品信息")
                .apiInfo(commodityInfo())
                .select()
                //Controller所在路径
                .apis(RequestHandlerSelectors.basePackage("com.yuanqi.service.commodity"))
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo commodityInfo() {
        return new ApiInfoBuilder()
                .title("商品信息 API")
                .description("商品增删改查")
                .termsOfServiceUrl("www.baidu.com")
                .contact("yuanqi")
                .version("0.0.1")
                .build();
    }

}
