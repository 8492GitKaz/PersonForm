package com.example.personform;

import com.example.validatingforminput.ValidatingFormInputApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonFormApplication {

    public static void main(String[] args) {
        // メインクラスをここで指定しておく。
        SpringApplication.run(ValidatingFormInputApplication.class, args);
    }
}
