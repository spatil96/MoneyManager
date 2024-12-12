package com.moneymanager.apiGateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;


@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

//    @Bean
//    public DefaultSecurityFilterChain securityWebFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(exchanges ->
//                        exchanges
//                                .requestMatchers("/user/**", "/api/**").authenticated()
//                                .anyRequest().permitAll()
//                )
//                .oauth2ResourceServer(oauth2 -> oauth2.jwt()); // Configure to use JWT
//        return http.build();
//    }
@Bean
public ReactiveJwtDecoder reactiveJwtDecoder() {
    // Replace with your Auth Server's JWKS endpoint
    return NimbusReactiveJwtDecoder.withJwkSetUri("http://localhost:8083/oauth/token_key").build();
}
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeExchange(exchanges -> exchanges
                        .anyExchange().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .jwtDecoder(reactiveJwtDecoder())
                        )
                )
                .build();
    }
}
