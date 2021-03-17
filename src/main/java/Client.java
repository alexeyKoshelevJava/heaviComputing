import java.io.*;
import java.net.Socket;
import java.util.Scanner;

//выбран Blocking потому что у на запрос на получении конкретной информации т.е целого числа . Мы не можем обрабатывать отдельно получая части числа.
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 18768);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {
            String msg;
            while (true) {
                System.out.println("Enter the value to get the fibonacci number or end if you want to exit ");
                msg = scanner.nextLine();

                System.out.println(msg);
                out.println(msg);
                if ("end".equals(msg)) break;

                System.out.println("Server/the fibonacci number: " + in.readLine());
            }


        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
