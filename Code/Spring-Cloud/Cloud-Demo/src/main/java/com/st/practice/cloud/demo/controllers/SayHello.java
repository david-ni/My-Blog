package com.st.practice.cloud.demo.controllers;

import org.springframework.http.HttpHeaders;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author David Wang <https://github.com/superTerrorist>
 */
@RequestMapping()
@RestController
public class SayHello{
    @GetMapping()
    public String sayHello(@RequestHeader HttpHeaders headers){
        for(Map.Entry<String, List<String>> entry: headers.entrySet()){
            System.out.println(entry.getKey());
        }
        return "My name is Cloud-Demo, Nice to meet you!";
    }
}
