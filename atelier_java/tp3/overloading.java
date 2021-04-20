public class overloading {
    // static void f(long x) {
        // System.out.println("f() long");
    // }
    static void f(int x) {
        System.out.println("f() int");
    }
    static void f(float x)
    {
        System.out.println("f() float");
    }
    static void f(byte... x)
    {
        System.out.println("f() ... byte");
    }
    public static void main(String [] s) {
        short x = 1;
        f(x);
        long y=2;
        f(y);
        byte z=3;
        f(z);

    }
}
