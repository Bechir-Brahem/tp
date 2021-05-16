import java.util.*;
class Reader extends Thread {
    Scanner sc = new Scanner(System.in);
    public void run() {
        int choice;
        while (true) {
            System.out.println("\n#############\ntype: \n1 to stop a thread\n2 to unpause a thread\n3 to kill a thread\n#############\n");
            choice = sc.nextInt();
            System.out.println("\n#############\nselect a thread id\n#############\n");
            int id = sc.nextInt();
            if(id>Mp.v.size())
                continue;
            Counter tmp = Mp.v.get(id - 1);
            if (choice == 1) {
                tmp.pause();
            } else if (choice == 2) {
                tmp.unpause();
            } else if (choice == 3) {
                tmp.interrupt();
            } else {
                System.out.println("wrong input");
            }


        }
    }

}
