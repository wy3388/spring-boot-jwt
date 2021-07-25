package com.github.wy3388.jwt;

import com.alibaba.fastjson.JSON;
import com.github.wy3388.jwt.bean.JwtConfig;
import io.jsonwebtoken.Claims;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class BasicJwtDoFilter implements IJwtDoFilter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain,
                         Jwt jwt,
                         IJwtResponse iJwtResponse,
                         IJwtVerificationSuccess iJwtVerificationSuccess,
                         JwtConfig jwtConfig) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader(JwtConfig.JWT_HEADER);
        if (token == null || token.equals("")) {
            servletResponse.setContentType("application/json;charset=utf-8");
            servletResponse.getWriter().write(JSON.toJSONString(iJwtResponse.empty()));
            return;
        }
        try {
            String t = token.replace(JwtConfig.JWT_PREFIX, "");
            Claims claims = jwt.decode(t);
            if (claims != null) {
                iJwtVerificationSuccess.success(claims);
            }
        } catch (Exception e) {
            if (jwtConfig.getShowError()) {
                e.printStackTrace();
            }
            servletResponse.setContentType("application/json;charset=utf-8");
            servletResponse.getWriter().write(JSON.toJSONString(iJwtResponse.failed()));
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
