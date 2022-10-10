package fr.lernejo;

import fr.lernejo.guessname.HumanPlayer;
import fr.lernejo.guessname.Player;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        System.out.println(userNumberInput);

        if (userNumberInput == numberToGuess){
            logger.log("Bravo");
            return true;
        }else{
            player.respond(userNumberInput > this.numberToGuess);
            return false;
        }

    }

    public void loopUntilPlayerSucceed(long loopNumber) {
        int i = 0;
        boolean success = nextRound();
        long startTime = System.currentTimeMillis();
        //TODO implement me
        while (success != true && i < loopNumber){
            i++;
            success = nextRound();
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        SimpleDateFormat simpleDate = new SimpleDateFormat("mm:ss.SSS");
        Date date = new Date(totalTime);
        String time = simpleDate.format(date);

        if (success == true && i < loopNumber){
            System.out.println("Bravo vous avez trouve le nombre avant la limite d'iterations en " + time + "ms");
        } else if(success == true && i == loopNumber){
            System.out.println("Bravo vous avez trouve le nombre avant la limite d'iterations en " + time + "ms");
        } else {
            System.out.println("Desole mais vous n'avez pas trouve le nombre");
        }
    }
}
