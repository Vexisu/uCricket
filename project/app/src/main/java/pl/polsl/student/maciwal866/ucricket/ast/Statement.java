package pl.polsl.student.maciwal866.ucricket.ast;

import org.bytedeco.llvm.LLVM.LLVMBuilderRef;
import org.bytedeco.llvm.LLVM.LLVMModuleRef;

public interface Statement extends ASTNode {
    void solve(LLVMBuilderRef builder, LLVMModuleRef module);
}
