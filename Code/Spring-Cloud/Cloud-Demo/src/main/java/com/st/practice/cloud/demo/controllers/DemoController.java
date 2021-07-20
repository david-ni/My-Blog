package com.st.practice.cloud.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author David Wang <https://github.com/superTerrorist>
 */
@RestController
@RequestMapping("demo")
public class DemoController{
    @GetMapping("/sleepForWhile")
    public String sleepForWhile() throws Exception{
        Thread.sleep(5000);
        return  "Sleep for a while!";
    }
}
