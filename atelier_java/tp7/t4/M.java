import java.io.*;
import java.util.*;
public class M {
    String [][]fichier;
    MyFrameAWT f = null;
    public M(MyFrameAWT f) {
        this.f = f;
    }
    public void run() {
        try {


            String tmp = f.ta.getText();
            String []l = tmp.split("\n");
            fichier = new String[l.length][7];
            for (int i = 0; i < l.length; i++) {
                String aux[] = l[i].split(":");
                for (int j = 0; j < aux.length; j++) {
                    fichier[i][j] = (String)aux[j];
                }
            }



        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
