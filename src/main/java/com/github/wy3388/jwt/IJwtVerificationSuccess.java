package com.github.wy3388.jwt;

import io.jsonwebtoken.Claims;

public interface IJwtVerificationSuccess {
    void success(Claims claims);
}
