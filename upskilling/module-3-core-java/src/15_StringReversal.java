import java.util.Scanner;

class StringReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();
        System.out.println(new StringBuilder(input).reverse());
    }
}

