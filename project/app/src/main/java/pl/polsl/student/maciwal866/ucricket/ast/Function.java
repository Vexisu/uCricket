package pl.polsl.student.maciwal866.ucricket.ast;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Resolvable;
import pl.polsl.student.maciwal866.ucricket.ast.extension.Scoped;

@Getter
public class Function implements Resolvable {
    private ValueType type;
    private String name;
    private LinkedHashMap<String, ValueType> arguments;
    private ArrayList<Statement> statements;

    public Function(ValueType type, String name, ArgumentChain argumentChain, StatementChain statementChain) {
        this.type = type;
        this.name = name;
        this.arguments = argumentChain != null ? argumentChain.collect() : new LinkedHashMap<>();
        this.statements = statementChain != null ? statementChain.collect() : new ArrayList<>();
    }

    @Getter
    @AllArgsConstructor
    public static class ArgumentChain {
        private ValueType type;
        private String name;
        private ArgumentChain next;

        public LinkedHashMap<String, ValueType> collect() {
            var arguments = new LinkedHashMap<String, ValueType>();
            arguments.put(name, type);
            var currentArgument = next;
            while (currentArgument != null) {
                arguments.put(currentArgument.getName(), currentArgument.getType());
                currentArgument = currentArgument.getNext();
            }
            return arguments;
        }
    }

    @Override
    public Object resolve(Scoped parent) {
        statements.forEach(statement -> statement.resolve(parent));
        return null;
    }
}
