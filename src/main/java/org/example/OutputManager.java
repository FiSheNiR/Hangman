package org.example;

public class OutputManager {

    public void printGameState(MaskWord maskWord, MistakeHandler mistakeHandler) {
        System.out.printf("Ошибочные буквы: %s%n", mistakeHandler.getWrongLetterList());
        System.out.printf("Отгаданные буквы: %s%n", maskWord);
        drawHangman(mistakeHandler);
    }

    private void drawHangman (MistakeHandler mistakeHandler) {
        System.out.println(Hangman.values()[mistakeHandler.getMistakeNumber()].getImage());
    }

}
