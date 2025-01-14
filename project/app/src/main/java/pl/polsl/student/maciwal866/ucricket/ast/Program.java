package pl.polsl.student.maciwal866.ucricket.ast;

import java.util.ArrayList;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.llvm.LLVM.LLVMTargetMachineRef;
import org.bytedeco.llvm.LLVM.LLVMTargetRef;

import static org.bytedeco.llvm.global.LLVM.*;

import lombok.Getter;

@Getter
public class Program {
    private ArrayList<Scope> scopes = new ArrayList<>();

    public void addScope(Scope scope) {
        scopes.add(scope);
    }

    public Scope getScopeByName(String name) {
        for (Scope scope : scopes) {
            if (scope.getName().equalsIgnoreCase(name)) {
                return scope;
            }
        }
        return null;
    }

    public Object resolve() {
        for (Scope scope : scopes) {
            scope.resolve(null);
        }
        return null;
    }

    public void solve() {
        var context = LLVMContextCreate();
        var mainScope = getScopeByName("Main");
        if (mainScope != null) {
            var module = LLVMModuleCreateWithNameInContext("Main", context);
            var builder = LLVMCreateBuilderInContext(context);
            var mainFunction = mainScope.getFunction("main", new ValueType[0]);
            if (mainFunction != null) {
                for (var scope : scopes) {
                    scope.solve(builder, module, context);
                }
                mainFunction.solve(builder, module, context);
                LLVMSetValueName(mainFunction.getLlvmFunction(), "main");
            }

            /* Test code for emiting code */
            LLVMSetTarget(module, "avr");
            PointerPointer<BytePointer> error = new PointerPointer<>(1);
            LLVMTargetRef target = LLVMGetTargetFromName("avr");
            if (target == null) {
                System.err.println("AVR target not found!");
                System.exit(1);
            }

            LLVMTargetMachineRef targetMachine = LLVMCreateTargetMachine(
                    target,
                    "avr",
                    "atmega328p",
                    "",
                    LLVMCodeGenLevelDefault,
                    LLVMRelocDefault,
                    LLVMCodeModelDefault);

            BytePointer fileName = new BytePointer("output.s");
            if (LLVMTargetMachineEmitToFile(
                    targetMachine,
                    module,
                    fileName,
                    LLVMAssemblyFile,
                    error) != 0) {
                System.err.println("Failed to emit file: " + error.get(BytePointer.class));
                System.exit(1);
            }

            var moduleMessage = new PointerPointer<BytePointer>(1);
            LLVMVerifyModule(module, 0, moduleMessage);
            LLVMDisposeMessage(moduleMessage.get(BytePointer.class));
            LLVMDumpModule(module);
            LLVMDisposeBuilder(builder);
            LLVMDisposeModule(module);
        }
        LLVMContextDispose(context);
    }
}
