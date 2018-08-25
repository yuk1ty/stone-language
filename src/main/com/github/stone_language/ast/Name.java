package com.github.stone_language.ast;

import com.github.stone_language.token.Token;

public class Name extends ASTLeaf {

    public Name(Token t) {
        super(t);
    }

    public String name() {
        return token().getText();
    }
}
