package pl.polsl.student.maciwal866.ucricket.ast.expression;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.ASTNode;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.ValueType;
import pl.polsl.student.maciwal866.ucricket.ast.exception.FunctionNotFoundException;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;

@Getter
@AllArgsConstructor
public class FunctionCallExpression implements Expression {
    public String functionName;
    public ArgumentsExpression arguments;

    @Override
    public ASTNode solve() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'solve'");
    }

    @Override
    public Object resolve(Scoped parent) {
        var argumentTypes = new ValueType[0];
        if (arguments != null && arguments.resolve(parent) instanceof ValueType[] resolvedArgumentTypes) {
            argumentTypes = resolvedArgumentTypes;
        }
        var calledFunction = parent.getFunction(functionName, argumentTypes);
        if (calledFunction == null) {
            throw new FunctionNotFoundException(functionName, argumentTypes);
        }
        return calledFunction.getType();
    }

}
