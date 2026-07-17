import java.util.Scanner;

class TryCatchExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter numerator: ");
            int a = sc.nextInt();
            System.out.print("Enter denominator: ");
            int b = sc.nextInt();
            System.out.println(a / b);
        } catch (ArithmeticException ex) {
            System.out.println("Cannot divide by zero.");
        }
    }
}

