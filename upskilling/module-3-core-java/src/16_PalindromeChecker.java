import java.util.Scanner;

class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String cleaned = sc.nextLine().replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        System.out.println(cleaned.equals(reversed) ? "Palindrome" : "Not palindrome");
    }
}

