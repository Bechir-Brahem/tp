import java.lang.reflect.*;
class a {

    public static void  main(String []s) {
        try {
            tmp x = new tmp();
            for (Field field : x.getClass().getDeclaredFields()) {
                Object value = field.get(x);
                System.out.println(field);
                System.out.println(value);

            }
        } catch (Exception e) {
            //
        }
    }
}
class tmp {
    public int x = 40;
    public int y = 20;
}
