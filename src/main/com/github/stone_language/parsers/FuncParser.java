package com.github.stone_language.parsers;

import com.github.stone_language.ast.Arguments;
import com.github.stone_language.ast.DefStmnt;
import com.github.stone_language.ast.ParameterList;

import static com.github.stone_language.parsers.Parser.rule;

public class FuncParser extends BasicParser {

    private final Parser param = rule().identifier(reserved);

    private final Parser params = rule(ParameterList.class).ast(param).repeat(rule().sep(",").ast(param));

    protected final Parser paramList = rule().sep("(").maybe(params).sep(")");

    protected final Parser def = rule(DefStmnt.class).sep("def").identifier(reserved).ast(paramList).ast(block);

    private final Parser args = rule(Arguments.class).ast(expr).repeat(rule().sep(",").ast(expr));

    protected final Parser postfix = rule().sep("(").maybe(args).sep(")");

    public FuncParser() {
        reserved.add(")");
        primary.repeat(postfix);
        simple.option(args);
        program.insertChoice(def);
    }
}
