package org.example;

import java.util.List;
import java.util.Random;

public class SecretWord {

    private final WordsListFromFile wordsListFromFile;
    private final char[] secretWord;

    public SecretWord(WordsListFromFile wordsListFromFile) {
        this.wordsListFromFile = wordsListFromFile;
        this.secretWord = getRandomWord();
    }

    public char[] getSecretWord() {
        return secretWord;
    }

    private char[] getRandomWord() {
        List<String> wordsList = wordsListFromFile.getWordsList();
        return randomWord(wordsList).toUpperCase().toCharArray();
    }

    private String randomWord(List<String> words) {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }
}