package com.github.stone_language.interpreters;

import com.github.stone_language.context.exception.ParseException;
import com.github.stone_language.environment.NestedEnv;
import com.github.stone_language.natives.Natives;
import com.github.stone_language.parsers.ClosureParser;

public class NativeInterpreter extends BasicInterpreter {

    public static void main(String[] args) throws ParseException {
        run(new ClosureParser(), new Natives().environment(new NestedEnv()));
    }
}
