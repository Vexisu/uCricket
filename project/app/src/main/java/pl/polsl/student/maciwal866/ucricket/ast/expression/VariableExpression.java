package pl.polsl.student.maciwal866.ucricket.ast.expression;

import static org.bytedeco.llvm.global.LLVM.LLVMBuildLoad2;
import static org.bytedeco.llvm.global.LLVM.LLVMGetElementType;

import org.bytedeco.llvm.LLVM.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.exception.VariableNotFoundException;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;
import pl.polsl.student.maciwal866.ucricket.ast.statement.PointerStatement;
import pl.polsl.student.maciwal866.ucricket.ast.statement.VariableStatement;

@Getter
@AllArgsConstructor
public class VariableExpression implements Expression {
    private String name;
    private VariableStatement linkedVariable;

    public VariableExpression(String name) {
        this.name = name;
    }

    @Override
    public Object resolve(Scoped parent) {
        if (!parent.hasVariable(name)) {
            throw new VariableNotFoundException(name);
        }
        linkedVariable = parent.getVariable(name);
        linkedVariable.setAccessed(true);
        return linkedVariable.getValueType();
    }

    @Override
    public LLVMValueRef solve(LLVMBuilderRef builder, LLVMModuleRef module, LLVMContextRef context) {
        if (linkedVariable instanceof PointerStatement linkedPointer) {
            var address = LLVMBuildLoad2(builder, linkedVariable.getValueType().pointerOf(context),
                    linkedPointer.getLlvmVariable(), name + "_ptr");
            return LLVMBuildLoad2(builder, linkedVariable.getValueType().getLlvmType(context),
                    address, name);
        }
        return LLVMBuildLoad2(builder, linkedVariable.getValueType().getLlvmType(context),
                linkedVariable.getLlvmVariable(),
                name);
    }

}
