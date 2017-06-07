package com.vstone.document.core;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.nio.charset.Charset;

/**
 * 支持tomcat 需要继承SpringBootServletInitializer
 * 使用单机job需要 @EnableScheduling 开启job支持
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
@Log4j2
//@ComponentScan(value = {"com.vstone.uranus.api.component"})
public class Application extends SpringBootServletInitializer {

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = fastConverter;

        StringHttpMessageConverter stringHttpMessageConverter =
                new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return new HttpMessageConverters(converter, stringHttpMessageConverter);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("============= SpringBoot Start Success =============");
    }
}
