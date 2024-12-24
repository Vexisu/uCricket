package pl.polsl.student.maciwal866.ucricket.ast;

import java.util.ArrayList;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.PointerPointer;

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
                mainFunction.solve(builder, module, context);
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
