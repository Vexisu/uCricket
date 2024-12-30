package pl.polsl.student.maciwal866.ucricket;

import java.io.IOException;

import org.bytedeco.llvm.global.LLVM;

public class Main {
    public static void main(String[] args) throws IOException {
        LLVM.LLVMInitializeAVRTarget();
        LLVM.LLVMInitializeAVRTargetInfo();
        LLVM.LLVMInitializeAVRTargetMC();
        LLVM.LLVMInitializeAVRAsmParser();
        LLVM.LLVMInitializeAVRAsmPrinter();
        if (args.length != 1) {
            System.out.println("Required parameter: main source file.");
            System.exit(1);
        }
        try {
            var sourcesReader = new SourcesReader(args[0]);
            var lexer = new UCricketLexer(sourcesReader.getSequencedSource());
            var parser = new UCricketParser(lexer);
            parser.parse();
            var program = parser.getProgram();
            program.resolve();
            program.solve();

        } catch (IOException e) {
            System.err.printf("Can't read file: %s\n", args[0]);
            e.printStackTrace();
        }
    }
}
