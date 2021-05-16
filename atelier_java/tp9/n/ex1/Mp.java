import java.util.*;

public class Mp {
    public static Vector<Counter> v = new Vector<Counter>();
    public static   Reader r = new Reader();
    public static void main(String []args) {
        int count = Integer.parseInt(args[0]);
        r.start();
        for (int j = 1; j <= count; j++) {
            int time = Integer.parseInt(args[j]);
            Counter tmp = new Counter(time, j);
            v.add(tmp);
            tmp.start();
        }
    }
}
