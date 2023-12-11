package pl.polsl.student.maciwal866.ucricket.ast.statement;

import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.ASTNode;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.Statement;
import pl.polsl.student.maciwal866.ucricket.ast.StatementChain;
import pl.polsl.student.maciwal866.ucricket.ast.ValueType;
import pl.polsl.student.maciwal866.ucricket.ast.exception.MismatchedTypeException;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;

@Getter
@AllArgsConstructor
public class IfStatement implements Statement {
    private Expression condition;
    private StatementChain statements;

    @Override
    public ASTNode solve() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'solve'");
    }

    @Override
    public Object resolve(Scoped parent) {
        var resolverConditionResult = condition.resolve(parent);
        if (resolverConditionResult instanceof ValueType conditionValueType) {
            if (Stream.of(ValueType.LOGIC_TYPES).anyMatch(logicType -> logicType.equals(conditionValueType))) {
                throw new MismatchedTypeException(conditionValueType, this);
            }
        }
        if (statements != null) {
            statements.resolve(parent);
        }
        return null;
    }
}