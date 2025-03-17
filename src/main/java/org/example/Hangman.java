package org.example;

public enum Hangman {

    STEP_0("""
  ------|
        |
        |
        |
        |
________|___
"""),
    STEP_1("""
  ------|
  |     |
  0     |
        |
        |
________|___
"""),
    STEP_2("""
  ------|
  |     |
  0     |
  |     |
        |
________|___
"""),
    STEP_3("""
  ------|
  |     |
  0 /   |
  |     |
        |
________|___
"""),
    STEP_4("""
  ------|
  |     |
\\ 0 /   |
  |     |
        |
________|___
"""),
    STEP_5("""
  ------|
  |     |
\\ 0 /   |
  |     |
   \\    |
________|___
"""),
    STEP_6(
        """
  ------|
  |     |
\\ 0 /   |
  |     |
 / \\    |
________|___
""");

    private final String image;

    Hangman(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }
}
