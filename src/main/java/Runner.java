import java.util.HashMap;

import static java.util.Arrays.asList;

public class Runner {
    public static void main(String[] args) {

        Games game = new Games();

        int amountOfGoes = 500;

        HashMap<String, Integer> play = game.play(50000);

        int wins = play.get("Wins");
        int losses = play.get("Losses");
        double winPercent = (double) (wins * 100) / amountOfGoes;
        double losePercent = (double) (losses * 100) / amountOfGoes;

        System.out.println("Win Percentage: " + winPercent + "%");
        System.out.println("Lose Percentage: " + losePercent + "%");

        System.out.println("Wins " + wins);
        System.out.println("Losses " + losses);
    }
}
