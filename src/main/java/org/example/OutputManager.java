package org.example;

public class OutputManager {

    public void printGameState(MaskWord maskWord, MistakeHandler mistakeHandler) {
        System.out.println("Ошибочные буквы: " + mistakeHandler.getWrongLetterList());
        System.out.println("Отгаданные буквы: " + maskWord);
        drawHangman(mistakeHandler);
    }

    private void drawHangman (MistakeHandler mistakeHandler) {
        System.out.println(Hangman.values()[mistakeHandler.getMistakeNumber()].getImage());
    }

}
