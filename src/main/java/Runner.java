import java.util.HashMap;

import static java.util.Arrays.asList;

public class Runner {
    public static void main(String[] args) {

        Games game = new Games();

        int amountOfGoes = 500000;
        boolean swap = true;

        HashMap<String, Integer> play = game.play(amountOfGoes, swap);

        double wins = play.get("Wins");
        double losses = play.get("Losses");
        double winPercent = ((wins * 100) / amountOfGoes);
        double losePercent = ((losses * 100) / amountOfGoes);

        System.out.println("Win Percentage: " + winPercent + "%");
        System.out.println("Lose Percentage: " + losePercent + "%");

        System.out.println("Wins " + wins);
        System.out.println("Losses " + losses);
    }
}
