package pl.polsl.student.maciwal866.ucricket.ast;

import org.bytedeco.llvm.LLVM.LLVMBuilderRef;
import org.bytedeco.llvm.LLVM.LLVMModuleRef;
import org.bytedeco.llvm.LLVM.LLVMValueRef;

public interface Expression extends ASTNode {
    LLVMValueRef solve(LLVMBuilderRef builder, LLVMModuleRef module);
}
