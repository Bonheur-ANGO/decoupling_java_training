package fr.lernejo;

import fr.lernejo.guessname.HumanPlayer;
import fr.lernejo.guessname.Player;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        //TODO implement me
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        //TODO implement me
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me
        System.out.println("Entrez un nombre entre 1 et 100");
        long userNumberInput = player.askNextGuess();
        boolean state;

        if (userNumberInput == numberToGuess){
            logger.log("Bravo");
            return true;
        }

        if (userNumberInput > numberToGuess){
            logger.log("Petit");
            return false;
        }else{
            logger.log("Grand");
            return false;
        }

    }

    public void loopUntilPlayerSucceed() {
        //TODO implement me
        while (this.nextRound() != true){
        }
    }
}
