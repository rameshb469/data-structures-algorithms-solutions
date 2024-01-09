package ds.array;

import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * There's an algorithms tournament taking place in which teams of programmers
 * compete against each other to solve algorithmic problems as fast as possible.
 * Teams compete in a round robin, where each team faces off against all other
 * teams. Only two teams compete against each other at a time, and for each
 * competition, one team is designated the home team, while the other team is the
 * away team. In each competition there's always one winner and one loser; there
 * are no ties. A team receives 3 points if it wins and 0 points if it loses. The
 * winner of the tournament is the team that receives the most amount of points.
 */
public class TournamentWinner {

    public static void main(String[] args) {
        List<List<String>> competitions = List.of(
                List.of("HTML", "Java"),
                List.of("Java", "Python"),
                List.of("Python", "HTML")
        );
        List<Integer> results = List.of(0,1,1);
        TournamentWinner winner = new TournamentWinner();
        System.out.println(winner.tournamentWinner(competitions,results ));
    }

    public String tournamentWinner(
            List<List<String>> competitions, List<Integer> results) {
        TreeMap<String,Integer> winnerPoints = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < results.size(); i++) {
            List<String> competition = competitions.get(i);
            String winner = (results.get(i).equals(1)) ? competition.get(0) : competition.get(1);
            if (winnerPoints.containsKey(winner)){
                winnerPoints.put(winner, winnerPoints.get(winner)+1);
            } else {
                winnerPoints.put(winner, 1);
            }
        }
            

        return winnerPoints.firstKey();
    }
}
