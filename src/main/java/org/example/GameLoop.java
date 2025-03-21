package org.example;

public class GameLoop {

    private static final String START = "Н";
    private static final String QUIT = "В";

    public void start() {
        DictionaryFromFile dictionaryFromFile = new DictionaryFromFile("src/main/java/org/example/WordsList.txt",
                5, "[а-яА-Я]+");
        boolean playable = true;
        while (playable) {
            System.out.println("Начать новую игру [н] Выйти [в]");
            InputHandler inputHandler = new InputHandler();
            switch (inputHandler.getUserInput()) {
                case START -> createGame(dictionaryFromFile);
                case QUIT ->{
                    System.out.println("Выход");
                    playable = false;
                }
                default -> System.out.println("Введите букву еще раз");
            }
        }
    }

    private void createGame(DictionaryFromFile dictionaryFromFile) {
        Game game = new Game(dictionaryFromFile);
        System.out.println("Игра началась");
        game.start();
    }
}
