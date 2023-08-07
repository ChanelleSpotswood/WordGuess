package com.github.zipcodewilmington;


import com.github.zipcodewilmington.sample.Console;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Wordguess {
    public static void main(String[] args){
        StringBuilder tempWord = new StringBuilder();
        boolean currGame = true;
        boolean runGame = true;
        char contPlay;


        System.out.println("Let's begin Word Guess, healthcare edition!");

        while (runGame){
            String word = getRandom();
            char[] correctWord = new char[word.length()];
            char[] guessWord = new char[word.length()];
            int numGuesses = word.length();


            for (int i = 0; i < word.length(); i++){
                correctWord[i] = word.charAt(i);
            }


            for (int i = 0; i < word.length(); i++){
                guessWord[i] = '_';
            }


            while (currGame) {
                char guess;
                System.out.println("\nCurrent Guesses:");

                for (int i = 0; i < word.length(); i++) {
                    if (i == word.length() - 1) {
                        System.out.println(guessWord[i]);
                    } else {
                        System.out.print(guessWord[i] + " ");
                    }
                }

                System.out.printf("You have %d guesses remaining.\n\n", numGuesses);


                guess = Console.getCharInput("Enter a single character (enter '-' to stop the current game):");


                if (guess == '-'){
                    break;
                }



                for (int i = 0; i < word.length(); i++) {
                    if (correctWord[i] == guess) {
                        guessWord[i] = guess;
                    }
                }


                numGuesses--;


                tempWord.setLength(0);

                for (int i = 0; i < word.length(); i++){
                    tempWord.append(guessWord[i]);
                }

                int index = tempWord.indexOf("_");

                if (index == -1) {
                    System.out.println("Congrats! You guessed the word. It was " + word + ".");
                    currGame = false;
                }

                if ((numGuesses == 0) && (index >= 0)) {
                    System.out.println("\nThe word was " + word + ".");
                    System.out.println("Sorry, you didn't guess the word correctly.");
                    break;
                }
            }

            System.out.println("\nWould you like to play again or return to waiting room?");
            contPlay = Console.getCharInput("Enter 'y' to play again or enter any other character to quit.");

            if (contPlay == 'y'){
                currGame = true;
            }
            else {
                runGame = false;
            }
        }
    }

    public static String getRandom(){
        Random rand = new Random();
        ArrayList<String> words = new ArrayList<>();

        words.add("nurse");
        words.add("doctor");
        words.add("patient");
        words.add("stretcher");
        words.add("heartbeat");
        words.add("safety");
        words.add("charting");
        words.add("sanitizer");
        words.add("ambulance");
        words.add("hospital");
        words.add("ultrasound");
        words.add("radiologist");
        words.add("technician");
        words.add("emergency");

        int x = rand.nextInt(words.size() - 1);

        return words.get(x);
    }
}

