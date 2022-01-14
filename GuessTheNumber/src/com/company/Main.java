package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    //public static String Playagain()


    public static void main(String[] args) {
	// write your code here
        String playAgain = "y";
        Scanner sc = new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Hello! Whats your name?");
        String a = sc.next();

        System.out.println("Well, " + a + ", I am thinking of a number between 1 and 20.");
        while (playAgain.equalsIgnoreCase("Y")) {// allows for play again
            System.out.println("Take a guess.");

            Random rand = new Random();
            int y = rand.nextInt(21);

            int x = sc.nextInt();
            int guesses = 1;
            guesses++;
            //int i = 1;
            int limit = 7;
            while (guesses < limit && x!=y) {// allows for multiple guesses
                if (x < y) {
                    System.out.println("Your guess is too low.");
                    System.out.println("Take a guess.");
                    x = sc.nextInt();
                    guesses++;
                }
                else if (x > y) {
                    System.out.println("Your guess is too high.");
                    System.out.println("Take a guess.");
                    x = sc.nextInt();
                    guesses++;
                }
                if (x == y) {
                    System.out.println("Good job " + a + "! You guessed my number in " + (guesses -1) + " guesses!");
                    System.out.println("Would you like to play again? (y or n) ");
                }
            }
            playAgain = sc.next();
        }
    }
}
