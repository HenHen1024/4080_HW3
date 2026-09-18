```java
// Chapter 6 Challenge 2
// Add support for the C-style conditional/ternary operator ?:.
//
// Grammar:
//
// conditional → or ( "?" expression ":" conditional )? ;
//
// The ternary operator is right-associative.
//
// Example:
// a ? b : c ? d : e
//
// is interpreted as:
//
// a ? b : (c ? d : e)
//
// In Parser.java, assignment() should call conditional()
// instead of calling or() directly.

private Expr conditional() {
    Expr expr = or();

    if (match(QUESTION)) {
        Expr thenBranch = expression();

        consume(COLON,
            "Expect ':' after then branch of conditional expression.");

        // Calling conditional() here makes the operator right-associative.
        Expr elseBranch = conditional();

        expr = new Expr.Ternary(expr, thenBranch, elseBranch);
    }

    return expr;
}


// Add QUESTION and COLON to TokenType.java:
//
// QUESTION,
// COLON,


// Add these cases to Scanner.java:
//
// case '?': addToken(QUESTION); break;
// case ':': addToken(COLON); break;


// Add this class to Expr.java:
//
// static class Ternary extends Expr {
//     Ternary(Expr condition, Expr thenBranch, Expr elseBranch) {
//         this.condition = condition;
//         this.thenBranch = thenBranch;
//         this.elseBranch = elseBranch;
//     }
//
//     @Override
//     <R> R accept(Visitor<R> visitor) {
//         return visitor.visitTernaryExpr(this);
//     }
//
//     final Expr condition;
//     final Expr thenBranch;
//     final Expr elseBranch;
// }


// Add this visitor method to Expr.java:
//
// R visitTernaryExpr(Ternary expr);


// Add this method to Interpreter.java:
//
// @Override
// public Object visitTernaryExpr(Expr.Ternary expr) {
//     Object condition = evaluate(expr.condition);
//
//     if (isTruthy(condition)) {
//         return evaluate(expr.thenBranch);
//     } else {
//         return evaluate(expr.elseBranch);
//     }
// }
```
