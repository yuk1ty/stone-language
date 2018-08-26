package com.github.stone_language.environment;

import com.github.stone_language.eval.FuncEvaluator;

import java.util.HashMap;
import java.util.Map;

public class NestedEnv implements Environment {

    protected Map<String, Object> values;

    protected Environment outer;

    public NestedEnv() {
        this(null);
    }

    public NestedEnv(Environment env) {
        this.values = new HashMap<>();
        this.outer = env;
    }

    public void setOuter(Environment outer) {
        this.outer = outer;
    }

    @Override
    public void put(String name, Object value) {
        Environment env = where(name);
        if (env == null) {
            env = this;
        }
        ((FuncEvaluator.EnvEx) env).putNew(name, value);
    }

    public Object get(String name) {
        Object v = values.get(name);
        if (v == null && outer != null) {
            return outer.get(name);
        } else {
            return v;
        }
    }

    public void putNew(String name, Object value) {
       values.put(name, value);
    }

    public Environment where(String name) {
        if (values.get(name) != null) {
            return this;
        } else if (outer == null) {
            return null;
        } else {
            return ((FuncEvaluator.EnvEx) outer).where(name);
        }
    }
}
