package org.example;

public class GameLoop {

    public void start() {
        boolean playable = true;
        while (playable) {
            System.out.println("Начать новую игру [н] Выйти [в]");
            InputHandler inputHandler = new InputHandler();
            switch (inputHandler.getUserInput()) {
                case "Н" -> initGame();
                case "В" ->{
                    System.out.println("Выход");
                    playable = false;
                }
                default -> System.out.println("Введите букву еще раз");
            }
        }
    }

    private void initGame(){
        Game game = new Game();
        System.out.println("Игра началась");
        game.start();
    }
}
