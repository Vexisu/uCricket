package pl.polsl.student.maciwal866.ucricket.ast.expression;

import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.ASTNode;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.ValueType;
import pl.polsl.student.maciwal866.ucricket.ast.exception.MismatchedOperatorException;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;

@Getter
@AllArgsConstructor
public class BinaryExpression implements Expression {
    private Expression leftExpression;
    private Operator operator;
    private Expression rightExpression;

    @Getter
    @AllArgsConstructor
    public enum Operator {
        EQUAL(ValueType.ALL_TYPES),
        NOT_EQUAL(ValueType.ALL_TYPES),
        LESS(ValueType.NUMERIC_TYPES),
        GREATER(ValueType.NUMERIC_TYPES),
        LESS_EQUAL(ValueType.NUMERIC_TYPES),
        GREATER_EQUAL(ValueType.NUMERIC_TYPES),
        ADD(ValueType.NUMERIC_TYPES),
        SUBTRACT(ValueType.NUMERIC_TYPES),
        MULTIPLY(ValueType.NUMERIC_TYPES),
        DIVIDE(ValueType.NUMERIC_TYPES);

        private final ValueType[] compatibleWith;

        public boolean isCompatibleWith(ValueType valueType) {
            return Stream.of(compatibleWith).anyMatch(compatibleType -> valueType.equals(compatibleType));
        }
    }

    @Override
    public ASTNode solve() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'solve'");
    }

    @Override
    public Object resolve(Scoped parent) {
        var resolverResultLeft = leftExpression.resolve(parent);
        var resolverResultRight = rightExpression.resolve(parent);
        if (resolverResultLeft instanceof ValueType leftValueType
                && resolverResultRight instanceof ValueType rightValueType) {
            if (!operator.isCompatibleWith(leftValueType) && !operator.isCompatibleWith(rightValueType)) {
                throw new MismatchedOperatorException(this);
            }
            return rightValueType;
        }
        throw new MismatchedOperatorException(this);
    }
}
