package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Game {

    private static int errorCounter;
    private static int correctCounter;

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        char[] secretWord = WordSelect.getWord();
        char[] maskedWord = maskWord(secretWord);
        System.out.println(secretWord);
        System.out.println(maskedWord);

        while (running) {
            String input = scanner.nextLine().toUpperCase();
            if (!checkLetter(input,secretWord)) {
                errorCounter++;
                System.out.println("Такой буквы нет " + errorCounter);
                //Рисуем виселицу
            } else {
                correctCounter++;
                System.out.println("Есть такая буква " + correctCounter);
                //showLetter
            }
            if (errorCounter == 3){
                System.out.println("Вы проиграли");
                running = false;
            }
            if (correctCounter == secretWord.length){
                System.out.println("Вы выйграли");
                running = false;
            }
        }
    }

    private static char[] maskWord(char[] word) {
        char[] maskedWord = new char[word.length];
        Arrays.fill(maskedWord, '_');
        return maskedWord;
    }

    public static boolean checkLetter(String input, char[] secretWord) {

        char targetChar = input.charAt(0);

        for (char c : secretWord) {
            if (c == targetChar) {
                return true;
            }
        }

        return false;
    }
}
