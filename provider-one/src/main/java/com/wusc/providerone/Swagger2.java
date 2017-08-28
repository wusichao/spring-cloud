package com.wusc.providerone;

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
 * <pre>
 * swagger2配置类
 * @author Leo
 * </pre>
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wusc.providerone.controller"))
                .paths(PathSelectors.any())
                .build();
	}
	
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("学习服务api")
                .description("请把详细服务内容写到这")
                .contact(new Contact("wusc", "没有url", "1033429246@qq.com"))
                .version("1.0")
                .build();
    }
}
