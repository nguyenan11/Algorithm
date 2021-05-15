import java.util.ArrayList;
import java.util.Hashtable;

public class TournamentWinner {

  /*

  There's an algorithms tournament taking place in which teams of programmers
  compete against each other to solve algorithmic problems as fast as possible.
  Teams compete in a round robin, where each team faces off against all other
  teams. Only two teams compete against each other at a time, and for each
  competition, one team is designated the home team, while the other team is the
  away team. In each competition there's always one winner and one loser; there
  are no ties. A team receives 3 points if it wins and 0 points if it loses. The
  winner of the tournament is the team that receives the most amount of points.


  Given an array of pairs representing the teams that have competed against each
  other and an array containing the results of each competition, write a
  function that returns the winner of the tournament. The input arrays are named "competitions" and
  "results", respectively. The "competitions" array has elements in the form of [homeTeam, awayTeam],
  where each team is a string of at most 30 characters representing the name of the team. The "results"
  array contains information about the winner of each corresponding competition in the "competitions"
  array. Specifically, "results[i]" denotes the winner of "competitions[i]", where "1" in the "results"
  array means that the home team in th corresponding competition won and a "0" means that the away team won.


  It's guaranteed that exactly one team will win the tournament and that each
  team will compete against all other teams exactly once. It's also guaranteed
  that the tournament will always have at least two teams.
   */

  private static final int AWAY_TEAM_WON = 0, POINTS_PER_WIN = 3;

  // O(n) time | O(k) space - n is number of competitions, k is number of teams
  public String tournamentWinner(ArrayList<ArrayList<String>> competitions,
      ArrayList<Integer> results) {
    Hashtable<String, Integer> tracking = new Hashtable<>();
    String winner = null;
    String roundWinner;
    int highestPoints = 0;
    for (int index = 0; index < competitions.size(); index++) {
      roundWinner = getRoundWinner(index, competitions, results);
      updateScores(tracking, roundWinner);

      if (tracking.get(roundWinner) > highestPoints) {
        highestPoints = tracking.get(roundWinner);
        winner = roundWinner;
      }

    }
    return winner;
  }

  private String getRoundWinner(int index, ArrayList<ArrayList<String>> competitions,
      ArrayList<Integer> results) {
    if (results.get(index) == AWAY_TEAM_WON) {
      return competitions.get(index).get(1);
    } else {
      return competitions.get(index).get(0);
    }
  }

  private void updateScores(Hashtable<String, Integer> tracking, String roundWinner) {
    if (tracking.containsKey(roundWinner)) {
      tracking.put(roundWinner, tracking.get(roundWinner) + POINTS_PER_WIN);
    } else {
      tracking.put(roundWinner, POINTS_PER_WIN);
    }
  }


  /* Cleaner
  private int HOME_TEAM_WON = 1;

  public String tournamentWinner(
      ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
    // Write your code here.
    HashMap<String, Integer> scores = new HashMap();
    String currentBestTeam = "";
    scores.put(currentBestTeam, 0);

    for (int i=0; i < competitions.size(); i++) {
      ArrayList<String> competition = competitions.get(i);
      Integer result = results.get(i);

      String homeTeam = competition.get(0);
      String awayTeam = competition.get(1);
      String winningTeam = (result == HOME_TEAM_WON) ? homeTeam : awayTeam;
      updateScores(winningTeam, 3, scores);

      if (scores.get(winningTeam) > scores.get(currentBestTeam)) {
        currentBestTeam = winningTeam;
      }
    }
    return currentBestTeam;
  }

  public void updateScores(String team, int points, HashMap<String, Integer> scores) {
    if (!scores.containsKey(team)) {
      scores.put(team, 0);
    }
    scores.put(team, scores.get(team) + points);
  }
}

   */
}
