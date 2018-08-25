package com.github.stone_language.ast;

import com.github.stone_language.token.Token;

public class NumberLiteral extends ASTLeaf {

    public NumberLiteral(Token t) {
        super(t);
    }

    public int value() {
        return token().getNumber();
    }
}
