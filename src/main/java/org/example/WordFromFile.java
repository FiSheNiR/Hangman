package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class WordFromFile {

    private static final String FILE_PATH = "src/main/java/org/example/WordsList.txt";

    private final char[] secretWord = getRandomWord();

    public static char[] getRandomWord() {
        List<String> wordsList = readWordsFromFile();
        return randomWord(wordsList).toUpperCase().toCharArray();
    }

    private static List<String> readWordsFromFile() {
        List<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("[^а-яА-Яa-zA-Z]+");

        try (BufferedReader reader = new BufferedReader(new FileReader(WordFromFile.FILE_PATH, java.nio.charset.StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] wordArray = pattern.split(line);
                for (String word : wordArray) {
                    if (word.length() >= 5 && word.matches("[а-яА-Я]+")) {
                        words.add(word);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        return words;
    }

    private static String randomWord(List<String> words) {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    public char[] getSecretWord() {
        return secretWord;
    }
}