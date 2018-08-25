package com.github.stone_language.environment;

import java.util.HashMap;
import java.util.Map;

public class BasicEnv implements Environment {

    protected Map<String, Object> values;

    public BasicEnv() {
        this.values = new HashMap<>();
    }

    public void put(String name, Object value) {
        values.put(name, value);
    }

    public Object get(String name) {
        return values.get(name);
    }
}
