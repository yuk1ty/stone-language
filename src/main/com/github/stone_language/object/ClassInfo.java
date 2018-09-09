package com.github.stone_language.object;

import com.github.stone_language.ast.ClassBody;
import com.github.stone_language.ast.ClassStmnt;
import com.github.stone_language.context.exception.StoneException;
import com.github.stone_language.environment.Environment;

public class ClassInfo {

    protected final ClassStmnt definition;

    protected final Environment environment;

    protected final ClassInfo superClass;

    public ClassInfo(ClassStmnt cs, Environment env) {
        this.definition = cs;
        this.environment = env;
        Object obj = env.get(cs.superClass());
        if (obj == null) {
            this.superClass = null;
        } else if (obj instanceof ClassInfo) {
            this.superClass = (ClassInfo) obj;
        } else {
            throw new StoneException("unknown super class: " + cs.superClass(), cs);
        }
    }

    public String name() {
        return definition.name();
    }

    public ClassInfo superClass() {
        return superClass;
    }

    public ClassBody body() {
        return definition.body();
    }

    public Environment environment() {
        return environment;
    }

    @Override
    public String toString() {
        return "<class " + name() + ">";
    }
}
