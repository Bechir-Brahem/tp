import java.util.regex.*;
class RegexSmall {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("ab"); // the expression
        Matcher m = p.matcher("abaaaba");
// the source
        boolean b = false;
        while (b = m.find()) {
            System.out.print(m.start() + " ");
        }
    }
}
