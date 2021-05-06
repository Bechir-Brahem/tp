import java.awt.event.*;
import java.io.*;
import java.awt.*;
public class MyActionListenerForOpenO implements ActionListener {
    MyFrameAWT f;
    public MyActionListenerForOpenO(MyFrameAWT f) {
        this.f = f;
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println("Bouton Open actionné");
        FileDialog fd = new FileDialog(f, "open a file obj", FileDialog.LOAD);
        fd.setVisible(true);
        String nomFichier = fd.getFile();
        String repFichier = fd.getDirectory();
        String nomComplet = repFichier + nomFichier;
        File file = new File(nomComplet);
        try {
            String perso;
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream si = new ObjectInputStream(fi);
            perso = (String)si.readObject();
            f.ta.setText(perso);
            si.close();

        } catch (java.io.IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }
}
