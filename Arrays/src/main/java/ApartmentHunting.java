import java.util.*;


public class ApartmentHunting {

  public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
    int closetDistance = Integer.MAX_VALUE;
    int mostOptimalIdx = 0;
    for (Map<String, Boolean> block : blocks) {
      int currDistance = calculateDistance(block, reqs);
      if (currDistance < closetDistance) {
        closetDistance = currDistance;
        mostOptimalIdx = blocks.indexOf(block);
      }
    }
    return mostOptimalIdx;
  }

  private static int calculateDistance(Map<String, Boolean> block, String[] reqs) {
    int currDistance = 0;
    for (String req : reqs) {
      if (!block.get(req)) {
        currDistance++;
      }
    }
    return currDistance;
  }

}
