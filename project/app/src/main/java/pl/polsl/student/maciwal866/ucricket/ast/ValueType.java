package pl.polsl.student.maciwal866.ucricket.ast;

public enum ValueType {
    INTEGER,
    FLOAT,
    BOOLEAN;

    public static ValueType parse(String name){
        for (var type : ValueType.values()) {
            if (name.equalsIgnoreCase(type.name())) {
                return type;
            }
        }
        return null;
    }
}
