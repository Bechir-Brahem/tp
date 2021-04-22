import java.awt.*;
class MyAppAWT{
    public static void main(String []s)
    {
        System.out.println("Application AWT");
        MyFrameAWT f=new MyFrameAWT();
    }
}
/*
 *         Scanner sc = new Scanner(System.in);
 *         String a = sc.nextLine();
 *         String[] l = a.split(" ");
 *         if (l.length == 1) {
 *             MyFrameAWT f = new MyFrameAWT();
 *             System.out.println("Bouton Open actionné");
 *             FileDialog fd = new FileDialog(f);
 *             fd.setVisible(true);
 *             String nomFichier = fd.getFile();
 *             String repFichier = fd.getDirectory();
 *             String nomComplet = repFichier + nomFichier;
 *             System.out.println("Nom Fichier : " + nomFichier);
 *             System.out.println("Répertoire Fichier : " + repFichier);
 *             System.out.println("Nom complet du Fichier : " + nomComplet);
 *             File file = new File(nomComplet);
 *             int size;
 *             size = (int) file.length();
 *             System.out.println("Taille du Fichier : " + size);
 *             try {
 *                 FileInputStream in = new FileInputStream(file);
 *                 byte data[] = new byte[size];
 *                 in.read(data);
 *                 String ss = new String(data);
 *                 f.ta.setText(ss);
 * 
 *             } catch (FileNotFoundException e2) {
 *                 System.out.println(e2);
 *             } catch (IOException e3) {
 *                 System.out.println(e3);
 *             }
 * 
 * 
 *         } else if (l.length == 2) {
 *             MyFrameAWT f = new MyFrameAWT();
 *             File file = new File(l[1]);
 *             int size;
 *             size = (int) file.length();
 *             try {
 *                 FileInputStream in = new FileInputStream(file);
 *                 byte data[] = new byte[size];
 *                 in.read(data);
 *                 String ss = new String(data);
 *                 f.ta.setText(ss);
 * 
 *             } catch (FileNotFoundException e2) {
 *                 System.out.println(e2);
 *             } catch (IOException e3) {
 *                 System.out.println(e3);
 *             }
 * 
 *         } else {
 *             System.out.println("invalid input");
 *         }
 */


