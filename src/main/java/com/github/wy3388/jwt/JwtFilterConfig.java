package com.github.wy3388.jwt;

import com.github.wy3388.jwt.bean.JwtConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class JwtFilterConfig {

    private final JwtConfig jwtConfig;
    private final JwtFilter jwtFilter;

    @Autowired
    public JwtFilterConfig(JwtConfig jwtConfig, JwtFilter jwtFilter) {
        this.jwtConfig = jwtConfig;
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public FilterRegistrationBean<? extends Filter> filterRegistrationBean() {
        FilterRegistrationBean<JwtFilter> filter = new FilterRegistrationBean<>(jwtFilter);
        filter.addUrlPatterns(jwtConfig.getUrl());
        filter.setOrder(1);
        return filter;
    }
}
