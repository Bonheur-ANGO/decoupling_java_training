package fr.lernejo;

import fr.lernejo.guessname.HumanPlayer;

import java.security.SecureRandom;

public class Launcher {

    public static void main(String[] args) {
        HumanPlayer player = new HumanPlayer();
        SecureRandom random = new SecureRandom();
        // long randomNumber = random.nextLong(); // génère un nombre entre Long.MIN_VALUE et Long.MAX_VALUE
        long randomNumber = random.nextLong(100); // génère un nombre entre 0 (inclus) et 100 (exclus)
        Simulation simulation = new Simulation(player);
        simulation.initialize(randomNumber);
        simulation.loopUntilPlayerSucceed();

    }
}
