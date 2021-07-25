package com.github.wy3388.jwt;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.github.wy3388.jwt")
public class JwtAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public IJwtResponse iJwtResponse() {
        return new BasicJwtResponse();
    }

    @Bean
    @ConditionalOnMissingBean
    public IJwtVerificationSuccess iJwtVerificationSuccess() {
        return new BasicJwtVerificationSuccess();
    }

    @Bean
    @ConditionalOnMissingBean
    public IJwtDoFilter iJwtDoFilter() {
        return new BasicJwtDoFilter();
    }
}
