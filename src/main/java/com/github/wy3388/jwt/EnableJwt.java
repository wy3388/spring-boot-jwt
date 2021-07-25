package com.github.wy3388.jwt;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({JwtAutoConfig.class})
public @interface EnableJwt {
}
