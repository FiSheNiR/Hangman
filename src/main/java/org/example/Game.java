package org.example;

public class Game {

    private final WordFromFile wordFromFile = new WordFromFile();
    private final MaskWord maskWord = new MaskWord(wordFromFile.getSecretWord());
    private final MistakeHandler mistakeHandler = new MistakeHandler();
    private final OutputManager outputManager = new OutputManager();
    private final InputHandler inputHandler = new InputHandler();

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
            System.out.printf("Вы проиграли. Загаданнаое слово: %s%n" , new String(wordFromFile.getSecretWord()));
            return false;
        }
        else if (maskWord.checkFullUnmask()){
            System.out.println("Вы выйграли");
            return false;
        }
        return true;
    }
}
