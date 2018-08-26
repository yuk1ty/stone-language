package com.github.stone_language.eval;

import com.github.stone_language.ast.ASTLeaf;
import com.github.stone_language.ast.ASTList;
import com.github.stone_language.ast.ASTree;
import com.github.stone_language.context.exception.StoneException;
import com.github.stone_language.environment.Environment;
import com.github.stone_language.token.Token;
import javassist.gluonj.Reviser;

import java.util.List;

@Reviser public class BasicEvaluator {

   @Reviser public static abstract class ASTreeEx extends ASTree {
       public abstract Object eval(Environment env);
   }

   @Reviser public static class ASTListEx extends ASTList {

       public ASTListEx(List<ASTree> c) {
           super(c);
       }

       public Object eval(Environment env) {
           throw new StoneException("cannot eval: " + toString(), this);
       }
   }

   @Reviser public static class ASTLeafEx extends ASTLeaf {

       public ASTLeafEx(Token t) {
           super(t);
       }

       public Object eval(Environment env) {
           throw new StoneException("cannot eval: " + toString(), this);
       }
   }
}
