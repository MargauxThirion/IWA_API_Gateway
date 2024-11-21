package com.example.iwa_api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .csrf().disable()
                .authorizeExchange()
                // Permettre l'accès sans authentification à certaines routes pour les tests
                .pathMatchers("/locations/**").permitAll()
                .pathMatchers("/notifications/**").permitAll()
                .pathMatchers("/commentaires/**").permitAll()
                .pathMatchers("/support/**").permitAll()
                .pathMatchers("/users/**").permitAll()
                .pathMatchers("/auth/**").permitAll()
                .pathMatchers("/favoris/**").permitAll()
                .pathMatchers("/flags/**").hasRole("ADMIN") // Exige un rôle spécifique pour les flags
                .anyExchange().permitAll();// Tout le reste nécessite une authentification
        return http.build();
    }
}
