import java.util.ArrayList;
import java.util.Collections;

public class Uni
{
    public static void main(String[]args)
    {
        ArrayList<Etudiant> students=new ArrayList<Etudiant>();
        students.add(new Etudiant("ahmed","moudir",19.2));
        students.add(new Etudiant("samir","xx",12.2));
        students.add(new Etudiant("khalil","aa",3.2));
        students.add(new Etudiant("azer","c",69.420));
        students.add(new Etudiant("sawsen","t",17.69));
        students.add(new Etudiant("ala","bh",5.420));
        System.out.println(students);
        Collections.sort(students);
        System.out.println(students);



    }

}
