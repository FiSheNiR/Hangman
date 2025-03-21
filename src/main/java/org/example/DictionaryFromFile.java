package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DictionaryFromFile {

    private final String filePath; //"src/main/java/org/example/WordsList.txt";
    private final int minWordLength;
    private final String wordsRegex;
    private final List<String> wordsFromFile;

    public DictionaryFromFile(String filePath, int minWordLength, String wordsRegex) {
        this.filePath = filePath;
        this.minWordLength = minWordLength;
        this.wordsRegex = wordsRegex;
        wordsFromFile = readWordsFromFile();
    }


    public List<String> getWordsFromFile() {
        return wordsFromFile;
    }

    private List<String> readWordsFromFile() {
        List<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("[^а-яА-Яa-zA-Z]+");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath, java.nio.charset.StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] wordArray = pattern.split(line);
                for (String word : wordArray) {
                    if (word.length() >= minWordLength && word.matches(wordsRegex)) { //"[а-яА-Я]+"
                        words.add(word);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        return words;
    }
}
