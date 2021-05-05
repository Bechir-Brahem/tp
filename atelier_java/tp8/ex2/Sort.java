import java.util.*;
class Sort {
    public static void main(String [] args) {
        System.out.println("Collections methods applied to ArrayList elements");
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(8);
        a.add(4);
        a.add(6);
        System.out.println("a=" + a);
        System.out.println("Sorting a elements...");
        Collections.sort(a);
        System.out.println("a=" + a);
    }
}
