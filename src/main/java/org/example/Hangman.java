package org.example;

public class Hangman {
    private static final String[] PICTURES = {
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
"""
};

    private int currentHangmanState = 0;
    private final int maxHangmanState = PICTURES.length-1;

    public int getCurrentHangmanState() {
        return currentHangmanState;
    }

    public void addHangmanState() {
        currentHangmanState++;
    }

    public boolean isAlive() {
        return currentHangmanState < maxHangmanState;
    }

    public static String getImage(int pictureNumber) {
        return PICTURES[pictureNumber];
    }
}
