package com.st.practice.cloud.route;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author David Wang <https://github.com/superTerrorist>
 */
@SpringBootApplication
@EnableZuulProxy
public class RouteApplication{
    public static void main(String[] args){
        SpringApplication.run(RouteApplication.class,args);
    }
}
