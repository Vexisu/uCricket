package pl.polsl.student.maciwal866.ucricket.ast;

import org.bytedeco.llvm.LLVM.*;
import static org.bytedeco.llvm.global.LLVM.*;

public enum ValueType {
    INTEGER,
    FLOAT,
    BOOLEAN,
    NONE;

    public final static ValueType[] NUMERIC_TYPES = { INTEGER, FLOAT };
    public final static ValueType[] LOGIC_TYPES = { BOOLEAN };
    public final static ValueType[] ALL_TYPES = { INTEGER, FLOAT, BOOLEAN };

    public LLVMTypeRef getLlvmType() {
        return switch (this) {
            case BOOLEAN -> LLVMInt1Type();
            case FLOAT -> LLVMFloatType();
            case INTEGER -> LLVMInt16Type();
            case NONE -> LLVMVoidType();
            default -> LLVMVoidType();
        };
    }

    public LLVMTypeRef getLlvmType(LLVMContextRef context) {
        return switch (this) {
            case BOOLEAN -> LLVMInt1TypeInContext(context);
            case FLOAT -> LLVMFloatTypeInContext(context);
            case INTEGER -> LLVMInt16TypeInContext(context);
            case NONE -> LLVMVoidTypeInContext(context);
            default -> LLVMVoidTypeInContext(context);
        };
    }

    public static ValueType parse(String name) {
        for (var type : ValueType.values()) {
            if (name.equalsIgnoreCase(type.name())) {
                return type;
            }
        }
        return null;
    }

    public boolean anyEquals(ValueType... types) {
        for (ValueType type : types) {
            if (this.equals(type)) {
                return true;
            }
        }
        return false;
    }
}
