package pl.polsl.student.maciwal866.ucricket.ast.statement;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.ASTNode;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.Statement;

@Getter
@AllArgsConstructor
public class IfStatement implements Statement {
    private Expression condition;
    private List<Statement> statements;

    @Override
    public ASTNode solve() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'solve'");
    }
}