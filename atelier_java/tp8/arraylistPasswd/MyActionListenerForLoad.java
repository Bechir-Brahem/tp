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
        M passwd = new M(f);
        passwd.run();
        boolean x = false;
        for (int i = 0; i < passwd.fichier.size(); i++) {
            System.out.println(passwd.fichier.get(i));
            if (passwd.fichier.get(i).get(0).equals(l[0])) {
                x = true;
                passwd.update(i,l);
                break;
            }

        }
        String out = "";
        int  i;
        for (i = 0; i < passwd.fichier.size() - 1; i++) {
            String tmp = String.join(":", passwd.fichier.get(i));
            out += tmp + "\n";
        }
        String tmp = String.join(":", passwd.fichier.get(i));
        out += tmp;
        if (x == false) {
            out +="\n"+String.join(":",l);
        }
        f.ta.setText(out);
    }
}
