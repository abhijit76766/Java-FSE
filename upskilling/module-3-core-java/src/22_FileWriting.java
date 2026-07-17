import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class FileWriting {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(sc.nextLine());
        }
        System.out.println("Data written to output.txt");
    }
}

