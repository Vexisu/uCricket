package pl.polsl.student.maciwal866.ucricket.ast;

import java.util.ArrayList;

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
}
