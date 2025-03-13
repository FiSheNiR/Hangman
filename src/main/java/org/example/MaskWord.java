package org.example;

import java.util.Arrays;

public class MaskWord {


    private final char[] secretWord;
    private final char[] maskWord;

    MaskWord(char[] secretWord) {
        this.secretWord = secretWord;
        this.maskWord = maskWord();
    }

    public char[] getMaskWord() {
        return maskWord;
    }

    @Override
    public String toString() {
        return String.valueOf(maskWord);
    }

    private char[] maskWord() {
        char[] maskedWord = new char[secretWord.length];
        Arrays.fill(maskedWord, '_');
        return maskedWord;
    }

    public void unmaskLetter(int index, char letter) {
        maskWord[index] = letter;
    }

}
