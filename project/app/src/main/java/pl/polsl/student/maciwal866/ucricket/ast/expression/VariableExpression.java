package pl.polsl.student.maciwal866.ucricket.ast.expression;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.ASTNode;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.exception.VariableNotFoundException;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;
import pl.polsl.student.maciwal866.ucricket.ast.statement.VariableStatement;

@Getter
@AllArgsConstructor
public class VariableExpression implements Expression {
    private String name;
    private VariableStatement linkedVariable;

    public VariableExpression(String name) {
        this.name = name;
    }

    @Override
    public ASTNode solve() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'solve'");
    }

    @Override
    public Object resolve(Scoped parent) {
        if (!parent.hasVariable(name)) {
            throw new VariableNotFoundException(name);
        }
        this.linkedVariable = parent.getVariable(name);
        return this.linkedVariable.getType();
    }

}
