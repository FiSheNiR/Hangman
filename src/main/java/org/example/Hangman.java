package org.example;

public class Hangman {

    private int mistakeNumber;

    private final String[] hangman = {
            """
  ------|
        |
        |
        |
        |
________|___
""",
            """
  ------|
  |     |
  0     |
        |
        |
________|___
""",
            """
  ------|
  |     |
  0     |
  |     |
        |
________|___
""",
            """
  ------|
  |     |
  0 /   |
  |     |
        |
________|___
""",
            """
  ------|
  |     |
\\ 0 /   |
  |     |
        |
________|___
""",
            """
  ------|
  |     |
\\ 0 /   |
  |     |
   \\    |
________|___
""",
            """
  ------|
  |     |
\\ 0 /   |
  |     |
 / \\    |
________|___
""",};

    public Hangman(int mistakeNumber) {
        this.mistakeNumber = mistakeNumber;
    }

    public void addMistakeNumber(){
        mistakeNumber++;
    }

    public int getMistakeNumber(){
        return mistakeNumber;
    }

    public int maxMistakeNumber(){
        return hangman.length;
    }
    public void drawHangman() {
        System.out.println(hangman[mistakeNumber]);
    }
}
