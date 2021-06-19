import java.util.ArrayList;
import java.util.List;

public class SunsetViews {

  public static List<Integer> sunsetViews(int[] buildings, String direction) {
    if (direction.equals("EAST")) {
      return facingEast(buildings);
    }
    return facingWest(buildings);
  }

  public static List<Integer> facingEast(int[] buildings) {
    List<Integer> stack = new ArrayList<>();
    int size = buildings.length;
    for (int i = 0; i < size; i++) {
      if (stack.size() != 0 && buildings[stack.get(stack.size() - 1)] <= buildings[i]) {
        while (buildings[stack.get(stack.size() - 1)] <= buildings[i]) {
          stack.remove(stack.size() - 1);
        }
      }
      stack.add(i);
    }
    return stack;
  }

  public static List<Integer> facingWest(int[] buildings) {
    List<Integer> stack = new ArrayList<>();
    int size = buildings.length;
    for (int i = size; i >= 0; i--) {
      if (stack.size() == 0 || buildings[stack.get(stack.size() - 1)] > buildings[i]) {
        stack.add(i);
      } else {
        while (buildings[stack.get(stack.size() - 1)] <= buildings[i]) {
          stack.remove(stack.size() - 1);
        }
      }
    }
    return stack;
  }

  public static void main(String[] args) {
    int[] array = new int[]{3, 5, 4, 4, 3, 1, 3, 2};
    System.out.println(sunsetViews(array, "EAST"));
  }
}
