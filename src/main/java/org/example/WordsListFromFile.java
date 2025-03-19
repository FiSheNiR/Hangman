package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class WordsListFromFile {

    private final String FILE_PATH = "src/main/java/org/example/WordsList.txt";
    private final int MIN_WORD_LENGTH = 5;
    private final List<String> wordsList = readWordsFromFile();

    public List<String> getWordsList() {
        return wordsList;
    }

    private List<String> readWordsFromFile() {
        List<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("[^а-яА-Яa-zA-Z]+");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH, java.nio.charset.StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] wordArray = pattern.split(line);
                for (String word : wordArray) {
                    if (word.length() >= MIN_WORD_LENGTH && word.matches("[а-яА-Я]+")) {
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
