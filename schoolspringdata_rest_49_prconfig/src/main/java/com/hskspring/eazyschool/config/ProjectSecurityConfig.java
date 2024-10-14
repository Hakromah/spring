package com.hskspring.eazyschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    //permit all the paths we have in the application
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.ignoringRequestMatchers("/saveMsg")
                        .ignoringRequestMatchers("/public/**")
                        .ignoringRequestMatchers("/api/**")
                        .ignoringRequestMatchers("/data-api/**"))
                .authorizeHttpRequests((request) -> request
                        .requestMatchers("/dashboard").authenticated()
                        .requestMatchers("/displayMessages/**").hasRole("ADMIN")//for viewing messages
                        .requestMatchers("/admin/**").hasRole("ADMIN")//admin access all the paths that have prefix /admin
                        .requestMatchers("/api/**").authenticated()
                        .requestMatchers("/data-api/**").authenticated()//secure all apis in HAL Explorer
                        .requestMatchers("/closeMsg/**").hasRole("ADMIN")//for update
                        .requestMatchers("/displayProfile").authenticated()
                        .requestMatchers("/updateProfile").authenticated()
                        .requestMatchers("/student/**").hasRole("STUDENT")
                        .requestMatchers("**", "/", "/home").permitAll()
                        .requestMatchers("/holidays/**").permitAll()
                        /*.requestMatchers("/profile/**").permitAll()
                        .requestMatchers("/courseses/**").permitAll()
                        .requestMatchers("/contacts/**").permitAll()
                        .requestMatchers("/data-api/**").permitAll()*/
                        .requestMatchers("/contact").permitAll()//.authenticated() u will be required to log in to get access
                        .requestMatchers("/saveMsg").permitAll()
                        .requestMatchers("/courses").permitAll()
                        .requestMatchers("/about").permitAll()
                        .requestMatchers("/assets/**").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/logout").permitAll()
                        .requestMatchers("/public/**").permitAll())
                .formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer.loginPage("/login")//setting up the custom loginPage
                        .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll())
                .logout(httpSecurityLogoutConfigurer -> httpSecurityLogoutConfigurer.logoutSuccessUrl("/login?logout=true")
                        .invalidateHttpSession(true).permitAll())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    /*Bcrypt Password Encoder & Hashing*/
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //This is how we create an in memory user manually
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("hskdev")
//                .password("hskdev@123")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }

}

























