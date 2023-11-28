package pl.polsl.student.maciwal866.ucricket.ast.statement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.ASTNode;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.Statement;
import pl.polsl.student.maciwal866.ucricket.ast.StatementChain;

@Getter
@AllArgsConstructor
public class IfStatement implements Statement {
    private Expression condition;
    private StatementChain statements;

    @Override
    public ASTNode solve() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'solve'");
    }
}