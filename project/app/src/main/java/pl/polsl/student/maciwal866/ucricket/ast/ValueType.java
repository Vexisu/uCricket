package pl.polsl.student.maciwal866.ucricket.ast;

public enum ValueType {
    INTEGER,
    FLOAT,
    BOOLEAN;

    public final static ValueType[] NUMERIC_TYPES = { INTEGER, FLOAT };
    public final static ValueType[] LOGIC_TYPES = { BOOLEAN };
    public final static ValueType[] ALL_TYPES = { INTEGER, FLOAT, BOOLEAN };

    public static ValueType parse(String name){
        for (var type : ValueType.values()) {
            if (name.equalsIgnoreCase(type.name())) {
                return type;
            }
        }
        return null;
    }
}
