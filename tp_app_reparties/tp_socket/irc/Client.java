import java.net.*;
import java.io.*;
import java.util.*;

class server extends Thread {

    private DataInputStream in   = null;
    public server(Socket socket) {
        try {

            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        } catch (IOException e) {
e.printStackTrace();
        }

    }
    public void run() {
        try {
            while (true) {
                //print the server's outcoming data
                System.out.println(in.readUTF());
            }
        } catch (Exception e) {
        e.printStackTrace();

        }

    }
}
class reader_client extends Thread {
    String line = "";
    Scanner sc = new Scanner(System.in);
    public void run() {
        while (true) {
            line = sc.nextLine();
            try {
                //sends the input from the user's stdin to the server
                Client.out.writeUTF(line);
            } catch (Exception e) {
                e.printStackTrace();;
            }
        }
    }
}

public class Client {
    public static Socket socket        = null;
    public static Scanner input = null;
    public static DataOutputStream out     = null;
    public static DataInputStream in   = null;

    public Client(String address, int port) {
        try {
            //opens a connection to the server
            socket = new Socket(address, port);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            //opens a thread to read standard input of the client without blocking 
            //the rest of the program
            reader_client r = new reader_client();
            r.start();
            //opens a thread to connect to a server and handles the input that comes from it
            server s = new server(socket);
            s.start();

        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        } finally {
            try {
                // input.close();
                // out.close();
                // socket.close();


            } catch (Exception e) {e.printStackTrace();}

        }
    }

    public static void main(String args[]) {
        Client client = new Client("20.50.2.28", 443);
    }
}
