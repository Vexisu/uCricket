package pl.polsl.student.maciwal866.ucricket.ast.expression;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.ASTNode;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;

@Getter
@AllArgsConstructor
public class BinaryExpression implements Expression {
    private Expression leftExpression;
    private Operator operator;
    private Expression rightExpression;

    public enum Operator {
        EQUAL,
        NOT_EQUAL,
        LESS,
        GREATER,
        LESS_EQUAL,
        GREATER_EQUAL,
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE
    }

    @Override
    public ASTNode solve() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'solve'");
    }
}
