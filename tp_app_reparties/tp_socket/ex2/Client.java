import java.io.*;
import java.net.*;
import java.util.*;
public class Client {
    private static Scanner sc;
    private static Socket s;
    private static InputStream is;
    private static DataInputStream dis;
    private static DataOutputStream dos;
    private static OutputStream os;
    public static void finalize(DataInputStream dis, InputStream is, Socket s, DataOutputStream dos, OutputStream os, Scanner sc) {
        try {
            dis.close();
            is.close();
            s.close();
            dos.close();
            os.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String []Args) {
        try {
            sc = new Scanner(System.in);
            System.out.println("Sending message...");
            s = new Socket("localhost", 8000);
            is = s.getInputStream();
            dis = new DataInputStream(is);
            System.out.println("I received a message : " + dis.readUTF());
            os = s.getOutputStream();
            dos = new DataOutputStream(os);
            String message = "tmp";
            while (!message.equals("")) {
                System.out.println("write yout message : ");
                message = sc.nextLine();
                dos.writeUTF(message);
                System.out.println("I received a message : " + dis.readUTF());
            }
        } catch (EOFException e) {
            return;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            finalize(dis, is, s, dos, os, sc);
        }
    }
}
