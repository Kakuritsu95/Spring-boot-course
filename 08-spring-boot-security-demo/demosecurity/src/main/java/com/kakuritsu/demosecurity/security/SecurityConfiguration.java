package com.kakuritsu.demosecurity.security;

import com.kakuritsu.demosecurity.KakuUserManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration {

    @Bean
    UserDetailsManager userDetailsManager(DataSource dataSource){

    JdbcUserDetailsManager theUserDetailsManager = new JdbcUserDetailsManager(dataSource);
    theUserDetailsManager.setUserExistsSql("select user_id from members where user_id=?");
    theUserDetailsManager.setUsersByUsernameQuery("select user_id,pw,active from members where user_id = ?");
    theUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id = ?");
    return theUserDetailsManager;

    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManagers(){
//
//        UserDetails john = User.builder()
//                .username("john")
//                .password("{noop}test123")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails mary = User.builder()
//                .username("mary")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//        UserDetails susan = User.builder()
//                .username("susan")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(john,mary,susan);
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers("/styles/**").permitAll()
                        .requestMatchers("/").hasAnyRole("EMPLOYEE","MANAGER","ADMIN")
                        .requestMatchers("/leaders/**").hasAnyRole("MANAGER","ADMIN")
                        .requestMatchers("/systems/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form->
                        form
                        .loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser").permitAll()
                )
                        .logout(LogoutConfigurer::permitAll)
                        .exceptionHandling(configurer->
                                configurer.accessDeniedPage("/authorizationFailed")

                                );


        http.csrf(AbstractHttpConfigurer::disable);
       return http.build();
    }

}
