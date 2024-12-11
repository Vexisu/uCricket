package pl.polsl.student.maciwal866.ucricket.ast.statement;

import org.bytedeco.llvm.LLVM.LLVMBuilderRef;
import org.bytedeco.llvm.LLVM.LLVMModuleRef;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.Statement;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;

@Getter
@AllArgsConstructor
public class ReturnStatement implements Statement {
    private Expression expression;

    @Override
    public Object resolve(Scoped parent) {
        return expression.resolve(parent);
    }

    @Override
    public void solve(LLVMBuilderRef builder, LLVMModuleRef module) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'solve'");
    }

}
