package org.example;

import java.util.*;

public class Game {

    private static int correctCounter;
    private static final int HANGMAN_START_POSITION = 0;

    public static void start() {
        correctCounter = 0;
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        WordFromFile wordFromFile = new WordFromFile();
        MaskWord maskedWord = new MaskWord(wordFromFile.getSecretWord());
        Hangman hangman = new Hangman(HANGMAN_START_POSITION);

        List<String> wrongLetterArray = new ArrayList<>();
        Map<String, Integer> duplicateLetters = new HashMap<>();

        //System.out.println(maskedWord.getSecretWord());
        System.out.println(maskedWord.getMaskWord());
        //hangman.drawHangman();

        while (running) {
            String userInput = scanner.nextLine().toUpperCase();

            if (userInput.length() != 1 || !userInput.matches("[А-Яа-яЁё]")) {
                System.out.println("Вам надо ввести одну русскую букву");
                continue;
            }

            if (duplicateLetters.containsKey(userInput)) {
                System.out.println("Вы уже вводили эту букву попробуйте еще раз");
                continue;
            }
            duplicateLetters.put(userInput, 0);
            if (!checkLetter(userInput, wordFromFile,maskedWord)) {
                wrongLetterArray.add(hangman.getMistakeNumber(), String.valueOf(userInput.charAt(0)));
                hangman.addMistakeNumber();
                System.out.println("Такой буквы нет. Количество ошибок: " + hangman.getMistakeNumber());
                printGameState(wrongLetterArray,maskedWord,hangman);

            } else {
                System.out.println("Есть такая буква. Колличество отгаданных букв: " + correctCounter);
                printGameState(wrongLetterArray,maskedWord,hangman);
            }
            if (hangman.getMistakeNumber() == hangman.maxMistakeNumber()) {
                System.out.println("Вы проиграли");
                running = false;
            }
            if (correctCounter == wordFromFile.getSecretWord().length){
                System.out.println("Вы выйграли");
                running = false;
            }
        }
    }

    private static boolean checkLetter(String input, WordFromFile wordFromFile, MaskWord maskedWord) {
        char inputChar = input.charAt(0);
        boolean found = false;
        char[] gameSecretWord = wordFromFile.getSecretWord();
        for (int i = 0; i < gameSecretWord.length; i++) {
            if (gameSecretWord[i] == inputChar) {
                maskedWord.unmaskLetter(i, inputChar);
                correctCounter++;
                found = true;
            }
        }
        return found;
    }

    private static void printGameState(List<String> wrongLetterArray, MaskWord maskedWord, Hangman hangman) {
        System.out.println("Ошибочные буквы: " + wrongLetterArray);
        System.out.println("Отгаданные буквы: " + maskedWord);
        hangman.drawHangman();
    }
}
