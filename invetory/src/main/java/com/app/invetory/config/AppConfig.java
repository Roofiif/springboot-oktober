package com.app.invetory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {
    //buat bean
    @Bean
    public String appPesan() {
        return "Apilkasi springboot Depedensi....";
    }

    @Bean
    @Primary
    public String appPesan1() {
        return "Apilkasi springboot Depedensi123....";
    }
}
