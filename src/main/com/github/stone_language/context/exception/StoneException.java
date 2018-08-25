package com.github.stone_language.context.exception;

import com.github.stone_language.ast.ASTree;

public class StoneException extends RuntimeException {

    public StoneException(String m) {
        super(m);
    }

    public StoneException(String m, ASTree t) {
        super(m + " " + t.location());
    }
}
