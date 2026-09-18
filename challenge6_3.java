```java
// Chapter 6 Challenge 3
// Detect binary operators appearing without a left-hand operand.
//
// These checks should be added at the beginning of the
// corresponding parsing methods in Parser.java.


// In equality():
//
// if (match(BANG_EQUAL, EQUAL_EQUAL)) {
//     Token operator = previous();
//     error(operator, "Expect left operand before operator.");
//
//     // Parse and discard the right operand using the
//     // appropriate precedence.
//     comparison();
//
//     return new Expr.Literal(null);
// }


// In comparison():
//
// if (match(GREATER, GREATER_EQUAL, LESS, LESS_EQUAL)) {
//     Token operator = previous();
//     error(operator, "Expect left operand before operator.");
//
//     // Parse and discard the right operand.
//     term();
//
//     return new Expr.Literal(null);
// }


// In term():
//
// if (match(PLUS)) {
//     Token operator = previous();
//     error(operator, "Expect left operand before operator.");
//
//     // Parse and discard the right operand using factor()
//     // because + has term-level precedence.
//     factor();
//
//     return new Expr.Literal(null);
// }


// In factor():
//
// if (match(SLASH, STAR)) {
//     Token operator = previous();
//     error(operator, "Expect left operand before operator.");
//
//     // Parse and discard the right operand using unary().
//     unary();
//
//     return new Expr.Literal(null);
// }


// Note:
// '-' is not handled here because '-' can also be a valid
// unary operator in Lox:
//
//     -123
//
// So the unary() rule should continue to handle MINUS normally.
```
