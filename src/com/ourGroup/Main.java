// Students: Alex Wesolowki, Chantel Drwg, Sean Yanik
// Class: CS 145 A with Mr. Criss
// Lab 1
// File Name: Main.java
/*
This program invites the user to play a guessing game. The computer picks a random number
from a range and the user tries to guess it, while being told if their guesses are too low
or too high.
Includes adjustable difficulty
 */

package com.ourGroup;

import java.util.*;//uses the random class

public class Main
{

    //Global Variables:
    public static int totalGuesses;
    public static int totalGames;
    public static int bestGuesses;//The fewest guesses any game took
    public static int minOfRange;//The minimum number in guessing range
    public static int maxOfRange;//The maximum number in guessing range
    public static int guessesAllowed; //how many guesses can the player make?


    //runs guessing game, sets up difficulty (easy, medium hard), displays stats when done
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
            gameLoop();//start game

            System.out.println("Today's Statistics:");
            System.out.println("Total Number of Guesses: " + totalGuesses);
            System.out.println("Total Number of Games: " + totalGames);
            //Average guesses calculates to one decimal point
            System.out.println("Average Guesses per game: " + ((totalGuesses * 10) / totalGames) / 10.0);

            if (bestGuesses != -1) //if the player won at least one game
            {
                System.out.println("Your best game took only " + bestGuesses + " guesses");
            } else//if the player won no games
            {
                System.out.println("You never won a game, so there isn't a best guesses number.");
            }//end of if the player won no games

        }//end of if the player wants to play

        System.out.println("Have a nice day!");//exit message
    }//end of main

    //asks user what difficulty they want to play on, sets up difficulty accordingly
    public static void setupDifficulty()
    {
        System.out.println("\nWould you like to play with a guessing range that is Easy (1-50), Medium (1-100), or Hard? (1-250)");
        String difficultySelection = getInput("easy", "medium", "hard");//does the player want an easy, medium, or hard range
        switch (difficultySelection)
        {
            case "easy":
                minOfRange = 1;
                maxOfRange = 50;
                break;
            case "medium":
                minOfRange = 1;
                maxOfRange = 100;
                break;
            case "hard":
                minOfRange = 1;
                maxOfRange = 250;
                break;
        }

        System.out.println("\nShould we have limited guesses?\n[Y/N]");
        if (getInput())//if they say yes, ask them how many guesses they want
        {
            System.out.println("Shall we play with 12 guesses, 10 guesses, or 6?");
            String guessAllowedSelection = getInput("12", "10", "6");//the user must enter 12,10, or 6
            guessesAllowed = 1 + Integer.parseInt(guessAllowedSelection);
        }
    }//end of setupDifficulty


    //getInput without parameters gets a yes or no response  from the user,
    // and keeps asking them until they give one
    public static boolean getInput()
    {
        Scanner scn_kkb = new Scanner(System.in);//make a scanner
        String input = scn_kkb.next();
        if (Character.toLowerCase(input.charAt(0)) == 'y')//if they typed yes
        {
            return true;
        } else if (Character.toLowerCase(input.charAt(0)) == 'n')//if they typed no
        {
            return false;
        } else//if they gave bad input
        {
            System.out.println("Please type Y or N.");
            return getInput();//recursively calls itself until they give good input
        }

    }//end of getInput (returning boolean)

    //get input with parameters minrange and maxrange gets an integer in that range from the user
    // and keeps asking them until they give one
    public static int getInput(int minRange, int maxRange)
    {
        Scanner scn_kkb = new Scanner(System.in);//make a scanner
        String input = scn_kkb.next();
        int returnValue;
        try
        {
            returnValue = Integer.parseInt(input);
            if (returnValue <= maxRange && returnValue >= minRange)
            {
                return returnValue;
            }
        } catch (NumberFormatException e)
        {
            System.out.println("Please type an integer");
            return getInput(minRange, maxRange);//recursively calls itself until user gives good input
        }

        System.out.println("Please type an number between " + minRange + " and " + maxRange);
        return getInput(minRange, maxRange);//recursively calls itself until user gives good input
    }//end of getInput (returning int)

    //get input with 3 string parameters gets one of those strings as a response from the user
    // and keeps asking them until they give one
    public static String getInput(String option1, String option2, String option3)
    {
        Scanner scn_kkb = new Scanner(System.in);//make a scanner
        String input = scn_kkb.next();//get input from user
        input = input.toLowerCase();//convert to lower case
        if (input.equals(option1))//if they want the first option
        {
            return option1;
        } else if (input.equals(option2))//if they want the second option
        {
            return option2;
        } else if (input.equals(option3))//if they want the third option
        {
            return option3;
        } else//if the user gave bad input
        {
            System.out.println("Please type " + option1 + ", " + option2 + " or " + option3);
            return getInput(option1, option2, option3);//recursively calls itself until user gives good input
        }

    }//end of getInput (returning String)

    //plays the guessing game until the player wants to stop
    public static void gameLoop()
    {
        boolean playAgain = true;//required for do while to compile
        do//using a do while so that the game auto plays the first time
        {
            totalGames++;
            System.out.println("\nOkay, I'm thinking of a number between " + minOfRange + " and " + maxOfRange + "...");
            Random rGen = new Random();//new random generator
            int randomNumber = (int) ((rGen.nextDouble() * maxOfRange) + 1);//get our random number
            doGuess(minOfRange, maxOfRange, guessesAllowed, 0, randomNumber);//make the player guess!
            System.out.println("Want to play again?\n[Y/N]");
            playAgain = getInput();
            if (playAgain)//if the user wants to play again
            {
                System.out.println("Shall we change the difficulty this round?\n[Y/N]");
                if (getInput())//If they want to change difficulty
                {
                    setupDifficulty();
                }
            }//end of if statement for if the user wants to play again
        } while (playAgain);//loop game if we're playing again

    }//end of gameLoop

    //Makes the player guess until they win, or exceed their guess limit
    public static void doGuess(int minRange, int maxRange, int guessesLeft, int guessesMade, int rightNumb)
    {
        guessesLeft--;
        guessesMade++;
        if (guessesLeft != 0)//if we have guesses left
        {
            System.out.println("Guess:");
            int thisGuess = getInput(minRange, maxRange);//get guess from user

            if (thisGuess < rightNumb)//if guess is too low
            {
                System.out.println(thisGuess + " is Too Low!");
                doGuess(minRange, maxRange, guessesLeft, guessesMade, rightNumb);//guess again!
            } else if (thisGuess > rightNumb)//if guess is too high
            {
                System.out.println(thisGuess + " is Too High!");
                doGuess(minRange, maxRange, guessesLeft, guessesMade, rightNumb);//guess again!
            } else //if correct guess was made
            {
                totalGuesses += guessesMade;//add guesses this round to the total guess sum

                System.out.println("That's right! " + rightNumb + " is the correct number!");
                if (guessesMade == 1) //if user guessed right on the first try
                {
                    System.out.println("You got it first try, too!");
                } else//if user didn't guess right on the first try
                {
                    System.out.println("It took you " + guessesMade + " guesses to get it.");
                }//end of if the user guessed right on the first try or not

                if (guessesMade < bestGuesses || bestGuesses == -1)//if user set a new record for guesses, or, if
                {                                                 //bestguesses = -1, because its the first round
                    bestGuesses = guessesMade;
                    System.out.println("New Record: " + bestGuesses + " guesses!");
                }
            }//end of if-else cluster about if the user guessed wrong or right

        } else//if user ran out of guesses...
        {
            System.out.println("You've run out of guesses! The correct number was " + rightNumb + ".");
            totalGuesses += guessesMade; //add to the total guess sum
        }//end of if the user ran out of guesses
    }//end of doGuess


}//end of class
