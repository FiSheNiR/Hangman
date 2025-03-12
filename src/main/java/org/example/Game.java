package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {

    private static int mistakeCounter;
    private static int correctCounter;
    private static final int MAX_MISTAKE_COUNT = 6;

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        char[] secretWord = WordSelect.getWord();
        char[] maskedWord = maskWord(secretWord);
        char[] wrongLetter = new char[MAX_MISTAKE_COUNT];
        Map<String, Integer> duplicateLetters = new HashMap<>();
        System.out.println(secretWord);
        System.out.println(maskedWord);
        Hangman.drawHangman(0);

        while (running) {
            String input = scanner.nextLine().toUpperCase();
            if (duplicateLetters.containsKey(input)) {
                System.out.println("Вы уже вводили эту букву попробуйте еще раз");
                continue;
            }
            duplicateLetters.put(input, 0);
            if (!checkLetter(input,secretWord,maskedWord)) {
                wrongLetter[mistakeCounter] = input.charAt(0);
                mistakeCounter++;
                System.out.println("Такой буквы нет. Количество ошибок: " + mistakeCounter);
                System.out.println("Ошибочные буквы: " + Arrays.toString(wrongLetter));
                Hangman.drawHangman(mistakeCounter);
            } else {
                System.out.println("Есть такая буква. Колличество отгаданных букв: " + correctCounter);
                System.out.println(maskedWord);
            }
            if (mistakeCounter == MAX_MISTAKE_COUNT) {
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

    private static boolean checkLetter(String input, char[] secretWord, char[] maskedWord) {
        char inputChar = input.charAt(0);
        boolean found = false;
        for (int i = 0; i < secretWord.length; i++) {
            if (secretWord[i] == inputChar) {
                unmaskLetter(maskedWord, i,secretWord[i]);
                correctCounter++;
                found = true;
            }
        }
        return found;
    }

    private static void unmaskLetter(char[] maskedWord, int index, char letter) {
        maskedWord[index] = letter;
    }
}
