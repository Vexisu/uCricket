package pl.polsl.student.maciwal866.ucricket.ast.expression;

import java.util.stream.Stream;

import org.bytedeco.llvm.LLVM.*;
import static org.bytedeco.llvm.global.LLVM.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.ValueType;
import pl.polsl.student.maciwal866.ucricket.ast.exception.MismatchedOperatorException;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;

@Getter
public class BinaryExpression implements Expression {
    private Expression leftExpression;
    private Operator operator;
    private Expression rightExpression;
    private ValueType returnType;

    public BinaryExpression(Expression leftExpression, Operator operator, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.operator = operator;
        this.rightExpression = rightExpression;
    }

    @Getter
    @AllArgsConstructor
    public enum Operator {
        EQUAL(ValueType.ALL_TYPES),
        NOT_EQUAL(ValueType.ALL_TYPES),
        LESS(ValueType.NUMERIC_TYPES),
        GREATER(ValueType.NUMERIC_TYPES),
        LESS_EQUAL(ValueType.NUMERIC_TYPES),
        GREATER_EQUAL(ValueType.NUMERIC_TYPES),
        ADD(ValueType.NUMERIC_TYPES),
        SUBTRACT(ValueType.NUMERIC_TYPES),
        MULTIPLY(ValueType.NUMERIC_TYPES),
        DIVIDE(ValueType.NUMERIC_TYPES);

        private final ValueType[] compatibleWith;

        public boolean isCompatibleWith(ValueType valueType) {
            return Stream.of(compatibleWith).anyMatch(compatibleType -> valueType.equals(compatibleType));
        }
    }

    @Override
    public Object resolve(Scoped parent) {
        var resolverResultLeft = leftExpression.resolve(parent);
        var resolverResultRight = rightExpression.resolve(parent);
        if (resolverResultLeft instanceof ValueType leftValueType
                && resolverResultRight instanceof ValueType rightValueType) {
            if (!operator.isCompatibleWith(leftValueType) && !operator.isCompatibleWith(rightValueType)) {
                throw new MismatchedOperatorException(this);
            }
            returnType = ValueType.FLOAT.anyEquals(leftValueType, rightValueType) ? ValueType.FLOAT : rightValueType;
            return returnType;
        }
        throw new MismatchedOperatorException(this);
    }

    @Override
    public LLVMValueRef solve(LLVMBuilderRef builder, LLVMModuleRef module, LLVMContextRef context) {
        var isFloatingOperation = returnType.equals(ValueType.FLOAT);
        var llvmLeftExpression = leftExpression.solve(builder, module, context);
        var llvmRightExpression = rightExpression.solve(builder, module, context);
        return switch (operator) {
            case EQUAL -> isFloatingOperation
                    ? LLVMBuildFCmp(builder, LLVMRealOEQ, llvmLeftExpression, llvmRightExpression, "tmp")
                    : LLVMBuildICmp(builder, LLVMIntEQ, llvmLeftExpression, llvmRightExpression, "tmp");
            case NOT_EQUAL -> isFloatingOperation
                    ? LLVMBuildFCmp(builder, LLVMRealONE, llvmLeftExpression, llvmRightExpression, "tmp")
                    : LLVMBuildICmp(builder, LLVMIntNE, llvmLeftExpression, llvmRightExpression, "tmp");
            case LESS -> isFloatingOperation
                    ? LLVMBuildFCmp(builder, LLVMRealOLT, llvmLeftExpression, llvmRightExpression, "tmp")
                    : LLVMBuildICmp(builder, LLVMIntSLT, llvmLeftExpression, llvmRightExpression, "tmp");
            case GREATER -> isFloatingOperation
                    ? LLVMBuildFCmp(builder, LLVMRealOGT, llvmLeftExpression, llvmRightExpression, "tmp")
                    : LLVMBuildICmp(builder, LLVMIntSGT, llvmLeftExpression, llvmRightExpression, "tmp");
            case LESS_EQUAL -> isFloatingOperation
                    ? LLVMBuildFCmp(builder, LLVMRealOLE, llvmLeftExpression, llvmRightExpression, "tmp")
                    : LLVMBuildICmp(builder, LLVMIntSLE, llvmLeftExpression, llvmRightExpression, "tmp");
            case GREATER_EQUAL -> isFloatingOperation
                    ? LLVMBuildFCmp(builder, LLVMRealOGE, llvmLeftExpression, llvmRightExpression, "tmp")
                    : LLVMBuildICmp(builder, LLVMIntSGE, llvmLeftExpression, llvmRightExpression, "tmp");
            case ADD -> isFloatingOperation
                    ? LLVMBuildFAdd(builder, llvmLeftExpression, llvmRightExpression, "tmp")
                    : LLVMBuildAdd(builder, llvmLeftExpression, llvmRightExpression, "tmp");
            case SUBTRACT -> isFloatingOperation
                    ? LLVMBuildFSub(builder, llvmLeftExpression, llvmRightExpression, "tmp")
                    : LLVMBuildSub(builder, llvmLeftExpression, llvmRightExpression, "tmp");
            case MULTIPLY -> isFloatingOperation
                    ? LLVMBuildFMul(builder, llvmLeftExpression, llvmRightExpression, "tmp")
                    : LLVMBuildMul(builder, llvmLeftExpression, llvmRightExpression, "tmp");
            case DIVIDE -> isFloatingOperation
                    ? LLVMBuildFDiv(builder, llvmLeftExpression, llvmRightExpression, "tmp")
                    : LLVMBuildSDiv(builder, llvmLeftExpression, llvmRightExpression, "tmp");
            default -> null;
        };
    }
}
