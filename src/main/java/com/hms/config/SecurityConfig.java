package com.hms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@Configuration
public class SecurityConfig {

    private JWTFilter jwtFilter;

    public SecurityConfig(JWTFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        //h(cd)2
        http.csrf().disable().cors().disable();
        http.addFilterBefore(jwtFilter, AuthorizationFilter.class);
        // Configure authorization rules
//        http.authorizeHttpRequests()
//                // Allow access to login, signup, and message endpoints
//                .requestMatchers("/api/v1/users/login", "/api/v1/users/signup", "/api/v1/users/signup-property-owner", "/message","/api/v1/properties/search-hotels")
//                .permitAll()
//
//                // Allow access to /search-hotels without any authentication or role
//
//
//                // Restrict access to /api/v1/countries/addCountry to users with ROLE_OWNER or ROLE_ADMIN
//                .requestMatchers("/api/v1/countries/addCountry")
//                .hasAnyRole("OWNER", "ADMIN")
//
//                // Require authentication for any other endpoint
//                .anyRequest()
//                .authenticated();

        http.authorizeHttpRequests(auth-> auth.anyRequest().permitAll());

        return http.build();
    }
}
