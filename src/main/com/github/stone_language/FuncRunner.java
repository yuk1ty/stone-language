package com.github.stone_language;

import com.github.stone_language.eval.FuncEvaluator;
import javassist.gluonj.util.Loader;

public class FuncRunner {
    public static void main(String[] args) throws Throwable {
        Loader.run(FuncInterpreter.class, args, FuncEvaluator.class);
    }
}
