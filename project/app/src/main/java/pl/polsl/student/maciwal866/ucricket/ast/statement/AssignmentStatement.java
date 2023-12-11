package pl.polsl.student.maciwal866.ucricket.ast.statement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.ASTNode;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.Statement;
import pl.polsl.student.maciwal866.ucricket.ast.ValueType;
import pl.polsl.student.maciwal866.ucricket.ast.exception.MismatchedTypeException;
import pl.polsl.student.maciwal866.ucricket.ast.exception.VariableNotFoundException;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;

@Getter
@AllArgsConstructor
public class AssignmentStatement implements Statement {
    private String variableName;
    private Expression expression;

    @Override
    public ASTNode solve() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'solve'");
    }

    @Override
    public Object resolve(Scoped parent) {
        var variableInScope = parent.getVariable(variableName);
        if (variableInScope == null) {
            throw new VariableNotFoundException(variableName);
        }
        if (expression.resolve(parent) instanceof ValueType expressionValueType
                && !expressionValueType.equals(variableInScope.getType())) {
            throw new MismatchedTypeException(expressionValueType, this);
        }
        return null;
    }

}
