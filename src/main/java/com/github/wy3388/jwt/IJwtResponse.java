package com.github.wy3388.jwt;

import java.util.Map;

public interface IJwtResponse {
    Map<String, Object> empty();

    Map<String, Object> failed();
}
