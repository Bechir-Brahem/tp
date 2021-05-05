public class Etudiant implements Comparable<Etudiant>{
    String name;
    String sur_name;
    double avg;
    public Etudiant(String a,String b,double c)
    {
        name=a;
        sur_name=b;
        avg=c;
    }
    public int compareTo(Etudiant e)
    {
        return (int) (avg-e.avg);
    }
    public String toString()
    {
        return name+" "+sur_name+" "+avg;
    }
}
