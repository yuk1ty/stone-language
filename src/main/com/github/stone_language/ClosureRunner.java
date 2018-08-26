package com.github.stone_language;

import com.github.stone_language.eval.ClosureEvaluator;
import com.github.stone_language.interpreters.ClosureInterpreter;
import javassist.gluonj.util.Loader;

public class ClosureRunner {
    public static void main(String[] args) throws Throwable {
        Loader.run(ClosureInterpreter.class, args, ClosureEvaluator.class);
    }
}
