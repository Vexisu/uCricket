package pl.polsl.student.maciwal866.ucricket.ast.statement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.ASTNode;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.Statement;
import pl.polsl.student.maciwal866.ucricket.ast.ValueType;
import pl.polsl.student.maciwal866.ucricket.ast.exception.MismatchedTypeException;
import pl.polsl.student.maciwal866.ucricket.ast.exception.VariableAlreadyExistsException;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;

@Getter
@AllArgsConstructor
public class VariableStatement implements Statement {
    private ValueType type;
    private String name;
    private Expression value;

    @Override
    public ASTNode solve() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'solve'");
    }

    @Override
    public Object resolve(Scoped parent) {
        if (parent.hasVariable(name)) {
            throw new VariableAlreadyExistsException(this);
        }
        if (value.resolve(parent) instanceof ValueType valueType && !valueType.equals(type)) {
            throw new MismatchedTypeException(valueType, this);
        }
        parent.addVariable(this);
        return null;
    }

}
