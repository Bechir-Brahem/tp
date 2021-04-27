import java.io.*;
import java.net.*;
class Server {
    ServerSocket s;
    public Server() {
        try {
            s = new ServerSocket(8000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void init() {
        while (true) {
            try {
                System.out.println("waiting for a connection...");
                Socket tmp_socket = s.accept();
                System.out.println("connection established");
                (new Server_thread(tmp_socket)).start();;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    } public static void main(String []args) {
        Server s = new Server();
        s.init();
    }
}
