package com.github.stone_language.environment;

public interface Environment {

    void put(String name, Object value);
    Object get(String name);
}
