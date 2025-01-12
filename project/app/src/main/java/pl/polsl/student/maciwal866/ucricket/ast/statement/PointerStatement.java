package pl.polsl.student.maciwal866.ucricket.ast.statement;

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
public class PointerStatement extends VariableStatement{
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'solve'");
    }

}
