public class HangmanVisuals {

  private static String[] STAGES = new String[] {
      "       \n       \n       \n       \n       \n       \n=========",
      "       \n      |\n      |\n      |\n      |\n      |\n=========",
      "  +---+\n      |\n      |\n      |\n      |\n      |\n=========",
      "  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========",
      "  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========",
      "  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========",
      "  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========",
      "  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========",
      "  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========",
      "  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n=========",
  };

  public static String[] getEasyStages() {
    String[] stages = new String[STAGES.length];
    System.arraycopy(STAGES, 0, stages, 0, stages.length);
    return stages;
  }

  public static String[] getHardStages() {
    final int START_INDEX = 3;
    String[] stages = new String[STAGES.length - START_INDEX];
    System.arraycopy(STAGES, START_INDEX, stages, 0, stages.length);
    return stages;
  }

  public static String getPicture(int currentState) {
    return (STAGES[9 - currentState]);
  }

}
