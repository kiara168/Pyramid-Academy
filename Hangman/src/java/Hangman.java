import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    //computer thinks of a word and draws a blank line for each letter of the word
    //user inputs guesses for letters in the word.
    Scanner sc = new Scanner();

    private ArrayList<String> words; //a list of words to pick from
    private char[] wordToGuess; //the target word we're trying to guess
    private char[] wordSoFar; //the word we've guessed so far (starts out as underscores!)
    private ArrayList<Character> alreadyGuessed; //the list of characters we've guessed
    private Random gen = new Random(); //a random generator for generating random numbers
    private ArrayList<String> missedLetters; //wrong guesses
    private int count;//number of times wrong letter was put in.

    //main:
    //make hangman drawing
     public static main(String args[]){
         System.out.println("HANGMAN");
         System.out.println("+---+");
          nextLine();
         System.out.println("|");
          nextLine();
         System.out.println("|");
          nextLine();
         System.out.println("|");
          nextLine();
         System.out.println("===");
          nextLine();
         System.out.println("Missed Letters: " + missedLetters);
     }

    //get random word from computer
    //pick a random word
     WordList list = new WordList(); //the list of words
     words = list.getWords(); //put the list in the words ArrayList
     words = new ArrayList<String>(); //make an empty word ArrayList
     words.add(debugWord); //add just the debugWord

    //create blank spaces for that word
    int randIndex = gen.nextInt(words.size()); //pick a random item from teh list
    wordToGuess = words.get(randIndex).toCharArray(); //get that item and convert to a charArray to store
    wordSoFar = new char[wordToGuess.length]; //make the wordSoFar (which has the same length
    for(int i=0; i<wordToGuess.length; i++) //fill with underscores
       {
         wordSoFar[i] = '_';
        }

    alreadyGuessed = new ArrayList<Character>(); //initialize the alreadyGuessed array
    String guess = sc.nextLine();
    getGuesses(guess);
    // as many guess as length of word
    //allow for play again


    //method 1
    //get user guess, if guess in word, put it into the right spot in blanks
    //if guess not in word, add to the hangman /call method 2
    //if guess already guessed choose another guess
//    return String;
    public static String getGuesses(String guess){
        for( String letter : wordToGuess){
            if(letter = guess){
                wordSoFar[letter.length - 1] = guess;
            }
            else{
                missedLetters += guess;
                count++;
                call method 2
                   }
//


                //method 2
                // top of hangman is an O, rest is vertical dashes
//    public static void drawHangman(String){
//        if(count = 1){
                //      System.out.println("+---+");
                //       nextLine();
                //      System.out.println("O   |");
                //       nextLine();
                //      System.out.println("|");
                //       nextLine();
                //      System.out.println("|");
                //       nextLine();
                //      System.out.println("===");
                //       nextLine();
                //      System.out.println("Missed Letters: " + missedLetters);
                //      }
                //    else if(count = 2) {
                //      System.out.println("+---+");
                //       nextLine();
                //      System.out.println("O   |");
                //       nextLine();
                //      System.out.println("|   |");
                //       nextLine();
                //      System.out.println("|");
                //       nextLine();
                //      System.out.println("===");
                //       nextLine();
                //      System.out.println("Missed Letters: " + missedLetters);
                //    }
                //     else if (count = 3){
                //
                //     else if (count = 4){
                //

//        return String;
//    }

                // We are going to create a Hangman Game with Java keywords :)

//    public void playAgain(String ans){
//        while(ans.equalsIgnoreCase("yes")){
//            play();
//        }
//    }

                private static String[] words = {"terminator", "banana", "computer", "cow", "rain", "water" };
                private static String word = words[(int) (Math.random() * words.length)];
                private static String asterisk = new String(new char[word.length()]).replace("\0", "*");
                private static int count = 0;

                public static void main(String[] args) {
                    Scanner sc = new Scanner(System.in);

                    while (count < 7 && asterisk.contains("*")) {
                        System.out.println("Guess any letter in the word");
                        System.out.println(asterisk);
                        String guess = sc.next();
                        hang(guess);
                    }
                    sc.close();
                }

                public static void hang(String guess) {
                    String newasterisk = "";
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == guess.charAt(0)) {
                            newasterisk += guess.charAt(0);
                        } else if (asterisk.charAt(i) != '*') {
                            newasterisk += word.charAt(i);
                        } else {
                            newasterisk += "*";
                        }
                    }

                    if (asterisk.equals(newasterisk)) {
                        count++;
                        hangmanImage();
                    } else {
                        asterisk = newasterisk;
                    }
                    if (asterisk.equals(word)) {
                        System.out.println("Correct! You win! The word was " + word);
                    }
                }

                public static void hangmanImage() {
                    if (count == 1) {
                        System.out.println("Wrong guess, try again");
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println("___|___");
                        System.out.println();
                    }
                    if (count == 2) {
                        System.out.println("Wrong guess, try again");
                        System.out.println("   |");
                        System.out.println("   |");
                        System.out.println("   |");
                        System.out.println("   |");
                        System.out.println("   |");
                        System.out.println("   |");
                        System.out.println("   |");
                        System.out.println("___|___");
                    }
                    if (count == 3) {
                        System.out.println("Wrong guess, try again");
                        System.out.println("   ____________");
                        System.out.println("   |");
                        System.out.println("   |");
                        System.out.println("   |");
                        System.out.println("   |");
                        System.out.println("   |");
                        System.out.println("   |");
                        System.out.println("   | ");
                        System.out.println("___|___");
                    }
                    if (count == 4) {
                        System.out.println("Wrong guess, try again");
                        System.out.println("   ____________");
                        System.out.println("   |          _|_");
                        System.out.println("   |         /   \\");
                        System.out.println("   |        |     |");
                        System.out.println("   |         \\_ _/");
                        System.out.println("   |");
                        System.out.println("   |");
                        System.out.println("   |");
                        System.out.println("___|___");
                    }
                    if (count == 5) {
                        System.out.println("Wrong guess, try again");
                        System.out.println("   ____________");
                        System.out.println("   |          _|_");
                        System.out.println("   |         /   \\");
                        System.out.println("   |        |     |");
                        System.out.println("   |         \\_ _/");
                        System.out.println("   |           |");
                        System.out.println("   |           |");
                        System.out.println("   |");
                        System.out.println("___|___");
                    }
                    if (count == 6) {
                        System.out.println("Wrong guess, try again");
                        System.out.println("   ____________");
                        System.out.println("   |          _|_");
                        System.out.println("   |         /   \\");
                        System.out.println("   |        |     |");
                        System.out.println("   |         \\_ _/");
                        System.out.println("   |           |");
                        System.out.println("   |           |");
                        System.out.println("   |          / \\ ");
                        System.out.println("___|___      /   \\");
                    }
                    if (count == 7) {
                        System.out.println("GAME OVER!");
                        System.out.println("   ____________");
                        System.out.println("   |          _|_");
                        System.out.println("   |         /   \\");
                        System.out.println("   |        |     |");
                        System.out.println("   |         \\_ _/");
                        System.out.println("   |          _|_");
                        System.out.println("   |         / | \\");
                        System.out.println("   |          / \\ ");
                        System.out.println("___|___      /   \\");
                        System.out.println("GAME OVER! The word was " + word);
                    }
                }
            }
        }
    }

