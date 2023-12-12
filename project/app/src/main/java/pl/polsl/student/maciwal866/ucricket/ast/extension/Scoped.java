package pl.polsl.student.maciwal866.ucricket.ast.extension;

import pl.polsl.student.maciwal866.ucricket.ast.Function;
import pl.polsl.student.maciwal866.ucricket.ast.ValueType;
import pl.polsl.student.maciwal866.ucricket.ast.statement.VariableStatement;

public interface Scoped {
    VariableStatement getVariable(String name);

    boolean hasVariable(String name);

    void addVariable(VariableStatement statement);

    Function getFunction(String name, ValueType[] argumentTypes);

    boolean hasFunction(String name, ValueType[] argumentTypes);

    void addFunction(Function function);
}
