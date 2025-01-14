package pl.polsl.student.maciwal866.ucricket.ast.statement;

import static org.bytedeco.llvm.global.LLVM.LLVMAddGlobal;
import static org.bytedeco.llvm.global.LLVM.LLVMBuildAlloca;
import static org.bytedeco.llvm.global.LLVM.LLVMBuildStore;
import static org.bytedeco.llvm.global.LLVM.LLVMConstIntToPtr;
import static org.bytedeco.llvm.global.LLVM.LLVMPointerType;
import static org.bytedeco.llvm.global.LLVM.LLVMSetInitializer;
import static org.bytedeco.llvm.global.LLVM.LLVMTypeOf;

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
                        llvmVariable = LLVMAddGlobal(module, valueType.pointerOf(context),
                                parent.getPath() + '_' + name + "_ptr");
                        LLVMSetInitializer(llvmVariable,
                                LLVMConstIntToPtr(value.solve(builder, module, context), LLVMTypeOf(llvmVariable)));
                    } else {
                        llvmVariable = LLVMBuildAlloca(builder, valueType.pointerOf(context),
                                parent.getPath() + '_' + name + "_ptr");
                        LLVMBuildStore(builder,
                                LLVMConstIntToPtr(value.solve(builder, module, context), LLVMTypeOf(llvmVariable)),
                                llvmVariable);
                    }
                    break;
                case VALUE:
                    if (global) {
                        var llvmAllocatedVariable = LLVMAddGlobal(module, valueType.getLlvmType(context),
                                parent.getPath() + '_' + name);
                        LLVMSetInitializer(llvmAllocatedVariable, value.solve(builder, module, context));
                        llvmVariable = LLVMAddGlobal(module, valueType.pointerOf(),
                                parent.getPath() + '_' + name + "_ptr");
                        LLVMSetInitializer(llvmVariable, llvmAllocatedVariable);
                    } else {
                        var llvmAllocatedVariable = LLVMBuildAlloca(builder, valueType.getLlvmType(context),
                                parent.getPath() + '_' + name);
                        LLVMBuildStore(builder, value.solve(builder, module, context), llvmAllocatedVariable);
                        llvmVariable = LLVMBuildAlloca(builder, valueType.pointerOf(),
                                parent.getPath() + '_' + name + "_ptr");
                        LLVMBuildStore(builder, llvmAllocatedVariable, llvmVariable);
                    }
                    break;
                default:
                    break;
            }
        }
    }

}
