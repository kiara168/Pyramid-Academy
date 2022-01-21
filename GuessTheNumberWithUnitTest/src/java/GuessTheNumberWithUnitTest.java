import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GuessTheNumberWithUnitTest {

    public static void main(String[] args) {
        // write your code here
        boolean error = true;
        String playAgain = "y";
        Scanner sc = new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Hello! Whats your name?");
        String a = sc.next();//string exception
        System.out.println("Well, " + a + ", I am thinking of a number between 1 and 20.");

        try {
            while (playAgain.equalsIgnoreCase("Y")) {
                System.out.println("Take a guess.");
               // Random rand = new Random();
                int y = getNumberByComputer();

                int x = sc.nextInt();//integer exception start
                int guesses = 1;
                guesses++;
                int limit = 7;
                //boolean notInt = true;
                while (guesses < limit && x != y) {// allows for multiple guesses
                    if (x < y) {
                        toLow();
                        try {
                            x = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println("Input Error. Please enter a number between 1 and 20");
                            sc.next();
                        }
                        guesses++;
                    } else if (x > y) {
                        toHigh();
                        try {
                            x = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println("Input Error. Please enter a number between 1 and 20");
                            sc.next();
                        }
                        guesses++;
                    }
                    if (x == y) {
                        System.out.println("Good job " + a + "! You guessed my number in " + (guesses - 1) + " guesses!");
                        System.out.println("Would you like to play again? (y or n) ");
                    }
                }
                playAgain = sc.next();//string exception
            }

        }
        catch (Exception e) {
            System.out.println("Input Error. Please enter a number between 1 and 20");
            sc.next();
        }

    }

    public static int getNumberByComputer() {
        return ThreadLocalRandom.current().nextInt(1, 21);
    }

    public static String toHigh() {
        return "Your guess is too high. \nTake a guess.";
    }

    public static String toLow() {
        return "Your guess is too low. \nTake a guess.";
    }

}

