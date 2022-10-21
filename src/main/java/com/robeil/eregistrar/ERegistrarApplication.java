package com.robeil.eregistrar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ERegistrarApplication {

    public static void main(String[] args) {
        SpringApplication.run(ERegistrarApplication.class, args);
        System.out.println("This is live reload and it is on.");
    }

}
