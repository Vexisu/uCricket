package pl.polsl.student.maciwal866.ucricket.ast;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Function {
    private ValueType type;
    private String name;
    private ArgumentsChain argumentsChain;
    private StatementChain statementChain;
    private HashMap<String, ValueType> arguments = new HashMap<>();
    private ArrayList<Statement> statements = new ArrayList<>();

    public Function(ValueType type, String name, ArgumentsChain argumentsChain, StatementChain statementChain) {
        this.type = type;
        this.name = name;
        this.argumentsChain = argumentsChain;
        this.statementChain = statementChain;
    }

    @Getter
    @AllArgsConstructor
    public static class ArgumentsChain {
        private ValueType type;
        private String name;
        private ArgumentsChain next;
    }
}
