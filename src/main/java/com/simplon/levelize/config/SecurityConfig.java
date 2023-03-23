package com.simplon.levelize.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.*;
import org.springframework.security.config.annotation.web.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.web.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().anyRequest().permitAll()
                .and()
                .csrf().disable()
                .formLogin().disable()
                .httpBasic().disable()
                .logout().disable();
        return http.build();
    }
}
