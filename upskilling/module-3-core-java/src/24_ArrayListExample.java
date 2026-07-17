import java.util.ArrayList;
import java.util.Scanner;

class ArrayListExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        System.out.print("How many names? ");
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) names.add(sc.nextLine());
        System.out.println(names);
    }
}

