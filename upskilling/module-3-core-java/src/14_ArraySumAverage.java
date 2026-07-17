import java.util.Scanner;

class ArraySumAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of elements: ");
        int n = sc.nextInt();
        int[] values = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
            sum += values[i];
        }
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + (sum / (double) n));
    }
}

