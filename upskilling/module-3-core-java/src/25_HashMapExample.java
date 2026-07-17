import java.util.HashMap;
import java.util.Scanner;

class HashMapExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> students = new HashMap<>();
        students.put(1, "Alice");
        students.put(2, "Bob");
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        System.out.println(students.getOrDefault(id, "Not found"));
    }
}

