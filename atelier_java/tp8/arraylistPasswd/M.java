import java.io.*;
import java.util.*;
public class M {
    ArrayList<ArrayList<String>> fichier = new ArrayList<ArrayList<String>>();
    MyFrameAWT f = null;
    public M(MyFrameAWT f) {
        this.f = f;
    }
    public void update(int i, String []s) {
        fichier.set(i, f(s));
    }
    private ArrayList<String> f(String [] s) {
        ArrayList<String> tmp = new ArrayList<String>();
        for (String x : s) {
            tmp.add(x);
        }
        return tmp;
    }
    public void print() {
        for (var x : fichier) {
            System.out.println(x);
        }
    }
    public void run() {
        try {
            String tmp = f.ta.getText();
            ArrayList<String> l = f(tmp.split("\n"));
            for (String x : l) {
                fichier.add(f(x.split(":")));
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
