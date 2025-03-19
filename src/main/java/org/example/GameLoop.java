package org.example;

public class GameLoop {

    public void start() {
        WordsListFromFile wordsListFromFile = new WordsListFromFile();
        boolean playable = true;
        while (playable) {
            System.out.println("Начать новую игру [н] Выйти [в]");
            InputHandler inputHandler = new InputHandler();
            switch (inputHandler.getUserInput()) {
                case "Н" -> initGame(wordsListFromFile);
                case "В" ->{
                    System.out.println("Выход");
                    playable = false;
                }
                default -> System.out.println("Введите букву еще раз");
            }
        }
    }

    private void initGame(WordsListFromFile wordsListFromFile) {
        Game game = new Game(wordsListFromFile);
        System.out.println("Игра началась");
        game.start();
    }
}
