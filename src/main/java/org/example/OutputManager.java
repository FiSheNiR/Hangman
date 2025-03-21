package org.example;

public class OutputManager {

    public void printGameState(MaskWord maskWord, LetterStorage letterStorage, Hangman hangman) {
        System.out.printf("Ошибочные буквы: %s %n", letterStorage.getWrongLetters());
        System.out.printf("Отгаданные буквы: %s %n", maskWord);
        drawHangman(hangman);
    }

    private void drawHangman (Hangman hangman) {
        int mistakeNumber = hangman.getCurrentHangmanState();
        String hangmanImage = Hangman.getImage(mistakeNumber);
        System.out.println(hangmanImage);
    }

}
