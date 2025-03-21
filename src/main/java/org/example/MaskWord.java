package org.example;

import java.util.Arrays;

public class MaskWord {

    private final char MASK_SYMBOL = '_';
    private final char[] gameSecretWord;
    private final char[] maskWord;

    MaskWord(char[] gameSecretWord) {
        this.gameSecretWord = gameSecretWord;
        this.maskWord = fillMaskArray();
    }

    public char[] getGameSecretWord() {
        return gameSecretWord;
    }

    private char[] fillMaskArray() {
        char[] maskedWord = new char[gameSecretWord.length];
        Arrays.fill(maskedWord, MASK_SYMBOL);
        return maskedWord;
    }

    public boolean checkFullUnmask(){
        for (char c : maskWord) {
            if (c == MASK_SYMBOL) {
                return false;
            }
        }
        return true;
    }

    public boolean IsLetterInSecretWord(String userInput) {
        char inputChar = userInput.charAt(0);
        boolean found = false;
        for (int i = 0; i < gameSecretWord.length; i++) {
            if (gameSecretWord[i] == inputChar) {
                maskWord[i] = inputChar;
                found = true;
            }
        }
        return found;
    }

    @Override
    public String toString() {
        return String.valueOf(maskWord);
    }
}
