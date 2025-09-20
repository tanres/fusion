package com.tanres.fusion.module.iot.biz.controller.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/iot")
public class IotHelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello iot";
    }
}
