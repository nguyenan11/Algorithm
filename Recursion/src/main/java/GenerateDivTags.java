import java.util.ArrayList;

/*
  Write a function that takes in a positive integer `numberOfTags` and returns a list of all the
  valid strings that you can generate with that number of matched `<div></div>` tags.

  A string is valid and contains matched `<div></div>` tags if for every opening tag `<div>`,
  there's a closing tag `</div>` that comes after the opening tag and that isn't used as a closing
  tag for another opening tag. Each output string should contain exactly `numberOfTags` opening
  tags and `numberOfTags` closing tags.

  For example, given `numberOfTags = 2`, the valid strings to return would be:
  `["<div></div><div></div>", "<div><div></div></div>"]`.

  Note that the output strings don't need to be in any particular order.
*/
public class GenerateDivTags {

  static final String OPEN_TAG = "<div>";
  static final String CLOSE_TAG = "</div>";

  // O((2n)!/((n!((n + 1)!)))) time | O((2n)!/((n!((n + 1)!)))) space
  public ArrayList<String> generateDivTags(int numberOfTags) {
    ArrayList<String> matchedDivTags = new ArrayList<String>();
    generateDivTagsFromPrefix(numberOfTags, numberOfTags, "", matchedDivTags);
    return matchedDivTags;
  }

  public void generateDivTagsFromPrefix(int openTagsNeeded, int closeTagsNeeded, String prefix,
      ArrayList<String> result) {
    if (openTagsNeeded > 0) {
      String newPrefix = prefix + OPEN_TAG;
      generateDivTagsFromPrefix(openTagsNeeded - 1, closeTagsNeeded, newPrefix, result);
    }

    if (openTagsNeeded < closeTagsNeeded) {
      String newPrefix = prefix + CLOSE_TAG;
      generateDivTagsFromPrefix(openTagsNeeded, closeTagsNeeded - 1, newPrefix, result);
    }

    if (closeTagsNeeded == 0) {
      result.add(prefix);
    }
  }

}
