import java.util.ArrayList;
import java.util.List;

public class LongestPeak {

  public static int longestPeak(int[] array) {
    List<Integer> tempArr = new ArrayList<>();
    boolean tipDetected = false;
    int longestPeak = 0;
    for (int i = 0; i < array.length - 1; i++) {
      tempArr.add(array[i]);
      int currDifference = array[i + 1] - array[i];
      if (currDifference == 0) {
        longestPeak = updateLongestPeak(longestPeak, tempArr);
        tempArr = new ArrayList<>();
      } else if (currDifference > 0) {
        if (tipDetected) {
          longestPeak = updateLongestPeak(longestPeak, tempArr);
          tempArr = new ArrayList<>();
          tempArr.add(array[i]);
        }
      } else if (currDifference < 0) {
        if (!tipDetected) {
          tipDetected = true;
        } else {
          longestPeak = updateLongestPeak(longestPeak, tempArr);
        }
      }
    }
    return longestPeak;
  }

  private static int updateLongestPeak(int longestPeak, List<Integer> array) {
    return Math.max(array.size(), longestPeak);
  }

  public static void main(String[] args) {
    int[] array = new int[]{1, 3, 2};
    longestPeak(array);
  }

  }
