package pl.polsl.student.maciwal866.ucricket.arch.avr;

import java.util.ArrayList;

import pl.polsl.student.maciwal866.ucricket.ast.extension.Addressable;

public class InstructionBuilder {
    private AvrInstruction instruction;
    private ArrayList<InstructionProperty> properties;

    private InstructionBuilder(AvrInstruction instruction) {
        this.instruction = instruction;
    }

    public InstructionBuilder from(AvrInstruction instruction) {
        return new InstructionBuilder(instruction);
    }

    public InstructionBuilder addLinkedProperty(int value, byte shift){
        return this;
    }

    public InstructionBuilder addProperty(int value, byte shift){
        return this;
    }

    private class InstructionProperty {
        private Addressable addressable;
        private int value;
        private byte shift;
    }
}
