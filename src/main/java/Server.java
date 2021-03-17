import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket servSocket = new ServerSocket(18768);
        while (true) {
            try (Socket socket = servSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                ;
                String s;
                while ((s = in.readLine()) != null) {

                    if ("end".equals(s)) break;
                    int x = Integer.parseInt(s);


                    out.println("число фибоначчи " + fib_n(x));

                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }

        }
    }

    public static int fib_n(int n) {
        if (n <= 2) return 1;
        var x = 1;
        var y = 1;
        var ans = 0;
        for (var i = 2; i < n; i++) {
            ans = x + y;
            x = y;
            y = ans;
        }
        return ans;
    }
}