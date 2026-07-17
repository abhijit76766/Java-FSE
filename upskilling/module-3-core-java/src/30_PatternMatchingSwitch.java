class PatternMatchingSwitch {
    static String describe(Object value) {
        return switch (value) {
            case Integer i -> "Integer: " + i;
            case String s -> "String length: " + s.length();
            case Double d -> "Double: " + d;
            case null -> "Null value";
            default -> "Other type";
        };
    }

    public static void main(String[] args) {
        System.out.println(describe(10));
        System.out.println(describe("Java"));
        System.out.println(describe(12.5));
    }
}

