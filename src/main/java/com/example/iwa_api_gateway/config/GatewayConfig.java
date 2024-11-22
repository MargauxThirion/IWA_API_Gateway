package com.example.iwa_api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("location-service", r -> r.path("/locations/**")
                        .uri("http://host.docker.internal:8083"))
        
                .route("location-service", r -> r.path("/photos/**")
                        .uri("http://host.docker.internal:8083"))
                
                .route("location-service", r -> r.path("/equipments/**")
                        .uri("http://host.docker.internal:8083"))
                
                .route("location-service", r -> r.path("/search/**")
                        .uri("http://host.docker.internal:8083"))

                .route("notification-service", r -> r.path("/notifications/**")
                        .uri("http://host.docker.internal:8085"))

                .route("admin-moderation-service", r -> r.path("/flags/**")
                        .uri("http://host.docker.internal:8088"))

                .route("commentaire-service", r -> r.path("/comments/**")
                        .uri("http://host.docker.internal:8084"))

                .route("user-service", r -> r.path("/users/**")
                        .uri("http://host.docker.internal:8080"))

                .route("auth-service", r -> r.path("/auth/**")
                        .uri("http://host.docker.internal:8080"))

                .route("favoris-service", r -> r.path("/favoris/**")
                        .uri("http://host.docker.internal:8080"))

                .route("support-service", r -> r.path("/support/**")
                        .uri("http://host.docker.internal:8082"))
                .build();
    }
}
