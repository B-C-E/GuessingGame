// Students: Alex Wesolowki, Chantel Drwg, Sean Yanik
// Class: CS 145 A with Mr. Criss
// Lab 1
/*
This program invites the user to play a guessing game. The computer picks a random number
from a range and the user tries to guess it, while being told if their guesses are too low
or too high.
Includes adjustable difficulty
 */

package com.ourGroup;

public class Main
{

    //Global Variables:
    public static int totalGuesses;
    public static int totalGames;
    public static int bestGuesses;//The fewest guesses any game took
    public static int minOfRange;//The minimum number in guessing range
    public static int maxOfRange;//The maximum number in guessing range
    public static int guessesAllowed; //how many guesses can the player make?


    //runs guessing game, sets up difficulty, displays stats when done
    public static void main(String[] args)
    {
        System.out.println("Hello, and welcome to the guessing game!" +
                "\nIn this game, I'll think of a number in a range, say, 1 to 100," +
                "\nand you can try to guess it." +
                "\nWith each guess I'll tell you if you are too low or too high." +
                "\nWould you like to play the guessing game?");
        System.out.println("[Y/N]");

        if (getInput())//If the user wants to play the game
        {
            //initiate variables
            totalGuesses = 0;
            totalGames = 0;
            bestGuesses = -1;//no best guess yet, so -1
            guessesAllowed = -1;//unlimited guesses is default

            setupDifficulty();
            gameLoop();

            System.out.println("Today's Statistics:");
            System.out.println("Total Number of Guesses: " + totalGuesses);
            System.out.println("Total Number of Games: " + totalGames);
            System.out.println("Average Guesses per game: " + ((totalGuesses * 10) / totalGames) / 10.0);
            System.out.println("Your best game took only " + bestGuesses + " guesses");

        }

        System.out.println("Have a nice day!");//exit message
    }

    public static void setupDifficulty()//asks user what difficulty they want to play on
    {
        System.out.println("\nWould you like to play with a guessing range that is Easy, Medium, or Hard?");
        String difficultySelection = getInput("Easy", "Medium", "Hard");
        switch(difficultySelection)
        {
            case "Easy":
                minOfRange = 1;
                maxOfRange = 50;
                break;
            case "Medium"
                minOfRange = 1;
            maxOfRange = 100;
                break;
            case "Hard"
                minOfRange = -100;
                maxOfRange = 100;
                break;
        }

        System.out.println("\nShould we have limited guesses?\n[Y/N]");
        if (getInput()) { //if they say yes
            System.out.println("Shall we play with 12 guesses, 10 guesses, or 6?")
            String guessAllowedSelection = getInput("12", "10", "6");
            guessesAllowed = Integer.parseInt(guessAllowedSelection);
        }
    }


    public static boolean getInput()
    {

    }

    public static int getInput(int minRange, int maxRange)
    {

    }

    public static String getInput(String option1, String option2, String option3)
    {

    }

    public static void gameLoop()
    {
        System.out.println("Okay, I'm thinking of a number between " + minOfRange + " and " + maxOfRange + "...");


    }

    public static void doGuess(int minRange, int maxRange, int guessesLeft, int guessesMade)
    {

    }


}
