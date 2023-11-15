package pl.polsl.student.maciwal866.ucricket.ast.expression;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.ASTNode;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;

@Getter
@AllArgsConstructor
public class UnaryExpression implements Expression {
    private Expression expression;
    private Type type;

    public enum Type {
        PARENTHESIS,
        LOGICAL_NEGATION,
        ARITHMETICAL_NEGATION
    }

    @Override
    public ASTNode solve() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'solve'");
    }
}
