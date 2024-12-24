package pl.polsl.student.maciwal866.ucricket.ast;

import static org.bytedeco.llvm.global.LLVM.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.llvm.LLVM.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.polsl.student.maciwal866.ucricket.ast.exception.FunctionAlreadyExistsException;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;
import pl.polsl.student.maciwal866.ucricket.ast.statement.VariableStatement;

@Getter
public class Function implements Statement, Scoped {
    private ValueType type;
    private String name;
    private LinkedHashMap<String, ValueType> arguments;
    private ArrayList<Statement> statements;
    private Scoped parent;
    private ArrayList<VariableStatement> localVariables = new ArrayList<>();
    private LLVMTypeRef llvmFunctionType;
    private LLVMValueRef llvmFunction;

    @Setter
    private boolean called;
    
    public Function(ValueType type, String name, ArgumentChain argumentChain, StatementChain statementChain) {
        this.type = type;
        this.name = name;
        this.arguments = argumentChain != null ? argumentChain.collect() : new LinkedHashMap<>();
        this.statements = statementChain != null ? statementChain.collect() : new ArrayList<>();
    }

    @Getter
    @AllArgsConstructor
    public static class ArgumentChain {
        private ValueType type;
        private String name;
        private ArgumentChain next;

        public LinkedHashMap<String, ValueType> collect() {
            var arguments = new LinkedHashMap<String, ValueType>();
            arguments.put(name, type);
            var currentArgument = next;
            while (currentArgument != null) {
                arguments.put(currentArgument.getName(), currentArgument.getType());
                currentArgument = currentArgument.getNext();
            }
            return arguments;
        }
    }

    public boolean isEquivalent(String name, ValueType[] comparedArguments) {
        if (this.name.equalsIgnoreCase(name) && comparedArguments.length == arguments.values().size()) {
            var argumentTypes = arguments.values().toArray(ValueType[]::new);
            for (var i = 0; i < comparedArguments.length; i++) {
                if (comparedArguments[i] != argumentTypes[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public Object resolve(Scoped parent) {
        this.parent = parent;
        ValueType[] argumentTypes = getArguments().values().toArray(ValueType[]::new);
        if (parent.hasFunction(name, argumentTypes)) {
            throw new FunctionAlreadyExistsException(name, argumentTypes);
        }
        parent.addFunction(this);
        arguments.forEach(
                (argumentName, argumentType) -> addVariable(new VariableStatement(argumentType, argumentName, null)));
        statements.forEach(statement -> statement.resolve(parent));
        return null;
    }

    @Override
    public VariableStatement getVariable(String name) {
        for (var variable : localVariables) {
            if (variable.getName().equalsIgnoreCase(name)) {
                return variable;
            }
        }
        return parent.getVariable(name);
    }

    @Override
    public boolean hasVariable(String name) {
        for (var variable : localVariables) {
            if (variable.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return parent.hasVariable(name);
    }

    @Override
    public void addVariable(VariableStatement statement) {
        localVariables.add(statement);
    }

    @Override
    public Function getFunction(String name, ValueType[] argumentTypes) {
        return parent.getFunction(name, argumentTypes);
    }

    @Override
    public boolean hasFunction(String name, ValueType[] argumentTypes) {
        return parent.hasFunction(name, argumentTypes);
    }

    @Override
    public void addFunction(Function function) {
        parent.addFunction(function);
    }

    @Override
    public void solve(LLVMBuilderRef builder, LLVMModuleRef module, LLVMContextRef context) {
        var argumentTypes = arguments.values().toArray(ValueType[]::new);
        var llvmArgumentTypes = new PointerPointer<LLVMTypeRef>(argumentTypes.length);
        for (int i = 0; i < argumentTypes.length; i++) {
            llvmArgumentTypes.put(i, argumentTypes[i].getLlvmType(context));
        }
        llvmFunctionType = LLVMFunctionType(type.getLlvmType(context), llvmArgumentTypes, argumentTypes.length, 0);
        llvmFunction = LLVMAddFunction(module, name, llvmFunctionType);
        var argumentNames = arguments.keySet().toArray(String[]::new);
        for (int i = 0; i < argumentNames.length; i++) {
            var argument = LLVMGetParam(llvmFunction, i);
            LLVMSetValueName(argument, argumentNames[i]);
        }
        var llvmFunctionEntry = LLVMAppendBasicBlockInContext(context, llvmFunction, "entry");
        LLVMPositionBuilderAtEnd(builder, llvmFunctionEntry);
        for (var statement : statements) {
            statement.solve(builder, module, context);
        }
        if (type.equals(ValueType.NONE)) {
            LLVMBuildRetVoid(builder);
        }
    }
}
