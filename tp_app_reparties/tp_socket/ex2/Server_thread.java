import java.io.*;
import java.net.*;
public class Server_thread extends Thread {
    Socket s;
    int reqcount = -1;
    public Server_thread(Socket s) {
        this.s = s;
    } private String message_suivant() {
        reqcount++;
        switch (reqcount % 5) {
        case 0:
            return new String("Marrakech est une ville magnifique.");
        case 1:
            return new String("La medina de Fes est splendide aucouchant.");
        case 2:
            return new String("Les montagnes de l'Atlas sontimpressionnantes.");
        case 3:
            return new String("La place Jamaa alfna est au centre de laville.");
        case 4:
            return new String("Les cotes du Maroc valent le coup d'oeil.");
        }
        return new String("ca n'arrive jamais");
    }
    public void finalize(DataInputStream dis, InputStream is, Socket s, DataOutputStream dos, OutputStream os) throws IOException {
        dis.close();
        is.close();
        s.close();
        dos.close();
        os.close();
    } public void run() {
        try {
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF("Welcome!");
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            String reponse ;
            reponse = dis.readUTF();
            while (!reponse.equals("")) {
                System.out.println("I received a message :" + reponse);
                Thread.sleep(1000);
                reponse = message_suivant();
                dos.writeUTF(reponse);
                reponse = dis.readUTF();
            }
            System.out.println("end of connection.");
            finalize(dis, is, s, dos, os);
        } catch (Exception e) {
            System.out.println("Client deconnecte");
        }
    }
}
