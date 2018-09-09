package com.github.stone_language.eval;

import com.github.stone_language.ast.ASTree;
import com.github.stone_language.context.exception.StoneException;
import com.github.stone_language.environment.Environment;
import com.github.stone_language.object.NativeFunction;
import javassist.gluonj.*;

import java.util.List;

@Require(FuncEvaluator.class)
@Reviser public class NativeEvaluator {
    @Reviser public static class NativeArgEx extends FuncEvaluator.ArgumentsEx {
        public NativeArgEx(List<ASTree> c) { super(c); }
        @Override public Object eval(Environment callerEnv, Object value) {
            if (!(value instanceof NativeFunction))
                return super.eval(callerEnv, value);

            NativeFunction func = (NativeFunction)value;
            int nparams = func.numOfParameters();
            if (size() != nparams)
                throw new StoneException("bad number of arguments", this);
            Object[] args = new Object[nparams];
            int num = 0;
            for (ASTree a: this) {
                BasicEvaluator.ASTreeEx ae = (BasicEvaluator.ASTreeEx)a;
                args[num++] = ae.eval(callerEnv);
            }
            return func.invoke(args, this);
        }
    }
}
