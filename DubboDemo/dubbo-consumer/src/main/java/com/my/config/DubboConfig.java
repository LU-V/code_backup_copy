package com.my.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:dubbo-consumer.xml")
public class DubboConfig {
}
