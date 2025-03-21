package org.example;

import java.util.List;
import java.util.Random;

public class RandomWordFromDictionary {

    private final DictionaryFromFile dictionaryFromFile;
    private final char[] randomWordFromDictionary;

    public RandomWordFromDictionary(DictionaryFromFile dictionaryFromFile) {
        this.dictionaryFromFile = dictionaryFromFile;
        this.randomWordFromDictionary = RandomWord();
    }

    public char[] getRandomWordFromDictionary() {
        return randomWordFromDictionary;
    }

    private char[] RandomWord() {
        Random random = new Random();
        List<String> wordsFromFile = dictionaryFromFile.getWordsFromFile();
        String randomWordFromFile =wordsFromFile.get(random.nextInt(wordsFromFile.size()));
        return randomWordFromFile.toUpperCase().toCharArray();
    }
}