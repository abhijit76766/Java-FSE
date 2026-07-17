class TypeCastingExample {
    public static void main(String[] args) {
        double value = 45.89;
        int narrowed = (int) value;
        int number = 25;
        double widened = number;
        System.out.println("Double to int: " + narrowed);
        System.out.println("Int to double: " + widened);
    }
}

