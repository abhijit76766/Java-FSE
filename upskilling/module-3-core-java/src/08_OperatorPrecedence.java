class OperatorPrecedence {
    public static void main(String[] args) {
        int result = 10 + 5 * 2;
        int grouped = (10 + 5) * 2;
        System.out.println("10 + 5 * 2 = " + result + " because multiplication runs first.");
        System.out.println("(10 + 5) * 2 = " + grouped + " because parentheses run first.");
    }
}

