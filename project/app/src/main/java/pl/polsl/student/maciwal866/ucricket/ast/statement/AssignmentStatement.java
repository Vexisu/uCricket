package pl.polsl.student.maciwal866.ucricket.ast.statement;

import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.ASTNode;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.Statement;
import pl.polsl.student.maciwal866.ucricket.ast.ValueType;
import pl.polsl.student.maciwal866.ucricket.ast.exception.MismatchedTypeException;
import pl.polsl.student.maciwal866.ucricket.ast.exception.VariableNotFoundException;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;

@Getter
public class AssignmentStatement implements Statement {
    private String variableName;
    private Expression expression;
    private VariableStatement linkedVariable;

    public AssignmentStatement(String variableName, Expression expression) {
        this.variableName = variableName;
        this.expression = expression;
    }

    @Override
    public ASTNode solve() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'solve'");
    }

    @Override
    public Object resolve(Scoped parent) {
        this.linkedVariable = parent.getVariable(variableName);
        if (linkedVariable == null) {
            throw new VariableNotFoundException(variableName);
        }
        if (expression.resolve(parent) instanceof ValueType expressionValueType
                && !expressionValueType.equals(this.linkedVariable.getType())) {
            throw new MismatchedTypeException(expressionValueType, this);
        }
        return null;
    }

}
