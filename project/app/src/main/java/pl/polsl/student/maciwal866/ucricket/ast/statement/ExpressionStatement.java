package pl.polsl.student.maciwal866.ucricket.ast.statement;

import org.bytedeco.llvm.LLVM.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.Statement;
import pl.polsl.student.maciwal866.ucricket.ast.ValueType;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;

@Getter
@AllArgsConstructor
public class ExpressionStatement implements Statement {
    private Expression expression;

    @Override
    public void solve(LLVMBuilderRef builder, LLVMModuleRef module, LLVMContextRef context) {
        expression.solve(builder, module, context);
    }

    @Override
    public Object resolve(Scoped parent) {
        if (expression.resolve(parent) instanceof ValueType expressionValueType) {
            return expressionValueType;
        }
        return null;
    }

}
