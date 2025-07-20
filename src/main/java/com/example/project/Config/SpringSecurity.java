package com.example.project.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurity {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF protection. This is common for stateless REST APIs.
                // this is basically some token thing So statteless dotn need because we are not storing it anyway..
                .csrf(csrf -> csrf.disable())
                // Configure authorization rules for HTTP requests
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/journal/**","/user/**","/public/**").permitAll()
                );
        return http.build();
    }
// on fetching data from db through userDetailsService we need to encode the password so that it matches with what is stored in db
     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
     }
//  Role: This method (when present and correctly overridden in a WebSecurityConfigurerAdapter subclass)
//  acts as the central configuration point for how authentication should happen.
//  auth.userDetailsService(userDetailsService): This line tells Spring Security: "When
//  someone tries to authenticate, go to this userDetailsService (your UserDetailsServiceImpl) to
//  load the user's details (username, hashed password, roles) from the database."
// .passwordEncoder(passwordEncoder()): This line tells Spring Security: "And when you need to
// compare the plain-text password provided by the user with the hashed password you got from the
// userDetailsService, use this passwordEncoder (your BCryptPasswordEncoder) to do the secure comparison."
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
