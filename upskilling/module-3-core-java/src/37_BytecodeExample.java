class BytecodeExample {
    public int square(int number) {
        return number * number;
    }

    public static void main(String[] args) {
        System.out.println(new BytecodeExample().square(5));
    }
}

