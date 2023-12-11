package pl.polsl.student.maciwal866.ucricket.ast.exception;

import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;

@Getter
public class MismatchedOperatorException extends RuntimeException {
    private Expression expression;

    public MismatchedOperatorException(Expression expression) {
        super("Mismatched type within expression:\n" + expression.toString());
        this.expression = expression;
    }
}
