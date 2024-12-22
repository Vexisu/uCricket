package pl.polsl.student.maciwal866.ucricket.ast.statement;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.bytedeco.llvm.LLVM.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.Function;
import pl.polsl.student.maciwal866.ucricket.ast.Statement;
import pl.polsl.student.maciwal866.ucricket.ast.StatementChain;
import pl.polsl.student.maciwal866.ucricket.ast.ValueType;
import pl.polsl.student.maciwal866.ucricket.ast.exception.MismatchedTypeException;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;

@Getter
@AllArgsConstructor
public class WhileStatement implements Statement, Scoped {
    private Expression condition;
    private StatementChain statements;

    private Scoped parent;
    private ArrayList<VariableStatement> localVariables = new ArrayList<>();

    public WhileStatement(Expression condition, StatementChain statements) {
        this.condition = condition;
        this.statements = statements;
    }

    @Override
    public Object resolve(Scoped parent) {
        this.parent = parent;
        var resolverConditionResult = condition.resolve(parent);
        if (resolverConditionResult instanceof ValueType conditionValueType) {
            if (Stream.of(ValueType.LOGIC_TYPES).anyMatch(logicType -> logicType.equals(conditionValueType))) {
                throw new MismatchedTypeException(conditionValueType, this);
            }
        }
        if (statements != null) {
            statements.resolve(parent);
        }
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'solve'");
    }
}
