package com.github.stone_language.interpreters;

import com.github.stone_language.environment.NestedEnv;
import com.github.stone_language.parsers.ClosureParser;

public class ClosureInterpreter extends BasicInterpreter {

    public static void main(String[] args) throws Throwable {
        run(new ClosureParser(), new NestedEnv());
    }
}
