package com.github.stone_language.eval;

import com.github.stone_language.ast.ASTree;
import com.github.stone_language.ast.Closure;
import com.github.stone_language.ast.Function;
import com.github.stone_language.environment.Environment;
import javassist.gluonj.Require;
import javassist.gluonj.Reviser;

import java.util.List;

@Require(FuncEvaluator.class)
@Reviser
public class ClosureEvaluator {

    @Reviser public static class ClosureEx extends Closure {

        public ClosureEx(List<ASTree> c) {
            super(c);
        }

        public Object eval(Environment env) {
            return new Function(parameters(), body(), env);
        }
    }
}
