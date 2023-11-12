package pl.polsl.student.maciwal866.ucricket;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.print("Required parameter: main source file.");
        }
        try {
            var lexer = new UCricketLexer(new FileReader(args[0]));
            var parser = new UCricketParser(lexer);
            parser.parse();
        } catch (IOException e) {
            System.err.printf("Can't read file: \s\n", args[0]);
        }
    }
}
