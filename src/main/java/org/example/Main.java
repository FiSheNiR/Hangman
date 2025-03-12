package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        startGame();
    }


    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean game = true;
        while (game) {
            System.out.println("Начать новую игру [н] Выйти [в]");
            String input = scanner.next().toUpperCase();
            switch (input) {
                case "Н":
                    System.out.println("Игра началась");
                    Game.start();
                    break;
                case "В":
                    System.out.println("Выход");
                    game = false;
                    break;
                default:
                    System.out.println("Введите букву еще раз");
            }
        }
    }
}