package pl.polsl.student.maciwal866.ucricket.ast.expression;

import static org.bytedeco.llvm.global.LLVM.*;
import org.bytedeco.llvm.LLVM.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.ValueType;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;

@Getter
@AllArgsConstructor
public class ValueExpression implements Expression {
    private Object value;
    private ValueType type;

    @Override
    public Object resolve(Scoped parent) {
        return type;
    }

    @Override
    public LLVMValueRef solve(LLVMBuilderRef builder, LLVMModuleRef module, LLVMContextRef context) {
        if (value instanceof String literalValue) { 
            return switch (type) {
                case INTEGER -> LLVMConstInt(type.getLlvmType(context), Long.parseLong(literalValue), 0);
                case FLOAT -> LLVMConstReal(type.getLlvmType(context), Double.parseDouble(literalValue));
                case BOOLEAN ->
                    LLVMConstInt(type.getLlvmType(context), literalValue.equalsIgnoreCase("true") ? 1 : 0, 0);
                default -> null;
            };
        }
        return null;
    }
}
