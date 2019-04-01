package com.detroitlabs.DLFinalAssessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class AppConfiguration {
    public static void main(String[] args) {
//        System.setProperty("https.protocols", "TLSv1.2");
        SpringApplication.run(AppConfiguration.class, args);
    }
}
