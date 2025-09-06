package com.vipusa.oAuthPractise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/", "/public").permitAll() // home + public accessible
                        .anyRequest().authenticated() // everything else requires login
                )
                .oauth2Login(Customizer.withDefaults()) // Google login
                .logout(logout -> logout
                        .logoutSuccessUrl("/") // after logout -> home
                        .invalidateHttpSession(true) // clear session
                        .deleteCookies("JSESSIONID") // clear cookie
                )
                .csrf(csrf -> csrf.disable()); // disable CSRF for testing

        return httpSecurity.build();
    }
}
