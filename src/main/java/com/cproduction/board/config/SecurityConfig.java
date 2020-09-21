package com.cproduction.board.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.frameoptions.WhiteListedAllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

import java.util.Arrays;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/h2-console/**").permitAll()
                    .antMatchers("/oauth2/**").permitAll()
                    .antMatchers("/api/**").permitAll()
                    .anyRequest().authenticated()
                .and()
                .headers()
                    .addHeaderWriter(
                            new XFrameOptionsHeaderWriter(
                                    new WhiteListedAllowFromStrategy(Arrays.asList("localhost"))
                            )
                    )
                    .frameOptions().sameOrigin()
                .and()
                    .oauth2Login();
    }
}
