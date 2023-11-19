package pl.polsl.student.maciwal866.ucricket.ast;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Function {
    @NonNull
    private String name;
    private HashMap<String, ValueType> arguments = new HashMap<>();
    private ArrayList<Statement> statements = new ArrayList<>();
}
