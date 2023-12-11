package pl.polsl.student.maciwal866.ucricket.ast.exception;

import lombok.Getter;

@Getter
public class VariableNotFoundException extends RuntimeException {
    private String name;

    public VariableNotFoundException(String name) {
        super("Variable " + name + " isn't defined.");
        this.name = name;
    }
}
