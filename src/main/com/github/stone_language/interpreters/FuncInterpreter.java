package com.github.stone_language.interpreters;

import com.github.stone_language.environment.NestedEnv;
import com.github.stone_language.interpreters.BasicInterpreter;
import com.github.stone_language.parsers.FuncParser;

public class FuncInterpreter extends BasicInterpreter {

    public static void main(String[] args) throws Throwable {
        run(new FuncParser(), new NestedEnv());
    }
}
