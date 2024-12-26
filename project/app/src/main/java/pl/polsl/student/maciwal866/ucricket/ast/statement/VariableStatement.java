package pl.polsl.student.maciwal866.ucricket.ast.statement;

import static org.bytedeco.llvm.global.LLVM.*;
import org.bytedeco.llvm.LLVM.*;

import lombok.Getter;
import lombok.Setter;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.Statement;
import pl.polsl.student.maciwal866.ucricket.ast.ValueType;
import pl.polsl.student.maciwal866.ucricket.ast.exception.MismatchedTypeException;
import pl.polsl.student.maciwal866.ucricket.ast.exception.VariableAlreadyExistsException;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;

@Getter
public class VariableStatement implements Statement {
    private ValueType type;
    private String name;
    private Expression value;
    private LLVMValueRef llvmVariable;
    private Scoped parent;
    @Setter
    private boolean accessed;
    @Setter
    private boolean global;

    public VariableStatement(ValueType type, String name, Expression value) {
        this.type = type;
        this.name = name;
        this.value = value;
    }

    @Override
    public Object resolve(Scoped parent) {
        this.parent = parent;
        if (parent.hasVariable(name)) {
            throw new VariableAlreadyExistsException(this);
        }
        if (value.resolve(parent) instanceof ValueType valueType && !valueType.equals(type)) {
            throw new MismatchedTypeException(valueType, this);
        }
        parent.addVariable(this);
        return null;
    }

    @Override
    public void solve(LLVMBuilderRef builder, LLVMModuleRef module, LLVMContextRef context) {
        if (accessed) {
            if (global) {
                llvmVariable = LLVMAddGlobal(module, type.getLlvmType(context), parent.getPath() + ':' + name);
                LLVMSetInitializer(llvmVariable, value.solve(builder, module, context));
            } else {
                llvmVariable = LLVMBuildAlloca(builder, type.getLlvmType(context), parent.getPath() + ':' + name);
                var llvmValue = value.solve(builder, module, context);
                LLVMBuildStore(builder, llvmValue, llvmVariable);
            }
        }
    }

}
