import java.util.ArrayList;
import java.util.Hashtable;

public class TournamentWinner {

  public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
    Hashtable<String, Integer> tracking = new Hashtable<>();
    String winner = null;
    String roundWinner;
    int highestPoints = 0;
    for (int index = 0; index < competitions.size(); index++) {
      if (results.get(index) == 0) {
        roundWinner = competitions.get(index).get(1);
      } else {
        roundWinner = competitions.get(index).get(0);
      }

      if (tracking.contains(roundWinner)) {
        tracking.put(roundWinner, tracking.get(roundWinner) + 3);
      } else {
        tracking.put(roundWinner, 3);
      }

      if (tracking.get(roundWinner) > highestPoints) {
        highestPoints = tracking.get(roundWinner);
        winner = roundWinner;
      }

    }
    return winner;
  }

}
