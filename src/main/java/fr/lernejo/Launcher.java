package fr.lernejo;

import fr.lernejo.guessname.ComputerPlayer;
import fr.lernejo.guessname.HumanPlayer;
import fr.lernejo.guessname.Player;

import java.security.SecureRandom;

public class Launcher {

    public static void main(String[] args) {
        if (args[0].equals("-interactive")){
            HumanPlayer player = new HumanPlayer();
            SecureRandom random = new SecureRandom();
            // long randomNumber = random.nextLong(); // génère un nombre entre Long.MIN_VALUE et Long.MAX_VALUE
            long randomNumber = random.nextLong(100); // génère un nombre entre 0 (inclus) et 100 (exclus)
            Simulation simulation = new Simulation(player);
            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }

        if (args[0].equals("-auto")){
            ComputerPlayer computerPlayer = new ComputerPlayer();
            Simulation simu = new Simulation(computerPlayer);
            if (args[1].length() > 1) {
                try {
                    simu.initialize(Integer.parseInt(args[1]));
                    simu.loopUntilPlayerSucceed(1000);
                }catch (NumberFormatException e){
                    System.out.println(e.getMessage());
                    System.out.println("Veuillez entrer un nombre valide");
                }
            }
        }

    }
}
