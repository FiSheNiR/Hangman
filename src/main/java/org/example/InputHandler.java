package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputHandler {

    private final Scanner scanner;
    private final Set<String> duplicateLettersSet;

    public InputHandler(Scanner scanner) {
        this.duplicateLettersSet = new HashSet<>();
        this.scanner = scanner;
    }

    public String getUserInput() {


        while(true) {
            String userInput = scanner.nextLine().toUpperCase();

            if (userInput.length() != 1 || !userInput.matches("[А-Яа-яЁё]")) {
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
