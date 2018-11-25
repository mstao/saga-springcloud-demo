package me.mingshan.saga.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author mingshan
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ShopCartGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopCartGatewayApplication.class, args);
    }
}
