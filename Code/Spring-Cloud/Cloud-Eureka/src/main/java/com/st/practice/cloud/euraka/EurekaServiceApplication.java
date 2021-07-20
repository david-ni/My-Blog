package com.st.practice.cloud.euraka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author David Wang <https://github.com/superTerrorist>
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceApplication{
    public static void main(String[] args){
        SpringApplication.run(EurekaServiceApplication.class,args);
    }
}
