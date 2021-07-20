package com.st.practice.cloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 使用注解 @EnableHystrix 启用Hystrix支持
 * @author David Wang <https://github.com/superTerrorist>
 */
@EnableEurekaClient
@EnableHystrix
@SpringBootApplication
public class CloudHystrixApplication{
    public static void main(String[] args){
        SpringApplication.run(CloudHystrixApplication.class,args);
    }
}
