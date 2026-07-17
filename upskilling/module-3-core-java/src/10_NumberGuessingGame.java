import java.util.Random;
import java.util.Scanner;

class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = new Random().nextInt(100) + 1;
        int guess;
        do {
            System.out.print("Guess number 1-100: ");
            guess = sc.nextInt();
            if (guess < target) System.out.println("Too low");
            else if (guess > target) System.out.println("Too high");
        } while (guess != target);
        System.out.println("Correct!");
    }
}

