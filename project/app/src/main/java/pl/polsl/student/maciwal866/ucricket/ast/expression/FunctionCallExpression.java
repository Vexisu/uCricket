package pl.polsl.student.maciwal866.ucricket.ast.expression;

import org.bytedeco.llvm.LLVM.LLVMBuilderRef;
import org.bytedeco.llvm.LLVM.LLVMModuleRef;
import org.bytedeco.llvm.LLVM.LLVMValueRef;

import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.Function;
import pl.polsl.student.maciwal866.ucricket.ast.ValueType;
import pl.polsl.student.maciwal866.ucricket.ast.exception.FunctionNotFoundException;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;

@Getter
public class FunctionCallExpression implements Expression {
    private String functionName;
    private ArgumentsExpression arguments;
    private Function linkedFunction;
    
    public FunctionCallExpression(String functionName, ArgumentsExpression arguments) {
        this.functionName = functionName;
        this.arguments = arguments;
    }

    @Override
    public Object resolve(Scoped parent) {
        var argumentTypes = new ValueType[0];
        if (arguments != null && arguments.resolve(parent) instanceof ValueType[] resolvedArgumentTypes) {
            argumentTypes = resolvedArgumentTypes;
        }
        this.linkedFunction = parent.getFunction(functionName, argumentTypes);
        if (this.linkedFunction == null) {
            throw new FunctionNotFoundException(functionName, argumentTypes);
        }
        return linkedFunction.getType();
    }

    @Override
    public LLVMValueRef solve(LLVMBuilderRef builder, LLVMModuleRef module) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'solve'");
    }

}
