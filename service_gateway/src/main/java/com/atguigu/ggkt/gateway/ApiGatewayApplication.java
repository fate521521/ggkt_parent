package com.atguigu.ggkt.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//网关在nacos中进行注册
//用于将当前应用程序注册到服务发现组件（例如 Eureka、Consul 等）中，以实现服务发现和负载均衡的功能。
@EnableDiscoveryClient
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
