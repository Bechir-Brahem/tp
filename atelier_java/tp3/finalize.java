class test {
    public int [] t;
    test() {
        t = new int[100];
        System.gc();
    }
   public void  finalize()
    {
        System.out.println("finaliz..e");
    }
}
class finalize {
    public    static void main(String [  ] s) {
        int a = 2;
        System.out.println("bbooo" + a);
        test p=new test();
        p=null;
        System.gc();
    }
    public void finalize()
    {
        System.out.println("finalize..main");

    }
}
