package pl.polsl.student.maciwal866.ucricket.ast;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Resolvable;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;
import pl.polsl.student.maciwal866.ucricket.ast.statement.VariableStatement;

@Getter
public class Scope implements Resolvable, Scoped {
    private String name;
    private ScopeContent<?> content;
    private ArrayList<VariableStatement> globalVariables = new ArrayList<>();
    private ArrayList<Function> functions = new ArrayList<>();

    public Scope(String name, ScopeContent<?> content) {
        this.name = name;
        this.content = content;
    }

    @Getter
    @AllArgsConstructor
    public static class ScopeContent<T> {
        private T element;
        private ScopeContent<?> next;
    }

    @Override
    public Object resolve(Scoped parent) {
        var currentContent = content;
        while (currentContent != null) {
            if (currentContent.getElement() instanceof Function function) {
                function.resolve(this);
            } else if (currentContent.getElement() instanceof VariableStatement variable) {
                variable.resolve(this);
            }
            currentContent = currentContent.getNext();
        }
        return null;
    }

    @Override
    public VariableStatement getVariable(String name) {
        if (name.contains(":")) {
            throw new UnsupportedOperationException("Unimplemented method 'getVariable'");
        }
        for (var variable : globalVariables) {
            if (variable.getName().equals(name)) {
                return variable;
            }
        }
        return null;
    }

    @Override
    public Function getFunction(String name, ValueType[] argumentTypes) {
        for (var function : functions) {
            if (function.isEquivalent(name, argumentTypes)) {
                return function;
            }
        }
        return null;
    }

    @Override
    public boolean hasVariable(String name) {
        if (name.contains(":")) {
            throw new UnsupportedOperationException("Unimplemented method 'hasVariable'");
        }
        for (var variable : globalVariables) {
            if (variable.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasFunction(String name, ValueType[] argumentTypes) {
        for (var function : functions) {
            if (function.isEquivalent(name, argumentTypes)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addVariable(VariableStatement statement) {
        globalVariables.add(statement);
    }

    @Override
    public void addFunction(Function function) {
        functions.add(function);
    }

    @Override
    public Scoped getParent() {
        return null;
    }
}
