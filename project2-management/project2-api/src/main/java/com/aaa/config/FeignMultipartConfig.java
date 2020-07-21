package com.aaa.config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Company: AAA软件教育
 * @Author: Cancer:栗仁杰
 * @Date: Created in 2020/7/18 11:02
 * @Description:
 *          这里不是让fein支持上传文件的配置，而是修改feign接收请求的请求头信息，使用Spring标准的encode，既可以接收文件又可以接收普通请求
 */
@Configuration
public class FeignMultipartConfig {

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    /**
     *@author: Cancer:栗仁杰
     *@description:
     *      @ConditionalOnBean这个注解其实是spring公司提供所修改架构的注解,当某一个bean存在的时候，被这个注解所标识的bean就会被加载
     *@param: []
     *@date: 11:03 2020/7/18
     *@return:
     *@throws:
     **/
    @Bean
    @ConditionalOnBean
    public Encoder SpringFormEncoder(){
        return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }


}
