package org.example;

public class Game {

    private final SecretWord secretWord;
    private final MaskWord maskWord;
    private final MistakeHandler mistakeHandler = new MistakeHandler();
    private final OutputManager outputManager = new OutputManager();
    private final InputHandler inputHandler = new InputHandler();

    public Game(WordsListFromFile wordsListFromFile) {
        this.secretWord = new SecretWord(wordsListFromFile);
        this.maskWord = new MaskWord(secretWord.getSecretWord());
    }

    public void start() {

        //System.out.println(secretWord.getSecretWord());
        outputManager.printGameState(maskWord, mistakeHandler);

        while (gameResult()) {
            String userInput = inputHandler.getUserInput();
            mistakeHandler.containLetter(userInput, secretWord, maskWord);
            outputManager.printGameState(maskWord, mistakeHandler);
        }

    }

    private boolean gameResult(){
        if (mistakeHandler.getMistakeNumber() == mistakeHandler.maxMistakeNumber()) {
            System.out.printf("Вы проиграли. Загаданнаое слово: %s%n" , new String(secretWord.getSecretWord()));
            return false;
        }
        if (maskWord.checkFullUnmask()){
            System.out.println("Вы выйграли");
            return false;
        }
        return true;
    }
}
