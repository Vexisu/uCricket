package pl.polsl.student.maciwal866.ucricket.ast;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.statement.VariableStatement;

@Getter
public class Scope {
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
}
