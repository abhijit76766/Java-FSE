import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class TcpChatClient {
    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket("localhost", 5000);
             BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            System.out.println(in.readLine());
            String line;
            while ((line = console.readLine()) != null) {
                out.println(line);
                System.out.println(in.readLine());
            }
        }
    }
}

