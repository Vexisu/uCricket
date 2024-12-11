package pl.polsl.student.maciwal866.ucricket;

import java.io.FileReader;
import java.io.IOException;

import org.bytedeco.llvm.global.LLVM;

public class Main {
    public static void main(String[] args) throws IOException {
        LLVM.LLVMInitializeAVRTargetMC();
        if (args.length != 2) {
            System.out.println("Required parameter: main source file.");
            System.exit(1);
        }
        try {
            var lexer = new UCricketLexer(new FileReader(args[0]));
            var parser = new UCricketParser(lexer);
            parser.parse();
            var program = parser.getProgram();
            program.resolve();
            System.out.println(":)");
        } catch (IOException e) {
            System.err.printf("Can't read file: %s\n", args[0]);
        }
    }
}
