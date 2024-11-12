package pl.polsl.student.maciwal866.ucricket.arch.avr;

import lombok.Getter;

@Getter
public enum AvrInstruction {
    // Arithmetic and logic
    ADD(0b0000_1100_0000_0000, (short) 16),
    ADC(0b0001_1100_0000_0000, (short) 16),
    SUB(0b0001_1000_0000_0000, (short) 16),
    SBC(0b0000_1000_0000_0000, (short) 16),
    AND(0b0010_0000_0000_0000, (short) 16),
    OR(0b0010_1000_0000_0000, (short) 16),
    EOR(0b0010_0100_0000_0000, (short) 16),
    SER(0b1110_1111_0000_1111, (short) 16),
    MUL(0b1001_1100_0000_0000, (short) 16),
    // Branch
    JMP(0b1001_0100_0000_1100_0000_0000_0000_0000, (short) 32),
    CALL(0b1001_0100_0000_1110_0000_0000_0000_0000, (short) 32),
    RET(0b1001_0101_0000_1000, (short) 16),
    CPSE(0b0001_0000_0000_0000, (short) 16),
    CP(0b0001_0100_0000_0000, (short) 16),
    BREQ(0b1111_0000_0000_0001, (short) 16),
    BRNE(0b1111_0100_0000_0001, (short) 16),
    BRSH(0b1111_0100_0000_0000, (short) 16),
    BRLO(0b1111_0000_0000_0000, (short) 16),
    BRGE(0b1111_0100_0000_0100, (short) 16),
    BRLT(0b1111_0000_0000_0100, (short) 16),
    LSR(0b1001_0100_0000_0110, (short) 16),
    ROR(0b1001_0100_0000_0111, (short) 16),
    ASR(0b1001_0100_0000_0101, (short) 16),
    SWAP(0b1001_0100_0000_0010, (short) 16),
    BSET(0b1001_0100_0000_1000, (short) 16),
    BCLR(0b1001_0100_1000_1000, (short) 16),
    // Data Transfer
    MOV(0b0010_1100_0000_0000, (short) 16),
    MOVW(0b0000_0001_0000_0000, (short) 16),
    LDI(0b1110_0000_0000_0000, (short) 16),
    LDX(0b1001_0000_0000_1100, (short) 16),
    LDY(0b1000_0000_0000_1000, (short) 16),
    LDZ(0b1000_0000_0000_0000, (short) 16),
    LDS(0b1001_0000_0000_0000_0000_0000_0000_0000, (short) 32),
    STX(0b1001_0010_0000_1100, (short) 16),
    STY(0b1000_0010_0000_1000, (short) 16),
    STZ(0b1000_0010_0000_0000, (short) 16),
    STS(0b1001_0010_0000_0000_0000_0000_0000_0000, (short) 32),
    LPM(0b1001_0101_1100_1000, (short) 16),
    SPM(0b1001_0101_1110_1000, (short) 16),
    IN(0b1011_0000_0000_0000, (short) 16),
    OUT(0b1011_1000_0000_0000, (short) 16),
    PUSH(0b1001_0010_0000_1111, (short) 16),
    POP(0b1001_0000_0000_1111, (short) 16),
    // MCU Control
    NOP(0b0000_0000_0000_0000, (short) 16)
    ;

    private final int value;
    private final short length;

    private AvrInstruction(int value, short length) {
        this.value = value;
        this.length = length;
    }

}
