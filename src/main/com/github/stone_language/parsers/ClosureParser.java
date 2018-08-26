package com.github.stone_language.parsers;

import com.github.stone_language.ast.Closure;

import static com.github.stone_language.parsers.Parser.rule;

public class ClosureParser extends FuncParser {

    public ClosureParser() {
        primary.insertChoice(rule(Closure.class).sep("fn").ast(paramList).ast(block));
    }
}
