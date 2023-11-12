package pl.polsl.student.maciwal866.ucricket.ast;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class BinaryExpression implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;
}
