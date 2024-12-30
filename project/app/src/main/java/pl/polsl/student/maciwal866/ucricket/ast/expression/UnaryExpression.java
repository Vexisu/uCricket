package pl.polsl.student.maciwal866.ucricket.ast.expression;

import static org.bytedeco.llvm.global.LLVM.*;
import org.bytedeco.llvm.LLVM.*;

import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.ValueType;
import pl.polsl.student.maciwal866.ucricket.ast.exception.MismatchedOperatorException;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;

@Getter
public class UnaryExpression implements Expression {
    private Expression expression;
    private Type expressionType;
    private ValueType returnType;
    
    public UnaryExpression(Expression expression, Type expressionType) {
        this.expression = expression;
        this.expressionType = expressionType;
    }

    public enum Type {
        PARENTHESIS,
        LOGICAL_NEGATION,
        ARITHMETICAL_NEGATION
    }

    @Override
    public Object resolve(Scoped parent) {
        var resolverResult = expression.resolve(parent);
        if (expressionType.equals(Type.PARENTHESIS)) {
            return resolverResult;
        }
        if (resolverResult instanceof ValueType resolvedType) {
            returnType = resolvedType;
            if (resolvedType.equals(ValueType.BOOLEAN) && expressionType.equals(Type.LOGICAL_NEGATION)) {
                return resolverResult;
            }
            if ((resolvedType.equals(ValueType.INTEGER) || resolvedType.equals(ValueType.FLOAT))
                    && expressionType.equals(Type.ARITHMETICAL_NEGATION)) {
                return resolverResult;
            }
        }
        throw new MismatchedOperatorException((Expression) this);
    }

    @Override
    public LLVMValueRef solve(LLVMBuilderRef builder, LLVMModuleRef module, LLVMContextRef context) {
        var llvmExpression = expression.solve(builder, module, context);
        switch (expressionType) {
            case PARENTHESIS:
                return llvmExpression; 
            case ARITHMETICAL_NEGATION:
                return switch(returnType) {
                    case FLOAT -> LLVMBuildFNeg(builder, llvmExpression, "tmp");
                    default -> LLVMBuildNeg(builder, llvmExpression, "tmp");
                };
            case LOGICAL_NEGATION:
                return LLVMBuildNot(builder, llvmExpression, "tmp");
            default:
                return null;
        }
    }
}
