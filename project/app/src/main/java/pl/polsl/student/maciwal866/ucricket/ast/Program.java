package pl.polsl.student.maciwal866.ucricket.ast;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class Program {
    private ArrayList<Scope> scopes = new ArrayList<>();
}
