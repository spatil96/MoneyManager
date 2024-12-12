package com.moneymanager.auth_server.config;

import com.moneymanager.auth_server.controller.HomeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Map;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////         http
////                .authorizeHttpRequests(auth -> {
////                    auth.requestMatchers("/").permitAll();
////                    auth.requestMatchers("/favicon.ico").permitAll();
////                    auth.anyRequest().authenticated();
////                })
////                .oauth2Login(withDefaults())
////                .formLogin(withDefaults())
//         http.csrf(csrf-> csrf.disable()).authorizeHttpRequests(authorizeRequests ->
//                 authorizeRequests.anyRequest().authenticated()).oauth2Login(oauth2->oauth2.defaultSuccessUrl("http://localhost:3000/dashboard",true));
//        return http.build();
//    }

    @Autowired
    private HomeController homeController;
@Bean
SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http .csrf(csrf -> csrf.disable())
            .authorizeRequests(auth -> auth
                    .requestMatchers("/", "/favicon.ico").permitAll()
                    .anyRequest().authenticated()
            )
            .oauth2Login(oauth2 -> oauth2
                    .successHandler((request, response, authentication) -> {
                        // After successful login, redirect to React dashboard
                        response.sendRedirect("http://localhost:3000/dashboard");
                    })
            );

    return http.build();
//            .csrf(csrf -> csrf.disable())
//            .authorizeRequests(auth -> auth.requestMatchers("/", "/favicon.ico").permitAll()
//                    .anyRequest().authenticated()
//            ) .oauth2Login(oauth2 -> oauth2
//                    .successHandler((request, response, authentication) -> {
//                        OAuth2User oauthUser = (OAuth2User) authentication.getPrincipal();
//
//                        // Programmatically invoke userInfo method
//                        Map<String, Object> userInfo = homeController.userInfo(oauthUser);
//
//                        // Redirect to the dashboard
//                        response.sendRedirect("http://localhost:3000/dashboard");
//                    })
//            );
//
//    return http.build();

}
}
