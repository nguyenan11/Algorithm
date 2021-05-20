public class RunLengthEncoding {

  private static final int MAX_COUNT = 9, COUNT_RESET = 1;

  public static String runLengthEncoding(String string) {
    String encoding = "";
    int currCount = COUNT_RESET;
    char currChar = string.charAt(0);
    for (int i = 1; i < string.length(); i++) {
      char tempChar = string.charAt(i);
      if (currChar == tempChar && currCount < MAX_COUNT) {
          currCount++;
      } else {
        encoding = encoding + currCount + currChar;
        currChar = tempChar;
        currCount = COUNT_RESET;
      }
    }
    encoding = encoding + currCount + currChar;
    return encoding;
  }

  public static void main(String[] args) {
    String expected = runLengthEncoding("AAAAAAAAAABBCCCCDD");
    System.out.println(expected);
  }
}
