package com.aaa;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName ApplicationRun
 * @Description TODO
 * @Author jyz
 * @date 2020/7/10 16:00
 **/
@SpringBootApplication
@MapperScan("com.aaa.mapper")
public class ApplicationRun {
    public static void main(String[] args) {

        SpringApplication.run(ApplicationRun.class,args);
    }
}
