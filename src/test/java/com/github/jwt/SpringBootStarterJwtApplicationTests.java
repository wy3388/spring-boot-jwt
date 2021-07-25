package com.github.jwt;

import com.github.jwt.bean.JwtConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.function.IntFunction;

@SpringBootTest
class SpringBootStarterJwtApplicationTests {

    @Autowired
    private JwtConfig jwtConfig;

    @Test
    void contextLoads() {
        System.out.println(Arrays.toString(jwtConfig.getWhiteList().toArray(new String[0])));
    }

}
