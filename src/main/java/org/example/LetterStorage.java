package org.example;

import java.util.HashSet;
import java.util.Set;

public class LetterStorage {

    private final Set<String> uniqueLetters = new HashSet<>();
    private final Set<String> wrongLetters = new HashSet<>();

    public Set<String> getWrongLetters() {
        return wrongLetters;
    }

    public void addWrongLetter(String letter) {
        wrongLetters.add(letter);
    }

    public boolean isLetterInStorage(String letter){
        return uniqueLetters.add(letter);
    }

    public void addUniqueLetter(String userInput) {
            uniqueLetters.add(userInput);
    }



}
