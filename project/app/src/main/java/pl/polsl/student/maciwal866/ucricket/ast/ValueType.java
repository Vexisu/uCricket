package pl.polsl.student.maciwal866.ucricket.ast;

import org.bytedeco.llvm.LLVM.*;
import static org.bytedeco.llvm.global.LLVM.*;

public enum ValueType {
    INTEGER,
    FLOAT,
    BOOLEAN,
    BYTE,
    NONE;

    public final static ValueType[] NUMERIC_TYPES = { INTEGER, FLOAT, BYTE };
    public final static ValueType[] LOGIC_TYPES = { BOOLEAN };
    public final static ValueType[] ALL_TYPES = { INTEGER, FLOAT, BOOLEAN, BYTE };

    public LLVMTypeRef getLlvmType() {
        return switch (this) {
            case BOOLEAN -> LLVMInt1Type();
            case FLOAT -> LLVMFloatType();
            case BYTE -> LLVMInt8Type();
            case INTEGER -> LLVMInt16Type();
            case NONE -> LLVMVoidType();
            default -> LLVMVoidType();
        };
    }

    public LLVMTypeRef getLlvmType(LLVMContextRef context) {
        return switch (this) {
            case BOOLEAN -> LLVMInt1TypeInContext(context);
            case FLOAT -> LLVMFloatTypeInContext(context);
            case BYTE -> LLVMInt16TypeInContext(context);
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

    public LLVMTypeRef pointerOf() {
        return LLVMPointerType(getLlvmType(), 0);
    }

    public LLVMTypeRef pointerOf(LLVMContextRef context) {
        return LLVMPointerType(getLlvmType(context), 0);
    }
}
