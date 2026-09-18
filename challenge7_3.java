// Chapter 6 Challenge 3
// Change in Interpreter.java, inside visitBinaryExpr():

case SLASH:
  checkNumberOperands(expr.operator, left, right);

  // Report a runtime error when dividing by zero.
  if ((double)right == 0) {
    throw new RuntimeError(expr.operator,
        "Cannot divide by zero.");
  }

  return (double)left / (double)right;
