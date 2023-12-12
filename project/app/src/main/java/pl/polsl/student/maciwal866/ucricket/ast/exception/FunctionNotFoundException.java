package pl.polsl.student.maciwal866.ucricket.ast.exception;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.ValueType;

@Getter
public class FunctionNotFoundException extends RuntimeException {
    private String name;
    private ValueType[] arguments;
    
    public FunctionNotFoundException(String name, ValueType[] arguments) {
        super("Function " + name + "(" + Stream.of(arguments).map(argument -> argument.name()).collect(Collectors.joining(",")) + ") doesn't exist.");
        this.name = name;
        this.arguments = arguments;
    }

}
