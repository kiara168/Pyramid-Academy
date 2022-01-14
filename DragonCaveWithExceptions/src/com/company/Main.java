package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        boolean error = true;
        System.out.println("You are in a land full of Dragons. In front of you, \nyou see two caves. In one cave, the dragon is friendly \nand will share his treasure with you. The other dragon \nis greedy and hungry and will eat you on sight.");
//print out intro

        Scanner sc = new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Which cave will you go into? (1 or 2)");

        do {
            try {
                int a = sc.nextInt();
                if (a == 1) {
                    System.out.println("You approach the cave... \nIt is dark and spooky... \nA large dragon jumps out in front of you! He opens his jaws and... \nGobbles you down in one bite!");
                    //if 1 you got the mean dragon
                }
                else {
                    System.out.println("You approach the cave... \nIt is dark and spooky... \nA large dragon jumps out in front of you! He opens his jaws and... \nTells you that you can take as much treasure as you want!");
                }
                error = false;
            }
            catch (InputMismatchException e) {
                System.out.println("Input is not an integer. Please Enter 1 or 2.");
                sc.next();
            }
        }while(error);
    }
}

