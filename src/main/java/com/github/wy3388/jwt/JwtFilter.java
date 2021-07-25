package com.github.wy3388.jwt;

import com.github.wy3388.jwt.bean.JwtConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class JwtFilter implements Filter {

    private final Jwt jwt;
    private final JwtConfig jwtConfig;
    private final IJwtResponse iJwtResponse;
    private final IJwtVerificationSuccess iJwtVerificationSuccess;
    private final IJwtDoFilter iJwtDoFilter;

    @Autowired
    public JwtFilter(Jwt jwt, JwtConfig jwtConfig, IJwtResponse iJwtResponse, IJwtVerificationSuccess iJwtVerificationSuccess, IJwtDoFilter iJwtDoFilter) {
        this.jwt = jwt;
        this.jwtConfig = jwtConfig;
        this.iJwtResponse = iJwtResponse;
        this.iJwtVerificationSuccess = iJwtVerificationSuccess;
        this.iJwtDoFilter = iJwtDoFilter;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url = request.getRequestURI();
        if (url == null || jwtConfig.getWhiteList().contains(url)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        iJwtDoFilter.doFilter(servletRequest, servletResponse, filterChain, jwt, iJwtResponse, iJwtVerificationSuccess, jwtConfig);
    }
}
