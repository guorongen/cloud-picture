package com.gre.cloudpicturebackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.gre.cloudpicturebackend.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableAsync
public class CloudPictureBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudPictureBackendApplication.class, args);
    }

}
