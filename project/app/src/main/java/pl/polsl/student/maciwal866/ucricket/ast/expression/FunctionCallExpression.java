package pl.polsl.student.maciwal866.ucricket.ast.expression;

import static org.bytedeco.llvm.global.LLVM.LLVMBuildCall2;
import static org.bytedeco.llvm.global.LLVM.LLVMBuildCallBr;
import static org.bytedeco.llvm.global.LLVM.LLVMCreateBuilderInContext;
import static org.bytedeco.llvm.global.LLVM.LLVMDisposeBuilder;
import static org.bytedeco.llvm.global.LLVM.LLVMFunctionType;
import static org.bytedeco.llvm.global.LLVM.LLVMGetInsertBlock;
import static org.bytedeco.llvm.global.LLVM.LLVMGetNamedFunction;

import java.util.ArrayList;

import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.llvm.LLVM.*;

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
        linkedFunction = parent.getFunction(functionName, argumentTypes);
        if (this.linkedFunction == null) {
            throw new FunctionNotFoundException(functionName, argumentTypes);
        }
        linkedFunction.setCalled(true);
        return linkedFunction.getType();
    }

    @Override
    public LLVMValueRef solve(LLVMBuilderRef builder, LLVMModuleRef module, LLVMContextRef context) {
        if (linkedFunction.getLlvmFunction() == null) {
            System.out.println("Delegating function build process to " + functionName + "().");
            var delegatedBuilder = LLVMCreateBuilderInContext(context);
            linkedFunction.solve(delegatedBuilder, module, context);
            LLVMDisposeBuilder(delegatedBuilder);
        }
        var argumentExpressions = new Expression[0];
        if (arguments != null) {
            argumentExpressions = arguments.collect();
        }
        var llvmArguments = new PointerPointer<LLVMTypeRef>(argumentExpressions.length);
        for (int i = 0; i < argumentExpressions.length; i++) {
            llvmArguments.put(argumentExpressions[i].solve(builder, module, context));
        }
        return LLVMBuildCall2(builder, linkedFunction.getLlvmFunctionType(), LLVMGetNamedFunction(module, functionName),
                llvmArguments, argumentExpressions.length, linkedFunction.getType().equals(ValueType.NONE) ? "" : functionName + "_ret");
    }

}
