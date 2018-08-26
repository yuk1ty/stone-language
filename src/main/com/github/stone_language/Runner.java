package com.github.stone_language;

import com.github.stone_language.eval.BasicEvaluator;
import javassist.gluonj.util.Loader;

public class Runner {

    public static void main(String[] args) throws Throwable {
        Loader.run(BasicInterpreter.class, args, BasicEvaluator.class);
    }
}
