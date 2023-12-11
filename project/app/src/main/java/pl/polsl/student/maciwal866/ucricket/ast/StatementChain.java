package pl.polsl.student.maciwal866.ucricket.ast;

import java.util.ArrayList;

import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Resolvable;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;

@Getter
public class StatementChain implements Resolvable {
    private Statement item;
    private StatementChain next;

    public StatementChain(Statement item, StatementChain next) {
        this.item = item;
        this.next = next;
    }

    public StatementChain(Statement item) {
        this.item = item;
    }

    public ArrayList<Statement> collect() {
        var statements = new ArrayList<Statement>();
        statements.add(item);
        var currentStatement = next;
        while (currentStatement != null) {
            statements.add(currentStatement.getItem());
            currentStatement = currentStatement.getNext();
        }
        return statements;
    }

    @Override
    public Object resolve(Scoped parent) {
        item.resolve(parent);
        if (next != null) {
            next.resolve(parent);
        }
        return null;
    }
}
