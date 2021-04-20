import java.io.*;
class test {
    public static void main(String [] s) {
        File f=new File("oop");
        deleteDir(f);


    }

    public static void deleteDir(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (final File file : files) {
                deleteDir(file);
            }
        }
        dir.delete();
    }
}
