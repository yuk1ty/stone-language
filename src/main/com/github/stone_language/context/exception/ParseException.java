package com.github.stone_language.context.exception;

import com.github.stone_language.token.Token;

import java.io.IOException;

public class ParseException extends Exception {

    public ParseException(Token t) {
        this("", t);
    }

    public ParseException(String msg, Token t) {
        super("syntax error arounnd " + location(t) + ". " + msg);
    }

    private static String location(Token t) {
        if (t.equals(Token.EOF)) {
            return "the last line";
        } else {
            return t.getText() + " at line " + t.getLineNumber();
        }
    }

    public ParseException(IOException e) {
        super(e);
    }

    public ParseException(String m) {
        super(m);
    }
}
