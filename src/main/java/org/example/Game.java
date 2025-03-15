package org.example;

import java.util.*;

public class Game {

    private int correctCounter;
    private final WordFromFile wordFromFile;
    private final MaskWord maskWord;
    private final Hangman hangman;
    private final List<String> wrongLetterList;

    Game() {
        correctCounter = 0;
        this.wrongLetterList = new ArrayList<>();
        this.wordFromFile = new WordFromFile();
        this.maskWord = new MaskWord(wordFromFile.getSecretWord());
        this.hangman = new Hangman();
    }

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler(scanner);

        Game gameState = new Game();

        System.out.println(gameState.wordFromFile.getSecretWord());
        System.out.println(gameState.maskWord);

        while (gameResult(gameState)) {
            String userInput = inputHandler.getUserInput();

            containLetter(gameState, userInput);

        }
    }

    private boolean checkLetter(String userInput) {
        char inputChar = userInput.charAt(0);
        boolean found = false;
        char[] gameSecretWord = this.wordFromFile.getSecretWord();
        for (int i = 0; i < gameSecretWord.length; i++) {
            if (gameSecretWord[i] == inputChar) {
                this.maskWord.unmaskLetter(i, inputChar);
                this.correctCounter++;
                found = true;
            }
        }
        return found;
    }

    private void printGameState(List<String> wrongLetterArray) {
        System.out.println("Ошибочные буквы: " + wrongLetterArray);
        System.out.println("Отгаданные буквы: " + maskWord);
        hangman.drawHangman();
    }

    private static void containLetter(Game gameState, String userInput) {
        if (!gameState.checkLetter(userInput)) {
            gameState.wrongLetterList.add(gameState.hangman.getMistakeNumber(), String.valueOf(userInput.charAt(0)));
            gameState.hangman.addMistakeNumber();
            System.out.println("Такой буквы нет. Количество ошибок: " + gameState.hangman.getMistakeNumber());
            gameState.printGameState(gameState.wrongLetterList);

        } else {
            System.out.println("Есть такая буква. Колличество отгаданных букв: " + gameState.correctCounter);
            gameState.printGameState(gameState.wrongLetterList);
        }
    }

    private static boolean gameResult(Game gameState){
        if (gameState.hangman.getMistakeNumber() == gameState.hangman.maxMistakeNumber()) {
            System.out.print("Вы проиграли. Загаданнаое слово: ");
            System.out.print(gameState.wordFromFile.getSecretWord());
            System.out.println();
            return false;
        }
        if (gameState.correctCounter == gameState.wordFromFile.getSecretWord().length){
            System.out.println("Вы выйграли");
            return false;
        }
        return true;
    }
}
