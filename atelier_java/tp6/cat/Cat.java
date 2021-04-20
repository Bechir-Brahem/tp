import java.awt.*;
import java.util.*;
import java.io.*;
class Cat {
    public static void main(String []s) {
        System.out.println("taper \"cat [nom du ficher]\" :pour voir le contenu du fichier ");
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String[] l = a.split(" ");
        if (l.length == 1) {
            if (!l[0].equals("cat")) {
                System.out.println("erreur: commande inconnue");
                return;
            }
            MyFrameAWT f = new MyFrameAWT();
            System.out.println("Bouton Open actionné");
            FileDialog fd = new FileDialog(f);
            fd.setVisible(true);
            String nomFichier = fd.getFile();
            String repFichier = fd.getDirectory();
            String nomComplet = repFichier + nomFichier;
            System.out.println("Nom Fichier : " + nomFichier);
            System.out.println("Répertoire Fichier : " + repFichier);
            System.out.println("Nom complet du Fichier : " + nomComplet);
            File file = new File(nomComplet);
            int size;
            size = (int) file.length();
            System.out.println("Taille du Fichier : " + size);
            try {
                FileInputStream in = new FileInputStream(file);
                byte data[] = new byte[size];
                in.read(data);
                String ss = new String(data);
                f.ta.setText(ss);

            } catch (FileNotFoundException e2) {
                System.out.println(e2);
            } catch (IOException e3) {
                System.out.println(e3);
            }


        } else if (l.length == 2) {
            if (!l[0].equals("cat")) {
                System.out.println("unknown command");
                return;
            }
            FileInputStream in = null;
            File file = new File(l[1]);
            try {
                in = new FileInputStream(file);
            } catch (FileNotFoundException e2) {
                System.out.println("file " + file + " not found");
                System.exit(0);
            }
            MyFrameAWT f = new MyFrameAWT();
            int size;
            size = (int) file.length();
            byte data[] = new byte[size];
            try {
                in.read(data);
                String ss = new String(data);
                f.ta.setText(ss);
            } catch (IOException e3) {
                System.out.println(e3);
            }

        } else {
            System.out.println("invalid input");
        }


    }
}
