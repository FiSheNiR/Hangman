package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputHandler {

    private final Scanner scanner = new Scanner(System.in);
    private final Set<String> duplicateLettersSet;
    private final String RUSSIAN_LETTER_REGEX = "[А-Яа-яЁё]";

    public InputHandler() {
        this.duplicateLettersSet = new HashSet<>();
    }

    public String getUserInput() {


        while(true) {
            String userInput = scanner.nextLine().toUpperCase();

            if (userInput.length() != 1 || !userInput.matches(RUSSIAN_LETTER_REGEX)) {
                System.out.println("Вам надо ввести одну русскую букву");
                continue;
            }

            if (!duplicateLettersSet.add(userInput)) {
                System.out.println("Вы уже вводили эту букву попробуйте еще раз");
                continue;
            }

            duplicateLettersSet.add(userInput);
            return userInput;
        }
    }
}
