package org.example;

import java.util.Scanner;

public class GameLoop {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean playable = true;
        while (playable) {
            System.out.println("Начать новую игру [н] Выйти [в]");
            String input = scanner.next().toUpperCase();
            switch (input) {
                case "Н":
                    initGame();
                    break;
                case "В":
                    System.out.println("Выход");
                    playable = false;
                    break;
                default:
                    System.out.println("Введите букву еще раз");
            }
        }
    }

    private void initGame(){
        Game game = new Game();
        System.out.println("Игра началась");
        game.start();
    }
}
