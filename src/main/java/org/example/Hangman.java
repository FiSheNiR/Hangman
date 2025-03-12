package org.example;

public class Hangman {
    public static void drawHangman(int mistakeNumber) {
        String[] hangman = {
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
        System.out.println(hangman[mistakeNumber]);
    }
}
