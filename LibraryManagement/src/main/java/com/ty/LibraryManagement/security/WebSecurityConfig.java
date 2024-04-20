package com.ty.LibraryManagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
 
@Configuration
public class WebSecurityConfig {
 
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
    @Bean
    UserDetailsService userDetailsService() {
        UserDetails user1 = User
                .withUsername("john")
                .password("$2a$10$xbzBJvAbU8QAOm00tCOszukYK2dMjBZi5tDerkL1TjoyklapwTmbO\r\n")
                .roles("USER")
                .build();
        UserDetails user2 = User
                .withUsername("nikhil")
                .password("$2a$10$p3l1TfKIt4gPVuFdWC.sMO/xbCkRUyF3vWiLjzEdsKgNhuzf8uCd6")
                .roles("ADMIN")
                .build();     
          
        return new InMemoryUserDetailsManager(user1, user2);       
    }
     
 
    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
    	http.csrf().disable();
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated())
            .httpBasic(Customizer.withDefaults())
        ;
         
        return http.build();
    }  
}