package pl.polsl.student.maciwal866.ucricket.ast.statement;

import static org.bytedeco.llvm.global.LLVM.LLVMAddGlobal;
import static org.bytedeco.llvm.global.LLVM.LLVMBuildAlloca;
import static org.bytedeco.llvm.global.LLVM.LLVMBuildStore;
import static org.bytedeco.llvm.global.LLVM.LLVMSetInitializer;

import org.bytedeco.llvm.LLVM.LLVMBuilderRef;
import org.bytedeco.llvm.LLVM.LLVMContextRef;
import org.bytedeco.llvm.LLVM.LLVMModuleRef;

import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.AssignmentType;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.ValueType;
import pl.polsl.student.maciwal866.ucricket.ast.exception.MismatchedTypeException;
import pl.polsl.student.maciwal866.ucricket.ast.exception.VariableAlreadyExistsException;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;

@Getter
public class PointerStatement extends VariableStatement {
    private AssignmentType assignmentType;

    public PointerStatement(ValueType valueType, String name, AssignmentType assignmentType, Expression value) {
        super(valueType, name, value);
        this.assignmentType = assignmentType;
    }

    @Override
    public Object resolve(Scoped parent) {
        super.parent = parent;
        if (parent.hasResolvedVariable(name)) {
            throw new VariableAlreadyExistsException(this);
        }
        if (value.resolve(parent) instanceof ValueType valueType) {
            if (assignmentType.equals(AssignmentType.ADDRESS) && !valueType.equals(ValueType.INTEGER)) {
                throw new MismatchedTypeException(valueType, this);
            }
            if (!valueType.equals(valueType)) {
                throw new MismatchedTypeException(valueType, this);
            }
        }
        resolved = true;
        parent.addVariable(this);
        return null;
    }

    @Override
    public void solve(LLVMBuilderRef builder, LLVMModuleRef module, LLVMContextRef context) {
        if (accessed) {
            switch (assignmentType) {
                case ADDRESS:
                    if (global) {
                        llvmVariable = LLVMAddGlobal(module, ValueType.INTEGER.getLlvmType(context),
                                parent.getPath() + ':' + name);
                        LLVMSetInitializer(llvmVariable, value.solve(builder, module, context));
                    } else {
                        llvmVariable = LLVMBuildAlloca(builder, ValueType.INTEGER.getLlvmType(context),
                                parent.getPath() + ':' + name);
                        var llvmValue = value.solve(builder, module, context);
                        LLVMBuildStore(builder, llvmValue, llvmVariable);
                    }
                    break;
                case VALUE:
                    if (global) {
                        
                    } else {
                        var llvmAllocatedVariable = LLVMBuildAlloca(builder, valueType.getLlvmType(context),
                                parent.getPath() + ':' + name);
                        var llvmValue = value.solve(builder, module, context);
                        LLVMBuildStore(builder, llvmValue, llvmVariable);
                        llvmVariable = LLVMBuildAlloca(builder, ValueType.POINTER.getLlvmType(context),
                                parent.getPath() + ':' + name + "_addr");
                        LLVMBuildStore(builder, llvmAllocatedVariable, llvmVariable);
                    }
                default:
                    break;
            }
        }
    }

}
