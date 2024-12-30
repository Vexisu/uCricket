package pl.polsl.student.maciwal866.ucricket.ast;

import org.bytedeco.llvm.LLVM.*;

public interface Expression extends ASTNode {
    LLVMValueRef solve(LLVMBuilderRef builder, LLVMModuleRef module, LLVMContextRef context);
}
