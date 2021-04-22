import java.awt.event.*;
import java.io.*;
import java.awt.*;
public class MyActionListenerForLoad implements ActionListener {
    MyFrameAWT f;
    public MyActionListenerForLoad(MyFrameAWT f) {
        this.f = f;
    }
    public void actionPerformed(ActionEvent e) {

        System.out.println("Bouton Load actionné");
        String s = f.search.getText();
        String []l = s.split(":");
        if (l.length != 7) {
            f.search.setText("invalid input");
            return;
        }
        m passwd = new m(f);
        passwd.run();
        boolean x = false;
        for (int i = 0; i < passwd.fichier.length; i++) {
            if (passwd.fichier[i][0].equals(l[0])) {
                x = true;
                passwd.fichier[i] = l;
                break;
            }

        }
        String out = "";
        int  i;
        for (i = 0; i < passwd.fichier.length - 1; i++) {
            String tmp = String.join(":", passwd.fichier[i]);
            out += tmp + "\n";
        }
        String tmp = String.join(":", passwd.fichier[i]);
        out += tmp;
        if (x == false) {
            out +="\n"+String.join(":",l);
        }
        f.ta.setText(out);
    }
}
