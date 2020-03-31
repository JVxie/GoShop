package com.jvxie.goshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "package com.jvxie.goshop.mapper;")
public class GoshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoshopApplication.class, args);
    }

}
