package com.st.practice.cloud.hystrix.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 降级处理
 * @author David Wang <https://github.com/superTerrorist>
 */
@RestController
@RequestMapping("fallback")
@Slf4j
public class FallbackTestController{

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 降级处理
     * 如果远程方法不可用，则调用fallbackMethod方法
     */
    @GetMapping
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String fallbackTest(){
        String url = "http://cloud-demo/demo/sleepForWhile";
        String result = restTemplate.getForObject(url,String.class);
        log.info("get the result from cloud demo, result: {}",result);
        return "success";
    }

    /**
     * 降级方法
     * 要求：
     * 1. 返回值与对应服务方法的返回值一致
     * 2. 参数与对应服务方法的参数一致
     */
    public String fallbackMethod(){
        log.info("execute fallback logic");
        return "The Service is not available, please try again later!";
    }
}
