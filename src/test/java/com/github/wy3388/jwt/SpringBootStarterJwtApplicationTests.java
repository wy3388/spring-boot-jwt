package com.github.wy3388.jwt;

import com.github.wy3388.jwt.bean.JwtConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class SpringBootStarterJwtApplicationTests {

    @Autowired
    private JwtConfig jwtConfig;

    @Test
    void contextLoads() {
        System.out.println(Arrays.toString(jwtConfig.getWhiteList().toArray(new String[0])));
    }

}
