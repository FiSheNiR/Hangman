package org.example;

import java.util.ArrayList;
import java.util.List;

public class MistakeHandler {

    private int mistakeNumber;
    private final List<String> wrongLetterList = new ArrayList<>();
    private final int MAX_MISTAKES = Hangman.values().length - 1;

    public int getMistakeNumber(){
        return mistakeNumber;
    }

    public List<String> getWrongLetterList(){
        return wrongLetterList;
    }

    public int maxMistakeNumber(){
        return MAX_MISTAKES;
    }

    public void containLetter(String userInput, WordFromFile wordFromFile, MaskWord maskWord) {
        if (!checkLetter(userInput, wordFromFile, maskWord)) {
            wrongLetterList.add(mistakeNumber, String.valueOf(userInput.charAt(0)));
            mistakeNumber++;
            System.out.println("Такой буквы нет. Количество ошибок: " + mistakeNumber);
        } else {
            System.out.println("Есть такая буква");
        }
    }

    private boolean checkLetter(String userInput, WordFromFile wordFromFile, MaskWord maskWord) {
        char inputChar = userInput.charAt(0);
        boolean found = false;
        char[] gameSecretWord = wordFromFile.getSecretWord();
        for (int i = 0; i < gameSecretWord.length; i++) {
            if (gameSecretWord[i] == inputChar) {
                maskWord.unmaskLetter(i, inputChar);
                found = true;
            }
        }
        return found;
    }

}
