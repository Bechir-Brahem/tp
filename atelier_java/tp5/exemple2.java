public class exemple2 {
    public static void main(String []s) {
        StringBuffer sb = new StringBuffer("abc");
        sb.append("def");
        System.out.println("sb = " + sb);
        StringBuilder sb2 = new StringBuilder("abc");
        sb2.append("def").reverse().insert(3, "---");
        System.out.println( sb2 );
    }
}
