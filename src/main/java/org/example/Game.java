package org.example;

import java.util.*;

public class Game {

    private final WordFromFile wordFromFile = new WordFromFile();
    private final MaskWord maskWord = new MaskWord(wordFromFile.getSecretWord());
    private final MistakeHandler mistakeHandler = new MistakeHandler();
    private final OutputManager outputManager = new OutputManager();
    private final Scanner scanner = new Scanner(System.in);
    private final InputHandler inputHandler = new InputHandler(scanner);

    public void start() {

        System.out.println(wordFromFile.getSecretWord());
        System.out.println(maskWord);

        while (gameResult()) {
            String userInput = inputHandler.getUserInput();
            mistakeHandler.containLetter(userInput, wordFromFile, maskWord);
            outputManager.printGameState(maskWord, mistakeHandler);
        }

    }

    private boolean gameResult(){
        if (mistakeHandler.getMistakeNumber() == mistakeHandler.maxMistakeNumber()) {
            System.out.print("Вы проиграли. Загаданнаое слово: ");
            System.out.print(wordFromFile.getSecretWord());
            System.out.println();
            return false;
        }
        if (maskWord.checkFullUnmask()){
            System.out.println("Вы выйграли");
            return false;
        }
        return true;
    }
}
