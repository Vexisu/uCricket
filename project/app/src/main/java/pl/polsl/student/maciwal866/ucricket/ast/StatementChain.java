package pl.polsl.student.maciwal866.ucricket.ast;

import lombok.Getter;

@Getter
public class StatementChain {
    private Statement item;
    private StatementChain next;

    public StatementChain(Statement item, StatementChain next) {
        this.item = item;
        this.next = next;
    }

    public StatementChain(Statement item) {
        this.item = item;
    }

}
