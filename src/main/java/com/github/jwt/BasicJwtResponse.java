package com.github.jwt;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BasicJwtResponse implements IJwtResponse {
    @Override
    public Map<String, Object> empty() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", -1);
        map.put("message", "token is empty");
        map.put("data", Collections.emptyMap());
        return map;
    }

    @Override
    public Map<String, Object> failed() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", -1);
        map.put("message", "token verification failed");
        map.put("data", Collections.emptyMap());
        return map;
    }
}
