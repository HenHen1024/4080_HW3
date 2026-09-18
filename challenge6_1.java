```java
// Chapter 6 Challenge 1
// Add support for comma expressions.

// Grammar:
// expression → comma ;
// comma → assignment ( "," assignment )* ;

// In Parser.java, change expression() to:
//
// private Expr expression() {
//     return comma();
// }

private Expr comma() {
    Expr expr = assignment();

    while (match(COMMA)) {
        Token operator = previous();
        Expr right = assignment();
        expr = new Expr.Binary(expr, operator, right);
    }

    return expr;
}
```
