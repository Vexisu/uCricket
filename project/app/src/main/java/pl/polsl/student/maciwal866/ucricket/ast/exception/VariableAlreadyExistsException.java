package pl.polsl.student.maciwal866.ucricket.ast.exception;

import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.statement.VariableStatement;

@Getter
public class VariableAlreadyExistsException extends RuntimeException {
    private VariableStatement variableStatement;

    public VariableAlreadyExistsException(VariableStatement variableStatement) {
        super("Variable " + variableStatement.getName() + " already exists.");
        this.variableStatement = variableStatement;
    }
}
