package pl.polsl.student.maciwal866.ucricket.ast.expression;

import java.util.ArrayList;

import org.bytedeco.llvm.LLVM.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.ValueType;
import pl.polsl.student.maciwal866.ucricket.ast.exception.MismatchedOperatorException;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;

@Getter
@AllArgsConstructor
public class ArgumentsExpression implements Expression {
    private Expression expression;
    private ArgumentsExpression next;

    @Override
    public Object resolve(Scoped parent) {
        var argumentTypes = new ArrayList<ValueType>();
        var currentArgument = this;
        while (currentArgument != null) {
            var resolverResult = currentArgument.getExpression().resolve(parent);
            if (resolverResult instanceof ValueType resolvedType) {
                argumentTypes.add(resolvedType);
            } else {
                throw new MismatchedOperatorException(currentArgument);
            }
            currentArgument = currentArgument.getNext();
        }
        return argumentTypes.toArray(ValueType[]::new);
    }

    @Override
    public LLVMValueRef solve(LLVMBuilderRef builder, LLVMModuleRef module, LLVMContextRef context) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'solve'");
    }

}
