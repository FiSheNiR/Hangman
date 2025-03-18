package org.example;

import java.util.Arrays;

public class MaskWord {

    private final char MASK_SYMBOL = '_';
    private final char[] secretWord;
    private final char[] maskWord;

    MaskWord(char[] secretWord) {
        this.secretWord = secretWord;
        this.maskWord = fillMaskArray();
    }

    @Override
    public String toString() {
        return String.valueOf(maskWord);
    }

    private char[] fillMaskArray() {
        char[] maskedWord = new char[secretWord.length];
        Arrays.fill(maskedWord, MASK_SYMBOL);
        return maskedWord;
    }

    public void unmaskLetter(int index, char letter) {
        maskWord[index] = letter;
    }

    public boolean checkFullUnmask(){
        for (char c : maskWord) {
            if (c == MASK_SYMBOL) {
                return false;
            }
        }
        return true;
    }
}
