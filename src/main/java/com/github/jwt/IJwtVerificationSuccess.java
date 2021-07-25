package com.github.jwt;

import io.jsonwebtoken.Claims;

public interface IJwtVerificationSuccess {
    void success(Claims claims);
}
