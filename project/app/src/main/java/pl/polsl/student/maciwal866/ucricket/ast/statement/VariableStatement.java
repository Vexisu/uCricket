package pl.polsl.student.maciwal866.ucricket.ast.statement;

import static org.bytedeco.llvm.global.LLVM.LLVMAddGlobal;
import static org.bytedeco.llvm.global.LLVM.LLVMBuildAlloca;
import static org.bytedeco.llvm.global.LLVM.LLVMBuildStore;
import static org.bytedeco.llvm.global.LLVM.LLVMSetInitializer;

import org.bytedeco.llvm.LLVM.LLVMBuilderRef;
import org.bytedeco.llvm.LLVM.LLVMContextRef;
import org.bytedeco.llvm.LLVM.LLVMModuleRef;
import org.bytedeco.llvm.LLVM.LLVMValueRef;

import lombok.Getter;
import lombok.Setter;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.Statement;
import pl.polsl.student.maciwal866.ucricket.ast.ValueType;
import pl.polsl.student.maciwal866.ucricket.ast.exception.VariableAlreadyExistsException;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;

@Getter
public class VariableStatement implements Statement {
    ValueType valueType;
    String name;
    Expression value;
    LLVMValueRef llvmVariable;
    Scoped parent;
    @Setter
    boolean accessed;
    @Setter
    boolean global;
    @Setter
    boolean resolved;

    public VariableStatement(ValueType valueType, String name, Expression value) {
        this.valueType = valueType;
        this.name = name;
        this.value = value;
    }

    @Override
    public Object resolve(Scoped parent) {
        this.parent = parent;
        if (parent.hasResolvedVariable(name)) {
            throw new VariableAlreadyExistsException(this);
        }
        resolved = true;
        parent.addVariable(this);
        return null;
    }

    @Override
    public void solve(LLVMBuilderRef builder, LLVMModuleRef module, LLVMContextRef context) {
        if (accessed) {
            if (global) {
                llvmVariable = LLVMAddGlobal(module, valueType.getLlvmType(context), parent.getPath() + '_' + name);
                LLVMSetInitializer(llvmVariable, value.solve(builder, module, context));
            } else {
                llvmVariable = LLVMBuildAlloca(builder, valueType.getLlvmType(context), parent.getPath() + '_' + name);
                var llvmValue = value.solve(builder, module, context);
                LLVMBuildStore(builder, llvmValue, llvmVariable);
            }
        }
    }

}
