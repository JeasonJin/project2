package com.aaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @ClassName ApplicationRun
 * @Description TODO
 * @Author jyz
 * @date 2020/7/15 14:54
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.aaa"})
@RibbonClient(name = "project2-interface-consumer")
public class ApplicationRun {
    public static void main(String[] args) {

        SpringApplication.run(ApplicationRun.class,args);
    }
}
