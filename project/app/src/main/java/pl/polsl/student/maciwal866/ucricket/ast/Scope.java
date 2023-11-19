package pl.polsl.student.maciwal866.ucricket.ast;

import java.util.ArrayList;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pl.polsl.student.maciwal866.ucricket.ast.statement.VariableStatement;

@Getter
@RequiredArgsConstructor
public class Scope {
    @NonNull
    private String name;
    private ArrayList<VariableStatement> globalVariables = new ArrayList<>();
    private ArrayList<Function> functions = new ArrayList<>();
}
