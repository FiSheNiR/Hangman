package org.example;

public class Game {

    private final RandomWordFromDictionary randomWordFromDictionary;
    private final MaskWord maskWord;
    private final Hangman hangman = new Hangman();
    private final LetterStorage letterStorage = new LetterStorage();
    private final OutputManager outputManager = new OutputManager();
    private final InputHandler inputHandler = new InputHandler();

    public Game(DictionaryFromFile dictionaryFromFile) {
        this.randomWordFromDictionary = new RandomWordFromDictionary(dictionaryFromFile);
        this.maskWord = new MaskWord(randomWordFromDictionary.getRandomWordFromDictionary());
    }

    public void start() {

        System.out.println(maskWord.getGameSecretWord());
        outputManager.printGameState(maskWord, letterStorage, hangman);

        while (isGameOver()) {
            String userInput = inputHandler.getUserInput();
            if (letterStorage.isLetterInStorage(userInput)) {
                if (maskWord.IsLetterInSecretWord(userInput)) {
                    letterStorage.addUniqueLetter(userInput);
                } else {
                    letterStorage.addUniqueLetter(userInput);
                    letterStorage.addWrongLetter(userInput);
                    hangman.addHangmanState();
                }
            }
            else {
                System.out.println("Вы уже вводили эту букву");
                continue;
            }
            outputManager.printGameState(maskWord, letterStorage, hangman);
        }

    }

    private boolean isGameOver(){
        if (isWin()){
            printWinMessage();
            return false;
        }
        if (isLose()) {
            printLoseMessage();
            return false;
        }
        return true;
    }

    private boolean isWin(){
        return maskWord.checkFullUnmask();
    }

    private boolean isLose(){
        return !hangman.isAlive();
    }

    private void printWinMessage(){
        System.out.println("Вы выйграли");
    }

    private void printLoseMessage(){
        System.out.printf("Вы проиграли. Загаданнаое слово: %s%n" , new String(randomWordFromDictionary.getRandomWordFromDictionary()));
    }
}
