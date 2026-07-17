import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class TcpChatServer {
    public static void main(String[] args) throws Exception {
        try (ServerSocket server = new ServerSocket(5000);
             Socket socket = server.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            out.println("Connected to server");
            String line;
            while ((line = in.readLine()) != null) {
                out.println("Server received: " + line);
            }
        }
    }
}

