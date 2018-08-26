package com.github.stone_language;

import com.github.stone_language.ast.ASTree;
import com.github.stone_language.ast.NullStmnt;
import com.github.stone_language.context.exception.ParseException;
import com.github.stone_language.environment.BasicEnv;
import com.github.stone_language.environment.Environment;
import com.github.stone_language.eval.BasicEvaluator;
import com.github.stone_language.parsers.BasicParser;
import com.github.stone_language.token.Token;

public class BasicInterpreter {

    public static void main(String[] args) throws ParseException {
        run(new BasicParser(), new BasicEnv());
    }

    private static void run(BasicParser bp, Environment env) throws ParseException {
        Lexer lexer = new Lexer(new CodeDialog());
        while (lexer.peek(0) != Token.EOF) {
            ASTree t = bp.parse(lexer);
            if (!(t instanceof NullStmnt)) {
                Object r = ((BasicEvaluator.ASTreeEx) t).eval(env);
                System.out.println("=> " + r);
            }
        }
    }
}
