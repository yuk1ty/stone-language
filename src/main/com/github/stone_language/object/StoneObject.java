package com.github.stone_language.object;

import com.github.stone_language.context.exception.AccessException;
import com.github.stone_language.environment.Environment;
import com.github.stone_language.eval.FuncEvaluator;

public class StoneObject {

    protected final Environment env;

    public StoneObject(Environment e) {
        this.env = e;
    }

    public Object read(String member) throws AccessException {
        return getEnv(member).get(member);
    }

    public void write(String member, Object value) throws AccessException {
        ((FuncEvaluator.EnvEx) getEnv(member)).putNew(member, value);
    }

    protected Environment getEnv(String member) throws AccessException {
        Environment e = ((FuncEvaluator.EnvEx) env).where(member);

        if (e != null && e == env) {
            return e;
        } else {
            throw new AccessException();
        }
    }
}
