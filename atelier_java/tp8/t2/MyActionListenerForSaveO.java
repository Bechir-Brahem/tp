import java.awt.event.*;
import java.io.*;
import java.awt.*;
public class MyActionListenerForSaveO implements ActionListener {
    MyFrameAWT f;
    public MyActionListenerForSaveO(MyFrameAWT f) {
        this.f = f;
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println("Bouton Open actionné");
        FileDialog fd = new FileDialog(f, "select passwd file", FileDialog.SAVE);
        fd.setVisible(true);
        String nomFichier = fd.getFile();
        String repFichier = fd.getDirectory();
        String nomComplet = repFichier + nomFichier;
        String text = f.ta.getText();
        File f = new File(nomComplet);
        try {
            FileOutputStream of = new FileOutputStream(f);
            ObjectOutputStream objf = new ObjectOutputStream(of);
            objf.writeObject(text);
            objf.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
