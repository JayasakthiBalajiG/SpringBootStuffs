package com.dhyan.netman.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests((authz) -> authz
                                    .requestMatchers(HttpMethod.GET,"movie/movies").hasRole("ADMINS")
//                                  .requestMatchers("/api/user/**").hasRole("USERS")
                                    .anyRequest().authenticated()
                    );
            return http.build();
        }

}
