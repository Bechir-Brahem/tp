import java.io.*;
import java.util.Scanner;
public class shell {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        File f = new File(".");
        shell fn = new shell();
        int choix = 0;
        Scanner sc = new Scanner(System.in);
        while (choix != 99) {
            System.out.println("Choisir une commande :");
            System.out.println("1- ls");
            System.out.println("2- pwd");
            System.out.println("3- rm");
            System.out.println("4- cat");
            System.out.println("5- cp");
            System.out.println("6- mv");
            System.out.println("7- mkdir");
            System.out.println("8- touch");
            System.out.println("99- exit");

            choix = sc.nextInt();

            switch (choix) {
            case 1:
                fn.ls(f);
                System.out.println();
                break;
            case 2:
                fn.pwd(f);
                System.out.println();
                break;
            case 3:
                fn.removes();
                System.out.println();
                break;
            case 4:
                fn.cat();
                System.out.println();
                break;
            case 5:
                fn.cp();
                System.out.println();
                break;
            case 6:
                fn.mv();
                System.out.println();
                break;
            case 7:
                fn.mkdir();
                System.out.println();
                break;
            case 8:
                fn.touch();
                System.out.println();
                break;

            }
        }
        sc.close();

    }



    void mv() {
        System.out.println("saisir votre fichier source ");
        String source = sc.next();
        File so = new File(source);
        if (!so.exists()) {
            System.out.println("\tfichier source n'existe pas");
            return;
        }
        System.out.println("sasir votre dossier/fichier de destination ");
        String dest = sc.next();
        File to = new File(dest);
        if (so.renameTo(to)) {
            System.out.println("\tsuccés");
        } else {
            System.out.println("\terreur");
        }



    }
    void removes() {
        sc = new Scanner(System.in);
        System.out.println("saisir le fichier ");
        String s = sc.next();
        File removed = new File(s);
        if (removed.delete()) {
            System.out.println("\tDeleted the file: " + removed.getName());
        } else {
            System.out.println("\tFailed to delete the file.");
        }

    }

    void cp() throws IOException {
        sc = new Scanner(System.in);
        System.out.println("saisir le fichier a copier ");
        String s = sc.next();
        File original = new File(s);
        System.out.println("saisir le fichier de destination ");
        s = sc.next();
        File copied = new File(s);

        try (
                InputStream in = new BufferedInputStream(
                new FileInputStream(original));
                OutputStream out = new BufferedOutputStream(
                new FileOutputStream(copied))) {

            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        } catch (FileNotFoundException e) {
            System.out.println("\tfile not found");
        }

    }
    void cat() {
        try {
            System.out.println("saisir le fichier ");
            sc = new Scanner(System.in);
            String s = sc.next();
            FileInputStream input = new FileInputStream(s);
            System.out.println("Data in the file: ");
            System.out.println();
            int i = input.read();
            while (i != -1) {
                System.out.print((char)i);
                i = input.read();
            }
            input.close();
            System.out.println();
        }

        catch (Exception e) {
            e.getStackTrace();
        }

    }
    void ls(File f) {
        // ls
        String[] pathnames = f.list();
        for (String s : pathnames) {
            System.out.println("\t" + s);
        }
    }
    void pwd(File f) {
        // pwd
        System.out.println("\t" + f.getAbsolutePath());
    }
    void mkdir() {
        System.out.println("Saisir le nom de votre dossier : ");
        String s = sc.next();
        File f = new File(s);
        if (f.exists()) {
            System.out.println("\tERREUR: le dossier existe");
            return;
        }
        if (f.mkdir()) {
            System.out.println("\tsuccés");
        } else {
            System.out.println("\terreur");
        }

    }
    void touch() {
        System.out.println("saisir le nom de votre fichier: ");
        String s = sc.next();
        File f = new File(s);
        if (f.exists()) {
            System.out.println("\tERREUR: le fichier existe");
            return;
        }
        try {
            if (f.createNewFile()) {
                System.out.println("\tsuccés");
            } else {
                System.out.println("\terreur");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
