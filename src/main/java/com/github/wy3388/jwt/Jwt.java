package com.github.wy3388.jwt;

import com.github.wy3388.jwt.bean.JwtConfig;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class Jwt {

    private final JwtConfig jwtConfig;

    @Autowired
    public Jwt(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    /**
     * 生成jwt字符串
     *
     * @param map map
     * @return {@code String}
     */
    public String encode(Map<String, Object> map) {
        Date date = new Date();
        long time = date.getTime() + jwtConfig.getExp();
        return Jwts.builder()
                .addClaims(map)
                .setIssuedAt(date)
                .setExpiration(new Date(time))
                .signWith(SignatureAlgorithm.HS256, jwtConfig.getKey())
                .compact();
    }

    /**
     * 解密token
     *
     * @param token token
     * @return {@link Claims}
     */
    public Claims decode(String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException {
        return Jwts.parser()
                .setSigningKey(jwtConfig.getKey())
                .parseClaimsJws(token)
                .getBody();
    }


}
