import java.net.*;
import java.io.*;

public class Server {
    private Socket       socket = null;
    private ServerSocket server = null;
    private DataInputStream in   = null;
    private DataOutputStream out;

    public Server(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            in = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("banananannana");


            String line = "";


            line = in.readUTF();
            System.out.println(line);


            System.out.println("Closing connection");

            // close connection
            socket.close();
            in.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        Server server = new Server(5000);
    }
}
