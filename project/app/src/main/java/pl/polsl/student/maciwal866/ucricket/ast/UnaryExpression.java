package pl.polsl.student.maciwal866.ucricket.ast;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class UnaryExpression {
    private Expression expression;
}
