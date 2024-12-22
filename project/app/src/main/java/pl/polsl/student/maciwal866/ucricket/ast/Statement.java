package pl.polsl.student.maciwal866.ucricket.ast;

import org.bytedeco.llvm.LLVM.*;

public interface Statement extends ASTNode {
    void solve(LLVMBuilderRef builder, LLVMModuleRef module, LLVMContextRef context);
}
