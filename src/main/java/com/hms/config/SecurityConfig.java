package com.hms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@Configuration
public class SecurityConfig {
    private JWTFilter jwtFilter;

    public SecurityConfig(JWTFilter jwtFilter){
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Disable CSRF
                .cors(cors -> cors.disable()) // Disable CORS
                .addFilterBefore(jwtFilter, AuthorizationFilter.class) // Add JWT Filter
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/users/login", "/api/v1/users/signup","/api/v1/users/signup-property-owner")
                        .permitAll() // Public endpoints
                        .requestMatchers("/api/v1/country/addCountry").hasAnyRole("OWNER","ADMIN")
                        .anyRequest().authenticated() // Authenticate all other requests
                )
                .build(); // Build the security chain
    }
}

/*

for reference by harsh for student wants to how it is
        //        h(cd)2
        http.csrf().disable().cors().disable();
        http.addFilterBefore(jwtFilter, AuthorizationFilter.class);
//        haap
        http.authorizeHttpRequests()
                .requestMatchers("/api/v1/users/login","/api/v1/users/signup")
                .permitAll()
                .anyRequest()
                .authenticated();

        return http.build();
*/
/*
// Disable CSRF and CORS
        http.csrf().disable().cors().disable();
        //http.csrf(csrf -> csrf.disable());
        //http.cors(cors -> cors.disable());

        // Permit all requests
        //http.authorizeHttpRequests().anyRequest().permitAll();
        http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
        // Return the built SecurityFilterChain
        return http.build();
 */