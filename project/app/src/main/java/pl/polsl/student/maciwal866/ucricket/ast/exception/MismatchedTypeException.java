package pl.polsl.student.maciwal866.ucricket.ast.exception;

import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.ASTNode;
import pl.polsl.student.maciwal866.ucricket.ast.ValueType;

@Getter
public class MismatchedTypeException extends RuntimeException {
    private ValueType valueType;
    private ASTNode astNode;

    public MismatchedTypeException(ValueType valueType, ASTNode astNode) {
        super("Type " + valueType.name() + " doesn't match with:\n" + astNode.toString());
        this.valueType = valueType;
    }

}
