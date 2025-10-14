package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/cek_demo")
    public String cekDemo() {
        return "haloo dari sprinboot";
    }
}
