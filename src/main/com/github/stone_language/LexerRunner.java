package com.github.stone_language;

import com.github.stone_language.context.exception.ParseException;
import com.github.stone_language.lexer.Lexer;
import com.github.stone_language.token.Token;

public class LexerRunner {

    public static void main(String[] args) throws ParseException {
        Lexer lexer = new Lexer(new CodeDialog());
        for (Token t; (t = lexer.read()) != Token.EOF; ) {
            System.out.println("=> " + t.getText());
        }
    }
}
