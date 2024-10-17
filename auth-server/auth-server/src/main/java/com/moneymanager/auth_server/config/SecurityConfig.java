package com.moneymanager.auth_server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//                .authorizeHttpRequests(auth -> {
//                    auth.requestMatchers("/").permitAll();
//                    auth.requestMatchers("/favicon.ico").permitAll();
//                    auth.anyRequest().authenticated();
//                })
//                .oauth2Login(withDefaults())
//                .formLogin(withDefaults())
         http.csrf(csrf-> csrf.disable()).authorizeHttpRequests(authorizeRequests ->
                 authorizeRequests.anyRequest().authenticated()).oauth2Login(oauth2->oauth2.defaultSuccessUrl("http://localhost:3000/dashboard",true));
        return http.build();
    }
}
