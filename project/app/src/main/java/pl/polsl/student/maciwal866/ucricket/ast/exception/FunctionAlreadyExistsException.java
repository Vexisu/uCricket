package pl.polsl.student.maciwal866.ucricket.ast.exception;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Getter;
import pl.polsl.student.maciwal866.ucricket.ast.ValueType;

@Getter
public class FunctionAlreadyExistsException extends RuntimeException {
    private String name;
    private ValueType[] arguments;

    public FunctionAlreadyExistsException(String name, ValueType[] arguments) {
        super("Function " + name + "(" + Stream.of(arguments).map(argument -> argument.name()).collect(Collectors.joining(",")) + ") already exists.");
        this.name = name;
        this.arguments = arguments;
    }

}
