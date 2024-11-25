package pl.polsl.student.maciwal866.ucricket.arch.avr;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceState {
    private boolean[] registersAllocation;

    public DeviceState() {
        this.registersAllocation = new boolean[32];
    }

    public void allocateRegister(Register register) {
        registersAllocation[register.getRegisterAddress()] = true;
    }

    public void freeRegister(Register register) {
        registersAllocation[register.getRegisterAddress()] = false;
    }

    @Getter
    public enum Register {
        R0((short) 0),
        R1((short) 1),
        R2((short) 2),
        R3((short) 3),
        R4((short) 4),
        R5((short) 5),
        R6((short) 6),
        R7((short) 7),
        R8((short) 8),
        R9((short) 9),
        R10((short) 10),
        R11((short) 11),
        R12((short) 12),
        R13((short) 13),
        R14((short) 14),
        R15((short) 15),
        R16((short) 16),
        R17((short) 17),
        R18((short) 18),
        R19((short) 19),
        R20((short) 20),
        R21((short) 21),
        R22((short) 22),
        R23((short) 23),
        R24((short) 24),
        R25((short) 25),
        R26((short) 26),
        R27((short) 27),
        R28((short) 28),
        R29((short) 29),
        R30((short) 30),
        R31((short) 31);

        private short registerAddress;

        private Register(short registerAddress) {
            this.registerAddress = registerAddress;
        }
    }

    @Getter
    public enum AllocationUnit {
        BYTE(1),
        WORD(2),
        DWORD(4);

        private int size;

        private AllocationUnit(int size) {
            this.size = size;
        }
    }
}
