package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        boolean error = true;
        String playAgain = "y";
        Scanner sc = new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Hello! Whats your name?");
        String a = sc.next();//string exception
        System.out.println("Well, " + a + ", I am thinking of a number between 1 and 20.");

        while (playAgain.equalsIgnoreCase("Y")) {// allows for play again
            System.out.println("Take a guess.");

            Random rand = new Random();
            int y = rand.nextInt(20) + 1;

            do{
                try {
                    int x = sc.nextInt();//integer exception start
                    int guesses = 1;
                    guesses++;
                    //int i = 1;
                    int limit = 7;
                    boolean notInt = true;
                    while (guesses < limit && x != y) {// allows for multiple guesses
                        if (x < y) {
                            System.out.println("Your guess is too low.");
                            System.out.println("Take a guess.");
                            do {
                                try {
                                    x = sc.nextInt();
                                    notInt = false;
                                } catch (Exception e) {
                                    System.out.println("Input Error. Please enter a number between 1 and 20");
                                    sc.next();
                                }
                            }while (notInt = true);
                            guesses++;
                        } else if (x > y) {
                            System.out.println("Your guess is too high.");
                            System.out.println("Take a guess.");
                            do {
                                try {
                                    x = sc.nextInt();
                                    notInt = false;
                                } catch (Exception e) {
                                    System.out.println("Input Error. Please enter a number between 1 and 20");
                                    sc.next();
                                }
                            }while (notInt = true);
                            guesses++;
                        }
                        if (x == y) {
                            System.out.println("Good job " + a + "! You guessed my number in " + (guesses - 1) + " guesses!");
                            System.out.println("Would you like to play again? (y or n) ");
                        }//integer exception end
                    }
                    error = false;
                }
                catch (Exception e) {
                    System.out.println("Input Error. Please enter a number between 1 and 20");
                    sc.next();
                }

            }while(error = true);

        }
        playAgain = sc.next();//string exception
        }
    }

