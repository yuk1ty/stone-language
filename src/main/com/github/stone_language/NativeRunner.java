package com.github.stone_language;

import com.github.stone_language.eval.ClosureEvaluator;
import com.github.stone_language.eval.NativeEvaluator;
import com.github.stone_language.interpreters.NativeInterpreter;
import javassist.gluonj.util.Loader;

public class NativeRunner {

    public static void main(String[] args) throws Throwable {
        Loader.run(NativeInterpreter.class, args, NativeEvaluator.class, ClosureEvaluator.class);
    }
}
