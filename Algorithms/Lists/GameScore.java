import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class GameScore {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>(Arrays.asList("5", "-2", "4", "Z", "X", "9", "+", "+"));

        System.out.println(gameScore(input, input.size()));

        List<String> input2 = new ArrayList<>(Arrays.asList("1", "2", "+", "Z"));

        System.out.println(gameScore(input2, input2.size()));
    }
    

    public static int gameScore(List<String> moves, int numMoves) {
        Stack<Integer> s = new Stack<>();
        int totalScore = 0;

        for (String move : moves) {
            if (move == "X") {
                int lastScore = 0;
                if (s.size() > 0) {
                    lastScore = s.peek();
                }
                totalScore += (lastScore * 2);
                s.push(lastScore * 2);
            } else if (move == "Z") {
                int lastScore = 0;
                if (s.size() > 0) {
                    lastScore = s.pop();
                }
                totalScore -= lastScore;
            } else if (move == "+") {
                int lastScore1 = 0;
                int lastScore2 = 0;
                int newScore = 0;
                if (s.size() > 1) {
                    lastScore1 = s.pop();
                    lastScore2 = s.peek();
                    s.push(lastScore1);
                } 

                if (s.size() == 1) {
                    lastScore1 = s.peek();
                }

                newScore = lastScore1 + lastScore2;
                s.push(newScore);

                totalScore += newScore;
            } else {
                int newScore = Integer.parseInt(move);
                s.push(newScore);
                totalScore += newScore;
            }
        }

        return totalScore;
    }
}