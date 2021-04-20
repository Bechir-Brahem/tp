class AddVerargs {
    static void go(int x, int y) {
        System.out.println("int,int");
    }
    static void go(byte ... x) {
        System.out.println("byte ...");
    }
    static void go(Byte x) {
        System.out.println("Byte ...");
    }
    static void f(Integer x)
    {
        System.out.println("PP");

    }
    static void f(long x)
    {
        System.out.println("PaP");

    }
    public static void main(String [] args) {
        int x=2;
        f(x);
        byte b = 5;
        go(b, b);
        go(b);
        go(b, b, b);

    }

}

