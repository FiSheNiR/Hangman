package org.example;

import java.util.*;

public class Game {

    private int correctCounter;
    private final WordFromFile wordFromFile;
    private final MaskWord maskWord;
    private final Hangman hangman;

    Game() {
        correctCounter = 0;
        this.wordFromFile = new WordFromFile();
        this.maskWord = new MaskWord(wordFromFile.getSecretWord());
        this.hangman = new Hangman();
    }

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler(scanner);

        boolean running = true;

        Game gameState = new Game();
        List<String> wrongLetterList = new ArrayList<>();

        System.out.println(gameState.wordFromFile.getSecretWord());
        System.out.println(gameState.maskWord);

        while (running) {
            String userInput = inputHandler.getUserInput();

            if (!gameState.checkLetter(userInput)) {
                wrongLetterList.add(gameState.hangman.getMistakeNumber(), String.valueOf(userInput.charAt(0)));
                gameState.hangman.addMistakeNumber();
                System.out.println("Такой буквы нет. Количество ошибок: " + gameState.hangman.getMistakeNumber());
                gameState.printGameState(wrongLetterList);

            } else {
                System.out.println("Есть такая буква. Колличество отгаданных букв: " + gameState.correctCounter);
                gameState.printGameState(wrongLetterList);
            }
            if (gameState.hangman.getMistakeNumber() == gameState.hangman.maxMistakeNumber()) {
                System.out.println("Вы проиграли");
                running = false;
            }
            if (gameState.correctCounter == gameState.wordFromFile.getSecretWord().length){
                System.out.println("Вы выйграли");
                running = false;
            }
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
}
