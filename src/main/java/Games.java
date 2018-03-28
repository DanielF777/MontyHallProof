import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class Games {

    private List<Door> doors;

    private Random rng;

    private int wins = 0;
    private int losses = 0;

    public Games() {
        this.doors = asList(
                new Door(
                        new Goat()
                ),
                new Door(
                        new Car()
                ),
                new Door(
                        new Goat()
                )
        );
        rng = new Random();
    }

    public HashMap<String, Integer> play(int amountOfGoes, boolean swap) {

        while( amountOfGoes > 0) {

            List<Door> currentGameDoors = doors;

            int chosenDoor = rng.nextInt(3);

            System.out.println("chosenDoor = " + chosenDoor);

            int doorNumToExpose = exposeADoorWithAGoat(chosenDoor);

            System.out.println("Door number " + doorNumToExpose + " has been exposed, behind this door is a: " + currentGameDoors.get(doorNumToExpose).toString());


            if (swap) {
                int swapDoorNumber = deduceExcludedValue(chosenDoor, doorNumToExpose);
                System.out.print("Do you want to swap doors? ");
                System.out.println("Yes");

                String whatIsBehindDoor = currentGameDoors.get(swapDoorNumber).toString();
                System.out.println("Behind your door is a: " + whatIsBehindDoor);
                System.out.println();

                addToWinsOrLosses(whatIsBehindDoor);
            } else {
                System.out.print("Do you want to swap doors? ");
                System.out.println("No");

                String whatIsBehindDoor = currentGameDoors.get(chosenDoor).toString();
                System.out.println("Behind your door is a: " + whatIsBehindDoor);

                addToWinsOrLosses(whatIsBehindDoor);
            }
            amountOfGoes--;
        }

        HashMap<String, Integer> ret = new HashMap<>();
        ret.put("Wins", wins);
        ret.put("Losses", losses);

        return ret;
    }

    private void addToWinsOrLosses(String whatIsBehindDoor) {
        if (whatIsBehindDoor.equals("Car")) {
            wins++;
        } else {
            losses++;
        }
    }

    private int exposeADoorWithAGoat(int chosenDoor) {
        int randomDoor = rng.nextInt(3);

        boolean isACar = checkRandomDoorIsACar(randomDoor);

        if (isACar) {
            return deduceExcludedValue(chosenDoor, randomDoor);
        }

        return randomDoor;
    }

    private int deduceExcludedValue(int chosenDoor, int randomDoor) {

        if(chosenDoor != 1 && randomDoor != 1) {
            return 1;
        } else if(chosenDoor != 2 && randomDoor != 2) {
            return 2;
        } else {
            return 0;
        }

    }

    private boolean checkRandomDoorIsACar(int randomDoor) {
        return doors.get(randomDoor).toString().equals("Car");
    }


}
