package com.github.wy3388.jwt;

import com.github.wy3388.jwt.bean.JwtConfig;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public interface IJwtDoFilter {
    void doFilter(ServletRequest servletRequest,
                  ServletResponse servletResponse,
                  FilterChain filterChain,
                  Jwt jwt,
                  IJwtResponse iJwtResponse,
                  IJwtVerificationSuccess iJwtVerificationSuccess,
                  JwtConfig jwtConfig) throws IOException, ServletException;
}
