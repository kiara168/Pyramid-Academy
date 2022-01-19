import java.util.Scanner;

public class DragonCaveWithUnitTest {

    public static void main(String[] args) {
        // write your code here
       System.out.print(Intro());
        boolean error = true;


        Scanner sc = new Scanner(System.in); //System.in is a standard input stream.
        do {
            try {
                int a = sc.nextInt();
                WhichDragon(a);
                error = false;
            }
            catch (Exception e) {
                System.out.println("Input Error. Please Enter 1 or 2.");
                sc.next();
            }
        }while(error);
    }
    public static String Intro() {
        return "You are in a land full of Dragons. In front of you, \nyou see two caves. In one cave, the dragon is friendly \nand will share his treasure with you. The other dragon \nis greedy and hungry and will eat you on sight. \nWhich cave will you go into? (1 or 2)";
    }
    public static String WhichDragon(int x) {
        if (x == 1) {
            return "You approach the cave... \nIt is dark and spooky... \nA large dragon jumps out in front of you! He opens his jaws and... \nGobbles you down in one bite!";
            //if 1 you got the mean dragon
        }
        else {
            return "You approach the cave... \nIt is dark and spooky... \nA large dragon jumps out in front of you! He opens his jaws and... \nTells you that you can take as much treasure as you want!";
        }
    }
}

