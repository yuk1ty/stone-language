package com.github.stone_language.parsers;

import com.github.stone_language.ast.ClassBody;
import com.github.stone_language.ast.ClassStmnt;
import com.github.stone_language.token.Token;

import static com.github.stone_language.parsers.Parser.rule;

public class ClassParser extends ClosureParser {

    protected final Parser member = rule(ClassBody.class).or(def, simple);

    protected final Parser classBody = rule(ClassBody.class).sep("{").option(member).repeat(rule().sep(";", Token.EOL).option(member)).sep("}");

    protected final Parser defClass = rule(ClassStmnt.class).sep("class").identifier(reserved).option(rule().sep("extends").identifier(reserved)).ast(classBody);

    public ClassParser() {
        postfix.insertChoice(rule().sep(".").identifier(reserved));
        program.insertChoice(defClass);
    }
}
