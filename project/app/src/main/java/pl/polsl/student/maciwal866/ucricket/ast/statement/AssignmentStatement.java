package pl.polsl.student.maciwal866.ucricket.ast.statement;

import static org.bytedeco.llvm.global.LLVM.LLVMBuildLoad2;
import static org.bytedeco.llvm.global.LLVM.LLVMBuildStore;

import org.bytedeco.llvm.LLVM.LLVMBuilderRef;
import org.bytedeco.llvm.LLVM.LLVMContextRef;
import org.bytedeco.llvm.LLVM.LLVMModuleRef;

import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.AssignmentType;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.Statement;
import pl.polsl.student.maciwal866.ucricket.ast.ValueType;
import pl.polsl.student.maciwal866.ucricket.ast.exception.MismatchedTypeException;
import pl.polsl.student.maciwal866.ucricket.ast.exception.VariableNotFoundException;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;

@Getter
public class AssignmentStatement implements Statement {
    private AssignmentType assignmentType;
    private String variableName;
    private Expression expression;
    private VariableStatement linkedVariable;

    public AssignmentStatement(AssignmentType assignmentType, String variableName, Expression expression) {
        this.assignmentType = assignmentType;
        this.variableName = variableName;
        this.expression = expression;
    }

    @Override
    public Object resolve(Scoped parent) {
        this.linkedVariable = parent.getVariable(variableName);
        if (linkedVariable == null) {
            throw new VariableNotFoundException(variableName);
        }
        linkedVariable.setAccessed(true);
        if (expression.resolve(parent) instanceof ValueType expressionValueType
                && !expressionValueType.equals(this.linkedVariable.getValueType())) {
            throw new MismatchedTypeException(expressionValueType, this);
        }
        return null;
    }

    @Override
    public void solve(LLVMBuilderRef builder, LLVMModuleRef module, LLVMContextRef context) {
        var llvmExpression = expression.solve(builder, module, context);
        if (linkedVariable instanceof PointerStatement) {
            var llvmPointer = LLVMBuildLoad2(builder, linkedVariable.getValueType().pointerOf(context),
                    linkedVariable.getLlvmVariable(), variableName);
            LLVMBuildStore(builder, llvmExpression, llvmPointer);
            return;
        }
        LLVMBuildStore(builder, llvmExpression, linkedVariable.getLlvmVariable());
    }

}
