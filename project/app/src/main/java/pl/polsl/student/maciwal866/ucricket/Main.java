package pl.polsl.student.maciwal866.ucricket;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var lexer = new UCricketLexer(new FileReader("math.txt"));
        var parser = new UCricketParser(lexer);
        parser.parse();
    }
}
