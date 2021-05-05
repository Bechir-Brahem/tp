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
        M passwd = new M(f);
        passwd.run();
        for (int i = 0; i < passwd.fichier.size(); i++) {
            if (passwd.fichier.get(i).get(0).equals(s)) {
                f.search.setText(String.join(":", passwd.fichier.get(i)) );
                return;
            }

        }
        f.search.setText("could not find it");




    }
}
