package com.st.practice.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author David Wang <https://github.com/superTerrorist>
 */
@EnableEurekaClient
@SpringBootApplication
public class CloudDemoApplication{
    public static void main(String[] args){
        SpringApplication.run(CloudDemoApplication.class,args);
    }
}
