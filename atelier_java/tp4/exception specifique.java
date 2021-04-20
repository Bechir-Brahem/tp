public class other {
    public static void main(String []s) {
        int i = 0;
        try {

            int []a = {1, 2, 3, 4};
            for (i = 0; i < 6; i++) {
                a[i]++;
                System.out.println("index: " + i);
            }

        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            System.out.println("out of bounds index: " + i);
            return;
        }
        catch (Exception e)
        {
            System.out.println("error");
        }

    }
}

