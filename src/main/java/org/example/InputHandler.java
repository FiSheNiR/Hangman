package org.example;

import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner = new Scanner(System.in);
    private static final String RUSSIAN_LETTER_REGEX = "[А-Яа-яЁё]";

    public InputHandler() {
    }

    public String getUserInput() {

        while(true) {
            String userInput = scanner.nextLine().toUpperCase();

            if (userInput.length() != 1 || !userInput.matches(RUSSIAN_LETTER_REGEX)) {
                System.out.println("Вам надо ввести одну русскую букву");
                continue;
            }

            return userInput;
        }
    }
}
