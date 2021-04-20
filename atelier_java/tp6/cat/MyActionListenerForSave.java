import java.awt.event.*;
import java.io.*;
import java.awt.*;
public class MyActionListenerForSave implements ActionListener {
    MyFrameAWT f;
    public MyActionListenerForSave(MyFrameAWT f) {
        this.f = f;
    }
    public void actionPerformed(ActionEvent e) {
        try {
            FileDialog fd = new FileDialog(f,"save file",FileDialog.SAVE);
            fd.setVisible(true);
            String nomFichier = fd.getFile();
            String dir=fd.getDirectory();
            String s =   f.ta.getText();
            FileOutputStream outputStream = new FileOutputStream(dir+nomFichier);
            byte[] strToBytes = s.getBytes();
            outputStream.write(strToBytes);

            outputStream.close();


        } catch (Exception es) {
            es.printStackTrace();
        }

    }
}
