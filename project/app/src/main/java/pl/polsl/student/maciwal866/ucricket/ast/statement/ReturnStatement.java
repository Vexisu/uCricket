package pl.polsl.student.maciwal866.ucricket.ast.statement;

import static org.bytedeco.llvm.global.LLVM.*;

import org.bytedeco.llvm.LLVM.*;

import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.Function;
import pl.polsl.student.maciwal866.ucricket.ast.Statement;
import pl.polsl.student.maciwal866.ucricket.ast.exception.MismatchedTypeException;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;

@Getter
public class ReturnStatement implements Statement {
    private Expression expression;
    private Function linkedFunction;

    public ReturnStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public Object resolve(Scoped parent) {
        var expressionType = expression.resolve(parent);
        var lookupParent = parent;
        while (!(lookupParent instanceof Function)) {
            lookupParent = lookupParent.getParent();
        }
        linkedFunction = (Function) lookupParent;
        if (!linkedFunction.getType().equals(expressionType)) {
            throw new MismatchedTypeException(linkedFunction.getType(), expression);
        }
        return expressionType;
    }

    @Override
    public void solve(LLVMBuilderRef builder, LLVMModuleRef module, LLVMContextRef context) {
        var llvmExpression = expression.solve(builder, module, context);
        LLVMBuildRet(builder, llvmExpression);
    }

}
