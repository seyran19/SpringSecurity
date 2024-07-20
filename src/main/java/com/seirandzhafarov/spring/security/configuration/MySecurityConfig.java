package com.seirandzhafarov.spring.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {

    @Autowired
    DataSource dataSource;

//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService(BCryptPasswordEncoder passwordEncoder) {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("...")
//                .password(passwordEncoder.encode("zaur"))
//                .username("zaur")
//                .roles("EMPLOYEE")
//                .build());
//        manager.createUser(User.withUsername("..")
//                .password(passwordEncoder.encode("elena"))
//                .username("elena")
//                .roles("HR")
//                .build());
//        manager.createUser(User.withUsername(".")
//                .password(passwordEncoder.encode("ivan"))
//                .username("ivan")
//                .roles("MANAGER", "HR")
//                .build());
//        return manager;
//    }

    // получаем информацию о пользователях через БД
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
                authorizeHttpRequests(user -> user.requestMatchers(new AntPathRequestMatcher("/"))
                        .hasAnyRole("HR", "MANAGER", "EMPLOYEE")
                        .requestMatchers(new AntPathRequestMatcher("/manager_info/**")).hasRole("MANAGER")
                        .requestMatchers(new AntPathRequestMatcher("/hr_info/**")).hasRole("HR")
                        .anyRequest().authenticated()).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());
                        return http.build();

    }
}