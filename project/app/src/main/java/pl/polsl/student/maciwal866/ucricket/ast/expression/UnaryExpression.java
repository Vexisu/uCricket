package pl.polsl.student.maciwal866.ucricket.ast.expression;

import org.bytedeco.llvm.LLVM.LLVMBuilderRef;
import org.bytedeco.llvm.LLVM.LLVMModuleRef;
import org.bytedeco.llvm.LLVM.LLVMValueRef;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.ValueType;
import pl.polsl.student.maciwal866.ucricket.ast.exception.MismatchedOperatorException;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;

@Getter
@AllArgsConstructor
public class UnaryExpression implements Expression {
    private Expression expression;
    private Type type;

    public enum Type {
        PARENTHESIS,
        LOGICAL_NEGATION,
        ARITHMETICAL_NEGATION
    }

    @Override
    public Object resolve(Scoped parent) {
        var resolverResult = expression.resolve(parent);
        if (type.equals(Type.PARENTHESIS)) {
            return resolverResult;
        }
        if (resolverResult instanceof ValueType resolvedType) {
            if (resolvedType.equals(ValueType.BOOLEAN) && type.equals(Type.LOGICAL_NEGATION)) {
                return resolverResult;
            }
            if ((resolvedType.equals(ValueType.INTEGER) || resolvedType.equals(ValueType.FLOAT))
                    && type.equals(Type.ARITHMETICAL_NEGATION)) {
                return resolverResult;
            }
        }
        throw new MismatchedOperatorException((Expression) this);
    }

    @Override
    public LLVMValueRef solve(LLVMBuilderRef builder, LLVMModuleRef module) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'solve'");
    }
}
