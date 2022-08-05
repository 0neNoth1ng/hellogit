package com.hcb.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("")
    public String hello(){
        System.out.println("第一次部署项目....");
        return "卧槽，真的巨秀好吧，秀翻了";
    }
}
