package com.example.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("Employee", r-> r.path("/employee/**")
                        .uri("http://localhost:8081/employee-service")

                )
                .route("Employee", r-> r.path("/consumer/**")
                        .uri("http://localhost:8082/address-service")
                )
                .build();
    }
}
