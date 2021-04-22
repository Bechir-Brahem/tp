import java.awt.event.*;
import java.io.*;
import java.awt.*;
public class MyActionListenerForSearch implements ActionListener {
    MyFrameAWT f;
    public MyActionListenerForSearch(MyFrameAWT f) {
        this.f = f;
    }
    public void actionPerformed(ActionEvent e) {

        System.out.println("Bouton serach actionné");
        String s = f.search.getText();
        m passwd = new m(f);
        passwd.run();
        for (int i = 0; i < passwd.fichier.length; i++) {
            if (passwd.fichier[i][0].equals(s)) {
                f.search.setText(String.join(":", passwd.fichier[i]) );
                return;
            }

        }
        f.search.setText("could not find it");




    }
}
