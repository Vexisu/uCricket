package pl.polsl.student.maciwal866.ucricket.ast.statement;

import static org.bytedeco.llvm.global.LLVM.*;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.bytedeco.llvm.LLVM.*;

import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.Function;
import pl.polsl.student.maciwal866.ucricket.ast.Statement;
import pl.polsl.student.maciwal866.ucricket.ast.StatementChain;
import pl.polsl.student.maciwal866.ucricket.ast.ValueType;
import pl.polsl.student.maciwal866.ucricket.ast.exception.MismatchedTypeException;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;

@Getter
public class IfStatement implements Statement, Scoped {
    private Expression condition;
    private StatementChain statements;

    private Scoped parent;
    private ArrayList<VariableStatement> localVariables = new ArrayList<>();

    public IfStatement(Expression condition, StatementChain statements) {
        this.condition = condition;
        this.statements = statements;
    }

    @Override
    public Object resolve(Scoped parent) {
        this.parent = parent;
        var resolverConditionResult = condition.resolve(this);
        if (resolverConditionResult instanceof ValueType conditionValueType) {
            if (!Stream.of(ValueType.LOGIC_TYPES).anyMatch(logicType -> logicType.equals(conditionValueType))) {
                throw new MismatchedTypeException(conditionValueType, this);
            }
        }
        if (statements != null) {
            statements.resolve(this);
        }
        return null;
    }

    @Override
    public VariableStatement getVariable(String name) {
        for (var variable : localVariables) {
            if (variable.getName().equals(name)) {
                return variable;
            }
        }
        return parent.getVariable(name);
    }

    @Override
    public boolean hasVariable(String name) {
        for (var variable : localVariables) {
            if (variable.getName().equals(name)) {
                return true;
            }
        }
        return parent.hasVariable(name);
    }

    @Override
    public boolean hasResolvedVariable(String name) {
        for (var variable : localVariables) {
            if (variable.getName().equals(name) && variable.isResolved()) {
                return true;
            }
        }
        return parent.hasResolvedVariable(name);
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
    public boolean hasResolvedFunction(String name, ValueType[] argumentTypes) {
        return parent.hasResolvedFunction(name, argumentTypes);
    }

    @Override
    public void solve(LLVMBuilderRef builder, LLVMModuleRef module, LLVMContextRef context) {
        var llvmCondition = condition.solve(builder, module, context);
        var llvmCurrentBlock = LLVMGetInsertBlock(builder);
        var llvmFunction = LLVMGetBasicBlockParent(llvmCurrentBlock);
        var llvmIfBlock = LLVMAppendBasicBlockInContext(context, llvmFunction, "if");
        var llvmContinuationBlock = LLVMAppendBasicBlockInContext(context, llvmFunction, "continue");
        LLVMBuildCondBr(builder, llvmCondition, llvmIfBlock, llvmContinuationBlock);
        LLVMPositionBuilderAtEnd(builder, llvmIfBlock);
        var collectedStatements = statements.collect();
        for (var statement : collectedStatements) {
            statement.solve(builder, module, context);
        }
        LLVMBuildBr(builder, llvmContinuationBlock);
        LLVMPositionBuilderAtEnd(builder, llvmContinuationBlock);
    }

    @Override
    public String getPath() {
        return parent.getPath() + "_if";
    }
}