package com.example.project.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod; // Keep if you plan to use it for specific method matching
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// Remove unused imports if you are not directly using them in this file
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder; // This is for the method you need to remove

import org.springframework.security.core.userdetails.UserDetailsService; // Ensure this is your custom UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration // Marks this class as a source of bean definitions
@EnableWebSecurity // Enables Spring Security's web security features
public class SpringSecurity {

    // Autowire your custom UserDetailsService.
    // Ensure your actual UserDetailsService implementation (e.g., CustomUserDetailsService)
    // is also a Spring component (e.g., annotated with @Service or @Component).
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean // This bean defines the security filter chain that Spring Security will use
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF protection. This is common for stateless REST APIs
                // because they don't rely on session cookies for authentication,
                // and thus don't need CSRF tokens.
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers( "/public/**").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic();

        // Build and return the configured SecurityFilterChain.
        return http.build();
    }

    // ***********************************************************************************
    // *** THIS METHOD HAS BEEN PERMANENTLY REMOVED. ***
    // Its presence was causing conflicts with modern Spring Security configuration.
    // Spring Security automatically wires up the UserDetailsService and PasswordEncoder
    // beans defined in your application context to build the AuthenticationManager.
    // ***********************************************************************************

    @Bean // This bean provides the PasswordEncoder instance that Spring Security will use
    // for encoding passwords (e.g., when saving new users) and for comparing
    // raw passwords with stored encoded passwords during authentication.
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
